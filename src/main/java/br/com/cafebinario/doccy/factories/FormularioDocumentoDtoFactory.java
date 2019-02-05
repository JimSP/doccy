package br.com.cafebinario.doccy.factories;

import br.com.cafebinario.doccy.contracts.ComprovanteTipoDocumentoDto;
import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;

public interface FormularioDocumentoDtoFactory {

	FormularioDocumentoDto criar(final String imagemOCR, final ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDtoIdentificado);
}
