package com.yey.site0913.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TblMaterialGroupDTO {
    private String matGupID;                    // 자재그룹ID
    private String matGupNm;                    // 자재그룹명
    private String description;                 // 설명
}
