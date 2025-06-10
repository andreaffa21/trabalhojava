
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ProdutoCSV {
    private static String nomeArquivo = "./dados/Produtos.csv";

    public static void AddProduto(Produto p){
        try {
            //verifica se o arquivo existe
            boolean arquivoExiste = new File(nomeArquivo).exists();

            //abre o escritor para adicionar os dados ao arquivo
            FileWriter escritor = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1, true);
             if (!arquivoExiste){
                escritor.write("Nome;Preço;Volume\n");
             }

             escritor.write(p.getNome() + ";" + p.getPreco() + ";" + p.getVolume() + "\n" );
             
             escritor.flush();
             //fecha o recurso de escrita
             escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //metodo para listar produtos dp arquivo CSV
     public static ArrayList<Produto> ListarProduto(){
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            //abrir o leitor
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor .readLine())!=null){
                if (primeiraLinha){
                    primeiralinha = false;
                    continue;
                }
                //Dividir a linha em partes usando o ;

                String[] partes = linha.split(";");

                String nome = partes[0];
                double preco = Double.parseDouble(partes[1]);
                int volume = int.parseInt(partes[2]);

                //Criar objeto Produto
                Produto p = new Produto(nome, preco, valume);

                //add na lista
                lista.add(p);
                //imprimir informações da lista
                System.out.print("Nome: "+ nome + "- Preço: " + preco + "- Volume: " + volume);
            }
            leitor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
     }
}

