package com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ValueObjectTest {

    @DisplayName("Should create IdValueObject with id String")
    @Test
    void test01() {
        final String uuid = UUID.randomUUID().toString();

        final IdValueObject id = new IdValueObject(uuid);

        Assertions.assertEquals(id.getId(), uuid);
    }

    @DisplayName("Should create IdValueObject with id empty and return new UUID String")
    @Test
    void test02() {
        final IdValueObject id = new IdValueObject("");

        Assertions.assertNotNull(id);
        Assertions.assertNotNull(id.getId());
    }

}
