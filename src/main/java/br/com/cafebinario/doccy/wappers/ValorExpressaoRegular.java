package br.com.cafebinario.doccy.wappers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValorExpressaoRegular implements RegraExtracao{

	private String regex;
}
