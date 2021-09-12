package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IDeleteCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IDeleteCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllCategoryPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasCategoryPort;
import com.codehunter.khonggiantruyen.domain.Category;
import com.codehunter.khonggiantruyen.peristence.entity.CategoryDao;
import com.codehunter.khonggiantruyen.peristence.mapper.CategoryMaper;
import com.codehunter.khonggiantruyen.peristence.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.stream.Collectors.toList;

@PersistenceAdapter
@AllArgsConstructor
@Slf4j
public class CategoryPersistenceAdapter implements ICreateCategoryPort, IGetAllCategoryPort, IDeleteCategoryPort, IHasCategoryPort {
    private final CategoryRepository categoryRepository;
    private final CategoryMaper categoryMaper;

    @Override
    public ICreateCategoryUseCase.CreateCategoryDataOut createCategory(ICreateCategoryUseCase.CreateCategoryDataIn dataIn) {
        CategoryDao categoryDao = categoryRepository.save(
                CategoryDao.builder()
                        .name(dataIn.getName())
                        .build());
        return new ICreateCategoryUseCase.CreateCategoryDataOut(categoryMaper.mapToCategory(categoryDao));
    }


    @Override
    public IGetAllCategoryUseCase.GetAllCategoryDataOut getAllCategory() {
        IGetAllCategoryUseCase.GetAllCategoryDataOut out = new IGetAllCategoryUseCase.GetAllCategoryDataOut();
        List<Category> categoryList = categoryRepository.findAll()
                .stream()
                .map(categoryMaper::mapToCategory)
                .collect(toList());
        out.getCategories().addAll(categoryList);
        return out;
    }

    @Override
    public void deleteCategory(IDeleteCategoryUseCase.DeleteCategoryDataIn dataIn) {
        categoryRepository.deleteById(dataIn.getId());
    }

    @Override
    public Boolean hasCategoryWithId(@NonNull Long id) {
        return categoryRepository.findById(id).isPresent();
    }
}
