public class No {

    String valor;
    No esquerda, direita;
    int altura;
    int fatorBalanceamento;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
        altura = 1;
        fatorBalanceamento = 0;
    }

    public void atualizarAlturaEFator() {
        int alturaEsquerda = (esquerda != null) ? esquerda.altura : 0;
        int alturaDireita = (direita != null) ? direita.altura : 0;

        altura = 1 + Math.max(alturaEsquerda, alturaDireita);
        fatorBalanceamento = alturaEsquerda - alturaDireita;
    }
}
