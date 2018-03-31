package br.com.apolomcmelo.maskotbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apolomcmelo.maskotbackend.business.PetBusiness;
import br.com.apolomcmelo.maskotbackend.models.Pet;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetBusiness business;

	// Serviços expostos
	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	public ResponseEntity<Pet> insertPet(@RequestBody Pet pet) {
		boolean success = business.insertPet(pet);
		
		if(success == true) {
			return new ResponseEntity<Pet>(pet, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Pet>(pet, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
		boolean success = business.updatePet(pet);
		
		if(success == true) {
			return new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} else {
			return new ResponseEntity<Pet>(pet, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}