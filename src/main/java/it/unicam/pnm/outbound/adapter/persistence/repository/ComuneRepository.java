package it.unicam.pnm.outbound.adapter.persistence.repository;

import it.unicam.pnm.outbound.adapter.persistence.entity.ComuneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComuneRepository extends JpaRepository<ComuneEntity, UUID>, JpaSpecificationExecutor<ComuneEntity> {

}