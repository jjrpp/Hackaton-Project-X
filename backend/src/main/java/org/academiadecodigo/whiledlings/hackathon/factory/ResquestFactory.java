package org.academiadecodigo.whiledlings.hackathon.factory;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.*;
import org.springframework.stereotype.Component;

@Component
public class ResquestFactory {

    public Solicitation createSolicitation(String solicitationType) {

        Solicitation newSolicitation;

        switch (solicitationType) {

            case "BABYSOLICITATION":
                newSolicitation = new BabySolicitation();
                break;
            case "BOOKSOLICITATION":
                newSolicitation = new BookSolicitation();
                break;
            case "CLOTHINGSOLICITATION":
                newSolicitation = new ClothingSolicitation();
                break;
            case "EDUCATIONSOLICITATION":
                newSolicitation = new EducationSolicitation();
                break;
            case "COUNSELINGSOLICITATION":
                newSolicitation = new CounselingSolicitation();
                break;
                default:
                    throw new IllegalArgumentException("Wrong type");

        }

        return newSolicitation;
    }

}
