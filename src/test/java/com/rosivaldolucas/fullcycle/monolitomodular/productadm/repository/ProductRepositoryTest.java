package com.rosivaldolucas.fullcycle.monolitomodular.productadm.repository;

import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.domain.Product;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.gateway.ProductGateway;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.repository.ProductEntity;
import com.rosivaldolucas.fullcycle.monolitomodular.produtoadm.repository.ProductRepository;
import com.rosivaldolucas.fullcycle.monolitomodular.shared.domain.valueobject.IdValueObject;
import org.hibernate.dialect.Dialect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductGateway productGateway;

    @DisplayName("Test injected dependencies")
    @Test
    public void test00() {
        Assertions.assertNotNull(this.productRepository);
        Assertions.assertNotNull(this.productGateway);
    }

    @DisplayName("Should test repository")
    @Test
    public void test01() {
        final IdValueObject id = new IdValueObject();
        final String name = "Product 1";
        final String description = "Product 1 description";
        final BigDecimal purchasePrice = BigDecimal.valueOf(100.00);
        final Integer stock = 10;

        final Product product = new Product(id, name, description, purchasePrice, stock);

        this.productGateway.add(product);

        final List<ProductEntity> products = this.productRepository.findAll();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(1, products.size());
    }

}
