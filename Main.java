import java.util.Scanner;
import java.util.ArrayList;

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LojaDeBebidas loja = new LojaDeBebidas();
        ArrayList<Produto> carrinho = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();

        System.out.println("=== Bem-vindo à Distribuidora JavaBebidas ===");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        Cliente cliente = new Cliente(nome, idade);

        int opcao;
        do {
            System.out.println("\nOlá " + cliente.getNome() + ", escolha uma opção:");
            System.out.println("1 - Escolher bebidas alcoólicas");
            System.out.println("2 - Escolher bebidas não alcoólicas");
            System.out.println("3 - Ver carrinho");
            System.out.println("4 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                case 2:
                    String tipo = (opcao == 1) ? "alcoolica" : "naoalcoolica";
                    if (tipo.equals("alcoolica") && cliente.getIdade() < 18) {
                        System.out.println("Você não pode comprar bebidas alcoólicas.");
                        break;
                    }

                    String temp = loja.selecionarTemperaturaPorIndice(sc);

                    ArrayList<Produto> lista = loja.listarBebidas(tipo, temp);
                    if (lista.isEmpty()) {
                        System.out.println("Nenhuma bebida disponível nessa categoria.");
                        break;
                    }

                    System.out.print("Digite o número da bebida que deseja: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index >= 0 && index < lista.size()) {
                        Produto selecionado = lista.get(index);
                        System.out.print("Quantidade: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();
                        carrinho.add(selecionado);
                        quantidades.add(qtd);
                        System.out.println(qtd + "x " + selecionado.getNome() + " adicionados ao carrinho.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 3:
                    System.out.println("\n=== Carrinho ===");
                    double total = 0;
                    for (int i = 0; i < carrinho.size(); i++) {
                        Produto p = carrinho.get(i);
                        int qtd = quantidades.get(i);
                        System.out.println(qtd + "x " + p.getNome() + " - R$" + p.getPreco());
                        total += p.getPreco() * qtd;
                    }
                    System.out.println("Total parcial: R$" + total);
                    break;

                case 4:
                    double totalFinal = 0;
                    System.out.println("\n=== Finalizando compra ===");
                    for (int i = 0; i < carrinho.size(); i++) {
                        Produto p = carrinho.get(i);
                        int qtd = quantidades.get(i);
                        totalFinal += p.getPreco() * qtd;
                    }
                    System.out.println("Compra finalizada. Total a pagar: R$" + totalFinal);
                    carrinho.clear();
                    quantidades.clear();
                    break;

                case 0:
                    System.out.println("Obrigado por visitar a JavaBebidas!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
