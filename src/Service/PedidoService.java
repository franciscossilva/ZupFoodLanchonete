package Service;

import Model.Bebida;
import Model.ItemPedido;
import Model.Lanche;
import Model.Pedido;
import Repository.RepositorioLanche;
import Repository.BebidaRepository;

public class PedidoService {
    private RepositorioLanche repositorioLanche;
    private BebidaRepository bebidaRepository;
    private Pedido pedido = new Pedido();

    public PedidoService(RepositorioLanche repositorioLanche, BebidaRepository bebidaRepository) {
        this.repositorioLanche = repositorioLanche;
        this.bebidaRepository = bebidaRepository;
    }
    public String adicionarItem (int codigo, int quantidade){
        if (quantidade <=0){
            return "Quantidade invalida";
        }
        Lanche lanche = repositorioLanche.buscarLanchePorCodigo(codigo);
        Bebida bebida = bebidaRepository.buscarBebidaPorCodigo(codigo);



        if (lanche == null && bebida == null) {
            return " Codigo invalido";
        }
        if (lanche !=null){
            pedido.adicionarItem(new ItemPedido(lanche.getCodigo(), lanche.getNome(), lanche.getValor(), quantidade));
        }else {
            pedido.adicionarItem(new ItemPedido(bebida.getCodigo(), bebida.getNome(), bebida.getValor(), quantidade));
        }

   return "Item adicionado";
}
public  String removerItem(int codigo){
    if (codigo <= 0 ){
        return  "Codigo invalido";
    }
    pedido.removerItem(codigo);
    return "Item removido";
}

public  String editarItem(int codigo, int novaQuantidade) {
    if (novaQuantidade <= 0) {
        return "Quantidade invalida";
    }
    pedido.editarItem(codigo, novaQuantidade);
    return "Quantidade atualizada";
}

public double calcularValorTotal(){
    return pedido.calcularValorTotal();
}
 public String finalizarPedido(String formaPagamento,double valorPago) {
     double valorTotal = calcularValorTotal();
     double troco = valorPago - valorTotal;
     if (troco < 0) {
         return " Nao é suficiente com esse valor ";
     }

     StringBuilder sb = new StringBuilder("Pedidos Finalizados \n");
     sb.append("Itens Pedidos: \n");
     for (ItemPedido item : pedido.getItens()) {
         sb.append(item.getNome()).append("- Quantidade: ").append(item.getQuantidade()).append("\n");
     }
     sb.append("Valor pago: R$ ").append(valorTotal).append("\n");
     if (formaPagamento.equalsIgnoreCase("Dinheiro")) {
         sb.append("Valor pago: R$").append(valorPago).append("\n");
         sb.append("Troco: R$").append(troco).append("\n");
     }
     sb.append("Obrigado");
     return sb.toString();
 }}