package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@DataJpaTest
@Import({ProductPersistenceAdapter.class, ProductMapper.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductAdapterTest {
    @Autowired
    ProductPersistenceAdapter adapterUnderTest;
    @Autowired
    ProductRepository productRepository;

    @Test
    void createSimpleProduct_withValidInput_thenNewProductReturn() {
        Date publishDate = new GregorianCalendar(2020, Calendar.OCTOBER, 18, 16, 0, 0).getTime();
        ICreateSimpleProductUseCase.CreateSimpleProductDataOut expected = new ICreateSimpleProductUseCase.CreateSimpleProductDataOut(
                new Product(
                        new Product.ProductId(1L),
                        "description",
                        "url_link",
                        "new product",
                        publishDate,
                        EProductStatus.PUBLISHING,
                        300,
                        EProductType.TRANSLATED
                )
        );

        ICreateSimpleProductUseCase.CreateSimpleProductDataIn in = new ICreateSimpleProductUseCase.CreateSimpleProductDataIn(
                "description",
                "url_link",
                "new product",
                publishDate,
                EProductStatus.PUBLISHING,
                300,
                EProductType.TRANSLATED
        );
        ICreateSimpleProductUseCase.CreateSimpleProductDataOut actual = adapterUnderTest.createSimpleProduct(in);
    }
}
