package com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.domain;

import com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.entity.AggregateRootInterface;
import com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.entity.BaseEntity;
import com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.valueobject.IdValueObject;

import java.math.BigDecimal;

public class Product extends BaseEntity implements AggregateRootInterface {

    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private Integer stock;

    public Product(final IdValueObject id, final String name, final String description, final BigDecimal purchasePrice, final Integer stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }

    public Product(final String name, final String description, final BigDecimal purchasePrice, final Integer stock) {
        super();
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
