package it.unicam.pnm.outbound.adapter.persistence.repository;

import it.unicam.pnm.outbound.adapter.persistence.entity.TipoProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoProdottoRepository extends JpaRepository<TipoProdottoEntity, UUID>, JpaSpecificationExecutor<TipoProdottoEntity> {
}
