package br.com.apolomcmelo.maskotbackend.converters;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.dtos.BreedDTO;
import br.com.apolomcmelo.maskotbackend.generics.Converter;
import br.com.apolomcmelo.maskotbackend.models.Breed;

import com.google.common.collect.Lists;

public class BreedConverter implements Converter<Breed, BreedDTO> {

	@Override
	public BreedDTO convertToDTO(Breed model) {
		BreedDTO dto = BreedDTO.builder()
						.name(model.getName())
						.description(model.getDescription())
						.size(model.getSize())
						.build();
		
		dto.setId(model.getId());

		return dto;
	}

	@Override
	public Breed convertToModel(BreedDTO dto) {
		Breed model = Breed.builder()
						.id(dto.getId())
						.name(dto.getName())
						.description(dto.getDescription())
						.size(dto.getSize())
						.build();
		
		return model;
	}

	@Override
	public List<BreedDTO> convertListToDTO(List<Breed> listModel) {
		List<BreedDTO> listDto = Lists.newArrayList();

		if (listModel != null) {
			listModel.forEach(model -> listDto.add(this.convertToDTO(model)));
		}

		return listDto;
	}

	@Override
	public List<Breed> convertListToModel(List<BreedDTO> listDto) {
		List<Breed> listModel = Lists.newArrayList();

		if (listDto != null) {
			listDto.forEach(dto -> listModel.add(this.convertToModel(dto)));
		}

		return listModel;
	}
}
