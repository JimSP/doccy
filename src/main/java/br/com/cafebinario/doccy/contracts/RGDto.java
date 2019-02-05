package br.com.cafebinario.doccy.contracts;

import java.util.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class RGDto implements FormularioDocumentoDto {

	private String orgaoEmissor;
	private Date dataExpedicao;
	private String nomePai;
	private String nomeMae;
	private Date dataNascimento;
	private String naturalidadeCidade;
	private EstadoEnum naturalidadeEstado;
	private String certidaoNascimento;
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
