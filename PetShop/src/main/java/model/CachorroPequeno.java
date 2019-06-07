package model;

public class CachorroPequeno extends Cachorro {

	public CachorroPequeno(String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		super(nome, raca, peso, altura, cor, porte, statusAdocao);
	}
	
	@Override
	public int nivelDeTremedeira() {
		return 10;
	}

}
