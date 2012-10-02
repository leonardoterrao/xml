package avaliacao.entidade;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Biblioteca implements Serializable {

    private final LinkedList<Livro> livros = new LinkedList<Livro>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public Biblioteca(){
    }

	public static Biblioteca createBiblioteca() {

		Biblioteca biblioteca = new Biblioteca();

		Autor autor1 = new Autor("R. Derpencio", "Derpencio Rerb");
		Livro livro1 = new Livro("Javando", "125473256", autor1);

		Autor autor2 = new Autor("S. Derpina", "Derpina Silva");
		Livro livro2 = new Livro("Java Foda", "55966514", autor2);

		Autor autor3 = new Autor("F. Derpson", "Derpson Faria");
		Livro livro3 = new Livro("Programação para iniciantes", "6633548787", autor3);

		biblioteca.addLivro(livro1);
		biblioteca.addLivro(livro2);
		biblioteca.addLivro(livro3);
		
		return biblioteca;
	}
}
