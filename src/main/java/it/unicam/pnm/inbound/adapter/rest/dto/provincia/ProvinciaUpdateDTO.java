package it.unicam.pnm.inbound.adapter.rest.dto.provincia;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProvinciaUpdateDTO implements Serializable {

    private UUID id;

    @NotBlank
    private String nome;
}
