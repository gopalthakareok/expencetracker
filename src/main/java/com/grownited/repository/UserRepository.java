package com.grownited.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	Optional<UserEntity> findByEmail(String email);
	
	List<UserEntity> findByRole(String role);
	List<UserEntity> findByRoleAndActive(String role,Boolean active);
	
	@Query(nativeQuery = true, value="select count(*) from user where month(created_at) = :month and role = 'USER'")
	Integer countThisMonthUser(Integer month);
	
}
