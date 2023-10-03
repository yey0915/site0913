package com.yey.site0913.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TblMaterialItem extends BaseWriteEntity{
    @Id
    @Column(length = 20, nullable = false)
    private String matItemID;                   // 자재품목ID
    @Column(length = 20, nullable = false)
    private String specType;                    // 재질 및 특징
    @Column(columnDefinition = "integer default 0", nullable = true)
    private int customerID;                     // 공급업체 코드
    @Column(length = 20)
    private String matGupID;                    // 자재 그룹코드
    @Column(length = 20)
    private String matCode;                     // 자재 코드
    @Column(length = 50)
    private String matNm;                       // 자재명
    @Column(length = 50)
    private String matType;                     // 사양
    @Column(length = 50)
    private String matSpec;                     // 특징
    @Column(length = 50)
    private String matUse;                      // 용도
    @Column(columnDefinition = "Decimal(10,2) default 0.0", nullable = true)
    private float matPrice;                     // 단가
    @Column(length = 20)
    private String matUnit;                     // 단위
    @Column(length = 100)
    private String img;                         // 자재이미지
    @Column(length = 50)
    private String matOrdDeadline;              // 주문소요기한
    @Column(length = 200)
    private String matStorageCondition;         // 보관기간

}