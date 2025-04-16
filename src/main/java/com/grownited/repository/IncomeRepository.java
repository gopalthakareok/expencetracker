package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer>
{
	@Query(value = "select i.title, i.transactiondate, i.description, i.amount ,u.firstname, u.lastname from income i,users u where i.user_id=u.user_id",nativeQuery = true)
	List<Object[]> getAllIncomes();
	
	@Query(value="select i.*,a.acctitle from income i,account a,users u where i.account_id=a.account_id and i.user_id=u.user_id",nativeQuery = true)
	List<Object[]> getIncomeByUserId(Integer userId);
	
	
}
 