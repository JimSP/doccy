package br.com.cafebinario.doccy.wappers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValorDocumentoRange implements RegraExtracao{

	private int beginIndex;
	private int endIndex;

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}
}
