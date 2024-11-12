package Jogo.Personagens;

public interface HabilidadesComuns<X extends FichaPersonagem> {
    public void socar(X x);
    public void correr(X x);
    public void curar();
}
