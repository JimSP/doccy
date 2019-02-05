package br.com.cafebinario.doccy.factories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.cafebinario.doccy.contracts.ComprovanteTipoDocumentoDto;
import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.TipoDocumento;
import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;

@Component
public class FormularioDocumentoManager {

	private Map<TipoDocumento, FormularioDocumentoDtoFactory> factoryMap = Collections
			.synchronizedMap(new HashMap<TipoDocumento, FormularioDocumentoDtoFactory>());

	public void registrar(final TipoDocumentoEnum tipoDocumento,
			final FormularioDocumentoDtoFactory formularioDocumentoDtoFactory) {
		factoryMap.put(tipoDocumento, formularioDocumentoDtoFactory);
	}

	public FormularioDocumentoDtoFactory remover(final TipoDocumento tipoDocumento) {
		return factoryMap.remove(tipoDocumento);
	}

	private FormularioDocumentoDtoFactory criarFactory(final TipoDocumento tipoDocumento) {
		return factoryMap.get(tipoDocumento);
	}

	public FormularioDocumentoDto criar(final TipoDocumento tipoDocumento, final String imagemOCR,
			final ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDtoIdentificado) {

		return criarFactory(tipoDocumento)
				.criar(imagemOCR, comprovanteTipoDocumentoDtoIdentificado);
	}
}
