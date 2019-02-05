package br.com.cafebinario.doccy.wappers;

import java.util.Arrays;

public enum TipoExtracao {
	
	INTERVALO {
		@Override
		public String extrair(final String imagemOCR, final RegraExtracao regraExtracao) {
			final ValorDocumentoRange valorDocumentoRange = (ValorDocumentoRange) regraExtracao;
			return imagemOCR.substring(valorDocumentoRange.getBeginIndex(), valorDocumentoRange.getEndIndex());
		}
	}, EXPRESSAO_REGULAR {
		@Override
		public String extrair(final String imagemOCR, final RegraExtracao regraExtracao) {
			final ValorExpressaoRegular valorExpressaoRegular = (ValorExpressaoRegular) regraExtracao;
			return Arrays
					.asList(imagemOCR.split(valorExpressaoRegular.getRegex()))
					.stream()
					.reduce((a,b)->a
							.concat(SPACE)
							.concat(b))
					.orElse(EMPTY);
		}
	};

	private static final String EMPTY = "";
	private static final String SPACE = " ";

	public abstract String extrair(final String imagemOCR, final RegraExtracao regraExtracao);

}
