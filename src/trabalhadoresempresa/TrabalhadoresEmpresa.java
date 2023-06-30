package trabalhadoresempresa;

import javax.swing.*;

public class TrabalhadoresEmpresa {

    private Trabalhador trab[];
    private int N;

    public static void main(String[] args) {
        TrabalhadoresEmpresa principal = new TrabalhadoresEmpresa();
    }

    public TrabalhadoresEmpresa() {
        simulacaoLeituraDeDados();
        mostraTrabalhadoresCadastrados();
        quickSortNome(trab, 0, trab.length - 1);
        visualizar(trab);
        quickSort(trab, 0, trab.length - 1);
        visualizar2(trab);
    }

    public void simulacaoLeituraDeDados() {

        N = 7;
        trab = new Trabalhador[N];
        trab[0] = new Trabalhador("Julio", 2000f, 'M');
        trab[1] = new Trabalhador("Mariana", 1000f, 'F');
        trab[2] = new Trabalhador("Renata", 800f, 'F');
        trab[3] = new Trabalhador("Pedro", 1500f, 'M');
        trab[4] = new Trabalhador("Amilton", 6000f, 'M');
        trab[5] = new Trabalhador("Jorge", 2200f, 'M');
        trab[6] = new Trabalhador("Carlos", 3500f, 'M');
    }

   
    

    public void mostraTrabalhadoresCadastrados() {
        String cad = "";
        for (int i = 0; i < N; i++) {
            cad += trab[i].toString() + "\n";
        }
        JTextArea outputArea = new JTextArea(15, 40);  
        outputArea.setText(cad);
        JScrollPane rolagem = new JScrollPane(outputArea);
        JOptionPane.showMessageDialog(null, rolagem, "Dados dos trabalhadores cadastrados",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean quickSortNome(Trabalhador[] vetor, int inicio, int fim) {
        if (vetor == null) {
            return false;
        }
        if (inicio < fim) {
            int posicaoPivo = separarNome(vetor, inicio, fim);
            quickSortNome(vetor, inicio, posicaoPivo - 1);
            quickSortNome(vetor, posicaoPivo + 1, fim);
        }
        return true;
    }

    private int separarNome(Trabalhador vetor[], int inicio, int fim) {
        Trabalhador pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i].getNome().compareToIgnoreCase(pivo.getNome()) <= 0) {
                i++;
            } else if (pivo.getNome().compareToIgnoreCase(vetor[f].getNome()) < 0) {
                f--;
            } else {
                Trabalhador troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    public boolean quickSort(Trabalhador[] vetor, int inicio, int fim) {
        if (vetor == null) {
            return false;
        }
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return true;
    }

    private int separar(Trabalhador[] vetor, int inicio, int fim) {
        Trabalhador pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i].getSalario() >= pivo.getSalario()) {
                i++;
            } else if (pivo.getSalario() > vetor[f].getSalario()) {
                f--;
            } else {
                Trabalhador troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;

    }

    public void visualizar(Trabalhador vetor[]) {
        System.out.println("Ordem Alfabética:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "   " + "\n");
        }
        System.out.println("\n");
    }

    public void visualizar2(Trabalhador vetor[]) {
        System.out.println("Ordem Salario:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "   " + "\n");
        }
        System.out.println("\n");
    }

}
