package com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.usecase.addproduct;

import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.domain.Product;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.gateway.ProductGateway;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddProduct {

    private final ProductGateway productRepository;

    public AddProduct(final ProductGateway productRepository) {
        this.productRepository = productRepository;
    }

    public AddProductOutputDto execute(final AddProductInputDto addProductInputDto) {
        final Product product = this.convertProductInputDtoToProduct(addProductInputDto);

        this.productRepository.add(product);

        final AddProductOutputDto productOutputDto = this.convertProductToProductOutputDto(product);

        return productOutputDto;
    }

    private Product convertProductInputDtoToProduct(final AddProductInputDto addProductInputDto) {
        return new Product(
                addProductInputDto.getName(),
                addProductInputDto.getDescription(),
                addProductInputDto.getPurchasePrice(),
                addProductInputDto.getStock()
        );
    }

    private AddProductOutputDto convertProductToProductOutputDto(final Product product) {
        final String id = product.getId().getId();
        final String name = product.getName();
        final String description = product.getDescription();
        final BigDecimal purchasePrice = product.getPurchasePrice();
        final Integer stock = product.getStock();
        final LocalDateTime createdAt = product.getCreatedAt();
        final LocalDateTime updatedAt = product.getUpdatedAt();

        final AddProductOutputDto productOutputDto = new AddProductOutputDto();
        productOutputDto.setId(id);
        productOutputDto.setName(name);
        productOutputDto.setDescription(description);
        productOutputDto.setPurchasePrice(purchasePrice);
        productOutputDto.setStock(stock);
        productOutputDto.setCreatedAt(createdAt);
        productOutputDto.setUpdatedAt(updatedAt);

        return productOutputDto;
    }

}
