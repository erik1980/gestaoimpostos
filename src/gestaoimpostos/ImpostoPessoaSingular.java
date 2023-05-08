package gestaoimpostos;

public class ImpostoPessoaSingular extends Imposto{
	private float rendimentoBrutoAnual;
	private float deducoes;
	
	public ImpostoPessoaSingular(int ano, float rendimentoBrutoAnual, float deducoes, PessoaSingular contribuinte) {
		super(ano, contribuinte);
		this.rendimentoBrutoAnual = rendimentoBrutoAnual;
		this.deducoes = deducoes;
	}
	
	
	public float getRendimentoBrutoAnual() {
		return rendimentoBrutoAnual;
	}


	public float getDeducoes() {
		return deducoes;
	}


	@Override
	public float calcularImposto() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
