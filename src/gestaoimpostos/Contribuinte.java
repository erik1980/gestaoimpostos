package gestaoimpostos;

public abstract class Contribuinte {
	private String nome;
	private int nif;
	
	public Contribuinte(String nome, int nif) {
		this.nome = nome;
		this.nif = nif;
	}
	
	public String getNome() {
		return nome;
	}

	public int getNif() {
		return nif;
	}

	
	

}
