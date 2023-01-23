package com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.entity;

import com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.valueobject.IdValueObject;

import java.time.LocalDateTime;

public class BaseEntity {

    private IdValueObject id;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public BaseEntity(final IdValueObject id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public IdValueObject getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
