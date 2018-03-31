package br.com.apolomcmelo.maskotbackend.generics;

import br.com.apolomcmelo.maskotbackend.daos.GenericDAO;

// TODO implementar forma de pegar o D por parâmetro
public abstract class Business<D extends GenericDAO> {
	private D dao;

	public Business() {
		
	}
	
	public D getDao() {
		return this.dao;
	}
}