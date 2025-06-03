package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.handecart.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
