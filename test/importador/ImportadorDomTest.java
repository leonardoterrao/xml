package importador;

import importador.Importador;
import importador.ImportadorDom;

import java.io.InputStream;


import org.junit.Test;

import entidade.Eleicoes;
import static org.junit.Assert.*;

public class ImportadorDomTest {
    
    @Test
    public void importar() throws Exception {
        InputStream in = getClass().getResourceAsStream("/eleicoes.xml");
        Importador importador = new ImportadorDom();
        Eleicoes eleicoes = importador.importar(in);
        assertEquals("44", eleicoes.getVotosParaPrefeito().get(0).getPartido());
        assertEquals("Fulano", eleicoes.getVotosParaPrefeito().get(0).getNome());
        assertEquals(123, eleicoes.getVotosParaPrefeito().get(0).getVotos());
        assertEquals("44", eleicoes.getVotosParaVereador().get(0).getPartido());
        assertEquals("Ciclano", eleicoes.getVotosParaVereador().get(0).getNome());
        assertEquals(5, eleicoes.getVotosParaVereador().get(0).getVotos());
        assertEquals("44", eleicoes.getVotosParaVereador().get(1).getPartido());
        assertEquals("Hermanoteu", eleicoes.getVotosParaVereador().get(1).getNome());
        assertEquals(10, eleicoes.getVotosParaVereador().get(1).getVotos());
    }
}
