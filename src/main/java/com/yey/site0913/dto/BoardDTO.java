package com.yey.site0913.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String ProductName;
    @NotEmpty
    private String ProductContent;
    @NotEmpty
    private String writer;
    private int qty;
    private int hit;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
