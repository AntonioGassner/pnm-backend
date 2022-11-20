package it.unicam.pnm.inbound.adapter.rest.dto.provincia;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProvinciaCreateDTO implements Serializable {

    @NotBlank
    private String nome;

}
