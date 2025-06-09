

import java.util.ArrayList;
import java.util.Scanner;


public class LojaDeBebidas {
    private ArrayList<Produto> estoque;

    public LojaDeBebidas() {
        estoque = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        // Bebidas alcoólicas geladas
        estoque.add(new BebidaAlcoolica("Cerveja", 5.99, 350, "Gelada"));
        estoque.add(new BebidaAlcoolica("Vodka", 19.99, 500, "Gelada"));
        estoque.add(new BebidaAlcoolica("Caipirinha", 14.99, 300, "Gelada"));
        estoque.add(new BebidaAlcoolica("Catuaba", 9.99, 500, "Gelada"));
        estoque.add(new BebidaAlcoolica("Ice", 8.50, 275, "Gelada"));

        // Bebidas alcoólicas ambiente
        estoque.add(new BebidaAlcoolica("Vinho", 29.99, 750, "Ambiente"));
        estoque.add(new BebidaAlcoolica("Whisky", 89.90, 700, "Ambiente"));
        estoque.add(new BebidaAlcoolica("Conhaque", 24.90, 500, "Ambiente"));
        estoque.add(new BebidaAlcoolica("Rum", 32.00, 600, "Ambiente"));
        estoque.add(new BebidaAlcoolica("Licor", 18.50, 500, "Ambiente"));

        // Bebidas não alcoólicas geladas
        estoque.add(new BebidaNaoAlcoolica("Refrigerante", 4.50, 600, "Gelada"));
        estoque.add(new BebidaNaoAlcoolica("Água", 2.50, 500, "Gelada"));
        estoque.add(new BebidaNaoAlcoolica("Chá Gelado", 3.90, 500, "Gelada"));
        estoque.add(new BebidaNaoAlcoolica("Suco de Laranja", 4.80, 400, "Gelada"));
        estoque.add(new BebidaNaoAlcoolica("Água com Gás", 3.00, 500, "Gelada"));

        // Bebidas não alcoólicas ambiente
        estoque.add(new BebidaNaoAlcoolica("Suco Natural", 6.00, 300, "Ambiente"));
        estoque.add(new BebidaNaoAlcoolica("Água de Coco", 5.50, 330, "Ambiente"));
        estoque.add(new BebidaNaoAlcoolica("Vitamina", 6.50, 400, "Ambiente"));
        estoque.add(new BebidaNaoAlcoolica("Leite", 3.20, 500, "Ambiente"));
        estoque.add(new BebidaNaoAlcoolica("Achocolatado", 4.20, 300, "Ambiente"));
    }

    public ArrayList<Produto> listarBebidas(String tipo, String temperatura) {
        ArrayList<Produto> listaFiltrada = new ArrayList<>();
        for (Produto p : estoque) {
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
            listaFiltrada.get(i).exibirInfo();
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
        for (Produto p : estoque) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
