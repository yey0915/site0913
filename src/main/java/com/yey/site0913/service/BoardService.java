package com.yey.site0913.service;

import com.yey.site0913.dto.BoardDTO;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;

import java.util.List;

public interface BoardService{

    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);

//    List<BoardDTO> list();
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

    void modify(BoardDTO boardDTO);

}
