package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets") //http://localhost:8080/tickets

//http://localhost:8080/tickets ==> TicketController obj=ioc.getTicketController();
public class TicketController {



	/*
	 *   REST PROTOCOL ==> HETREROGENIOUS COMMUNICATIONS
	 *
	 *   JSON ==> Javascript Object Notation ==> {
	 *   											key1:"value1",
	 *   											key2:"value2",
	 *
	 *   										}
	 *
	 *   {
	 *
	 *   	paseengerName:"vijay",
	 *   	sourceStation:"Hyderabad",
	 *   	destinationStatin:"Goa"
	 *   }
	 *
	 *   @RestController ==> JACKSON LIBRARY ==> JAVA OBJECT TO JSON AND JSON OBJECT TO JAVA
	 *
	 *   // Create Operation  ==> @Post + @RequestMapping ==> @PostMapping
	 *   // Update Operation  ==> @Put + @RequestMapping  ==> @PutMapping
	 *   // Retrive Opertaion ==> @Get + @RequestMapping  ==> @GetMapping
	 *   // Delete Operations ==> @Delete + @RequestMapping ==> @DeleteMapping
	 *   Default is GET
	 *
	 *  	//@RequestBody ==> Header,Body, Request and Response==> Going to scan Body section
	 *  					    and retrieves the json object and converts to java object
	 *
	 *  	//@PathVariable==> This annotations reads the dynamic variable in the URL and assigns to java iput variable
	 */


	@Autowired
	private TicketService ticketService;



	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	 //http://localhost:8080/tickets/create ==> obj.createTicket();


	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}


	@GetMapping(value="/all")  //       http://localhost:8091/tickets/all
	////http://localhost:8080/tickets/all==> obj.getAllTickets();

	public Iterable<Ticket> getAllTickets(){
		return ticketService.retrieveAllTickets();
	}

	/*
	//http://localhost:8080/tickets/1 ==> 1st Ticket
	//http://localhost:8080/tickets/2 ==> 2nd Ticket
	//http://localhost:8080/tickets/100 ==> 100th Ticket
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}

*/


	@GetMapping(value="/ticket/{passengerName}")
	public Ticket getTicket(@PathVariable("passengerName") String passengerName) {
		return ticketService.findByPassengerName(passengerName);
	}


	//Update Ticket
	//http://localhost:8080/tickets/1/vijumca@gmail.com

	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
							   @PathVariable("newEmail") String newEmail){
		return ticketService.updateTicket(ticketId, newEmail);
	}


	//DeleteTicket
	//http://localhost:8080/tickets/1 ==> Delete
	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")  Integer ticketId) {
		ticketService.deletTicket(ticketId);
	}

}
