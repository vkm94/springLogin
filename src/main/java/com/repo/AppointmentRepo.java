package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Appointment;
@Repository
public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {
	
	@Query("SELECT a  from appoint a  where a.doc_id=:id")
	List<Appointment> DocAppointment(int id);

	@Query("SELECT a  from appoint a  where a.user_id=:id")

	List<Appointment>  getAll(int id);

	

}
