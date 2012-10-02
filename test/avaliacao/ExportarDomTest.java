package avaliacao;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import avaliacao.entidade.Biblioteca;
import avaliacao.exportar.ExportarDom;

public class ExportarDomTest {

	@Test
	public void testExportar() throws Exception {

		Biblioteca biblioteca = Biblioteca.createBiblioteca();

		ExportarDom exportar = new ExportarDom();
		exportar.exportar(biblioteca, System.out);
	}

	@Test
	public void testExportarFile() throws Exception {

		File file = new File("C:\\biblioteca.xml");
		FileOutputStream fos = new FileOutputStream(file);

		Biblioteca biblioteca = Biblioteca.createBiblioteca();

		ExportarDom exportar = new ExportarDom();
		exportar.exportar(biblioteca, fos);
	}
}