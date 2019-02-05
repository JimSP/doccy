package br.com.cafebinario.doccy.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class ParametroRegraExtracaoEntity {
	
	@Id
	private BigInteger id;
	private TipoDocumentoEnum tipoDocumento;
	private String chaveParametro;
	private String valorParametro;

}
