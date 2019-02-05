package br.com.cafebinario.doccy.factories;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.cafebinario.doccy.contracts.ComprovanteTipoDocumentoDto;
import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;

@Component
public class FormularioDocumentoManager {

	private Map<TipoDocumentoEnum, FormularioDocumentoDtoFactory> factoryMap = Collections
			.synchronizedMap(new EnumMap<TipoDocumentoEnum, FormularioDocumentoDtoFactory>(TipoDocumentoEnum.class));

	public void registrar(final TipoDocumentoEnum tipoDocumento,
			final FormularioDocumentoDtoFactory formularioDocumentoDtoFactory) {
		factoryMap.put(tipoDocumento, formularioDocumentoDtoFactory);
	}

	public FormularioDocumentoDtoFactory remover(final TipoDocumentoEnum tipoDocumento) {
		return factoryMap.remove(tipoDocumento);
	}

	private FormularioDocumentoDtoFactory criarFactory(final TipoDocumentoEnum tipoDocumento) {
		return factoryMap.get(tipoDocumento);
	}

	public FormularioDocumentoDto criar(final TipoDocumentoEnum tipoDocumento, final String imagemOCR,
			final ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDtoIdentificado) {

		return criarFactory(tipoDocumento)
				.criar(imagemOCR, comprovanteTipoDocumentoDtoIdentificado);
	}
}
