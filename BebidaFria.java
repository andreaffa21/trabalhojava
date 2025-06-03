    // Subclasse que representa bebidas frias (ex: refrigerante, água)
    public class BebidaFria extends Bebida {
        private boolean gelada;  // Indica se a bebida está gelada
        private String tamanho;  // Tamanho da bebida (ex: P, M, G ou 500ml)

        // Construtor
        public BebidaFria(String nome, double preco, int quantidadeEstoque, boolean gelada, String tamanho) {
            super(nome, preco, quantidadeEstoque);
            this.gelada = gelada;
            this.tamanho = tamanho;
        }

        // Implementação do método abstrato: dá 10% de desconto se estive
        @Override
        public double calcularDesconto() {
            return (gelada)  getPreco() * 0.10 : 0;
        }

        // Sobrescreve exibirDetalhes para incluir detalhes específicos de bebida fria
        @Override
        public void exibirDetalhes() {
            super.exibirDetalhes();
            System.out.println("Gelada: " + gelada + ", Tamanho: " + tamanho);
        }
    }
