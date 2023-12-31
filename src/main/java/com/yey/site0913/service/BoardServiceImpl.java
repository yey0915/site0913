package com.yey.site0913.service;

import com.yey.site0913.domain.Board;
import com.yey.site0913.dto.BoardDTO;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }

    @Override
    public BoardDTO readOne(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);

        return boardDTO;
    }

//    @Override
//    public List<BoardDTO> list() {
//        log.info("service............list");
//        List<BoardDTO>  boardDTOList = boardRepository.findAll()
//                .stream()
//                .map(board -> modelMapper.map(board, BoardDTO.class))
//                .collect(Collectors.toList());
//        return boardDTOList;
//    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {

        log.info("service................list");
        Pageable pageable = pageRequestDTO.getPageable("bno");
        Page<Board> result = boardRepository.findAll(pageable);

        List<BoardDTO>  boardDTOList = result
                .getContent()
                .stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());

        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(boardDTOList)
                .total((int)result.getTotalElements())
                .build();
    }

//    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
//
//        log.info("service................list");
//        List<BoardDTO>  boardDTOList = boardRepository.findAll()
//                .stream()
//                .map(board -> modelMapper.map(board, BoardDTO.class))
//                .collect(Collectors.toList());
//
//        long result = boardRepository.count();
//
//        return PageResponseDTO.<BoardDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(boardDTOList)
//                .total((int)result)
//                .build();
//    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        Board board = result.orElseThrow();
        board.change(boardDTO);
        boardRepository.save(board);
    }

}
