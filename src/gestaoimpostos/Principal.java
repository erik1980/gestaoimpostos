package gestaoimpostos;

public class Principal {

	public static void main(String[] args) {

		DirecaoGeralImpostos dgi = new DirecaoGeralImpostos();
		System.out.println("********************Grupo 1***************************");

		System.out.println("1.Eliminar um contribuinte dado o seu NIF, se nunca foram aplicados impostos a ele.");

		System.out.println("2.Atualizar os dados de um contribuinte dado o seu NIF.");

		System.out.println("3.Listar os nomes e os NIF das pessoas coletivas.");

		System.out.println("4.Listar os NIF das pessoas coletivas e o valor dos impostos aplicados, que realizam uma determinada atividade.");

		System.out.println("5.Listar os NIF das pessoas singulares que pagaram todos os impostos até o ano atual.");

		System.out.println("6.Mostrar o nome e o NIF da pessoa singular que pagou menos impostos em um determinado ano.");

		System.out.println("7.Mostrar o total de impostos pagos por um contribuinte em um intervalo de anos.");

		System.out.println("8.Listar os contribuintes que pertencem ao setor do turismo.");

		System.out.println("9.Mostrar o total de impostos que foram aplicados as pessoas simples que são solteras.");

		System.out.println("********************Grupo 2***************************");
		System.out.println("1.Eliminar um imposto dado o ano e o NIF do contribuinte.");

		System.out.println("2.Atualizar um imposto dado o ano e o NIF do contribuinte.");
		System.out.println();
		System.out.println("3.Listar os nomes e os NIF das pessoas singulares.");
		for (Contribuinte contribuinte : dgi.obterPessoasSingulares()) {
			System.out.printf("\tNome: %s\n\tNIF: %s\n", contribuinte.getNome(), contribuinte.getNif());
			System.out.println();
		}
		System.out.println("4.Listar os NIF dos contribuintes e o valor dos impostos aplicados dado o ano.");

		System.out.println("5.Listar os NIF das pessoas coletivas que não pagaram impostos no ano atual.");

		System.out.println("6.Mostrar o nome e o NIF da pessoa coletiva que mais impostos pagou em um determinado ano");

		System.out.println("7.Mostrar o imposto de um contribuinte em um determinado ano.");

		System.out.println("8.Listar os contribuintes com estado civil solteiro.");

		System.out.println("9.Mostrar o total de impostos que foram aplicados as pessoas coletivas que exercem uma determinada atividade.");

	}

}
