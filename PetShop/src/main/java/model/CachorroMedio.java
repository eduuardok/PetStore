package model;

public class CachorroMedio extends Cachorro {

	public CachorroMedio(String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		super(nome, raca, peso, altura, cor, porte, statusAdocao);
	}
	
	public CachorroMedio(int id,String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		super(id,nome, raca, peso, altura, cor, porte, statusAdocao);
	}

	@Override
	public int nivelDeTremedeira() {
		return 5;
	}
}
