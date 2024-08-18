package com.example.community.service;

import com.example.community.com.Search;
import com.example.community.dto.BoardDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {

    Page<BoardDto> getBoardsByTypeWithPaging(String boardType, Search search);

    int getTotalBoardCountByType(String boardType);

    BoardDto getBoardById(Long id);

    void createBoard(BoardDto boardDto);

    void updateBoard(BoardDto boardDto);

    void incrementHitCount(Long id);

    void deleteBoard(String boardType);

}

