package it.unicam.pnm.inbound.adapter.rest.dto.azienda;

import it.unicam.pnm.inbound.adapter.rest.dto.comune.ComuneDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.produttore.ProduttoreDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.provincia.ProvinciaDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class AziendaDTO implements Serializable {

    private UUID id;

    private String nome;

    private String numeroPubblico;

    private String email;

    private ProduttoreDTO produttore;

    private ComuneDTO comune;

    private ProvinciaDTO provincia;
}
