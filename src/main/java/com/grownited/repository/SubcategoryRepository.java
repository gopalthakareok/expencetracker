package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.SubcategoryEntity;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {

   List<SubcategoryEntity> findByUserId(Integer userId);
	
	@Query(value = "select s.* , c.category_Name  from category c , subcategory s where s.category_id = c.category_id", nativeQuery = true)
	List<Object[]> getAll();
	@Query(value = "select s.* , c.category_Name  from category c , subcategory s where s.category_id = c.category_id and s.user_id= :userId", nativeQuery = true)
	List<Object[]> getByUserId(Integer userId);
}
