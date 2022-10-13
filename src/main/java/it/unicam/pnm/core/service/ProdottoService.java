package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.ProdottoDTOMapper;
import it.unicam.pnm.core.model.ProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.prodotto.ProdottoUpdateDTO;
import it.unicam.pnm.inbound.port.ProdottoInboundPort;
import it.unicam.pnm.outbound.port.ProdottoOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdottoService implements ProdottoInboundPort {

    @Autowired
    private ProdottoDTOMapper prodottoMapper;

    @Autowired
    private ProdottoOutboundPort prodottoPersistence;

    @Override
    public ProdottoDTO create(ProdottoCreateDTO dto) {
        ProdottoDTO prodottoDto = prodottoMapper.fromCreateDTO(dto);
        //this.validate(prodottoDto);
        return prodottoMapper.toDto(prodottoPersistence.save(prodottoMapper.toModel(prodottoDto)));
    }

    @Override
    public Page<ProdottoDTO> search(ProdottoCriteria criteria, Pageable pageRequest) {
        Page<ProdottoModel> models = prodottoPersistence.search(criteria, pageRequest);
        return models.map(model -> this.prodottoMapper.toDto(model));
    }

    @Override
    public ProdottoDTO update(ProdottoUpdateDTO dto) {
        this.checkExists(dto.getId());
        ProdottoDTO prodottoDto = prodottoMapper.fromUpdateDTO(dto);
        //this.validate(prodottoDto);
        return prodottoMapper.toDto(prodottoPersistence.save(prodottoMapper.toModel(prodottoDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        prodottoPersistence.delete(id);
    }

    private void checkExists(UUID id){
        if(!prodottoPersistence.existsById(id)){
            throw new NotFoundException(String.format("Prodotto %s non trovato", id));
        }
    }

}

/*
// TODO validate

    private void validate(AperturaDTO dto) {

        boolean error = false;
        String error_validate = "";

        if (dto.getServizio() != null) {
            if (!servizioPersistence.existsById(dto.getServizio().getId())) {
                error = true;
                error_validate += "Servizio";
            }
        }

        if (dto.getIstituto() != null) {
            if (!istitutoPersistence.existsById(dto.getIstituto().getId())) {
                if (!error_validate.equals(""))
                    error_validate += ", ";

                error = true;
                error_validate += "Istituto";
            }
        }

        if (error) {
            log.warn("Apertura error: {}", error_validate);
            throw new BadRequestException(String.format("Errore creazione Apertura: %s non valido", error_validate));
        } else {
            DataValidation dataValidation = new DataValidation();
            dataValidation.validatePeriod(dto.getDataInizio(), dto.getDataFine());
        }
    }
 */

/*

// TODO checkInUse

private void checkInUse(UUID id) {

        boolean error = false;
        String error_validate = "";

        if (this.assenzaPersistence.containsClasseComposizione(id)) {
            error = true;
            error_validate += "Assenza";
        }

        if (this.classeComposizioneAnnoPersistence.containsClasseComposizione(id)) {
            if (!error_validate.equals(""))
                error_validate += ", ";
            error = true;
            error_validate += "ClasseComposizioneAnno";
        }

        if (this.giornoRefezionabilePersistence.containsClasseComposizione(id)) {
            if (!error_validate.equals(""))
                error_validate += ", ";
            error = true;
            error_validate += "GiornoRefezionabile";
        }

        if (error) {
            log.warn("ClasseComposizione error: {}", error_validate);
            throw new BadRequestException(String.format("Errore eliminazione ClasseComposizione, utilizzato da: %s ", error_validate));
        }
    }
 */