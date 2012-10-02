package avaliacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import avaliacao.entidade.Biblioteca;
import avaliacao.entidade.Livro;
import avaliacao.exportar.ExportarDom;
import avaliacao.importar.ImportarSax;

public class App {

	public static void main(String[] args) throws Exception {
		new App();
	}

	public App() throws Exception {
		exportar();
		importar();
	}

	private void importar() throws Exception {
		Biblioteca biblioteca = null;

		File file = new File("C:\\biblioteca.xml");
		FileInputStream fis = new FileInputStream(file);

		// InputStream in = getClass().getResourceAsStream("/avaliacao.xml");

		ImportarSax importacaoSAX = new ImportarSax();
		biblioteca = importacaoSAX.importar(fis);

		for (Livro livro : biblioteca.getLivros()) {
			System.out.println(" LIVRO - Isbn: " + livro.getIsbn());
			System.out.println(" LIVRO - Titulo: " + livro.getTitulo());
			System.out.println("   |--AUTOR - Nome: " + livro.getAutor().getNome());
			System.out.println("   |--AUTOR - Titulo: " + livro.getAutor().getTitulo());
			System.out.println("");
		}

	}

	private void exportar() throws Exception {

		File file = new File("C:\\biblioteca.xml");
		FileOutputStream fos = new FileOutputStream(file);

		Biblioteca biblioteca = Biblioteca.createBiblioteca();

		ExportarDom exportador = new ExportarDom();
		exportador.exportar(biblioteca, fos);
	}
}