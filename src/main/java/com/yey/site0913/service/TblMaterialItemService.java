package com.yey.site0913.service;

import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.dto.TblMaterialItemDTO;

public interface TblMaterialItemService {
    String register(TblMaterialItemDTO tblMaterialItemDTO);
    PageResponseDTO<TblMaterialItemDTO> list(PageRequestDTO pageRequestDTO);
}
