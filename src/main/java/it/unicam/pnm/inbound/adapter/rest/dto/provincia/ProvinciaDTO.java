package it.unicam.pnm.inbound.adapter.rest.dto.provincia;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProvinciaDTO implements Serializable {

    private UUID id;

    private String nome;

}