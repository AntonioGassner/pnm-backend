package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProvinciaModel implements Serializable {

    private UUID id;

    private String nome;

}
