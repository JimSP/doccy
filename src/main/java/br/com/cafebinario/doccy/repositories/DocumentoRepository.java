package br.com.cafebinario.doccy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cafebinario.doccy.contracts.TipoDocumentoEnum;
import br.com.cafebinario.doccy.entities.DocumentoEntity;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, String> {

	@Query("select uuidParticipante from DocumentoEntity d where tipoDocumento = :tipoDocumento and valor = :valor")
	List<String> findByTipoDocumentoAndValor(
			@Param("tipoDocumento") final TipoDocumentoEnum tipoDocumento,
			@Param("valor") final String valor);

}
