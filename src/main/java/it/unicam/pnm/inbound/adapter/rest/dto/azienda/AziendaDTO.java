package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaDTO implements Serializable {

    private UUID id;

    private String nome;

    private String numeroPubblico;

    private String email;

    private UUID produttore;

    private UUID comune;

    private UUID provincia;
}
