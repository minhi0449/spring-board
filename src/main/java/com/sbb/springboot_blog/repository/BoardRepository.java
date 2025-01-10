package com.sbb.springboot_blog.repository;

import com.sbb.springboot_blog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository<대상으로 지정할 엔티티, 해당 엔티티 PK 타입>


}
