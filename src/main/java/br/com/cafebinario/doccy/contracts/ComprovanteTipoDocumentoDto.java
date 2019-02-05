package br.com.cafebinario.doccy.contracts;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class ComprovanteTipoDocumentoDto {

	private final String valor;
	private final ImagemComprovanteDto<TipoDocumentoEnum> imagemComprovante;
}
