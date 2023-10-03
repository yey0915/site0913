package com.yey.site0913.service;

import com.yey.site0913.domain.TblMaterialGroup;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.dto.TblMaterialGroupDTO;

public interface TblMaterialGroupService {
    String register(TblMaterialGroupDTO tblMaterialGroupDTO);

    PageResponseDTO<TblMaterialGroupDTO> list(PageRequestDTO pageRequestDTO);

}
