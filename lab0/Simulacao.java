import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacao {
    public static void main(String[] args) {
        List<Tanque> tanques = new ArrayList<>();
        String[] nomes = {"Alfa", "Bravo", "Charlie", "Delta", "Echo"};
        
        for (int i = 0; i < nomes.length; i++) {
            tanques.add(new Tanque(nomes[i]));
        }

        Random sorteio = new Random();
        System.out.println("Inicio com " + tanques.size() + " tanques.\n");

        while (tanques.size() > 1) {
            int indiceAtacante = sorteio.nextInt(tanques.size());
            Tanque atacante = tanques.get(indiceAtacante);

            int indiceAlvo;
            do {
                indiceAlvo = sorteio.nextInt(tanques.size());
            } while (indiceAlvo == indiceAtacante);
            
            Tanque alvo = tanques.get(indiceAlvo);

            atacante.atirarEm(alvo);
            if (!alvo.isVivo()) {
                tanques.remove(alvo);
                System.out.println(alvo.getNome() + " foi destruido! Só tem " + tanques.size() + " tanques.\n");
            }
        }

        System.out.println("Vencedor: " + tanques.get(0).getNome());
    }
}