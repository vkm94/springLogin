package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="appoint")
@Table(name="appoint")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public  int id;
	public int user_id;
	public int doc_id;
	public String booking_date;
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user_id=" + user_id + ", doc_id=" + doc_id + ", booking_date="
				+ booking_date + "]";
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}


}
