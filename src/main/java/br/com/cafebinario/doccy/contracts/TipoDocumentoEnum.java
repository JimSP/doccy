package br.com.cafebinario.doccy.contracts;

import br.com.cafebinario.doccy.wappers.RegraExtracao;
import br.com.cafebinario.doccy.wappers.TipoExtracao;
import br.com.cafebinario.doccy.wappers.ValorDocumentoRange;

public enum TipoDocumentoEnum {

	RG,
	CPF,
	CARTEIRA_MOTORISTA,
	CNPJ,
	INSCRICAO_ESTATUAL,
	RNE,
	PASSAPORTE,
	CARTEIRA_TRABALHO,
	PIS;

	
	public TipoExtracao getTipoExtracao() {
		return TipoExtracao.INTERVALO;
	}

	public RegraExtracao getRegraExtracao() {
		return ValorDocumentoRange.builder().beginIndex(0).endIndex(10).build();
	}
}
