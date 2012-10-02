package entidade;

import org.w3c.dom.Node;

public class Vereador extends Candidato {

    Vereador(String partido, String nome, int votos) {
        super(partido, nome, votos);
    }

    Vereador(Node node) {
        super(node);
    }
    
}