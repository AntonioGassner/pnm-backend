package it.unicam.pnm.outbound.adapter.persistence.repository;

import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.core.model.AziendaModel;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaDettaglioDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.azienda.AziendaPreviewDTO;
import it.unicam.pnm.outbound.adapter.persistence.entity.AziendaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AziendaRepository extends JpaRepository<AziendaEntity, UUID>, JpaSpecificationExecutor<AziendaEntity> {

    @Query(value = "SELECT new AziendaEntity(" +
            "d.nomeProduttore, " +
            "d.cognomeProduttore, " +
            "d.partitaIva, " +
            "d.nomeAzienda" +
            "d.numeroAzienda" +
            "d.emailAzienda" +
            "d.comune" +
            "d.provincia" +
            "d.indirizzo" +
            "d.cap" +
            "d.descrizioneLunga" +
            "d.linkFacebook" +
            "d.linkYoutube" +
            "d.linkInstagram" +
            "d.linkWebsite" +
            "d.linkTicToc" +
            "d.tipoProdotto" +
            ") FROM #{#entityName} d WHERE d.id = ?1")
    AziendaEntity getAziendaDettaglioById(UUID id);

    @Query(value = "SELECT new AziendaEntity(" +
            "d.nomeProduttore, " +
            "d.cognomeProduttore, " +
            "d.nomeAzienda" +
            "d.comune" +
            "d.provincia" +
            "d.indirizzo" +
            "d.descrizioneBreve" +
            "d.tipoProdotto" +
            ") FROM #{#entityName} d WHERE d.nomeAzienda = ?1 AND d.provincia = ?2 AND d.tipoProdotto = ?3")
    Page<AziendaEntity> getAziendaPreviewByNomeAziendaAndProvinciaAndTipoProdotto(String nomeAzienda, String provincia, String tipoProdotto,
                                                                                        Pageable pageable);
    @Modifying
    @Query(value = "UPDATE #{#entityName} d SET d.tesseramentoAttivo = true WHERE d.id = ?1")
    boolean attivaTesseramento(UUID id);

    @Query(value = "SELECT new AziendaEntity(" +
            "d.nomeProduttore, " +
            "d.cognomeProduttore, " +
            "d.numeroAzienda" +
            "d.emailAzienda" +
            ") FROM #{#entityName} d")
    Page<AziendaEntity> getContactList();


    boolean existsByEmailPrivataAndPassword(String user, String pass);
}
