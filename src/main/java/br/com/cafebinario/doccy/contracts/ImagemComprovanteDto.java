package br.com.cafebinario.doccy.contracts;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder=true)
public class ImagemComprovanteDto<T extends Enum<?>> {
	
	private T tipoImagemComprovante;
	private String ulr;
	
	@NotEmpty
	private byte[] imagem;
}
