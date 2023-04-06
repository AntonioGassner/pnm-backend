package it.unicam.pnm.outbound.adapter.persistence.repository;

import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AziendaRepository extends JpaRepository<AziendaEntity, UUID>, JpaSpecificationExecutor<AziendaEntity> {

    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.tesseramentoAttivo = true WHERE d.id = ?1")
    void attivaTesseramento(UUID id);

    AziendaEntity getByEmailPrivataAndPassword(String user, String pass);
    // TODO resolve error "query did not return a unique result" somehow
}
