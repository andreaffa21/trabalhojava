import java.util.ArrayList;


public class Loja {
    private ArrayList<Bebida> bebidas = new ArrayList<>();  

    // Adiciona uma bebida à lista
    public void adicionarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    // Lista todas as bebidas com seus detalhes e descontos
    public void listarBebidas() {
        for (Bebida b : bebidas) {
            b.exibirDetalhes();  // chamada poliformica, tanto quente quanto gelada
            System.out.println("Desconto: R$" + b.calcularDesconto());
        }
    }

    // calcula total de descontos
    public double calcularTotalDescontos() {
        double total = 0;
        for (Bebida b : bebidas) {
            total += b.calcularDesconto();
        }
        return total;
    }

    // Retorna a lista de bebidas
    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }
}
