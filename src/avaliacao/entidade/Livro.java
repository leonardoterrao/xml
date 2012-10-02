package avaliacao.entidade;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Livro implements Serializable {

	private final String titulo;
	private final String isbn;
	private final Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public Livro(String titulo, String isbn, Autor autor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
	}

}