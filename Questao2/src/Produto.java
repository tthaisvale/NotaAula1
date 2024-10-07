public class Produto {
    private int codigo;
    private String nome;
    private String tamanhoOuPeso;
    private String cor;
    private double valor;
    private int quantidadeEmEstoque;

    // Construtor da classe Produto
    public Produto(int codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Método para verificar se há quantidade suficiente em estoque para a venda
    public boolean verificarEstoque(int quantidadeVendida) {
        return quantidadeVendida <= quantidadeEmEstoque;
    }

    // Método para realizar a venda e atualizar o estoque
    public void realizarVenda(int quantidadeVendida) {
        if (verificarEstoque(quantidadeVendida)) {
            quantidadeEmEstoque -= quantidadeVendida;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    // Método para exibir o valor do produto com base na forma de pagamento
    public double calcularValorComDesconto(String formaDePagamento) {
        if (formaDePagamento.equalsIgnoreCase("pix") ||
                formaDePagamento.equalsIgnoreCase("espécie") ||
                formaDePagamento.equalsIgnoreCase("transferência") ||
                formaDePagamento.equalsIgnoreCase("débito")) {
            return valor * 0.95; // 5% de desconto
        } else {
            return valor; // Sem desconto
        }
    }

    // Método para parcelar no crédito
    public void parcelarNoCredito() {
        double valorParcelado = valor / 3;
        System.out.println("Valor parcelado em 3x sem juros: 3x de R$ " + String.format("%.2f", valorParcelado));
    }

    // Método para exibir os detalhes do produto
    public void exibirDetalhes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho/Peso: " + tamanhoOuPeso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
    }

    // Método para verificar troco
    public void verificarTroco(double valorPago, double valorFinal) {
        if (valorPago > valorFinal) {
            double troco = valorPago - valorFinal;
            System.out.println("Troco: R$ " + String.format("%.2f", troco));
        } else if (valorPago == valorFinal) {
            System.out.println("Pagamento exato, sem troco.");
        } else {
            System.out.println("Valor pago insuficiente.");
        }
    }
}
