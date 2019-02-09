package br.com.apolomcmelo.maskotbackend.generics;

import java.util.List;

public interface Converter<M, D> {
	public D convertToDTO(M model);
	
	public M convertToModel(D dto);
	
	public List<D> convertListToDTO(List<M> listModel);
	
	public List<M> convertListToModel(List<D> listDto);
}