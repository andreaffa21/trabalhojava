import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

// Classe da interface gráfica da loja
public class LojaInterface extends JFrame {
    private Loja loja;                      // Referência para a loja (modelo de dados)
    private JTable tabela;                  // Tabela para exibir as bebidas
    private DefaultTableModel modeloTabela; // Modelo da tabela (controla dados exibidos)
    private JButton btnTotalDescontos;      // Botão para calcular total de descontos

    // Construtor da interface
    public LojaInterface(Loja loja) {
        this.loja = loja; // Armazena a instância da loja

        // Configurações da janela
        setTitle("Loja de Bebidas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Define as colunas da tabela
        String[] colunas = {"Nome", "Preço", "Estoque", "Desconto"};
        modeloTabela = new DefaultTableModel(colunas, 0); // Inicia com 0 linhas
        tabela = new JTable(modeloTabela);

        // Estilização da tabela (fonte e altura da linha)
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        tabela.setRowHeight(24);

        // Alinha colunas numéricas à direita (preço, estoque e desconto)
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabela.getColumnModel().getColumn(1).setCellRenderer(rightRenderer); // Preço
        tabela.getColumnModel().getColumn(2).setCellRenderer(rightRenderer); // Estoque
        tabela.getColumnModel().getColumn(3).setCellRenderer(rightRenderer); // Desconto

        // Adiciona a tabela com scroll ao centro da janela
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Criação do botão para calcular total de descontos
        btnTotalDescontos = new JButton("Calcular Total de Descontos");
        btnTotalDescontos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ao clicar, calcula o total de descontos e mostra em uma janela
                double total = loja.calcularTotalDescontos();
                JOptionPane.showMessageDialog(LojaInterface.this,
                        String.format("Total de Descontos: R$ %.2f", total));
            }
        });

        // Painel inferior para posicionar o botão centralizado
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelInferior.add(btnTotalDescontos);
        add(painelInferior, BorderLayout.SOUTH); // Coloca o painel com o botão no rodapé

        // Carrega os dados da loja na tabela
        carregarTabela();
    }

    // Função que carrega os dados das bebidas na tabela
    private void carregarTabela() {
        modeloTabela.setRowCount(0);  // Limpa a tabela removendo todas as linhas
        for (Bebida b : loja.getBebidas()) {
            // Formata o preço e o desconto com duas casas decimais
            String precoFormatado = String.format("R$ %.2f", b.getPreco());
            String descontoFormatado = String.format("R$ %.2f", b.calcularDesconto());
            
            // Cria a linha com os dados formatados
            Object[] linha = {b.getNome(), precoFormatado, b.getQuantidadeEstoque(), descontoFormatado};
            
            // Adiciona a linha no modelo da tabela
            modeloTabela.addRow(linha);
        }
    }
}
