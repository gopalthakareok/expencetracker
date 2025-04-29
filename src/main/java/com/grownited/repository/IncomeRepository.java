package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.IncomeEntity;
import java.sql.Date;


@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
 
	List<IncomeEntity> findByUserId(Integer userId);
	
	@Query(value = "select i.* , a.title  from income i , account a where a.account_id = i.account_id", nativeQuery = true)
	List<Object[]> getAll();
	
	@Query(value = "select i.* , a.title  from income i , account a where a.account_id = i.account_id and i.user_id= :userId", nativeQuery = true)
	List<Object[]> getByUserId(Integer userId);
	
	@Query(value = " select count(*) from income where month(transaction_date) = :month",nativeQuery = true)
	Integer countThisMonthTransaction(Integer month);
	
	@Query(value = "SELECT COALESCE(SUM(amount), 0) FROM income WHERE user_id = :userId AND MONTH(transaction_date) = MONTH(CURRENT_DATE()) AND YEAR(transaction_date) = YEAR(CURRENT_DATE())",nativeQuery = true)
	Integer getMonthlyIncome(Integer userId);
	
	@Query(value = "SELECT COALESCE(SUM(amount), 0) FROM income WHERE user_id = :userId AND  YEAR(transaction_date) = :year",nativeQuery = true)
	Integer getYearlyIncome(Integer userId, Integer year);
	
}
