package com.curd.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.card.model.Card;
import com.curd.card.model.ServiceResponse;
import com.curd.card.service.ICardService;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class CardController {

	@Autowired
	private ICardService service;
	
	@GetMapping
	public String testSaludo() {
		return "Esta es una prueba de Conexion";
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Card>> getList(){
		var results =service.findAll();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ServiceResponse> saveCard(@RequestBody Card card){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = service.save(card);
		
		if (result ==1) {
			serviceResponse.setMessage("Item saved with success");
			serviceResponse.setSuccess(true);
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ServiceResponse> updateCard(@RequestBody Card card){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = service.update(card);
		
		if (result == 1) {
			serviceResponse.setMessage("Item update with success");
			serviceResponse.setSuccess(true);
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = service.deleteById(id);
		
		if (result == 1) {
			serviceResponse.setMessage("Item removed with success");
		}
		return new ResponseEntity<> (serviceResponse, HttpStatus.OK);
	}
	
}
