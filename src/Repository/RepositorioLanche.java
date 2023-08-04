package Repository;


import Model.Lanche;

import java.util.HashMap;
import java.util.Map;

public class RepositorioLanche {
    private Map<Integer, Lanche> lanches = new HashMap<>();
    public RepositorioLanche() {
        lanches.put(1,new Lanche(1, "X-burger",10.00));
        lanches.put(1,new Lanche(2,"X-Salada",12.00));
    }


    public Lanche buscarLanchePorCodigo(int codigo){
    return lanches.get(codigo);
}
}