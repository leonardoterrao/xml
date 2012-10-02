package avaliacao.importar;

import java.util.HashMap;
import java.util.Map;

import avaliacao.entidade.Biblioteca;
import avaliacao.entidade.Livro;

public enum Elemento {

	LIVRO("http://www.biblioteca.com.br/livro") {
		@Override
		public void adicionarLivro(Biblioteca biblioteca, Livro livro) {}
	},

	AUTOR("http://www.biblioteca.com.br/autor") {
		@Override
		public void adicionarLivro(Biblioteca biblioteca, Livro livro) {}
	},
	NOME("nome") {
		@Override
		public void adicionarLivro(Biblioteca biblioteca, Livro livro) {
			biblioteca.addLivro(livro);
		}
	},
	NENHUM(null) {
		@Override
		public void adicionarLivro(Biblioteca biblioteca, Livro livro) {}
	};

	private static final Map<String, Elemento> values = new HashMap<String, Elemento>();

	static {
		for (Elemento elemento : values()) {
			values.put(elemento.uri, elemento);
		}
	}

	public static Elemento fromString(String uri) {
		return values.get(uri);
	}

	private final String uri;

	private Elemento(String uri) {
		this.uri = uri;
	}

	public abstract void adicionarLivro(Biblioteca biblioteca, Livro livro);
}
