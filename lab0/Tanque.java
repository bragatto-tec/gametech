public class Tanque {
    private String nome;
    private boolean vivo;
    private int municao;
    private int armadura;

    public Tanque(String nome) {
        this.nome = nome;
        this.vivo = true;
        this.municao = 5;      
        this.armadura = 60;    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String toString() {
        if (this.vivo) {
            return this.nome + ", " + this.armadura + " de armadura, " + this.municao + " municoes";
        } else {
            return this.nome + " MORTO";
        }
    }

    public void explodir() {
        this.vivo = false;
        System.out.println(this.nome + " explodiu!");
    }

    public void tomarTiro() {
        this.armadura -= 20;
        System.out.println(this.nome + " foi atingido!");
        if (this.armadura <= 0) {
            this.explodir();
        }
    }

    public void atirarEm(Tanque inimigo) {
        if (this.municao >= 1) {
            this.municao -= 1;
            System.out.println(this.nome + " atira em " + inimigo.getNome());
            inimigo.tomarTiro();
        } else {
            System.out.println(this.nome + " sem municao!!!");
        }
    }
}