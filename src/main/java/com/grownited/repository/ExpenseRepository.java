package com.grownited.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.ExpenseEntity;


@Repository

	public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> 
	{
		
	@Query(value = "select e.exptitle , e.amount,  e.description,e.transactiondate, u.firstname,u.lastname,a.acctitle,c.categoryname,sc.subcategoryname from expense e, users u , account a,category c,subcategory sc where e.user_id = u.user_id and a.account_id = e.account_id and c.category_id = e.category_id and sc.subcategory_id = e.subcategory_id",nativeQuery = true)
	List<Object[]> getAllExpenses();
	
	@Query(value="select e.*,c.categoryname,sc.subcategoryname , a.acctitle from expense e,category c,subcategory sc,account a,users u where e.category_id = c.category_id and e.subcategory_id = sc.subcategory_id and e.account_id=a.account_id and u.user_id=:userId",nativeQuery = true)
	List<Object[]> getExpenseByUserId(Integer userId);
			
	}

