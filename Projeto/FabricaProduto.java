package org.example;

public class FabricaProduto {
    public Produto criarProduto(String tipo, String nome, double preco) {
        if (tipo.equalsIgnoreCase("sanduiche")) {
            return new Sanduiche(nome, preco);
        } else if (tipo.equalsIgnoreCase("bebida")) {
            return new Bebida(nome, preco);
        } else {
            throw new IllegalArgumentException("Tipo de produto inválido");
        }
    }
}