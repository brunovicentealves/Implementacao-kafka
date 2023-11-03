package br.com.brunoalves.producerskafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.brunoalves.producerskafka.services.MachineService;
import models.CreateMachineRequest;

@RestController
@RequestMapping("machines")
public class MachineControllers {
	
	@Autowired
	private MachineService service;
	
	@PostMapping
	ResponseEntity<Void> createEvent(@RequestBody CreateMachineRequest request){
		
		service.createEvent(request);
		
		return ResponseEntity.ok().build();
		
	}

}
