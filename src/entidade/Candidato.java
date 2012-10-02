package entidade;

import org.w3c.dom.Node;

public abstract class Candidato {

    private final String partido;
    private final String nome;
    private final int votos;

    Candidato(String partido, String nome, int votos) {
        this.partido = partido;
        this.nome = nome;
        this.votos = votos;
    }

    Candidato(Node node) {
        this.partido = node.getAttributes().getNamedItem("partido").getTextContent();
        this.nome = node.getAttributes().getNamedItem("nome").getTextContent();
        this.votos = Integer.parseInt(node.getTextContent());
    }

    public static Prefeito newPrefeito(Node node) {
        return new Prefeito(node);
    }

    public static Prefeito newPrefeito(String partido, String nome, int votos) {
        return new Prefeito(partido, nome, votos);
    }

    public static Vereador newVereador(Node node) {
        return new Vereador(node);
    }

    public static Vereador newVereador(String partido, String nome, int votos) {
        return new Vereador(partido, nome, votos);
    }

    public String getPartido() {
        return partido;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }
}