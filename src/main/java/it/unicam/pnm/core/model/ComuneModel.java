package it.unicam.pnm.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ComuneModel implements Serializable {

    private UUID id;

    private String nome;

    private UUID provincia;

}
