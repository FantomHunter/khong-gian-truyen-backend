package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.in.ICreateAuthorUseCase;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllAuthorUseCase;
import com.codehunter.khonggiantruyen.core.port.out.ICreateAuthorPort;
import com.codehunter.khonggiantruyen.core.port.out.IGetAllAuthorPort;
import com.codehunter.khonggiantruyen.core.port.out.IHasAuthorPort;
import com.codehunter.khonggiantruyen.domain.Author;
import com.codehunter.khonggiantruyen.peristence.entity.AuthorDao;
import com.codehunter.khonggiantruyen.peristence.repository.AuthorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class AuthorPersistenceAdapter implements IHasAuthorPort, ICreateAuthorPort, IGetAllAuthorPort {
    private final AuthorRepository authorRepository;

    @Override
    public Boolean hasAuthorWithId(@NonNull Long authorId) {
        return authorRepository.existsById(authorId);
    }

    @Override
    public ICreateAuthorUseCase.CreateAuthorDataOut createAuthor(ICreateAuthorUseCase.CreateAuthorDataIn dataIn) {
        AuthorDao authorDao = authorRepository.save(new AuthorDao(null, dataIn.getName(), null));
        return new ICreateAuthorUseCase.CreateAuthorDataOut(Author.builder()
                .id(authorDao.getId())
                .name(authorDao.getName())
                .build());
    }

    @Override
    public IGetAllAuthorUseCase.GetAllAuthorDataOut getAllAuthor(IGetAllAuthorUseCase.GetAllAuthorDataIn dataIn) {
        List<Author> authorList = authorRepository.findAll(PageRequest.of(dataIn.getPage(), dataIn.getSize()))
                .stream()
                .map(authorDao -> new Author(authorDao.getId(), authorDao.getName()))
                .collect(toList());
        return new IGetAllAuthorUseCase.GetAllAuthorDataOut(authorList);
    }
}
