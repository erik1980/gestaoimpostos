package gestaoimpostos;

import java.time.LocalDate;
import java.util.ArrayList;

public class DirecaoGeralImpostos {

	private final ArrayList<Contribuinte> contribuintes = new ArrayList<>();
	private final ArrayList<Imposto> impostos = new ArrayList<>();
	public DirecaoGeralImpostos() {
		populate();
	}

	private Contribuinte findContribuinte(int nif) {
		for (Contribuinte contribuinte : contribuintes) {
			if (contribuinte.getNif() == nif) {
				return contribuinte;
			}
		}
		return null;
	}

	public boolean addPessoaSingular(String nome, int nif, EstadoCivil estadoCivil, String nic) {		
		if (findContribuinte(nif) == null) {
			contribuintes.add(new PessoaSingular(nome, nif, estadoCivil, nic));
			return true;
		}
		return false;
	}
	public boolean addPessoaColetiva(String nome, int nif, Atividade atividadePrincipal) {		
		if (findContribuinte(nif) == null) {
			contribuintes.add(new PessoaColetiva(nome, nif, atividadePrincipal));
			return true;
		}
		return false;
	}
	
	public boolean addImpostoPessoaColetiva(int ano, float lucroContabilistico, float despensasDedutiveis, int nif) {		
		if(findContribuinte(nif) instanceof PessoaColetiva pc) {
			impostos.add(new ImpostoPessoaColetiva(ano, lucroContabilistico, despensasDedutiveis, pc));
			return true;
		}
		return false;
	}
	
