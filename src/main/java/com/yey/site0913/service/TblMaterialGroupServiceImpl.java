package com.yey.site0913.service;

import com.yey.site0913.domain.TblMaterialGroup;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.dto.TblMaterialGroupDTO;
import com.yey.site0913.repository.TblMaterialGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class TblMaterialGroupServiceImpl implements TblMaterialGroupService{
    private final ModelMapper modelMapper;
    private final TblMaterialGroupRepository tblMaterialGroupRepository;
    @Override
    public String register(TblMaterialGroupDTO tblMaterialGroupDTO) {
        TblMaterialGroup tblMaterialGroup = modelMapper.map(tblMaterialGroupDTO, TblMaterialGroup.class);
        String matGupID = tblMaterialGroupRepository.save(tblMaterialGroup).getMatGupID();
        return matGupID;
    }

    @Override
    public PageResponseDTO<TblMaterialGroupDTO> list(PageRequestDTO pageRequestDTO) {
        log.info("material service.............................list");
        List<TblMaterialGroupDTO> tblmaterialGroupDTOList = tblMaterialGroupRepository.findAll()
                .stream()
                .map(tblMaterialGroup -> modelMapper.map(tblMaterialGroup, TblMaterialGroupDTO.class))
                .collect(Collectors.toList());
        long result = tblMaterialGroupRepository.count();
        return PageResponseDTO.<TblMaterialGroupDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(tblmaterialGroupDTOList)
                .total((int)result)
                .build();
    }
}
