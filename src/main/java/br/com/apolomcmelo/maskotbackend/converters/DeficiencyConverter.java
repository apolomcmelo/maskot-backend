package br.com.apolomcmelo.maskotbackend.converters;

import java.util.List;

import br.com.apolomcmelo.maskotbackend.dtos.DeficiencyDTO;
import br.com.apolomcmelo.maskotbackend.generics.Converter;
import br.com.apolomcmelo.maskotbackend.models.Deficiency;

import com.google.common.collect.Lists;

public class DeficiencyConverter implements
		Converter<Deficiency, DeficiencyDTO> {

	@Override
	public DeficiencyDTO convertToDTO(Deficiency model) {
		DeficiencyDTO dto = DeficiencyDTO.builder()
							.description(model.getDescription())
							.build();
		
		dto.setId(model.getId());

		return dto;
	}

	@Override
	public Deficiency convertToModel(DeficiencyDTO dto) {
		Deficiency model = Deficiency.builder()
							.id(dto.getId())
							.description(dto.getDescription())
							.build();
		
		return model;
	}

	@Override
	public List<DeficiencyDTO> convertListToDTO(List<Deficiency> listModel) {
		List<DeficiencyDTO> listDto = Lists.newArrayList();

		if (listModel != null) {
			listModel.forEach(model -> listDto.add(this.convertToDTO(model)));
		}

		return listDto;
	}

	@Override
	public List<Deficiency> convertListToModel(List<DeficiencyDTO> listDto) {
		List<Deficiency> listModel = Lists.newArrayList();

		if (listDto != null) {
			listDto.forEach(dto -> listModel.add(this.convertToModel(dto)));
		}

		return listModel;
	}

}
