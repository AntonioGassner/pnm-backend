package it.unicam.pnm.outbound.adapter.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "azienda")
public class AziendaEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nomeProduttore")
    private String nomeProduttore;

    @Column(name = "cognomeProduttore")
    private String cognomeProduttore;

    @Column(name = "partitaIva")
    private String partitaIva;

    @Column(name = "numeroPrivato")
    private String numeroPrivato;

    @Column(name = "emailPrivata")
    private String emailPrivata;

    @Column(name = "codiceFiscale")
    private String codiceFiscale;

    @Column(name = "tesseramentoAttivo")
    private boolean tesseramentoAttivo;

    @Column(name = "nomeAzienda")
    private String nomeAzienda;

    @Column(name = "ragioneSociale")
    private String ragioneSociale;

    @Column(name = "numeroAzienda")
    private String numeroAzienda;

    @Column(name = "emailAzienda")
    private String emailAzienda;

    @Column(name = "comune")
    private String comune;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private String cap;

    @Column(name = "descrizioneBreve")
    private String descrizioneBreve;

    @Column(name = "descrizioneLunga")
    private String descrizioneLunga;

    @Column(name = "linkFacebook")
    private String linkFacebook;

    @Column(name = "linkYoutube")
    private String linkYoutube;

    @Column(name = "linkInstagram")
    private String linkInstagram;

    @Column(name = "linkWebsite")
    private String linkWebsite;

    @Column(name = "linkTicToc")
    private String linkTicToc;

    @Column(name = "tipoProdotto")
    private String tipoProdotto;

    @Column(name = "password")
    private String password;

    @Column(name = "image1")
    private String image1;

    @Column(name = "image2")
    private String image2;

    @Column(name = "image3")
    private String image3;

    @Column(name = "image4")
    private String image4;

    @Column(name = "image5")
    private String image5;

}
