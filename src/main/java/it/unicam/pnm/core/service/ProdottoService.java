package it.unicam.pnm.core.service;

import it.unicam.pnm.core.mapper.inbound.TipoProdottoDTOMapper;
import it.unicam.pnm.core.model.TipoProdottoModel;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCreateDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoCriteria;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoDTO;
import it.unicam.pnm.inbound.adapter.rest.dto.tipoProdotto.TipoProdottoUpdateDTO;
import it.unicam.pnm.inbound.port.TipoProdottoInboundPort;
import it.unicam.pnm.outbound.port.TipoProdottoOutboundPort;
import it.unicam.pnm.web.rest.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TipoProdottoService implements TipoProdottoInboundPort {

    @Autowired
    private TipoProdottoDTOMapper tipoProdottoMapper;

    @Autowired
    private TipoProdottoOutboundPort tipoProdottoPersistence;

    @Override
    public TipoProdottoDTO create(TipoProdottoCreateDTO dto) {
        TipoProdottoDTO tipoProdottoDto = tipoProdottoMapper.fromCreateDTO(dto);
        //this.validate(tipoProdottoDto);
        return tipoProdottoMapper.toDto(tipoProdottoPersistence.save(tipoProdottoMapper.toModel(tipoProdottoDto)));
    }

    @Override
    public Page<TipoProdottoDTO> search(TipoProdottoCriteria criteria, Pageable pageRequest) {
        Page<TipoProdottoModel> models = tipoProdottoPersistence.search(criteria, pageRequest);
        return models.map(model -> this.tipoProdottoMapper.toDto(model));
    }

    @Override
    public TipoProdottoDTO update(TipoProdottoUpdateDTO dto) {
        this.checkExists(dto.getId());
        TipoProdottoDTO tipoProdottoDto = tipoProdottoMapper.fromUpdateDTO(dto);
        //this.validate(tipoProdottoDto);
        return tipoProdottoMapper.toDto(tipoProdottoPersistence.save(tipoProdottoMapper.toModel(tipoProdottoDto)));
    }

    @Override
    public void delete(UUID id) {
        this.checkExists(id);
        tipoProdottoPersistence.delete(id);
    }

    private void checkExists(UUID id){
        if(!tipoProdottoPersistence.existsById(id)){
            throw new NotFoundException(String.format("TipoProdotto %s non trovato", id));
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