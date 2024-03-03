package com.example.Week16GradedProject;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Week16GradedProject.model.TicketRepositary;
import com.example.Week16GradedProject.model.TicketService;
import com.example.Week16GradedProject.model.TicketTracker;

@Controller
public class TicketController {
	
	@Autowired
	TicketService tic;
	
	@RequestMapping("/")
	public String homepage(Model data) {
		List<TicketTracker> ticketTracker=tic.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		return "Home";
	}
	@RequestMapping("/newTicket")
	public String newTicket() {
		return "add";
	}
	@PostMapping("/addticket")
	public  String addticketform(@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker t1=new TicketTracker(0, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		tic.add(t1);
		
		List<TicketTracker> ticketTracker=tic.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		
		return "Home";
		
	}
	@GetMapping("/deletemethod")
	public String deleteTicket(@RequestParam int id,Model data) {
		
		TicketTracker t2=new TicketTracker(id, "", "", null);
		tic.delete(t2);		
		
		List<TicketTracker> ticketTracker=tic.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		return "Home";
	}
	@GetMapping("/editmethod")
	public String editform(@RequestParam int id,Model data) {
		
		TicketTracker t3=tic.getById(id);
		if(t3 !=null) {
			data.addAttribute("editid",t3);
			return "edit";
		}
		else {
			return "Home";
		}
	}
	@PostMapping("/editticket")
	public String editform(@RequestParam int id,@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker t4=new TicketTracker(id, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		tic.add(t4);
		
		List<TicketTracker> ticketTracker=tic.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		return "Home"; 
		
	}
	@GetMapping("/searchfunction")
	public String search(@RequestParam String search,Model data) {
		
		List<TicketTracker> t5=tic.search(search);
		data.addAttribute("ticketTracker",t5);
		return "Home";
		 
	}  
	
	@GetMapping("/viewmethod")
	public String viewform(@RequestParam int id,Model data) {
		
		TicketTracker viewid=tic.getById(id);
		if(viewid !=null) {
			data.addAttribute("viewid",viewid);
			return "view";
		}
		else {
			return "Home";
		}
	}
	@PostMapping("/viewticket")
	public String viewform(@RequestParam int id,@RequestParam String ticketTitle,@RequestParam String ticketShortDiscription,@RequestParam LocalDate ticketCreatedOn,Model data) {
		
		TicketTracker t6=new TicketTracker(id, ticketTitle, ticketShortDiscription, ticketCreatedOn);
		tic.add(t6);
		
		List<TicketTracker> ticketTracker=tic.getAll();
		data.addAttribute("ticketTracker",ticketTracker);
		
		return "Home"; 
		
	}

}
