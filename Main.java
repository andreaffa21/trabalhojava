import javax.swing.SwingUtilities;

// Classe principal para testar a aplicação
public class Main {
    public static void main(String[] args) {
        // Cria a loja e adiciona bebidas
        Loja loja = new Loja();
        loja.adicionarBebida(new BebidaQuente("Chá Verde", 8.50, 100, 80, false));
        loja.adicionarBebida(new BebidaFria("Água Mineral", 3.00, 200, true, "500ml"));
        loja.adicionarBebida(new BebidaFria("Refrigerante", 7.50, 30, true, "1L"));

        // Inicia a interface gráfica na thread de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LojaInterface(loja).setVisible(true);
            }
        });
    }
}
