package br.com.cafebinario.doccy.contracts;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ParticipanteDto {
	private UUID uuidParticipante;
	private String primeiroNome;
	private String segundoNome;
	private String nomeCompleto;
	private Date dataNascimento;
	private List<EnderecoDto> enderecos;
	private List<ContatoDto> contatos;
	private List<FormularioDocumentoDto> documentos;
}