	public boolean addImpostoPessoaSingular(int ano, float rendimentoBrutoAnual, float deducoes, int nif) {		
		if(findContribuinte(nif) instanceof PessoaSingular pc) {
			impostos.add(new ImpostoPessoaSingular(ano, rendimentoBrutoAnual, deducoes, pc));
			return true;
		}
		return false;
	}
	//Funcionalidade 3 do Grupo 2.
	public ArrayList<Contribuinte> obterPessoasSingulares() {
		ArrayList<Contribuinte> pessoasSingulares = new ArrayList<>();
		for (Contribuinte contribuinte : contribuintes) {
			if (contribuinte instanceof PessoaSingular ps) {
				pessoasSingulares.add(ps);

			}
		}
		return pessoasSingulares;
	}
	// Funcionalidade 5 do Grupo 2.
	private boolean naoPagouAnoAtual(Contribuinte contribuinte) {
		for (Imposto imposto : impostos) {
			if (imposto.getAno() == LocalDate.now().getYear()
					&& imposto.getContribuinte().getNif() == contribuinte.getNif()) {
				return false;
			}
		}
		return true;
	}
	// Funcionalidade 5 do Grupo 2.
	public ArrayList<PessoaColetiva> obterPessoasColetivasQueNaoPagaramAnoAtual() {
		ArrayList<PessoaColetiva> pessoasColetivas = new ArrayList<>();
		for (Contribuinte contribuinte : contribuintes) {
			if (contribuinte instanceof PessoaColetiva pc && naoPagouAnoAtual(contribuinte)) {
				pessoasColetivas.add(pc);

			}
		}
		return pessoasColetivas;
	}
	//Funcionalidade 6 do Grupo 2.
	private ArrayList<ImpostoPessoaColetiva> obterImpostosPessoaColetiva(int ano){
		ArrayList<ImpostoPessoaColetiva> listaImpostosPessoasColetivas= new ArrayList<>();
		for (Imposto imposto : impostos) {
			if(imposto.getAno() == ano && imposto instanceof ImpostoPessoaColetiva ipc) {
				listaImpostosPessoasColetivas.add(ipc);
				
			}			
		}
		return listaImpostosPessoasColetivas;
	}
	//Funcionalidade 6 do Grupo 2.
	public Contribuinte obterPessoaCotetivaMaiorImposto(int ano) {
		ArrayList<ImpostoPessoaColetiva> listaImpostosPessoasColetivas = obterImpostosPessoaColetiva(ano);
		ImpostoPessoaColetiva maiorImposto = listaImpostosPessoasColetivas.get(0);
		for (int i = 1; i < listaImpostosPessoasColetivas.size(); i++) {
			if(maiorImposto.calcularImposto() < listaImpostosPessoasColetivas.get(i).calcularImposto()) {
				maiorImposto = listaImpostosPessoasColetivas.get(i);
			}			
		}
		return maiorImposto.getContribuinte();
	}
	//Funcionalidade 7 do Grupo 2.
	public Imposto obterImposto(int ano, int nif) {		
	
		for (Imposto imposto : impostos) {
			if(imposto.getAno() == ano && imposto.getContribuinte().getNif() == nif) {
				return imposto;
			}			
		}
		return null;
	}
	private void populate() {	
		
		addPessoaColetiva("Frescomar",138529349,Atividade.INDUSTRIA);
		addImpostoPessoaColetiva(2018, 120000000, 4000000, 138529349);
		addImpostoPessoaColetiva(2019, 160000000, 6000000, 138529349);
		addImpostoPessoaColetiva(2020, 300000000, 11000000, 138529349);
		addImpostoPessoaColetiva(2021, 350000000, 14000000, 138529349);
		addImpostoPessoaColetiva(2022, 370000000, 13000000, 138529349);
		//addImpostoPessoaColetiva(2023, 560000000, 15000000, 138529349);		
		addPessoaColetiva("Fenicia",182495623,Atividade.COMERCIO);
		addImpostoPessoaColetiva(2018, 36000000, 1000000, 182495623);
		addImpostoPessoaColetiva(2019, 44000000, 3000000, 182495623);
		addImpostoPessoaColetiva(2020, 57000000, 3000000, 182495623);
		addImpostoPessoaColetiva(2021, 63000000, 4000000, 182495623);
		addImpostoPessoaColetiva(2022, 76000000, 4000000, 182495623);
		//addImpostoPessoaColetiva(2023, 88000000, 5000000, 182495623);		
		addPessoaColetiva("Calu&Angela",192742749,Atividade.COMERCIO);
		addImpostoPessoaColetiva(2018, 23000000, 1400000, 192742749);
		addImpostoPessoaColetiva(2019, 74000000, 2300000, 192742749);
		addImpostoPessoaColetiva(2020, 84000000, 1300000, 192742749);
		addImpostoPessoaColetiva(2021, 63000000, 5300000, 192742749);
		addImpostoPessoaColetiva(2022, 63000000, 6300000, 192742749);
		addImpostoPessoaColetiva(2023, 73000000, 65300000, 192742749);		
		addPessoaColetiva("Secreto Iberico",157296378,Atividade.SERVICO);
		addImpostoPessoaColetiva(2018, 30000000, 1000000, 157296378);
		addImpostoPessoaColetiva(2019, 40000000, 3000000, 157296378);
		addImpostoPessoaColetiva(2020, 50000000, 3000000, 157296378);
		addImpostoPessoaColetiva(2021, 60000000, 4000000, 157296378);
		addImpostoPessoaColetiva(2022, 70000000, 4000000, 157296378);
		addImpostoPessoaColetiva(2023, 80000000, 5000000, 157296378);		
		addPessoaColetiva("Roma",173482697,Atividade.SERVICO);
		addImpostoPessoaColetiva(2018, 30000000, 1000000, 173482697);
		addImpostoPessoaColetiva(2019, 40000000, 3000000, 173482697);
		addImpostoPessoaColetiva(2020, 50000000, 3000000, 173482697);
		addImpostoPessoaColetiva(2021, 60000000, 4000000, 173482697);
		addImpostoPessoaColetiva(2022, 70000000, 4000000, 173482697);
		addImpostoPessoaColetiva(2023, 80000000, 5000000, 173482697);		
		addPessoaColetiva("Iogurel",162947296,Atividade.INDUSTRIA);
		addImpostoPessoaColetiva(2018, 30000000, 3600000, 162947296);
		addImpostoPessoaColetiva(2019, 35500000, 1300000, 162947296);
		addImpostoPessoaColetiva(2020, 56300000, 4600000, 162947296);
		addImpostoPessoaColetiva(2021, 36300000, 2500000, 162947296);
		addImpostoPessoaColetiva(2022, 63500000, 2300000, 162947296);
		//addImpostoPessoaColetiva(2023, 83600000, 6300000, 162947296);
		addPessoaColetiva("Cultura de cana-de-açúcar",174379572,Atividade.AGRICULTURA);
		addImpostoPessoaColetiva(2018, 35300000, 1500000, 174379572);
		addImpostoPessoaColetiva(2019, 46300000, 3600000, 174379572);
		addImpostoPessoaColetiva(2020, 56300000, 3500000, 174379572);
		addImpostoPessoaColetiva(2021, 66300000, 5300000, 174379572);
		addImpostoPessoaColetiva(2022, 73400000, 6500000, 174379572);
		addImpostoPessoaColetiva(2023, 83400000, 6300000, 174379572);
		addPessoaColetiva("Caprinicultura",192648294,Atividade.AGRICULTURA);
		addImpostoPessoaColetiva(2018, 34600000, 1400000, 192648294);
		addImpostoPessoaColetiva(2019, 46700000, 3600000, 192648294);
		addImpostoPessoaColetiva(2020, 56700000, 3300000, 192648294);
		addImpostoPessoaColetiva(2021, 68400000, 4500000, 192648294);
		addImpostoPessoaColetiva(2022, 73500000, 4400000, 192648294);
		addImpostoPessoaColetiva(2023, 86300000, 5500000, 192648294);
		addPessoaColetiva("Ocean Suites",164738495,Atividade.TURISMO);
		addImpostoPessoaColetiva(2018, 24500000, 1150000, 164738495);
		addImpostoPessoaColetiva(2019, 53400000, 3050000, 164738495);
		addImpostoPessoaColetiva(2020, 57400000, 5600000, 164738495);
		addImpostoPessoaColetiva(2021, 84500000, 4700000, 164738495);
		addImpostoPessoaColetiva(2022, 73300000, 4800000, 164738495);
		addImpostoPessoaColetiva(2023, 56346634, 5100000, 164738495);		
		addPessoaColetiva("Hotel Dunas de Sal ",173649274,Atividade.TURISMO);
		addImpostoPessoaColetiva(2018, 34000000, 1000000, 173649274);
		addImpostoPessoaColetiva(2019, 50400000, 3000000, 173649274);
		addImpostoPessoaColetiva(2020, 12500000, 3000000, 173649274);
		addImpostoPessoaColetiva(2021, 64400000, 4000000, 173649274);
		addImpostoPessoaColetiva(2022, 45700000, 4000000, 173649274);
		addImpostoPessoaColetiva(2023, 80300000, 5000000, 173649274);		
		addPessoaSingular("João Martins", 162553853, EstadoCivil.CASADO,"20030301F1283");		
		addImpostoPessoaSingular(2018, 1040000, 200000, 162553853);
		addImpostoPessoaSingular(2019, 1040000, 200000, 162553853);
		addImpostoPessoaSingular(2020, 1040000, 200000, 162553853);
		addImpostoPessoaSingular(2021, 1040000, 200000, 162553853);
		addImpostoPessoaSingular(2022, 1040000, 200000, 162553853);
		addImpostoPessoaSingular(2023, 1040000, 200000, 162553853);
		addPessoaSingular("Graciette Texeira", 152583953, EstadoCivil.CASADO,"20010315F1098");
		addImpostoPessoaSingular(2018, 2350000, 210000, 152583953);
		addImpostoPessoaSingular(2019, 2350000, 210000, 152583953);
		addImpostoPessoaSingular(2020, 2350000, 210000, 152583953);
		addImpostoPessoaSingular(2021, 2350000, 210000, 152583953);
		addImpostoPessoaSingular(2022, 2350000, 210000, 152583953);
		addImpostoPessoaSingular(2023, 2040000, 210000, 152583953);
		addPessoaSingular("Claudia Rodrigues", 182583969, EstadoCivil.CASADO,"20040904F1442");
		addImpostoPessoaSingular(2018, 7540000, 340000, 182583969);
		addImpostoPessoaSingular(2019, 7540000, 340000, 182583969);
		addImpostoPessoaSingular(2020, 7540000, 340000, 182583969);
		addImpostoPessoaSingular(2021, 7540000, 340000, 182583969);
		addImpostoPessoaSingular(2022, 7540000, 340000, 182583969);
		addImpostoPessoaSingular(2023, 7540000, 340000, 182583969);
		addPessoaSingular("Mario Gonsales", 152583356, EstadoCivil.CASADO,"19990123M1882");
		addImpostoPessoaSingular(2018, 3420000, 150000, 152583356);
		addImpostoPessoaSingular(2019, 3420000, 150000, 152583356);
		addImpostoPessoaSingular(2020, 3420000, 150000, 152583356);
		addImpostoPessoaSingular(2021, 3420000, 150000, 152583356);
		addImpostoPessoaSingular(2022, 3420000, 150000, 152583356);
		addImpostoPessoaSingular(2023, 3420000, 150000, 152583356);
		addPessoaSingular("Luis Arlindo", 192883353, EstadoCivil.CASADO,"19871215M1784");
		addImpostoPessoaSingular(2018, 320000, 110000, 192883353);
		addImpostoPessoaSingular(2019, 320000, 110000, 192883353);
		addImpostoPessoaSingular(2020, 320000, 110000, 192883353);
		addImpostoPessoaSingular(2021, 320000, 110000, 192883353);
		addImpostoPessoaSingular(2022, 320000, 110000, 192883353);
		addImpostoPessoaSingular(2023, 320000, 110000, 192883353);
		addPessoaSingular("Jose da Luz", 128533983, EstadoCivil.CASADO,"19931121M1273");
		addImpostoPessoaSingular(2018, 212000, 100000, 128533983);
		addImpostoPessoaSingular(2019, 212000, 100000, 128533983);
		addImpostoPessoaSingular(2020, 212000, 100000, 128533983);
		addImpostoPessoaSingular(2021, 212000, 100000, 128533983);
		addImpostoPessoaSingular(2022, 212000, 100000, 128533983);
		addImpostoPessoaSingular(2023, 212000, 100000, 128533983);
		
	}

}
