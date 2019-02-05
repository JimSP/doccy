package br.com.cafebinario.doccy.contracts;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder=true)
public class ContatoDto {

	private TipoContatoEnum tipoContato;
	private String valor;
	
}
