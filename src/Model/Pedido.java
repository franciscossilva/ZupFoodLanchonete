package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    public  void adicionarItem(ItemPedido item) {
        itens.add(item);
    }
    public  void  removerItem(int codigo){
        itens.removeIf(item -> item.getCodigo()==codigo);
    }
    public void  editarItem(int codigo,int novaQuantidade){
        for (ItemPedido item : itens){
            if (item.getCodigo()==codigo){
                item.setQuantidade(novaQuantidade);
                break;
            }
        }
    }
public double calcularValorTotal() {
    double total = 0;
    for (ItemPedido item : itens) {
        total += item.getValor() * item.getQuantidade();
    }
    return total;
}
public  List<ItemPedido> getItens(){
    return itens;
    }
}