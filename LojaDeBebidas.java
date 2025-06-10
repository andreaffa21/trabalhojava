import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LojaDeBebidas {
    private ArrayList<Produto> catalogo;
    private Map<String, Integer> quantidadesEstoque;

    public LojaDeBebidas() {
        catalogo = new ArrayList<>();
        quantidadesEstoque = new HashMap<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        adicionarProdutoAoEstoque(new BebidaAlcoolica("Cerveja", 5.99, 350, "Gelada"), 50);
        adicionarProdutoAoEstoque(new BebidaAlcoolica("Vinho", 29.99, 750, "Ambiente"), 20);
        adicionarProdutoAoEstoque(new BebidaAlcoolica("Vodka", 19.99, 500, "Gelada"), 30);
        adicionarProdutoAoEstoque(new BebidaNaoAlcoolica("Refrigerante", 4.50, 600, "Gelada"), 100);
        adicionarProdutoAoEstoque(new BebidaNaoAlcoolica("Água", 2.50, 500, "Gelada"), 150);
        adicionarProdutoAoEstoque(new BebidaNaoAlcoolica("Suco Natural", 6.00, 300, "Ambiente"), 40);
    }

    private void adicionarProdutoAoEstoque(Produto produto, int quantidade) {
        catalogo.add(produto);
        quantidadesEstoque.put(produto.getNome(), quantidade);
    }
    
    public void verificarDisponibilidade(Produto produto, int quantidadeDesejada) throws EstoqueInsu {
        int estoqueAtual = quantidadesEstoque.getOrDefault(produto.getNome(), 0);

        if (quantidadeDesejada > estoqueAtual) {
            throw new EstoqueInsu(
                "Estoque insuficiente para '" + produto.getNome() + "'. Disponível: " + estoqueAtual
            );
        }
    }

    public ArrayList<Produto> listarBebidas(String tipo, String temperatura) {
        ArrayList<Produto> listaFiltrada = new ArrayList<>();
        for (Produto p : catalogo) {
            if ((tipo.equals("alcoolica") && p instanceof BebidaAlcoolica) ||
                (tipo.equals("naoalcoolica") && p instanceof BebidaNaoAlcoolica)) {
                if (p instanceof BebidaAlcoolica ba && ba.getTemperatura().equalsIgnoreCase(temperatura)) {
                    listaFiltrada.add(ba);
                } else if (p instanceof BebidaNaoAlcoolica bna && bna.getTemperatura().equalsIgnoreCase(temperatura)) {
                    listaFiltrada.add(bna);
                }
            }
        }
        for (int i = 0; i < listaFiltrada.size(); i++) {
            System.out.print(i + " - ");
            listaFiltrada.get(i).exibirInfo(); // REQUISITO: Chamada Polimórfica
            System.out.println("    (Estoque: " + quantidadesEstoque.get(listaFiltrada.get(i).getNome()) + ")");
        }
        return listaFiltrada;
    }
    
     public String selecionarTemperaturaPorIndice(Scanner sc) {
        System.out.println("Selecione a temperatura da bebida:");
        System.out.println("1 - Gelada");
        System.out.println("2 - Ambiente (Quente)");
        System.out.print("Opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        if (escolha == 1) return "Gelada";
        else if (escolha == 2) return "Ambiente";
        else return "";
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : catalogo) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
