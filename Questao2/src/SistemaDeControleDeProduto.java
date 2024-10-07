import java.util.Scanner;

public class SistemaDeControleDeProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do produto
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o tamanho/peso do produto: ");
        String tamanhoOuPeso = scanner.nextLine();

        System.out.print("Informe a cor do produto: ");
        String cor = scanner.nextLine();

        System.out.print("Informe o valor do produto: ");
        double valor = scanner.nextDouble();

        System.out.print("Informe a quantidade em estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();

        // Criação do objeto Produto
        Produto produto = new Produto(codigo, nome, tamanhoOuPeso, cor, valor, quantidadeEmEstoque);

        // Exibir detalhes do produto
        produto.exibirDetalhes();

        // Solicitar a quantidade a ser vendida
        System.out.print("Informe a quantidade a ser vendida: ");
        int quantidadeVendida = scanner.nextInt();

        // Verificar se a venda pode ser realizada
        if (!produto.verificarEstoque(quantidadeVendida)) {
            System.out.println("Estoque insuficiente para realizar a venda.");
            return; // Encerrar o programa caso não haja estoque
        }

        // Seleção da forma de pagamento
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Informe a forma de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
        String formaDePagamento = scanner.nextLine();

        // Calcular o valor final com base na forma de pagamento
        double valorFinal = produto.calcularValorComDesconto(formaDePagamento) * quantidadeVendida;
        System.out.println("Valor total da compra: R$ " + String.format("%.2f", valorFinal));

        // Realizar a venda e atualizar o estoque
        produto.realizarVenda(quantidadeVendida);

        // Caso seja crédito, parcelar em 3x sem juros
        if (formaDePagamento.equalsIgnoreCase("crédito")) {
            produto.parcelarNoCredito();
        }

        // Caso a forma de pagamento seja espécie, verificar se há troco
        if (formaDePagamento.equalsIgnoreCase("espécie")) {
            System.out.print("Informe o valor pago pelo cliente: ");
            double valorPago = scanner.nextDouble();
            produto.verificarTroco(valorPago, valorFinal);
        }

        // Fechar o scanner
        scanner.close();
    }
}
