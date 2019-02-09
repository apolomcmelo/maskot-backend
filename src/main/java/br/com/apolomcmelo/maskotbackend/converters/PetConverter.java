package br.com.apolomcmelo.maskotbackend.converters;


import java.util.List;

import com.google.common.collect.Lists;

import br.com.apolomcmelo.maskotbackend.dtos.PetDTO;
import br.com.apolomcmelo.maskotbackend.generics.Converter;
import br.com.apolomcmelo.maskotbackend.models.Pet;

public class PetConverter implements Converter<Pet, PetDTO> {

	@Override
	public PetDTO convertToDTO(Pet model) {
		PetDTO dto = PetDTO.builder()
						.name(model.getName())
						.profilePicture(model.getProfilePicture())
						.pictures(model.getPictures())
						.species(model.getSpecies())
						.breed(new BreedConverter().convertToDTO(model.getBreed()))
						.color(new ColorConverter().convertToDTO(model.getColor()))
						.deficiencies(new DeficiencyConverter().convertListToDTO(model.getDeficiencies()))
						.neutered(model.getNeutered())
						.age(model.getAge())
						.lastLocation(model.getLastLocation())
						.lastTimeSeen(model.getLastTimeSeen())
						.withOwner(model.getWithOwner())
						.build();
		
		dto.setId(model.getId());
		
		return dto;
						
	}

	@Override
	public Pet convertToModel(PetDTO dto) {
		Pet model = Pet.builder()
				.id(dto.getId())
				.name(dto.getName())
				.profilePicture(dto.getProfilePicture())
				.pictures(dto.getPictures())
				.species(dto.getSpecies())
				.breed(new BreedConverter().convertToModel(dto.getBreed()))
				.color(new ColorConverter().convertToModel(dto.getColor()))
				.deficiencies(new DeficiencyConverter().convertListToModel(dto.getDeficiencies()))
				.neutered(dto.getNeutered())
				.age(dto.getAge())
				.lastLocation(dto.getLastLocation())
				.lastTimeSeen(dto.getLastTimeSeen())
				.withOwner(dto.getWithOwner())
				.build();

		return model;
	}

	@Override
	public List<PetDTO> convertListToDTO(List<Pet> listModel) {
		List<PetDTO> listDto = Lists.newArrayList();
		
		if(listModel != null) {
			listModel.forEach(model -> listDto.add(this.convertToDTO(model)));
		}
		
		return listDto;
	}

	@Override
	public List<Pet> convertListToModel(List<PetDTO> listDto) {
		List<Pet> listModel = Lists.newArrayList();
		
		if(listDto != null) {
			listDto.forEach(dto -> listModel.add(this.convertToModel(dto)));
		}
		
		return listModel;
	}

}