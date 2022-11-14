package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaDTO implements Serializable {

    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String numeroPubblico;

    @NotBlank
    private String email;

    @NotNull
    private UUID produttore;

    @NotNull
    private UUID comune;

    @NotNull
    private UUID provincia;
}
