package xml;

import entidade.Medalha;
import entidade.Pais;
import entidade.QuadroDeMedalhas;

public class QuadroDeMedalhasFactory {

	public static QuadroDeMedalhas createQuadroDeMedalhas() {
		QuadroDeMedalhas quadroDeMedalhas = new QuadroDeMedalhas();
		Pais eua = new Pais("EUA", 999);
		adicionarMedalhas(eua, Medalha.OURO, 41);
		adicionarMedalhas(eua, Medalha.PRATA, 26);
		adicionarMedalhas(eua, Medalha.BRONZE, 28);
		quadroDeMedalhas.addPais(eua);
		Pais china = new Pais("China", 12000);
		adicionarMedalhas(china, Medalha.OURO, 37);
		adicionarMedalhas(china, Medalha.PRATA, 26);
		adicionarMedalhas(china, Medalha.BRONZE, 21);
		quadroDeMedalhas.addPais(china);
		return quadroDeMedalhas;
	}

	private static void adicionarMedalhas(Pais pais, Medalha medalha,
			int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			pais.addMedalha(medalha);
		}
	}
}
