package Jogo;

import Jogo.Personagens.FichaPersonagem;
import Jogo.Personagens.Heroi;
import Jogo.Personagens.Inimigo;
import Jogo.Personagens.Raca;

public class Play {
    public static void main(String[] args) {
        Heroi a = new Heroi(Raca.OGRO, 1, "1");
        Inimigo b = new Inimigo(Raca.ELFO, 2, "a");
        a.socar(b);

    }
}
