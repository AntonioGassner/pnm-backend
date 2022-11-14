package it.unicam.pnm.outbound.adapter.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "pnm_azienda")
public class AziendaEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numeroPubblico")
    private String numeroPubblico;

    @Column(name = "numeroPubblico")
    private String email;

    @Column(name = "numeroPubblico")
    private UUID produttore;

    @Column(name = "numeroPubblico")
    private UUID comune;

    @Column(name = "numeroPubblico")
    private UUID provincia;

}
