package entidade;

import java.util.LinkedList;
import java.util.List;

public class Eleicoes {

    private List<Prefeito> votosParaPrefeito = new LinkedList<Prefeito>();
    
    private List<Vereador> votosParaVereador = new LinkedList<Vereador>();
    
    public void addVotoParaPrefeito(Prefeito prefeito) {
        this.votosParaPrefeito.add(prefeito);
    }
    
    public void addVotoParaVereador(Vereador vereador) {
        this.votosParaVereador.add(vereador);
    }

    public List<Prefeito> getVotosParaPrefeito() {
        return votosParaPrefeito;
    }

    public List<Vereador> getVotosParaVereador() {
        return votosParaVereador;
    }
    
}