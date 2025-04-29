package com.grownited.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ExpenseEntity;



@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer>{

	List<ExpenseEntity> findByUserId(Integer userId);
	
	@Query(value = " select e.expense_id as expenseId, e.title as expenseTitle ,e.amount,e.description,e.transaction_date, e.status, u.first_name as firstName ,a.title as accountName, v.vendor_name as vendorName ,c.category_name as categoryName,sc.sub_category_name as subCategoryName from expense e, user u ,account a,vendor v,category c,subcategory sc where e.user_id = u.user_id and  a.account_id = e.account_id and v.vendor_id = e.vendor_id and c.category_id = e.category_id and sc.sub_category_id = e.sub_category_id", nativeQuery = true)
	List<Object[]> getAll();
	@Query(value = " select  e.expense_id as expenseId,e.title as expenseTitle ,e.amount,e.description,e.transaction_date, e.status, u.first_name as firstName ,a.title as accountName, v.vendor_name as vendorName ,c.category_name as categoryName,sc.sub_category_name as subCategoryName from expense e, user u ,account a,vendor v,category c,subcategory sc where e.user_id = u.user_id and  a.account_id = e.account_id and v.vendor_id = e.vendor_id and c.category_id = e.category_id and sc.sub_category_id = e.sub_category_id and e.user_id= :userId", nativeQuery = true)
	List<Object[]> getByUserId(Integer userId);
	
	@Query(value = " select count(*) from expense where month(transaction_date) = :month",nativeQuery = true)
	Integer countThisMonthTransaction(Integer month);
	
	@Query(value = " select sum(amount) from expense where month(transaction_date) = :month and  user_id IS NOT NULL ",nativeQuery = true)
	Integer sumThisMonthExpense(Integer month);
	
	
	@Query(value = "SELECT COALESCE(SUM(amount), 0) FROM expense WHERE user_id = :userId AND MONTH(transaction_date) = MONTH(CURRENT_DATE()) AND YEAR(transaction_date) = YEAR(CURRENT_DATE())",nativeQuery = true)
	Integer getCurrentMonthExpenseByUser(Integer userId);
	
	@Query(value = "SELECT COALESCE(SUM(amount), 0) FROM expense WHERE user_id = :userId  AND YEAR(transaction_date) = :year",nativeQuery = true)
	Integer getYearlyExpense(Integer userId, Integer year);
	
	@Query(value = "SELECT SUM(amount) FROM expense WHERE MONTH(transaction_date) = :month AND YEAR(transaction_date) = :year AND user_id = :userId",nativeQuery = true)
	Integer getCurrentMonthExpense(Integer month,Integer year, Integer userId);
	
	
	
	@Query(value = "select u.first_name, u.last_name, sum(e.amount) from expense e join user u on e.user_id = u.user_id where e.transaction_date between :startDate and :endDate group by u.user_id order by sum(e.amount) desc ",nativeQuery = true )
	 List<Object[]> getExpenseDistributionByUsers(
	        @Param("startDate") Date startDate,
	        @Param("endDate") Date endDate
	    );
	 
	 
	 @Query(value = "SELECT c.category_name AS CategoryName, SUM(e.amount) AS total FROM expense e JOIN category c ON e.category_id = c.category_id WHERE e.user_id = :userId AND MONTH(e.transaction_date) = :month AND YEAR(e.transaction_date) = :year  GROUP BY c.category_name", nativeQuery = true)
	 List<Object[]> getMonthlyExpenseByCategory(@Param("userId") int userId,@Param("month") int month,@Param("year") int year);

	
	
}
