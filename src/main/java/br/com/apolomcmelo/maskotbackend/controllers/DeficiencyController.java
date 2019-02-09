package br.com.apolomcmelo.maskotbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apolomcmelo.maskotbackend.business.DeficiencyBusiness;
import br.com.apolomcmelo.maskotbackend.dtos.DeficiencyDTO;

@RestController
@RequestMapping("/deficiency")
public class DeficiencyController {
	
	@Autowired
	private DeficiencyBusiness business;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DeficiencyDTO> insertDeficiency(@RequestBody DeficiencyDTO deficiency) {
		boolean success = business.insertDeficiency(deficiency);
		
		if(success == true) {
			return new ResponseEntity<DeficiencyDTO>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<DeficiencyDTO>(deficiency, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<DeficiencyDTO> updateDeficiency(@RequestBody DeficiencyDTO deficiency) {
		boolean success = business.updateDeficiency(deficiency);
		
		if(success == true) {
			return new ResponseEntity<DeficiencyDTO>(deficiency, HttpStatus.OK);
		} else {
			return new ResponseEntity<DeficiencyDTO>(deficiency, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public ResponseEntity<List<DeficiencyDTO>> listDeficiency() {
		List<DeficiencyDTO> listDeficiency = business.listDeficiency();

		return new ResponseEntity<List<DeficiencyDTO>>(listDeficiency, HttpStatus.OK);
	}

}