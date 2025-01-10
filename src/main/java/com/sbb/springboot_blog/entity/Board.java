package com.sbb.springboot_blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@Builder
@Entity
public class Board {
    @Id
    private String id;

}
