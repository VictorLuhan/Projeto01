package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoDeCompras carrinho = CarrinhoDeCompras.getInstance();
        FabricaProduto fabrica = new FabricaProduto();
        Pedido pedido = new Pedido();
        Cozinha cozinha = new Cozinha();
        Atendente atendente = new Atendente();

        pedido.adicionarObservador(cozinha);
        pedido.adicionarObservador(atendente);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do Scanner

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, carrinho, fabrica);
                    break;
                case 2:
                    removerProduto(scanner, carrinho);
                    break;
                case 3:
                    enviarPedido(scanner, carrinho, pedido);
                    break;
                case 4:
                    exibirTotalCarrinho(carrinho);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== Lanchonete =====");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Enviar pedido para produção");
        System.out.println("4. Exibir total do carrinho");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
    }

    private static void adicionarProduto(Scanner scanner, CarrinhoDeCompras carrinho, FabricaProduto fabrica) {
        System.out.println("Selecione o tipo de produto:");
        System.out.println("1. Sanduíche");
        System.out.println("2. Bebida");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do Scanner

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do Scanner

        Produto produto;
        switch (opcao) {
            case 1:
                produto = fabrica.criarProduto("sanduiche", nome, preco);
                break;
            case 2:
                produto = fabrica.criarProduto("bebida", nome, preco);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        carrinho.adicionarProduto(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    private static void removerProduto(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = scanner.nextLine();

        for (Produto produto : carrinho.getItens()) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                carrinho.removerProduto(produto);
                System.out.println("Produto removido do carrinho: " + produto.getNome());
                return;
            }
        }

        System.out.println("Produto não encontrado no carrinho!");
    }

    private static void enviarPedido(Scanner scanner, CarrinhoDeCompras carrinho, Pedido pedido) {
        if (carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de enviar o pedido.");
            return;
        }

        System.out.print("Deseja confirmar o envio do pedido? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            for (Produto produto : carrinho.getItens()) {
                System.out.println("Enviando para produção: " + produto.getNome());
            }

            carrinho.limparCarrinho();
            pedido.setStatus(StatusPedido.RECEBIDO);
            pedido.setStatus(StatusPedido.PREPARANDO);
            pedido.setStatus(StatusPedido.ENTREGUE);

            System.out.println("Pedido enviado para produção.");
        } else {
            System.out.println("Envio do pedido cancelado.");
        }
    }

    private static void exibirTotalCarrinho(CarrinhoDeCompras carrinho) {
        System.out.println("Total do carrinho: " + carrinho.calcularTotal());
    }
}