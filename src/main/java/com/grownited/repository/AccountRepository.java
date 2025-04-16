package com.grownited.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>
{
	
	@Query(value = "select a.acctitle,a.amount,u.firstname from account a,users u where a.user_id=u.user_id",nativeQuery = true)
	List<Object[]> getAllAccounts();
	
	@Query(value="select a.* from account a,users u where a.user_id=u.user_id",nativeQuery = true)
	List<Object[]> getAccountByUserId(Integer userId);
	
}