package Jogo.Personagens;

//Classe abstrata, não podendo ser instânciada mas posuindo todos os métodos necessários para as classes filhas
public class FichaPersonagem{
    public FichaPersonagem(Raca raca, Integer level, String nome){
        this.raca = raca;
        this.level = level;
        this.nome = nome;
    }
    protected Raca raca;
    protected Integer level;
    public Double vida = null;
    protected String nome;
    public Double definirDano(){
        double dano = 0;
        switch (raca){
            case GOBLIN -> dano = 1.4 * this.level;
            case ELFO -> dano = 2.2 * this.level;
            case OGRO -> dano = 4.4 * this.level;
            case GNOMO -> dano = 1.3 * this.level;
            case HUMANO -> dano = 2 * this.level;
            case MEIO_HUMANO -> dano = this.level;
        }
        return dano;
    }
    public Double definirDefesa(){
        double defesa = 0;
        switch (raca){
            case GOBLIN -> defesa = 0.4 * this.level;
            case ELFO -> defesa = 1.2 * this.level;
            case OGRO -> defesa = 3.5 * this.level;
            case GNOMO -> defesa = 0.5 * this.level;
            case HUMANO -> defesa = this.level;
            case MEIO_HUMANO -> defesa = 0.5 *  this.level;
        }

        return this.vida = defesa;
    }
    public  Double definirVelocidade(){
        double velocidade = 0;
        switch (raca){
            case GOBLIN -> velocidade = 2 * this.level;
            case ELFO -> velocidade = 1.4 * this.level;
            case OGRO -> velocidade = 0.3 * this.level;
            case GNOMO -> velocidade = 2.1 * this.level;
            case HUMANO -> velocidade = 1.4 * this.level;
            case MEIO_HUMANO -> velocidade = 3.1 * this.level;
        }
        return velocidade;
    }
}
