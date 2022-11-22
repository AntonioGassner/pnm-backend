package it.unicam.pnm.outbound.adapter.persistence.entity;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "numeroPubblico")
    private String numeroPubblico;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @JoinColumn(name = "id_produttore", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ProduttoreEntity produttore;

    @NotNull
    @JoinColumn(name = "id_comune", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ComuneEntity comune;

    @NotNull
    @JoinColumn(name = "id_provincia", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ProvinciaEntity provincia;

}
