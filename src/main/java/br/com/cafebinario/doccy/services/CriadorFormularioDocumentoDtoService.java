package br.com.cafebinario.doccy.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafebinario.doccy.contracts.ComprovanteTipoDocumentoDto;
import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.ImagemComprovanteDto;
import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import br.com.cafebinario.doccy.entities.DocumentoEntity;
import br.com.cafebinario.doccy.factories.FormularioDocumentoManager;
import br.com.cafebinario.doccy.ocr.OCRDocumentos;
import br.com.cafebinario.doccy.wappers.TipoExtracao;

@Service
public class CriadorFormularioDocumentoDtoService {
	
	@Autowired
	private FormularioDocumentoManager formularioDocumentoManager;

	@Autowired
	private OCRDocumentos ocrDocumentos;

	@Autowired
	private CloudStorageService cloudStorageService;
	
	@Autowired
	private ManutencaoDocumentosService manutencaoDocumentosService;
	
	public FormularioDocumentoDto criar(final ImagemComprovanteDto<TipoDocumentoEnum> imagemComprovanteDto, final UUID uuidParticipante) {
		
		final byte[] imagem = imagemComprovanteDto.getImagem();

		final String imagemOCR = ocrDocumentos.lerImagem(null);
		
		final TipoDocumentoEnum tipoDocumento = imagemComprovanteDto.getTipoImagemComprovante();
		final String valor = extrairValorDocumento(tipoDocumento, imagemOCR);
		
		final String ulr = cloudStorageService.salvarDocumento(imagem, uuidParticipante);
		
		final DocumentoEntity documentoEntity = manutencaoDocumentosService.salvar(
				DocumentoEntity
					.builder()
					.uuidParticipante(uuidParticipante.toString())
					.imagemOCR(imagemOCR)
					.valor(valor)
					.build());
		
		final ImagemComprovanteDto<TipoDocumentoEnum> imagemComprovanteDtoProcessado = imagemComprovanteDto
				.toBuilder()
				.tipoImagemComprovante(documentoEntity.getTipoDocumento())
				.ulr(ulr)
				.build();
		
		final ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDtoIdentificado = ComprovanteTipoDocumentoDto
				.builder()
				.imagemComprovante(imagemComprovanteDtoProcessado)
				.valor(documentoEntity.getValor())
				.build();
		
		return formularioDocumentoManager.criar(tipoDocumento, imagemOCR, comprovanteTipoDocumentoDtoIdentificado);
	}

	private String extrairValorDocumento(final TipoDocumentoEnum tipoDocumento, final String imagemOCR) {
		
		final TipoExtracao tipoExtracao = tipoDocumento.getTipoExtracao();
		return tipoExtracao.extrair(imagemOCR, tipoDocumento.getRegraExtracao());
	}

	public List<String> obterUUIDporTipoDOcumentoEValor(final TipoDocumentoEnum tipoDocumento, final String valor) {
		return manutencaoDocumentosService.buscarPorValorTipoDocumento(tipoDocumento, valor);
	}
}
