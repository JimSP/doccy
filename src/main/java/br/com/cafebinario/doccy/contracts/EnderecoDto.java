package br.com.cafebinario.doccy.contracts;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder=true)
public class EnderecoDto {

	private TipoLogradouroEnum tipoLogradouro;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private EstadoEnum estado;
	private String cep;
	private ImagemComprovanteDto<TipoComprovanteEnderecoEnum> comprovanteEndereco;
	
}
