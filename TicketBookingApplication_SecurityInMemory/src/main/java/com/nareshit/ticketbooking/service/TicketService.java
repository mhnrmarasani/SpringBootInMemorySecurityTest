package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service //Its business Logic Layer
		//It internally transaction Managment, and we can connect with external frameworks like RabitMQ,JMS,HIBERNATE
public class TicketService {



	@Autowired
	private TicketDao ticketDao;  //TicketDao obj=new TicketDao();


	//Retrieva All Ticket

	public Iterable<Ticket> retrieveAllTickets(){
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket
		//Entire Resultset converted into Iterable<Ticket>
	}


	//Create Ticket



	public Ticket createTicket(Ticket ticketObj) {

		return ticketDao.save(ticketObj);

		//save Method ==> Internally used for inserting the data and updating the data
		/*
		 * If ticketObj.ticketId == null ==> Insert into tbl_ticket
		 *
		 * If ticketObj.ticketId != null and does not exists in the table ==> Insert into tbl_ticket
		 *
		 * If ticketObj.ticketId != null and ticketid exists in the table ==> update the tbl_ticket
		 *
		 */

	}



	//Retrive Single Ticket

	public Ticket getTicket(Integer ticketId) {

		return ticketDao.findById(ticketId).orElse(new Ticket());

		//findById ==> select * from tbl_ticket where ticket_id=ticketId
	}


	//Update Ticket

	public Ticket updateTicket(Integer ticketId,String newEmail) {

		//IN UpdateTicket Method we are only updating email column.
		Ticket dbTicketObj=getTicket(ticketId);
		//dbTicketObj.setEmail(newEmail);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj);
		//In this context dbTicketObj having ticket_id in the database
		//Hence it will perform update query
		//update tbl_ticket set email=newEmail where ticket_id=ticketId



	}


	//Delete Ticket

	public void deletTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		//deleteById ==> delete from tbl_ticket where ticket_id=ticketId
	}


	public Ticket findByPassengerName(String passengerName) {
		return ticketDao.findByPassengerName(passengerName);
	}





}
