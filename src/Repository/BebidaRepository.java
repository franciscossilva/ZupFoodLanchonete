package Repository;

import Model.Bebida;

import Model.Lanche;

import java.util.HashMap;
import java.util.Map;

public class BebidaRepository {
    private Map<Integer, Bebida> bebidas = new HashMap<>();
    public BebidaRepository() {
        bebidas.put(1,new Bebida(1, "Refrigerante",8.00));
        bebidas.put(2,new Bebida(1, "Suco",6.00));
    }


    public Bebida buscarBebidaPorCodigo(int codigo){
        return bebidas.get(codigo);
    }
}