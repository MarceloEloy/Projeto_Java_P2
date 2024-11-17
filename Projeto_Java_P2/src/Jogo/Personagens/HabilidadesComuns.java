package Jogo.Personagens;

public interface HabilidadesComuns<X extends FichaPersonagem> {
    public void socar(X x);
    public Integer correr(X x);
    public void curar();
    public void mostrarVida();
}
