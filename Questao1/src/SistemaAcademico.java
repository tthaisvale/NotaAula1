import java.util.Scanner;

public class SistemaAcademico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome e as três notas do aluno
        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a nota 1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Informe a nota 2: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Informe a nota 3: ");
        double nota3 = scanner.nextDouble();

        // Cria um objeto Aluno e exibe a situação acadêmica
        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
        aluno.exibirSituacao();

        // Fechar o scanner
        scanner.close();
    }
}
