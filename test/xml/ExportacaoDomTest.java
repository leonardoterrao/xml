package xml;


import org.junit.Test;

import xml.ExportacaoDom;
import xml.QuadroDeMedalhasFactory;

import entidade.QuadroDeMedalhas;

public class ExportacaoDomTest {

    @Test
    public void testExportar() throws Exception {
        QuadroDeMedalhas quadroDeMedalhas = QuadroDeMedalhasFactory.createQuadroDeMedalhas();

        ExportacaoDom exportacaoDom = new ExportacaoDom();
        exportacaoDom.exportar(quadroDeMedalhas, System.out);
    }
}
