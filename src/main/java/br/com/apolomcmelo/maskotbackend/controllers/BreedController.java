package br.com.apolomcmelo.maskotbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apolomcmelo.maskotbackend.business.BreedBusiness;
import br.com.apolomcmelo.maskotbackend.dtos.BreedDTO;

@RestController
@RequestMapping("/breed")
public class BreedController {
	
	@Autowired
	private BreedBusiness business;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BreedDTO> insertBreed(@RequestBody BreedDTO breed) {
		boolean success = business.insertBreed(breed);
		
		if(success == true) {
			return new ResponseEntity<BreedDTO>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<BreedDTO>(breed, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BreedDTO> updateBreed(@RequestBody BreedDTO breed) {
		boolean success = business.updateBreed(breed);
		
		if(success == true) {
			return new ResponseEntity<BreedDTO>(breed, HttpStatus.OK);
		} else {
			return new ResponseEntity<BreedDTO>(breed, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public ResponseEntity<List<BreedDTO>> listBreed() {
		List<BreedDTO> listBreed = business.listBreed();

		return new ResponseEntity<List<BreedDTO>>(listBreed, HttpStatus.OK);
	}

}