package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllProductUseCase;
import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.CommentRepository;
import com.codehunter.khonggiantruyen.peristence.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Import({ProductPersistenceAdapter.class, ProductMapper.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductAdapterTest {
    @Autowired
    ProductPersistenceAdapter adapterUnderTest;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CommentRepository commentRepository;

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

    @Test
    @Sql("product.sql")
    void getAllProduct_withOrderById_theReturn3Product() {
        IGetAllProductUseCase.GetAllProductDataOut actual = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_ID));

        assertNotNull(actual);
        assertNotNull(actual.getProductList());
        assertEquals(3, actual.getProductList().size());
        assertEquals(1L, actual.getProductList().get(0).getId().getValue());
        assertEquals(2L, actual.getProductList().get(1).getId().getValue());
        assertEquals(3L, actual.getProductList().get(2).getId().getValue());
    }

    @Test
    @Sql("product.sql")
    void getAllProduct_withOrderByComment_theReturn3OrderedProduct() {
        IGetAllProductUseCase.GetAllProductDataOut actual = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_COMMENT));

        assertNotNull(actual);
        assertNotNull(actual.getProductList());
        assertEquals(3, actual.getProductList().size());
        assertEquals(2L, actual.getProductList().get(0).getId().getValue());
        assertEquals(3L, actual.getProductList().get(1).getId().getValue());
        assertEquals(1L, actual.getProductList().get(2).getId().getValue());
    }

    @Test
    @Sql("product.sql")
    void getAllProduct_withOrderByPublishDate_theReturn3OrderedProduct() {
        IGetAllProductUseCase.GetAllProductDataOut actual = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_TIME));

        assertNotNull(actual);
        assertNotNull(actual.getProductList());
        assertEquals(3, actual.getProductList().size());
        assertEquals(1L, actual.getProductList().get(0).getId().getValue());
        assertEquals(3L, actual.getProductList().get(1).getId().getValue());
        assertEquals(2L, actual.getProductList().get(2).getId().getValue());
    }

    @Test
    @Sql("product.sql")
    void deleteProduct_withExistId_thenSuccess() {
        // before
        IGetAllProductUseCase.GetAllProductDataOut before = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_ID));

        assertNotNull(before);
        assertNotNull(before.getProductList());
        assertEquals(3, before.getProductList().size());
        assertEquals(6, commentRepository.findAll().size());

        adapterUnderTest.deleteProduct(new IDeleteProductUseCase.DeleteProductDataIn(2L));

        // after
        IGetAllProductUseCase.GetAllProductDataOut after = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_ID));

        assertNotNull(after);
        assertNotNull(after.getProductList());
        assertEquals(2, after.getProductList().size());
        // the comment of the product is also removed
        assertEquals(3, commentRepository.findAll().size());
    }
}
