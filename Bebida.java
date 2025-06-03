// Classe abstrata que representa uma bebida genérica
public abstract class Bebida {
    // Atributos encapsulados
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    // Construtor
    public Bebida(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Método abstrato
    public abstract double calcularDesconto();

    // Método concreto: exibe detalhes da bebida
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + ", Preço: R$" + preco + ", Estoque: " + quantidadeEstoque);
    }

    // Métodos de acesso (getters)
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
}
