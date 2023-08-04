package Model;

public class Lanche {
    private int codigo;
    private String nome;
    private double valor;
    public Lanche(int codigo,String nome,double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
    public int getCodigo(){
    return codigo;
    }
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
