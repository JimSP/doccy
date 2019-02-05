package br.com.cafebinario.doccy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class DocumentoEntity {

	@Id
	private String uuidParticipante;
	
	@Enumerated(EnumType.STRING)
	private TipoDocumentoEnum tipoDocumento;

	@Column(length = 12)
	private String valor;

	@Column(length = 8096)
	private String imagemOCR;
}
