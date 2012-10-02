package importador;

import java.io.InputStream;

import entidade.Eleicoes;

public interface Importador {

    public Eleicoes importar(InputStream in) throws Exception;
    
}