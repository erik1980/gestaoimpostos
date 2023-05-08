package gestaoimpostos;

public class PessoaSingular extends Contribuinte {
	private EstadoCivil estadoCivil;
	private String nic;
	
	public PessoaSingular(String nome, int nif, EstadoCivil estadoCivil, String nic) {
		super(nome, nif);
		this.estadoCivil = estadoCivil;
		this.nic = nic;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public String getNic() {
		return nic;
	}
	
	

}
