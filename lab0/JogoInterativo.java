import java.util.Random;
import java.util.Scanner;

public class JogoInterativo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random sorteio = new Random();

        int quantidade = 0;
        
        while (quantidade < 2 || quantidade > 10) {
            System.out.print("Quantos tanques vao jogar? ");
            quantidade = teclado.nextInt();
        }
        
        String lixo = teclado.nextLine(); 

        Tanque[] tanques = new Tanque[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nome do tanque " + i + ": ");
            String nome = teclado.nextLine();
            tanques[i] = new Tanque(nome);
        }

        int vivos = quantidade;
        int rodada = 1;

        while (vivos > 1) {
            System.out.println("\n Rodada " + rodada + "");

            boolean[] jaJogou = new boolean[quantidade];

            for (int turno = 0; turno < quantidade; turno++) {
                
                int sorteado;
                do {
                    sorteado = sorteio.nextInt(quantidade);
                } while (jaJogou[sorteado] == true);
                
                jaJogou[sorteado] = true; 
                
                Tanque atirador = tanques[sorteado];

                if (atirador.isVivo() == true) {
                    
                    int vivosAgora = 0;
                    for (int i = 0; i < quantidade; i++) {
                        if (tanques[i].isVivo() == true) {
                            vivosAgora++;
                        }
                    }
                    if (vivosAgora == 1) {
                        break; 
                    }

                    System.out.println("\nE a vez de: " + atirador.getNome());
                    System.out.println("Opcoes de alvo:");
                    
                    for (int i = 0; i < quantidade; i++) {
                        if (tanques[i].isVivo() == true && i != sorteado) {
                            System.out.println("Digite " + i + " para atacar " + tanques[i].getNome());
                        }
                    }

                    System.out.print("Qual e o seu alvo? ");
                    int escolha = teclado.nextInt();

                    atirador.atirarEm(tanques[escolha]);
                }
            }

            System.out.println("\nStatus ao fim da rodada " + rodada + "");
            for (int i = 0; i < quantidade; i++) {
                System.out.println(tanques[i].toString());
            }

            vivos = 0;
            for (int i = 0; i < quantidade; i++) {
                if (tanques[i].isVivo() == true) {
                    vivos++;
                }
            }

            rodada++;
        }

        System.out.println("\nFIM DE JOGO!");
        for (int i = 0; i < quantidade; i++) {
            if (tanques[i].isVivo() == true) {
                System.out.println("VENCEDOR: " + tanques[i].getNome());
            }
        }
    }
}