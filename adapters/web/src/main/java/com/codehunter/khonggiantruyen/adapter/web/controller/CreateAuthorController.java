package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.common.AuthorDto;
import com.codehunter.khonggiantruyen.adapter.web.api.createauthor.CreateAuthorRequest;
import com.codehunter.khonggiantruyen.adapter.web.api.createauthor.CreateAuthorResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.createauthor.ICreateAuthorApi;
import com.codehunter.khonggiantruyen.core.port.in.ICreateAuthorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class CreateAuthorController implements ICreateAuthorApi {
    private final ICreateAuthorUseCase createAuthorUseCase;

    @Override
    public CreateAuthorResponse createAuthor(CreateAuthorRequest request) {
        log.info("createAuthor: {}", request);
        ICreateAuthorUseCase.CreateAuthorDataOut author = createAuthorUseCase.createAuthor(new ICreateAuthorUseCase.CreateAuthorDataIn(request.getName()));
        return CreateAuthorResponse.builder()
                .newAuthor(AuthorDto.builder()
                        .id(author.getAuthor().getId())
                        .name(author.getAuthor().getName())
                        .build())
                .build();
    }
}
