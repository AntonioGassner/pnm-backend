package it.unicam.pnm.outbound.adapter.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "azienda")
@AllArgsConstructor
@NoArgsConstructor
public class AziendaEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank
    @Column(name = "nome_produttore")
    private String nomeProduttore;

    @NotBlank
    @Column(name = "cognome_produttore")
    private String cognomeProduttore;

    @NotBlank
    @Column(name = "partita_iva")
    private String partitaIva;

    @NotBlank
    @Column(name = "numero_privato")
    private String numeroPrivato;

    @NotBlank
    @Column(name = "email_privata")
    private String emailPrivata;

    @NotBlank
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "tesseramento_attivo")
    private boolean tesseramentoAttivo;

    @NotBlank
    @Column(name = "nome_azienda")
    private String nomeAzienda;

    @NotBlank
    @Column(name = "ragione_sociale")
    private String ragioneSociale;

    @Column(name = "numero_azienda")
    private String numeroAzienda;

    @Column(name = "email_azienda")
    private String emailAzienda;

    @NotBlank
    @Column(name = "comune")
    private String comune;

    @NotBlank
    @Column(name = "provincia")
    private String provincia;

    @NotBlank
    @Column(name = "indirizzo")
    private String indirizzo;

    @NotBlank
    @Column(name = "cap")
    private String cap;

    @Column(name = "descrizione_breve")
    private String descrizioneBreve;

    @Column(name = "descrizione_lunga")
    private String descrizioneLunga;

    @Column(name = "link_facebook")
    private String linkFacebook;

    @Column(name = "link_youtube")
    private String linkYoutube;

    @Column(name = "link_instagram")
    private String linkInstagram;

    @Column(name = "link_website")
    private String linkWebsite;

    @Column(name = "link_tictoc")
    private String linkTicToc;

    @Column(name = "tipo_prodotto")
    private String tipoProdotto;

    @Column(name = "password")
    private String password;

}
