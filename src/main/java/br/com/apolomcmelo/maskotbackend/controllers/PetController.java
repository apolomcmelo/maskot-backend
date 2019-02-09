package br.com.apolomcmelo.maskotbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apolomcmelo.maskotbackend.business.PetBusiness;
import br.com.apolomcmelo.maskotbackend.dtos.PetDTO;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetBusiness business;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PetDTO> insertPet(@RequestBody PetDTO pet) {
		boolean success = business.insertPet(pet);
		
		if(success == true) {
			return new ResponseEntity<PetDTO>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<PetDTO>(pet, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<PetDTO> updatePet(@RequestBody PetDTO pet) {
		boolean success = business.updatePet(pet);
		
		if(success == true) {
			return new ResponseEntity<PetDTO>(pet, HttpStatus.OK);
		} else {
			return new ResponseEntity<PetDTO>(pet, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public ResponseEntity<List<PetDTO>> listPet() {
		List<PetDTO> listPet = business.listPet();

		return new ResponseEntity<List<PetDTO>>(listPet, HttpStatus.OK);
	}

}