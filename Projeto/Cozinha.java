package org.example;

public class Cozinha implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("Cozinha: Pedido atualizado - Novo status: " + pedido.getStatus());
    }
}