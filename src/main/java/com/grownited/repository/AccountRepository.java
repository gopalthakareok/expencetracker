package com.grownited.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	List<AccountEntity> findByUserId(Integer userId);
}
