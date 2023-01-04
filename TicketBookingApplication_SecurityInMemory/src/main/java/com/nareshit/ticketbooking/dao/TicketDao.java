package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

//DAO Layer a wrapper to the datbase

@Repository  //This will create or uses an existing datatbase connection and framework will use
             //this ticketDao for all tbl_ticket table operations

/*
 * Spring Boot is giving CRUD Repository for performing crud operations
 * CrudRepository ==> TWO INPUTS ==1) Table Name
 *                                 2) Datatype of Primary key
 *
 *
 */
public interface TicketDao extends CrudRepository<Ticket, Integer>{


	/*
	 *
	 * Developer no need to write any code for performing CRUD OPERATION
	 * Both Abstract Method and Implementation to be achieved by framework
	 * With TicketDao we can perform all database operations
	 *
	 * C ==> CREATE ==> INSERT ==> SAVE METHOD(CrudRepository)
	 * R ==> READ ==> SELECT   ==> FINDALL,FINDBYID(CrudRepository)
	 * U ==> UPDATE ==> UPDATE ==> SAVE METHOD(CrudRepository)
	 * D ==> DELETE ==> DELETE ==> DELETEBYID(CrudRepository)
	 */


	/*
	 *
	 *
	 * Derived Method ==> Abstract Method should be written by Developer and framework will implement
	 *
	 * Rules for Writing Abstract Method
	 *
	 * 1) Input and Output of Developers Choice
	 * 2) Method Name should start with "findBy" keyword
	 * 3) PropertyName which we want to Search should be followed by findBy Keyword
	 * 4) Both findByKeyword and propertyName should be in camelcase Notation
	 *
	 *
	 */

	public Ticket findByPassengerName(String passengerName);

	//select * from tbl_ticket where passenger_name=passengerName;

}
