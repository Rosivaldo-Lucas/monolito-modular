package com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.gateway;

import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.domain.Product;

public interface ProductGateway {

    Product find(final String id);

    void add(final Product product);

}
