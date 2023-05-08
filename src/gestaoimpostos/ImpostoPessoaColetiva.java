package gestaoimpostos;

public class ImpostoPessoaColetiva extends Imposto {
	private float lucroContabilistico;
	private float despensasDedutiveis;

	public ImpostoPessoaColetiva(int ano, float lucroContabilistico, float despensasDedutiveis,
			PessoaColetiva contribuinte) {
		super(ano, contribuinte);
		this.lucroContabilistico = lucroContabilistico;
		this.despensasDedutiveis = despensasDedutiveis;
	}

	public float getLucroContabilistico() {
		return lucroContabilistico;
	}

	public float getDespensasDedutiveis() {
		return despensasDedutiveis;
	}

	@Override
	public float calcularImposto() {
		return 0.25f * (lucroContabilistico - despensasDedutiveis);
	}
}
