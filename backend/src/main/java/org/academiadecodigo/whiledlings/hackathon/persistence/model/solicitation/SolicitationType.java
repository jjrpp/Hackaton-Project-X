package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import java.util.Arrays;
import java.util.List;

public enum SolicitationType {

    BABYSOLICITATION,
    COUNSELINGSOLICITATION,
    EDUCATIONSOLICITATION,
    MATERIALSOLICITATION;

    public static List<SolicitationType> list(){
        return Arrays.asList(SolicitationType.values());
    }
}
