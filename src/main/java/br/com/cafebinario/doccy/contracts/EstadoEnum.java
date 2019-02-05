package br.com.cafebinario.doccy.contracts;

import java.util.Arrays;

public enum EstadoEnum {
	ACRE("AC"),
	ALAGOAS("AL"),
	AMAPA("AP"),
	AMAZONAS("AM"),
	BAHIA("BA"),
	CEARA("CE"),
	DISTRITO_FEDERAL("DF"),
	ESPIRITO_SANTO("ES"),
	GOIAS("GO"),
	MARANHAO("MA"),
	MATO_GROSSO("MT"),
	MATO_GROSSO_DO_SUL("MS"),
	MINAS_GERAIS("MG"),
	PARA("PA"),
	PARAIBA("PB"),
	PARANA("PR"),
	PERNAMBUCO("PE"),
	PIAUI("PI"),
	RIO_DE_JANEIRO("RJ"),
	RIO_GRANDE_DO_NORTE("RN"),
	RIO_GRANDE_DO_SUL("RS"),
	RONDONIA("RO"),
	RORAIMA("RR"),
	SANTA_CATARINA("SC"),
	SAO_PAULO("SP"),
	SERGIPE("SE"),
	TOCANTINS("TO");

	private final String sigla;

	private EstadoEnum(final String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public static EstadoEnum of(final String sigla) {
		return Arrays
				.asList(EstadoEnum.values())
				.stream()
				.filter(estado -> estado.sigla.equalsIgnoreCase(sigla))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("%s não é uma sigla válida.", sigla)));
	}
}
