package avaliacao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import avaliacao.entidade.Biblioteca;
import avaliacao.importar.ImportarSax;

public class ImportarSaxTest {

	@Test
	public void importarTest() throws Exception {

		InputStream in = getClass().getResourceAsStream("/avaliacao.xml");
		ImportarSax importar = new ImportarSax();
		Biblioteca biblioteca = importar.importar(in);
		assertEquals("125473256", biblioteca.getLivros().get(0).getIsbn());
        assertEquals("Javando", biblioteca.getLivros().get(0).getTitulo());
        assertEquals("Derpencio Rerb", biblioteca.getLivros().get(0).getAutor().getNome());
        assertEquals("R. Derpencio", biblioteca.getLivros().get(0).getAutor().getTitulo());
        assertEquals("55966514", biblioteca.getLivros().get(1).getIsbn());
        assertEquals("Java Foda", biblioteca.getLivros().get(1).getTitulo());
        assertEquals("Derpina Silva", biblioteca.getLivros().get(1).getAutor().getNome());
        assertEquals("S. Derpina", biblioteca.getLivros().get(1).getAutor().getTitulo());
        assertEquals("6633548787", biblioteca.getLivros().get(2).getIsbn());
        assertEquals("Programação para iniciantes", biblioteca.getLivros().get(2).getTitulo());
        assertEquals("Derpson Faria", biblioteca.getLivros().get(2).getAutor().getNome());
        assertEquals("F. Derpson", biblioteca.getLivros().get(2).getAutor().getTitulo());
	}

	@Test
	public void importarFileTest() throws Exception {
		
		File file = new File("C:\\biblioteca.xml");
		FileInputStream fis = new FileInputStream(file);

		ImportarSax importar = new ImportarSax();
		Biblioteca biblioteca = importar.importar(fis);

		assertEquals("125473256", biblioteca.getLivros().get(0).getIsbn());
		assertEquals("Javando", biblioteca.getLivros().get(0).getTitulo());
		assertEquals("Derpencio Rerb", biblioteca.getLivros().get(0).getAutor().getNome());
		assertEquals("R. Derpencio", biblioteca.getLivros().get(0).getAutor().getTitulo());
		assertEquals("55966514", biblioteca.getLivros().get(1).getIsbn());
		assertEquals("Java Foda", biblioteca.getLivros().get(1).getTitulo());
		assertEquals("Derpina Silva", biblioteca.getLivros().get(1).getAutor().getNome());
		assertEquals("S. Derpina", biblioteca.getLivros().get(1).getAutor().getTitulo());
		assertEquals("6633548787", biblioteca.getLivros().get(2).getIsbn());
		assertEquals("Programação para iniciantes", biblioteca.getLivros().get(2).getTitulo());
		assertEquals("Derpson Faria", biblioteca.getLivros().get(2).getAutor().getNome());
		assertEquals("F. Derpson", biblioteca.getLivros().get(2).getAutor().getTitulo());
	}
	
}
