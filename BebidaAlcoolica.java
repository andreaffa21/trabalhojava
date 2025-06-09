public class BebidaAlcoolica extends Produto {
    private String temperatura;

    public BebidaAlcoolica(String nome, double preco, int volume, String temperatura) {
        super(nome, preco, volume);
        this.temperatura = temperatura;
    }

    public String getTemperatura() { return temperatura; }

    //Sobre escreve a função exibirInfo();
    @Override
    public void exibirInfo() {
        System.out.println("Alcoólica (" + temperatura + "): " + nome + " - R$" + preco + " - " + volume + "ml");
    }
}
