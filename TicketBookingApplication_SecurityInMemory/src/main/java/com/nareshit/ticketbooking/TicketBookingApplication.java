package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner{

	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//The code which we are writig in this snippet will be exeucted only once during startup

		Ticket ticket=new Ticket();
		ticket.setPassengerName("Ramu");
		ticket.setSourceStation("Hyderabad");
		ticket.setDestination_station("Delhi");
		ticket.setTravelDate(new Date());
		ticket.setEmail("ramu@gmail.com");

		ticketService.createTicket(ticket);
		
		Ticket hari=new Ticket();
		hari.setPassengerName("Hari");
		hari.setSourceStation("Banglore");
		hari.setDestination_station("America");
		hari.setTravelDate(new Date());
		hari.setEmail("Hari@gmail.com");
		
		ticketService.createTicket(hari);
		
		
		Ticket sita=new Ticket();
		sita.setPassengerName("Sita");
		sita.setSourceStation("Chennai");
		sita.setDestination_station("London");
		sita.setTravelDate(new Date());
		sita.setEmail("Sita@gmail.com");
		
		ticketService.createTicket(sita);
		

	}

}
