package org.academiadecodigo.whiledlings.hackathon.converter;
import org.academiadecodigo.whiledlings.hackathon.dto.SolicitationDto;
import org.academiadecodigo.whiledlings.hackathon.factory.ResquestFactory;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SolicitationDtoToSolicitation implements Converter<SolicitationDto, Solicitation> {

    private ResquestFactory resquestFactory;

    @Autowired
    public void setResquestFactory(ResquestFactory resquestFactory) {
        this.resquestFactory = resquestFactory;
    }

    @Override
    public Solicitation convert(SolicitationDto solicitationDto) {
        Solicitation solicitation = null;


        System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(solicitationDto.toString());
        System.out.println("-----------------------------");

        solicitation = resquestFactory.createSolicitation(solicitationDto.getSolicitationType());
        solicitation.setDescription(solicitationDto.getDescription());

        return solicitation;
    }
}
