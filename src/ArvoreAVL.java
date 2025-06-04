public class ArvoreAVL {

    private No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No node, String valor) {
        if (node == null) {
            return new No(valor);
        }

        if (valor.compareTo(node.valor) < 0) {
            node.esquerda = inserir(node.esquerda, valor);
        } else if (valor.compareTo(node.valor) > 0) {
            node.direita = inserir(node.direita, valor);
        } else {
            return node;
        }

        node.atualizarAlturaEFator();

        return (node);
    }


    public void buscarPreOrdem() {
        buscarPreOrdemRec(raiz);
    }

    private void buscarPreOrdemRec(No node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            buscarPreOrdemRec(node.esquerda);
            buscarPreOrdemRec(node.direita);
        }
    }

}