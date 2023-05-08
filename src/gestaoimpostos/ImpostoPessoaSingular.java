package gestaoimpostos;

public class ImpostoPessoaSingular extends Imposto {
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
		float taxa;
		if (rendimentoBrutoAnual <= 300000)
			taxa = 0;
		else if (rendimentoBrutoAnual <= 600000)
			taxa = 10f;
		else if (rendimentoBrutoAnual <= 1200000)
			taxa = 15f;
		else if (rendimentoBrutoAnual <= 2400000)
			taxa = 20f;
		else if (rendimentoBrutoAnual <= 4800000)
			taxa = 25f;
		else if (rendimentoBrutoAnual <= 7200000)
			taxa = 30f;
		else
			taxa = 35f;
		return taxa * (rendimentoBrutoAnual - deducoes);
	}

}
