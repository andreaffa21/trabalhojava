
public class BebidaQuente extends Bebida {
    private int temperaturaIdeal;  
    private boolean contemCafeina; 

    // Construtor
    public BebidaQuente(String nome, double preco, int quantidadeEstoque, int temperaturaIdeal, boolean contemCafeina) {
        super(nome, preco, quantidadeEstoque);
        this.temperaturaIdeal = temperaturaIdeal;
        this.contemCafeina = contemCafeina;
    }

    // meotod abstrato(melhorar): dá 5% de desconto se o estoque for grande
    @Override
    public double calcularDesconto() {
        return (getQuantidadeEstoque() > 50) ? getPreco() * 0.05 : 0;
    }

    // Sobrescreve a chada de exibição de detalhes para incluir detalhes específicos de bebida quente
    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Temperatura Ideal: " + temperaturaIdeal + "°C, Contém Cafeína: " + contemCafeina);
    }
}
