package Jogo.Personagens;

public class Inimigo extends FichaPersonagem implements HabilidadesComuns<FichaPersonagem> {
    public Inimigo(Raca raca, Integer level, String nome, int id) {
        super(raca, level, nome, id);
    }
    // toda a proxima implementação de interface foi feita usando GENERICS e trabalha polimorfismo.
    @Override
    public void socar(FichaPersonagem fichaPersonagem) {
        if(this.vida == null){
            definirDefesa();
            fichaPersonagem.definirDefesa();
        }
        if(this.vida <= 0){
            System.out.println("Inimigo Morto!");
        }
        else if (fichaPersonagem.vida <= 0) {

            System.out.println("Este Heroi está morto!");
        }
        else{
            fichaPersonagem.vida -= definirDano();
            System.out.println("Agressão realizada");
        }
    }
    @Override
    public Integer correr(FichaPersonagem fichaPersonagem) {
        if(this.vida == null){
            definirDefesa();
            fichaPersonagem.definirDefesa();
        }
        if(this.vida <= 0){
            System.out.println("Inimigo Morto!");
        }
        else if (fichaPersonagem.vida <= 0) {

            System.out.println("Este oponente está morto!");
        }
        else{
            System.out.println("Inimigos não fogem!!!");
        }
        return 0;
    }

    @Override
    public void curar() {
        if(this.vida == null){
            definirDefesa();
        }
        if(this.vida > 0) {
            this.vida += level;
            System.out.println("Curou " + this.level + " Pontos de vida");
        }
        else{
            System.out.println("Inimigo Morto!");
        }
    }
    @Override
    public void mostrarVida() {
        if(this.vida == null){
            definirDefesa();
        }
        System.out.println(this.vida);
    }
}
