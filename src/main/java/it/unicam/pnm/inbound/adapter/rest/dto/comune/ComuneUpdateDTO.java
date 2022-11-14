package it.unicam.pnm.inbound.adapter.rest.dto.comune;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ComuneUpdateDTO implements Serializable {

    private UUID id;

    @NotBlank
    private String nome;

    @NotNull
    private UUID provincia;
}
