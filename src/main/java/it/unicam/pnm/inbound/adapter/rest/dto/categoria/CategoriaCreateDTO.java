package it.unicam.pnm.inbound.adapter.rest.dto.categoria;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CategoriaCreateDTO implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String descrizione;

}
