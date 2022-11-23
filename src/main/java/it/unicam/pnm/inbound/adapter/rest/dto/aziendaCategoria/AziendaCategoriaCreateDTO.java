package it.unicam.pnm.inbound.adapter.rest.dto.aziendaCategoria;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaCategoriaCreateDTO implements Serializable {

    @NotNull
    private UUID azienda;

    @NotNull
    private UUID categoria;

}
