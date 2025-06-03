// Classe de exceção personalizada para casos de estoque insuficiente
public class Estoqueinsu extends Exception {
    public Estoqueinsu(String mensagem) {
        super(mensagem);
    }
}
