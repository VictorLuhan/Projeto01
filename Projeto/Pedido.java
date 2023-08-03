package org.example;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Observer> observadores;
    private StatusPedido status;

    public Pedido() {
        observadores = new ArrayList<>();
    }

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.atualizar(this);
        }
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
        notificarObservadores();
    }
}