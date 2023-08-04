package Controller;

import Repository.RepositorioLanche;
import Repository.BebidaRepository;
import Service.PedidoService;

import java.util.Scanner;

public class PedidoController {
    private PedidoService pedidoService;
    private Scanner scanner = new Scanner(System.in);
    public  PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    public void  exibirMenu(){
        System.out.println("_____MENU------");
        System.out.println("1. Lanche");
        System.out.println("2. Bebida");
        System.out.println("0. Finalizar Pedido");
        System.out.println("__________");

    }
    public void processoEscolha(int opcao) {
        switch (opcao) {
            case 1:
                exibirMenuLanches();
                break;
            case 2:
                exibirMenuBebidas();
                break;
            case 0:
                finalizarPedido();
                break;
            default:
                System.out.println("Opação Incavlida");
        }
    }
    private  void exibirMenuLanches(){
        System.out.println("----LANCHE----");
        System.out.println("1. xBURGER");
        System.out.println("2. xSALADA");
        System.out.println("0. VOLTAR AO MENU");
        System.out.println("--------");}

    private void exibirMenuBebidas() {
        System.out.println("----LANCHE----");
        System.out.println("1. Refrigenrante");
        System.out.println("2. Suco");
        System.out.println("0. VOLTAR AO MENU");
        System.out.println("--------");
    }

    private int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextInt();
    }
    public void  iniciar(){
    int opcao;
    do {
        exibirMenu();
        opcao = lerInteiro("Escolha a opção: ");
        processoEscolha(opcao);
    }while (opcao!=0);
    }
    private void adicionarItem(int codigo,int quantidade){
    String resultado = pedidoService.adicionarItem(codigo,quantidade);
    System.out.println(resultado);
    }
    private void removerItem(int codigo){
    String resultado = pedidoService.removerItem(codigo);
    System.out.println(resultado);
}
private  void  editarItem(int codigo, int novaQuantidade){
    String resultado = pedidoService.editarItem(codigo,novaQuantidade);
    System.out.println(resultado);
    }
private void  finalizarPedido(){
    System.out.println("Finalizando pedido");
    System.out.println("Valor total: R$"+ pedidoService.calcularValorTotal());
    System.out.println("Forma de pagamento: ");
    System.out.println("1. cartao de credito ");
    System.out.println("2. cartao de debito ");
    System.out.println("3.Vale refeicao ");
    System.out.println("4.dinheiro: ");
    System.out.println("------------- ");

    int opcaoPagamento = lerInteiro("Escolha um opção de pagamento:");
    String formaPagamento;
    switch (opcaoPagamento){
        case 1:
            formaPagamento = "Cartao de credito";
            break;
        case 2:
            formaPagamento = " Cartao de Debito";
            break;
        case 3:
            formaPagamento = " vale refeiçao";
            break;
        case 4:
            formaPagamento = "dinheiro";
            break;
        default:
            System.out.println("Opção invalida");
            return;
    }
    double valorPago = 0;
    if (formaPagamento.equals("Dinheiro")) {
        valorPago = scanner.nextDouble();
    }
    String resultado = pedidoService.finalizarPedido(formaPagamento,valorPago);
    System.out.println(resultado);

    }
    public static void main( String[]args) {
        RepositorioLanche repositorioLanche = new RepositorioLanche();
        BebidaRepository bebidaRepository = new BebidaRepository();
        PedidoService pedidoService = new PedidoService(repositorioLanche, bebidaRepository);
        PedidoController controller = new PedidoController(pedidoService);
        controller.iniciar();
    }
}

















