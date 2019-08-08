package org.academiadecodigo.whiledlings.hackathon.factory;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.*;

public class ResquestFactory {

    public Solicitation createSolicitation(SolicitationType solicitationType) {

        Solicitation newSolicitation;

        switch (solicitationType) {

            case BABYSOLICITATION:
                newSolicitation = new BabySolicitation();
                break;
            case MATERIALSOLICITATION:
                newSolicitation = new MaterialSolicitation();
                break;
            case EDUCATIONSOLICITATION:
                newSolicitation = new EducationSolicitation();
                break;
            case COUNSELINGSOLICITATION:
                newSolicitation = new CounselingSolicitation();
                break;
                default:
                    throw new IllegalArgumentException("Wrong type");

        }

        return newSolicitation;
    }

}
