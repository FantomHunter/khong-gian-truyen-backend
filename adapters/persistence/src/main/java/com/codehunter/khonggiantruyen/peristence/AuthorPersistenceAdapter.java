package com.codehunter.khonggiantruyen.peristence;

import com.codehunter.khonggiantruyen.PersistenceAdapter;
import com.codehunter.khonggiantruyen.core.port.out.IHasAuthorPort;
import com.codehunter.khonggiantruyen.peristence.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class AuthorPersistenceAdapter implements IHasAuthorPort {
    private final AuthorRepository authorRepository;

    @Override
    public Boolean hasAuthorWithId(@NonNull Long authorId) {
        return authorRepository.existsById(authorId);
    }
}
