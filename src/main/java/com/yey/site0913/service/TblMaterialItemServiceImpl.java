package com.yey.site0913.service;

import com.yey.site0913.domain.Board;
import com.yey.site0913.domain.TblMaterialItem;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.dto.TblMaterialItemDTO;
import com.yey.site0913.repository.TblMaterialItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class TblMaterialItemServiceImpl implements TblMaterialItemService{
    private final ModelMapper modelMapper;
    private final TblMaterialItemRepository tblMaterialItemRepository;

    @Override
    public String register(TblMaterialItemDTO tblMaterialItemDTO) {
        TblMaterialItem tblMaterialItem = modelMapper.map(tblMaterialItemDTO, TblMaterialItem.class);
        String matItemID = tblMaterialItemRepository.save(tblMaterialItem).getMatItemID();
        return matItemID;
    }

    @Override
    public PageResponseDTO<TblMaterialItemDTO> list(PageRequestDTO pageRequestDTO) {
        log.info("material Item service...................List");
        Pageable pageable = pageRequestDTO.getPageable("matItemID");
        Page<TblMaterialItem> result = tblMaterialItemRepository.findAll(pageable);

        List<TblMaterialItemDTO> tblMaterialItemDTOList = result
                .getContent()
                .stream()
                .map(tblMaterialItem -> modelMapper.map(tblMaterialItem, TblMaterialItemDTO.class))
                .collect(Collectors.toList());
//        long result = tblMaterialItemRepository.count();
        return PageResponseDTO.<TblMaterialItemDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(tblMaterialItemDTOList)
                .total((int)result.getTotalElements())
                .build();
    }
}
