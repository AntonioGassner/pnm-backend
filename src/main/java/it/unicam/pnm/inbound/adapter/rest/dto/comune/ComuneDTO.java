package it.unicam.pnm.inbound.adapter.rest.dto.comune;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ComuneDTO implements Serializable {

    private UUID id;

    private String nome;

    private UUID provincia;
}
