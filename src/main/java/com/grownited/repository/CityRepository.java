package com.grownited.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer>
{

	@Query(value = "select c.cityname,s.statename from state s,city c where c.state_id = s.state_id",nativeQuery = true)
	List<Object[]> getAllCities();


}