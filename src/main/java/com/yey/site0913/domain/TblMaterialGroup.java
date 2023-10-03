package com.yey.site0913.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TblMaterialGroup {
    @Id
    @Column(length = 20, nullable = false)
    private String matGupID;                    // 자재그룹ID
    @Column(length = 50)
    private String matGupNm;                    // 자재그룹명
    @Column(length = 200)
    private String description;                 // 설명

}
