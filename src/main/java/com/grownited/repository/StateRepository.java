package com.grownited.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer>
{
	
	List<StateEntity> findByStateId(Integer stateId);
}
