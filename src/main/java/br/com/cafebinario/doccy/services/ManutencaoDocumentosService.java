package br.com.cafebinario.doccy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import br.com.cafebinario.doccy.entities.DocumentoEntity;
import br.com.cafebinario.doccy.repositories.DocumentoRepository;

@Service
public class ManutencaoDocumentosService {

	@Autowired
	private DocumentoRepository documentoRepository;

	public DocumentoEntity salvar(final DocumentoEntity documentoEntity) {
		return documentoRepository.save(documentoEntity);

	}

	public List<String> buscarPorValorTipoDocumento(final TipoDocumentoEnum tipoDocumento, final String valor) {
		return documentoRepository.findByTipoDocumentoAndValor(tipoDocumento, valor);
	}
}
