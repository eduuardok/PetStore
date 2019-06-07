package model;

public class CachorroGrande extends Cachorro {

	public CachorroGrande(String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		super(nome, raca, peso, altura, cor, porte, statusAdocao);
	}

	@Override
	public int nivelDeTremedeira() {
		return 2;
	}
}
