package com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.valueobject;

import java.util.UUID;

public class IdValueObject implements ValueObjectInterface {

    private final String id;

    public IdValueObject() {
        this.id = UUID.randomUUID().toString();
    }

    public IdValueObject(final String id) {
        this.id = id.equals("") ? UUID.randomUUID().toString() : id;
    }

    public String getId() {
        return id;
    }

}
