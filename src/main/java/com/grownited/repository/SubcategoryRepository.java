package com.grownited.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.SubcategoryEntity;

@Repository
public interface SubcategoryRepository extends JpaRepository< SubcategoryEntity, Integer>
{
	@Query(value = "select s.subcategoryname  ,c.categoryname from subcategory s,category c where s.subcategory_id = s.category_id ",nativeQuery = true)
	List<Object[]> getAllSubcategories();
	
}