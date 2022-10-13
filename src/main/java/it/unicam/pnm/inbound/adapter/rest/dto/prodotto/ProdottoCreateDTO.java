package it.unicam.pnm.inbound.adapter.rest.dto.prodotto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProdottoCreateDTO implements Serializable {

    @NotBlank
    private String nome;

    @NotBlank
    private String descrizione;

}
