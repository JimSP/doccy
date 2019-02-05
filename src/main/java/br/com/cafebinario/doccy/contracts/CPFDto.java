package br.com.cafebinario.doccy.contracts;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder=true)
public class CPFDto implements FormularioDocumentoDto{
	private ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDto;

	@Override
	public String getValor() {
		return comprovanteTipoDocumentoDto.getValor();
	}

	@Override
	public ImagemComprovanteDto<TipoDocumento> getComprovanteDocumento() {
		return comprovanteTipoDocumentoDto.getImagemComprovante();
	}

}
