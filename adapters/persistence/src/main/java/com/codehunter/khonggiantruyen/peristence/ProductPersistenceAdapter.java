package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.exception.EntityNotFoundException;
import com.codehunter.khonggiantruyen.core.port.in.*;
import com.codehunter.khonggiantruyen.core.port.out.*;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.entity.AuthorDao;
import com.codehunter.khonggiantruyen.peristence.entity.CategoryDao;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.AuthorRepository;
import com.codehunter.khonggiantruyen.peristence.repository.CategoryRepository;
import com.codehunter.khonggiantruyen.peristence.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class ProductPersistenceAdapter implements ICreateProductPort, IGetAllProductPort, IDeleteProductPort,
        IHasProductPort, IUpdateProductPort, IAddCategoryToProductPort, IAddAuthorToProductPort {
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String AUTHOR_NOT_FOUND = "Author not found";
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Override
    public ICreateSimpleProductUseCase.CreateSimpleProductDataOut createSimpleProduct(ICreateSimpleProductUseCase.CreateSimpleProductDataIn in) {
        ProductDao productDao = productRepository.save(productMapper.mapToProductDao(in));
        return productMapper.mapToCreateSimpleProductDataOut(productDao);
    }

    @Override
    public IGetAllProductUseCase.GetAllProductDataOut getAllProduct(IGetAllProductUseCase.GetAllProductDataIn in) {
        IGetAllProductUseCase.GetAllProductDataOut result = new IGetAllProductUseCase.GetAllProductDataOut();
        List<Product> productList = new ArrayList<>();
        switch (in.getOrderBy()) {
            case BY_ID:
                productList = productRepository
                        .findAll(PageRequest.of(in.getPage(), in.getSize(), Sort.by("id")))
                        .stream()
                        .map(productMapper::mapToProduct)
                        .collect(Collectors.toList());
                break;
            case BY_COMMENT:
                productList = productRepository
                        .findAllProductOrderByCommentCountDesc(PageRequest.of(in.getPage(), in.getSize()))
                        .stream()
                        .map(productMapper::mapToProduct)
                        .collect(Collectors.toList());
                break;
            case BY_TIME:
                productList = productRepository
                        .findAll(PageRequest.of(in.getPage(), in.getSize(), Sort.by(Sort.Direction.DESC, "publishDate")))
                        .stream()
                        .map(productMapper::mapToProduct)
                        .collect(Collectors.toList());
                break;
            case BY_VIEW:
            default:
                throw new NotYetImplementedException("Filter by view is not supported");
        }
        result.getProductList().addAll(productList);
        return result;
    }

    @Override
    public void deleteProduct(IDeleteProductUseCase.DeleteProductDataIn in) {
        productRepository.deleteById(in.getId());
    }

    @Override
    public Boolean hasProductWithId(@NonNull Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public IUpdateProductUseCase.UpdateProductDataOut updateProduct(IUpdateProductUseCase.UpdateProductDataIn in) throws EntityNotFoundException {
        Optional<ProductDao> productDao = productRepository.findById(in.getProduct().getId().getValue());
        if (productDao.isPresent()) {
            ProductDao productDaoUpdate = productRepository.save(productMapper.mapToProductDaoWithTarget(in.getProduct(), productDao.get()));
            return new IUpdateProductUseCase.UpdateProductDataOut(productMapper.mapToProduct(productDaoUpdate));
        }
        throw new EntityNotFoundException(PRODUCT_NOT_FOUND);
    }

    @Override
    public void addCategoryToProduct(IAddCategoryToProductUseCase.AddCategoryToProductDataIn dataIn) throws EntityNotFoundException {
        ProductDao productDao = productRepository.findById(dataIn.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT_NOT_FOUND));
        CategoryDao categoryDao = categoryRepository.findById(dataIn.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException(CATEGORY_NOT_FOUND));
        if (!productDao.getCategoryList().contains(categoryDao)) {
            productDao.getCategoryList().add(categoryDao);
            productRepository.save(productDao);
        }
    }

    @Override
    public void addAuthorToProductPort(IAddAuthorToProductUseCase.AddAuthorToProductDataIn dataIn) throws EntityNotFoundException {
        ProductDao productDao = productRepository.findById(dataIn.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT_NOT_FOUND));
        AuthorDao authorDao = authorRepository.findById(dataIn.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException(AUTHOR_NOT_FOUND));
        if (!authorDao.equals(productDao.getAuthor())) {
            productDao.setAuthor(authorDao);
            productRepository.save(productDao);
        }
    }
}
