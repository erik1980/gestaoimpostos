package gestaoimpostos;

public class PessoaColetiva extends Contribuinte {

	private Atividade atividadePrincipal;

	public PessoaColetiva(String nome, int nif, Atividade atividadePrincipal) {
		super(nome, nif);
		this.atividadePrincipal = atividadePrincipal;
	}

	public Atividade getAtividadePrincipal() {
		return atividadePrincipal;
	}
	
	
	
	
	
}
