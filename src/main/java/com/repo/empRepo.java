package com.repo;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.employe;

@Repository
public interface empRepo extends CrudRepository<employe, String> {

	
	@Query(value = "SELECT distinct emp_id,name,bdte,exp,joindate,address,c_password,password FROM employe WHERE joindate  BETWEEN ?1 AND ?2 ", nativeQuery = true)
	public 	 List<employe> getDataByDate(String date, String date2);
	@Query(value = "SELECT emp_id from employe where name=?1 and password=?2 ", nativeQuery = true)
	public String findbyname(String name, String password);
	

	
	

}
