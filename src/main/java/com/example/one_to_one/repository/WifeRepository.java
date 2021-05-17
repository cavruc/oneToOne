package com.example.one_to_one.repository;

import com.example.one_to_one.entity.Wife;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WifeRepository extends JpaRepository<Wife, Integer> {
}
