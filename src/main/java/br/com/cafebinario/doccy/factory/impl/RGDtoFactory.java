package br.com.cafebinario.doccy.factory.impl;

import java.util.Date;

import br.com.cafebinario.doccy.contracts.ComprovanteTipoDocumentoDto;
import br.com.cafebinario.doccy.contracts.EstadoEnum;
import br.com.cafebinario.doccy.contracts.FormularioDocumentoDto;
import br.com.cafebinario.doccy.contracts.RGDto;
import br.com.cafebinario.doccy.factories.FormularioDocumentoDtoFactory;

public class RGDtoFactory implements FormularioDocumentoDtoFactory {

	@Override
	public FormularioDocumentoDto criar(final String imagemOCR,
			final ComprovanteTipoDocumentoDto comprovanteTipoDocumentoDtoIdentificado) {
		
		final String orgaoEmissor = "";
		final Date dataExpedicao = null;
		final String nomePai = "";
		final String nomeMae = "";
		final Date dataNascimento = null;
		final String naturalidadeCidade = "";
		final EstadoEnum naturalidadeEstado = EstadoEnum.SAO_PAULO;
		final String certidaoNascimento = "";

		return RGDto
				.builder()
				.dataNascimento(dataNascimento)
				.nomeMae(nomeMae)
				.nomePai(nomePai)
				.certidaoNascimento(certidaoNascimento)
				.dataExpedicao(dataExpedicao)
				.naturalidadeCidade(naturalidadeCidade)
				.naturalidadeEstado(naturalidadeEstado)
				.orgaoEmissor(orgaoEmissor)
				.build();
	}

}
