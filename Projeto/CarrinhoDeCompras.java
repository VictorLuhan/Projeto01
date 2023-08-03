package org.example;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private static CarrinhoDeCompras instance;
    private List<Produto> itens;

    private CarrinhoDeCompras() {
        itens = new ArrayList<>();
    }

    public static CarrinhoDeCompras getInstance() {
        if (instance == null) {
            instance = new CarrinhoDeCompras();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        itens.remove(produto);
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }
}