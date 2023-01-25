package com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.repository;

import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.domain.Product;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.gateway.ProductGateway;
import org.springframework.stereotype.Component;

@Component
public class ProductPostgresGateway implements ProductGateway {

    private final ProductRepository productRepository;

    public ProductPostgresGateway(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product find(final String id) {
        return null;
    }

    @Override
    public void add(final Product product) {
        final ProductEntity productEntity = new ProductEntity();
        productEntity.setIdUUID(product.getId().getId());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPurchasePrice(product.getPurchasePrice());
        productEntity.setStock(product.getStock());
        productEntity.setCreatedAt(product.getCreatedAt());
        productEntity.setUpdatedAt(product.getUpdatedAt());

        this.productRepository.save(productEntity);
    }

}
