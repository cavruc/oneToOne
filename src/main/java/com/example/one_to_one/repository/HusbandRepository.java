package com.example.one_to_one.repository;

import com.example.one_to_one.entity.Husband;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HusbandRepository extends JpaRepository<Husband, Integer> {
}
