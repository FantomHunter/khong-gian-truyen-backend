package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.in.ICreateSimpleProductUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteProductUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllProductUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IDeleteProductPort;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllProductPort;
import com.codehunter.khonggiantruyen.domain.Product;
import com.codehunter.khonggiantruyen.peristence.entity.ProductDao;
import com.codehunter.khonggiantruyen.peristence.mapper.ProductMapper;
import com.codehunter.khonggiantruyen.peristence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class ProductPersistenceAdapter implements ICreateProductPort, IGetAllProductPort, IDeleteProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ICreateSimpleProductUseCase.CreateSimpleProductDataOut createSimpleProduct(ICreateSimpleProductUseCase.CreateSimpleProductDataIn in) {
        ProductDao productDao = productRepository.save(productMapper.mapToProductDao(in));
        return productMapper.maptoCreateSimpleProductDataOut(productDao);
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
}
