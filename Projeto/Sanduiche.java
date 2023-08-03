package org.example;

public class Sanduiche extends Produto {
    public Sanduiche(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public Sanduiche clone() {
        return new Sanduiche(this.getNome(), this.getPreco());
    }
}