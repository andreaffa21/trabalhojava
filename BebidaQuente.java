// Subclasse que representa bebidas quentes (ex: café, chá)
public class BebidaQuente extends Bebida {
    private int temperaturaIdeal;  // Temperatura ideal de consumo
    private boolean contemCafeina; // Se contém cafeína

    // Construtor
    public BebidaQuente(String nome, double preco, int quantidadeEstoque, int temperaturaIdeal, boolean contemCafeina) {
        super(nome, preco, quantidadeEstoque);
        this.temperaturaIdeal = temperaturaIdeal;
        this.contemCafeina = contemCafeina;
    }

    // Implementação do método abstrato: dá 5% de desconto se o estoque for grande
    @Override
    public double calcularDesconto() {
        return (getQuantidadeEstoque() > 50) ? getPreco() * 0.05 : 0;
    }

    // Sobrescreve exibirDetalhes para incluir detalhes específicos de bebida quente
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Temperatura Ideal: " + temperaturaIdeal + "°C, Contém Cafeína: " + contemCafeina);
    }
}
