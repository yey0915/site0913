package com.yey.site0913.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 500, nullable = false)
    private String ProductName;
    @Column(length = 2000, nullable = false)
    private String ProductContent;
    @Column(length = 50, nullable = false)
    private String writer;
    @Column(nullable = false)
    private int qty;
    private int hit;

}
