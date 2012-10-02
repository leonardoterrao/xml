package entidade;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Strings;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

public class Pais {
    
    private final String nome;
    
    private final int delegacao;
    
    private final Multiset<Medalha> medalhas = LinkedHashMultiset.create();
    
    public Pais(String nome, int delegacao) {
        checkArgument(!Strings.isNullOrEmpty(nome));
        checkArgument(delegacao > 0);
        this.nome = nome;
        this.delegacao = delegacao;
    }
    
    public Pais addMedalha(Medalha medalha) {
        checkNotNull(medalha);
        medalhas.add(medalha);
        return this;
    }
    
    public int getOuros() {
        return medalhas.count(Medalha.OURO);
    }
    
    public int getPratas() {
        return medalhas.count(Medalha.PRATA);
    }
    
    public int getBronzes() {
        return medalhas.count(Medalha.BRONZE);
    }

    public String getNome() {
        return nome;
    }

    public int getDelegacao() {
        return delegacao;
    }
    
}