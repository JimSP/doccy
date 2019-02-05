package br.com.cafebinario.doccy.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.cafebinario.doccy.contracts.TipoDocumento;
import br.com.cafebinario.doccy.entities.ParametroRegraExtracaoEntity;

public interface ParametroRegraExtracaoRepository extends JpaRepository<ParametroRegraExtracaoEntity, BigInteger>{

	List<ParametroRegraExtracaoEntity> findByTipoDocumento(@Param("tipoDocumento") final TipoDocumento tipoDocumento);

}
