package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//1. Every Java Class is Table ==> Ticket Class as Table ==> @Entity
@Entity //By default Class name will be table name(
@Table(name = "tbl_ticket") //This is optional Annotation which wil customize table name
 							// IN this case tbl_ticket wil be created in place of Ticket
public class Ticket {


	/*
	 * @GeneratedValue==> Framework will generate PK value and its not user input
	 *  AUTO ==> JPA Framework will create a database sequence and this will be used for populating
	 *   		 primary key
	 *
	 */

	@Id //This annotation wil create a primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="passenger_id")
	private Integer passengerId;


	//2.Every Java Property is Database Column
	@Column(name="passenger_name") //@Column is also optional which wil customize column name
								   // In this case passenger_name will be created in place of passengerName
	private String passengerName;


	@Column(name="source_station")
	private String sourceStation;


	@Column(name="destination_station")
	private String destination_station;



	@Column(name="travel_date")
	private Date travelDate;			//We Should Use java.util.Date




	private String email; 				//We no need to write @Column for email. since same column


	public Integer getPassengerId() {
		return passengerId;
	}


	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getSourceStation() {
		return sourceStation;
	}


	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}


	public String getDestination_station() {
		return destination_station;
	}


	public void setDestination_station(String destination_station) {
		this.destination_station = destination_station;
	}


	public Date getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Ticket(String passengerName, String sourceStation, String destination_station,
			String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destination_station = destination_station;
		this.travelDate = new Date();
		this.email = email;
	}

	public Ticket() {}


	@Override
	public String toString() {
		return "Ticket [passengerId=" + passengerId + ", passengerName=" + passengerName + ", sourceStation="
				+ sourceStation + ", destination_station=" + destination_station + ", travelDate=" + travelDate
				+ ", email=" + email + "]";
	}








}
