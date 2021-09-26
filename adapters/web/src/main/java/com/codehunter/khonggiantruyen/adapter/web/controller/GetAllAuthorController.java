package com.codehunter.khonggiantruyen.adapter.web.controller;

import com.codehunter.khonggiantruyen.WebAdapter;
import com.codehunter.khonggiantruyen.adapter.web.api.common.AuthorDto;
import com.codehunter.khonggiantruyen.adapter.web.api.getallauthor.GetAllAuthorResponse;
import com.codehunter.khonggiantruyen.adapter.web.api.getallauthor.IGetAllAuthorApi;
import com.codehunter.khonggiantruyen.core.port.in.IGetAllAuthorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class GetAllAuthorController implements IGetAllAuthorApi {
    private final IGetAllAuthorUseCase getAllAuthorUseCase;

    @Override
    public GetAllAuthorResponse getAllAuthor(@RequestParam Integer page, @RequestParam Integer size) {
        log.info("getAllAuthor: page: {}, size: {}", page, size);
        List<AuthorDto> authorDtoList = getAllAuthorUseCase.getAllAuthor(new IGetAllAuthorUseCase.GetAllAuthorDataIn(page, size))
                .getAuthorList()
                .stream()
                .map(author -> AuthorDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .build())
                .collect(Collectors.toList());
        return new GetAllAuthorResponse(authorDtoList);
    }
}
