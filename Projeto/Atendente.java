package org.example;

public class Atendente implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("Atendente: Pedido atualizado - Novo status: " + pedido.getStatus());
    }
}