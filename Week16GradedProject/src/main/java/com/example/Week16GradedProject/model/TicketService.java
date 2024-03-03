package com.example.Week16GradedProject.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
	
	@Autowired
	TicketRepositary tic;
	
	//----------add function-----------
	public void add(TicketTracker ticketTracker) {
		tic.save(ticketTracker);
	}
	//----------update function------------
	public void update(TicketTracker ticketTracker) {
		tic.save(ticketTracker);
	}
	//----------select function-----------
	public List<TicketTracker> getAll(){
		return tic.findAll();
	}
	//delete function
	public void delete(TicketTracker ticketTracker) {
		tic.delete(ticketTracker);
	}
	public TicketTracker getById(int id) {
		Optional<TicketTracker> t0=tic.findById(id);
		TicketTracker temp=null;
		if(t0.get()!=null) {
			temp=t0.get();
		}
		return temp;
	}
	
	//----------search data---------- 
	public List<TicketTracker> search(String searchkey) {

		// create a object based on the searchKey
		TicketTracker t1 = new TicketTracker();
		t1.setTicketTitle(searchkey);

		// create jpa;
		ExampleMatcher t2 = ExampleMatcher.matching()
				.withMatcher("ticketTitle", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "ticketShortDiscription", "ticketCreatedOn");

		
	
		Example<TicketTracker> ex = Example.of(t1, t2);
		
		return tic.findAll(ex);
	}

}
