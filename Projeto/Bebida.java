package org.example;

public class Bebida extends Produto {
    public Bebida(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public Bebida clone() {
        return new Bebida(this.getNome(), this.getPreco());
    }
}