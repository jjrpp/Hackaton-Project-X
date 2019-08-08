package org.academiadecodigo.whiledlings.hackathon.converter;

import org.academiadecodigo.whiledlings.hackathon.dto.SolicitationDto;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;
import org.springframework.stereotype.Component;

@Component
public class SolicitationToSolicitationDtoConverter extends AbstractConverter<Solicitation, SolicitationDto> {


    @Override
    public SolicitationDto convert(Solicitation solicitation) {
        SolicitationDto solicitationDto = new SolicitationDto();
        solicitationDto.setDescription(solicitation.getDescription());
        solicitationDto.setId(solicitation.getId());
        solicitationDto.setPerson(solicitation.getPerson());

        return solicitationDto;
    }
}
