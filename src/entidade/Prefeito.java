package entidade;

import org.w3c.dom.Node;

public class Prefeito extends Candidato {

    Prefeito(String partido, String nome, int votos) {
        super(partido, nome, votos);
    }

    Prefeito(Node node) {
        super(node);
    }
}