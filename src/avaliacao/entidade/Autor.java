package avaliacao.entidade;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Autor implements Serializable {

    private final String titulo;
    private final String nome;

    public Autor(String titulo, String nome) {
        this.titulo = titulo;
        this.nome = nome;
    }
    
	public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }
}
