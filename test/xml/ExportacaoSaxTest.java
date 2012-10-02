package xml;


import org.junit.Test;

import xml.ExportacaoSax;
import xml.QuadroDeMedalhasFactory;

import entidade.QuadroDeMedalhas;

public class ExportacaoSaxTest {

	@Test
	public void testExportar() throws Exception {
		QuadroDeMedalhas quadroDeMedalhas = QuadroDeMedalhasFactory.createQuadroDeMedalhas();
		ExportacaoSax exportacaoSax = new ExportacaoSax();
		exportacaoSax.exportar(quadroDeMedalhas, System.out);
	}

}