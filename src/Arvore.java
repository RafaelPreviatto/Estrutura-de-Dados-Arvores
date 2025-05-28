import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {

    No raiz;

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public void buscarPreOrdem(No node) {
        if (node != null) {
            System.out.println(node.valor + " ");
            buscarPreOrdem(node.esquerda);
            buscarPreOrdem(node.direita);
        }
    }

    public void buscarEmOrdem(No node) {
        if (node != null) {
            buscarEmOrdem(node.esquerda);
            System.out.println(node.valor + " ");
            buscarEmOrdem(node.direita);
        }
    }

    public void buscarPosOrdem(No node) {
        if (node != null) {
            buscarPosOrdem(node.esquerda);
            buscarPosOrdem(node.direita);
            System.out.println(node.valor + " ");
        }
    }

    public void buscaEmNivel(No node) {
        if (node != null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.println(atual.valor + "  ");

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
    }

    public void preOrdemInterativo(No raiz) {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.valor + " ");

            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
    }

    public void emOrdemInterativo(No raiz){
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()){
            while (atual != null){
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.println(atual.valor);

            atual = atual.direita;
        }
    }

    public void posOrdemInterativo(No raiz) {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) {
                pilha1.push(atual.esquerda);
            }

            if (atual.direita != null) {
                pilha1.push(atual.direita);
            }
        }

        while (!pilha2.isEmpty()) {
            No atual = pilha2.pop();
            System.out.println(atual.valor);
        }
    }


}