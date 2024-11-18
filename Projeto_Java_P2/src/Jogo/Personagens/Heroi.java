package Jogo.Personagens;

public class Heroi extends FichaPersonagem implements HabilidadesComuns<FichaPersonagem> {
    public Heroi(Raca raca, Integer level, String nome, int id) {
        super(raca, level, nome, id);
    }

// toda a proxima implementação de interface foi feita usando GENERICS e trabalha polimorfismo.

    public void ataqueHeroi (FichaPersonagem fichaPersonagem){
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
        else {
            fichaPersonagem.vida -= this.vida * this.level;
            System.out.println("Ataque realizado com sucesso");
        }};


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
    public Integer correr(FichaPersonagem fichaPersonagem) {
        if(this.vida == null){
            definirDefesa();
            fichaPersonagem.definirDefesa();
        }
        if(this.vida <= 0){
            System.out.println("Este personagem está morto!");
        }
        else if (fichaPersonagem.vida <= 0) {

            System.out.println("Este oponente está morto, fuga bem sucedida!");
            return 1;
        }
        else{
            if(definirVelocidade() > fichaPersonagem.definirVelocidade()){
                System.out.println("Fugiu");
                return 1;
            }
            else {
                System.out.println("Openente é mais rápido");
                return 0;
            }
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
            System.out.println("personagem morto, impossivel curar");
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






