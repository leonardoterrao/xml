package entidade;

import static com.google.common.base.Preconditions.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

public class QuadroDeMedalhas {
    
    private final List<Pais> paises = Lists.newLinkedList();
    
    public QuadroDeMedalhas addPais(Pais pais) {
        checkNotNull(pais);
        paises.add(pais);
        return this;
    }
    
    public List<Pais> getPaises() {
        return ImmutableList.copyOf(paises);
    }
    
}