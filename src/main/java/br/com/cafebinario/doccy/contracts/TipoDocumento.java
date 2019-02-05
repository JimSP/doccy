package br.com.cafebinario.doccy.contracts;

import java.io.Serializable;
import java.util.Map;

import br.com.cafebinario.doccy.wappers.RegraExtracao;
import br.com.cafebinario.doccy.wappers.TipoExtracao;
import br.com.cafebinario.doccy.wappers.ValorDocumentoRange;

public interface TipoDocumento {

	public default TipoExtracao getTipoExtracao() {
		return TipoExtracao.INTERVALO;
	}

	public default RegraExtracao getRegraExtracao(final Map<String, Serializable> parameters) {
		final Integer beginIndex = (Integer) parameters.get("beginIndex");
		final Integer endIndex = (Integer) parameters.get("endIndex");

		return ValorDocumentoRange.builder().beginIndex(beginIndex).endIndex(endIndex).build();
	}
}
