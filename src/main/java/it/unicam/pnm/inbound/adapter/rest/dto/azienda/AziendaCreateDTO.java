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
public class AziendaCreateDTO implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String numeroPubblico;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private UUID produttore;

    @NotNull
    private UUID comune;

    @NotNull
    private UUID provincia;

}
