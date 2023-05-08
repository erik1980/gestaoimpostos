package gestaoimpostos;

public abstract class Imposto {
	private int ano;
	private Contribuinte contribuinte;
	
	public Imposto(int ano, Contribuinte contribuinte) {
		this.ano = ano;
		this.contribuinte = contribuinte;
	}	

	public int getAno() {
		return ano;
	}
	
	public Contribuinte getContribuinte() {
		return contribuinte;
	}
	
	public abstract float calcularImposto();


}
