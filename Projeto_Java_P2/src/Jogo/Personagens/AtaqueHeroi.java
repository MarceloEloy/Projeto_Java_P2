package Jogo.Personagens;

@FunctionalInterface
public interface AtaqueHeroi<X extends FichaPersonagem> {
    public void ataqueHeroico(FichaPersonagem fichaPersonagem);
}
