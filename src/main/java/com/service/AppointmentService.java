package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Appointment;
import com.entity.Users;
import com.repo.AppointmentRepo;

@Service
public class AppointmentService {
	@Autowired
	AppointmentRepo ar;

	public List<Appointment> docApointments(int id) {
	System.out.println(ar.DocAppointment(id).toString());
		return ar.DocAppointment(id);
		//return null;
	}

	public Appointment bookAppointment(Appointment ap) {
		return ar.save(ap);
		
	}

	public List<Appointment> ListAppoints(int id) {
		return ar.getAll(id);
		
	}

	

}
