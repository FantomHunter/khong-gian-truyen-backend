package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.in.ICreateCategoryUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateCategoryPort;
import com.codehunter.khonggiantruyen.domain.Category;
import com.codehunter.khonggiantruyen.peristence.entity.CategoryDao;
import com.codehunter.khonggiantruyen.peristence.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@PersistenceAdapter
@AllArgsConstructor
@Slf4j
public class CategoryPersistenceAdapter implements ICreateCategoryPort {
    private final CategoryRepository categoryRepository;

    @Override
    public ICreateCategoryUseCase.CreateCategoryDataOut createCategory(ICreateCategoryUseCase.CreateCategoryDataIn dataIn) {
        CategoryDao categoryDao = categoryRepository.save(
                CategoryDao.builder()
                        .name(dataIn.getName())
                        .build());
        return new ICreateCategoryUseCase.CreateCategoryDataOut(
                Category.builder()
                        .id(categoryDao.getId())
                        .name(categoryDao.getName())
                        .build());
    }
}
