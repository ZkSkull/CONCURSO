package Concurso;

import java.util.Scanner;

class Pessoa {
    String nome;
    double nota1;
    double nota2;
    double media;

    Pessoa(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = (nota1 + nota2) / 2.0;
    }
}

public class Concurso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de pessoas? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha

        Pessoa[] pessoas = new Pessoa[n];
        int totalAprovados = 0;
        double somaMediaAprovados = 0.0;
        Pessoa maiorMediaPessoa = null;

        // Leitura dos dados das pessoas
        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Nota etapa 1: ");
            double nota1 = sc.nextDouble();
            System.out.print("Nota etapa 2: ");
            double nota2 = sc.nextDouble();
            sc.nextLine(); // Consumir a quebra de linha

            Pessoa pessoa = new Pessoa(nome, nota1, nota2);
            pessoas[i] = pessoa;

            // Verifica aprovação
            if (pessoa.media >= 70.0) {
                totalAprovados++;
                somaMediaAprovados += pessoa.media;
            }

            // Verifica maior média
            if (maiorMediaPessoa == null || pessoa.media > maiorMediaPessoa.media) {
                maiorMediaPessoa = pessoa;
            }
        }

        // Exibe a tabela de pessoas
        System.out.println("### TABELA ###");
        for (Pessoa pessoa : pessoas) {
            System.out.printf("%s, %.1f, %.1f, MEDIA = %.2f%n", pessoa.nome, pessoa.nota1, pessoa.nota2, pessoa.media);
        }

        // Exibe os aprovados
        System.out.println("### PESSOAS APROVADAS ###");
        for (Pessoa pessoa : pessoas) {
            if (pessoa.media >= 70.0) {
                System.out.println(pessoa.nome);
            }
        }

        // Calcula e exibe porcentagem de aprovação
        double porcentagemAprovacao = (double) totalAprovados / n * 100;
        System.out.printf("Porcentagem de aprovação: %.1f %%\n", porcentagemAprovacao);

        // Exibe a maior média
        if (maiorMediaPessoa != null) {
            System.out.println("Maior média: " + maiorMediaPessoa.nome);
        }

        // Exibe a média dos aprovados, se houver algum
        if (totalAprovados > 0) {
            double mediaAprovados = somaMediaAprovados / totalAprovados;
            System.out.printf("Nota média dos aprovados: %.2f%n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados");
        }

        sc.close();
    }
}
