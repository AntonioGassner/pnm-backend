package it.unicam.pnm.outbound.adapter.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "pnm_produttore")
public class ProduttoreEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "codiceFiscale")
    private String codiceFiscale;

    @Column(name = "numeroPrivato")
    private String numeroPrivato;

    @Column(name = "email")
    private String email;

    @Column(name = "partitaIva")
    private String partitaIva;

    @Column(name = "tesseramentoAttivo")
    private boolean tesseramentoAttivo;
}
