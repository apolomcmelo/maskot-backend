package br.com.apolomcmelo.maskotbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apolomcmelo.maskotbackend.business.ColorBusiness;
import br.com.apolomcmelo.maskotbackend.dtos.ColorDTO;

@RestController
@RequestMapping("/color")
public class ColorController {
	
	@Autowired
	private ColorBusiness business;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ColorDTO> insertColor(@RequestBody ColorDTO color) {
		boolean success = business.insertColor(color);
		
		if(success == true) {
			return new ResponseEntity<ColorDTO>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ColorDTO>(color, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ColorDTO> updateColor(@RequestBody ColorDTO color) {
		boolean success = business.updateColor(color);
		
		if(success == true) {
			return new ResponseEntity<ColorDTO>(color, HttpStatus.OK);
		} else {
			return new ResponseEntity<ColorDTO>(color, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public ResponseEntity<List<ColorDTO>> listColor() {
		List<ColorDTO> listColor = business.listColor();

		return new ResponseEntity<List<ColorDTO>>(listColor, HttpStatus.OK);
	}

}