import java.util.ArrayList;

// Classe que representa a loja, armazenando uma coleção de bebidas
public class Loja {
    private ArrayList<Bebida> bebidas = new ArrayList<>();  // Coleção de bebidas (associação)

    // Adiciona uma bebida à lista
    public void adicionarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    // Lista todas as bebidas com seus detalhes e descontos
    public void listarBebidas() {
        for (Bebida b : bebidas) {
            b.exibirDetalhes();  // Chamada polimórfica: pode ser BebidaFria ou BebidaQuente
            System.out.println("Desconto: R$" + b.calcularDesconto());
        }
    }

    // Calcula o total de descontos acumulados
    public double calcularTotalDescontos() {
        double total = 0;
        for (Bebida b : bebidas) {
            total += b.calcularDesconto();
        }
        return total;
    }

    // Retorna a lista de bebidas (usado na interface gráfica)
    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }
}
