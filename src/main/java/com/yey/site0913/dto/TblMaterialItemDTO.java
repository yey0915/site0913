package com.yey.site0913.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TblMaterialItemDTO {

    private String matItemID;                   // 자재품목ID
    private String specType;                    // 재질 및 특징
    private int customerID;                     // 공급업체 코드
    private String matGupID;                    // 자재 그룹코드
    private String matCode;                     // 자재 코드
    private String matNm;                       // 자재명
    private String matType;                     // 사양
    private String matSpec;                     // 특징
    private String matUse;                      // 용도
    private float matPrice;                     // 단가
    private String matUnit;                     // 단위
    private String img;                         // 자재이미지
    private String matOrdDeadline;              // 주문소요기한
    private String matStorageCondition;         // 보관조건
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
