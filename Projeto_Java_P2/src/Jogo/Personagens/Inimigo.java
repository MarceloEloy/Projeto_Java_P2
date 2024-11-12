package Jogo.Personagens;

public class Inimigo extends FichaPersonagem implements HabilidadesComuns {
    public Inimigo(Raca raca, Integer level, String nome) {
        super(raca, level, nome);
    }
    // toda a proxima implementação de interface foi feita usando GENERICS e trabalha polimorfismo.
    @Override
    public void socar(FichaPersonagem fichaPersonagem) {
        if(this.vida == null){
            definirDefesa();
            fichaPersonagem.definirDefesa();
        }
        if(this.vida <= 0){
            System.out.println("Este personagem está morto!");
        }
        else if (fichaPersonagem.vida <= 0) {

            System.out.println("Este oponente está morto!");
        }
        else{
            fichaPersonagem.vida -= definirDano();
            System.out.println("Agressão realizada");
        }
    }
    @Override
    public void correr(FichaPersonagem fichaPersonagem) {
        if(this.vida == null){
            definirDefesa();
            fichaPersonagem.definirDefesa();
        }
        if(this.vida <= 0){
            System.out.println("Este personagem está morto!");
        }
        else if (fichaPersonagem.vida <= 0) {

            System.out.println("Este oponente está morto!");
        }
        else{
            System.out.println("Inimigos não fogem!!!");
        }
    }

    @Override
    public void curar() {
        if(this.vida == null){
            definirDefesa();
        }
        this.vida += level;
        System.out.println("Curou " + this.level + " Pontos de vida");
    }
}