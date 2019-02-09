package br.com.apolomcmelo.maskotbackend.generics;


// TODO implementar forma de pegar o D por parâmetro
public abstract class Business<D extends DAO> {
	private D dao;

	public Business() {
		
	}
	
	public D getDao() {
		return this.dao;
	}
}