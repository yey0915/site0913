package com.yey.site0913.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    private String ProductName;
    private String ProductContent;
    private String writer;
    private int qty;
    private int hit;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
