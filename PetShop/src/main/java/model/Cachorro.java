package model;

public class Cachorro {
	private int id;
	private String nome;
	private String raca;
	private float peso;
	private float altura;
	private String cor;
	private String porte;
	private String statusAdocao;
	
	public Cachorro(String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.altura = altura;
		this.cor = cor;
		this.porte = porte;
		this.setStatusAdocao(statusAdocao);
	}
	
	public Cachorro(int id, String nome, String raca, float peso, float altura, String cor, String porte, String statusAdocao) {
		this.setId(id);
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.altura = altura;
		this.cor = cor;
		this.porte = porte;
		this.setStatusAdocao(statusAdocao);
	}
	
	public int nivelDeTremedeira() {
		return 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cachorro other = (Cachorro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cachorro [nome=" + nome + ", raca=" + raca + ", peso=" + peso + ", altura=" + altura + ", cor=" + cor
				+ "]";
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusAdocao() {
		return statusAdocao;
	}

	public void setStatusAdocao(String statusAdocao) {
		this.statusAdocao = statusAdocao;
	}
	
}
