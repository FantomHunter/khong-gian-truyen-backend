package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.*;
import com.codehunter.khonggiantruyen.domain.EProductStatus;
import com.codehunter.khonggiantruyen.domain.EProductType;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.entity.CategoryDao;
import com.codehunter.khonggiantruyen.peristence.entity.CommentDao;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import com.codehunter.khonggiantruyen.peristence.mapper.CategoryMaper;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.CategoryRepository;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Import({ProductPersistenceAdapter.class, ProductMapper.class, CategoryMaper.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductAdapterTest {
    @Autowired
    ProductPersistenceAdapter adapterUnderTest;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CategoryRepository categoryRepository;

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
                        EProductType.TRANSLATED,
                        null,
                        null
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

    @Test
    @Sql("product.sql")
    void updateProduct_withExistId_thenSuccess() throws EntityNotFoundException {
        // before
        IGetAllProductUseCase.GetAllProductDataOut before = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_ID));

        assertNotNull(before);
        assertNotNull(before.getProductList());
        assertEquals(3, before.getProductList().size());
        assertEquals(6, commentRepository.findAll().size());
        assertEquals("product name 1", before.getProductList().get(0).getName());
        assertEquals(1L, before.getProductList().get(0).getId().getValue());

        Date publishDate = new GregorianCalendar(2021, Calendar.OCTOBER, 18, 16, 0, 0).getTime();
        adapterUnderTest.updateProduct(new IUpdateProductUseCase.UpdateProductDataIn(
                new Product(
                        new Product.ProductId(1L),
                        "description",
                        "url_link",
                        "product updated",
                        publishDate,
                        EProductStatus.PUBLISHING,
                        300,
                        EProductType.TRANSLATED,
                        null,
                        null
                )
        ));

        // after
        IGetAllProductUseCase.GetAllProductDataOut after = adapterUnderTest.getAllProduct(new IGetAllProductUseCase.GetAllProductDataIn(
                0, 10, IGetAllProductUseCase.GetAllProductDataIn.EOrder.BY_ID));

        assertNotNull(after);
        assertNotNull(after.getProductList());
        assertEquals("product updated", after.getProductList().get(0).getName());
        // the comment of the product is still kept
        assertEquals(6, commentRepository.findAll().size());
    }

    @Test
    @Sql("product.sql")
    void addCategoryToProduct_withExistedCategoryAndProduct_thenSuccess() throws EntityNotFoundException {
        // before
        ProductDao productDaoBefore = productRepository.findById(1L).orElse(null);
        assertNotNull(productDaoBefore);
        assertNotNull(productDaoBefore.getCategoryList());
        assertEquals(0,productDaoBefore.getCategoryList().size());
        CategoryDao categoryDao = categoryRepository.findById(1L).orElse(null);
        assertNotNull(categoryDao);

        adapterUnderTest.addCategoryToProduct(new IAddCategoryToProductUseCase.AddCategoryToProductDataIn(1L, 1L));

        ProductDao productDaoAfter = productRepository.findById(1L).orElse(null);
        assertNotNull(productDaoAfter);
        assertNotNull(productDaoAfter.getCategoryList());
        assertEquals(1,productDaoAfter.getCategoryList().size());


    }

}
