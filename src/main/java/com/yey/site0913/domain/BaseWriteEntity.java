package com.yey.site0913.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseWriteEntity {

    @CreatedDate
    @Column(name = "regDt", length = 20, updatable = false)
    private LocalDateTime regDt;
    //private String regNm;

    @LastModifiedDate
    @Column(name = "modDt", length = 20)
    private LocalDateTime modDt;
    //private String modNm;

}