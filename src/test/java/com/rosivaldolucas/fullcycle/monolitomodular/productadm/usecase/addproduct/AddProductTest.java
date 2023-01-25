package com.rosivaldolucas.fullcycle.monolitomodular.productadm.usecase.addproduct;

import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.gateway.ProductGateway;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.usecase.addproduct.AddProduct;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.usecase.addproduct.AddProductInputDto;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.usecase.addproduct.AddProductOutputDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

class AddProductTest {

    @Mock
    private ProductGateway productRepository;

    @BeforeEach
    public void setup() {
        final AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);

        try {
            autoCloseable.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Should add a product")
    @Test
    void test01() {
        final AddProductInputDto addProductInputDto = new AddProductInputDto();
        addProductInputDto.setName("Product 1");
        addProductInputDto.setDescription("Product 1 description");
        addProductInputDto.setPurchasePrice(BigDecimal.valueOf(100.00));
        addProductInputDto.setStock(10);

        final AddProduct addProduct = new AddProduct(this.productRepository);

        Mockito.doNothing().when(this.productRepository).add(Mockito.any());

        final AddProductOutputDto productOutputDto = addProduct.execute(addProductInputDto);

        Assertions.assertNotNull(productOutputDto.getId());
        Assertions.assertEquals(productOutputDto.getName(), addProductInputDto.getName());
        Assertions.assertEquals(productOutputDto.getDescription(), addProductInputDto.getDescription());
        Assertions.assertEquals(productOutputDto.getPurchasePrice(), addProductInputDto.getPurchasePrice());
        Assertions.assertEquals(productOutputDto.getStock(), addProductInputDto.getStock());
        Assertions.assertNotNull(productOutputDto.getCreatedAt());
        Assertions.assertNotNull(productOutputDto.getUpdatedAt());
    }

}
