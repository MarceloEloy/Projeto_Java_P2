package Jogo.Armazenar;

import Jogo.Personagens.Heroi;
import Jogo.Personagens.Inimigo;

import java.util.ArrayList;
import java.util.List;

public class PersonagensService {
    public List<Inimigo> inimigos = new ArrayList<>();
    public List<Heroi> herois = new ArrayList<>();

    public void addHeroi(Heroi fichaPersonagem) {
        herois.add(fichaPersonagem);
    }

    public void addInimigo(Inimigo fichaPersonagem) {
        inimigos.add(fichaPersonagem);
    }

    public void atualizar(Object mudanca, int id, Object classe) {
        if (classe.getClass() == Inimigo.class) {
            if (mudanca.getClass() == Integer.class) {
                for (int i = 0; i < inimigos.size(); i++) {
                    if (inimigos.get(i).id == id) {
                        inimigos.get(i).level = (Integer) mudanca;
                    }
                }
            }
            if (mudanca.getClass() == String.class) {
                for (int i = 0; i < inimigos.size(); i++) {
                    if (inimigos.get(i).id == id) {
                        inimigos.get(i).nome = (String) mudanca;
                    }
                }
            }
        }
        if (classe.getClass() == Heroi.class) {
            if (mudanca.getClass() == Integer.class) {
                for (int i = 0; i < herois.size(); i++) {
                    if (herois.get(i).id == id) {
                        herois.get(i).level = (Integer) mudanca;
                    }
                }
            }
            if (mudanca.getClass() == String.class) {
                for (int i = 0; i < herois.size(); i++) {
                    if (herois.get(i).id == id) {
                        herois.get(i).nome = (String) mudanca;
                    }
                }
            }
        }
    }

    ;

    public Heroi getPersonagemHeroi(int id) {
        Heroi heroi = null;
            for (int i = 0; i < herois.size(); i++) {
                if (herois.get(i).id == id) {
                    heroi =  herois.get(i);
                }
            }
            return heroi;
        }
    public Inimigo getPersonagemInimigo(int id) {
        Inimigo inimigo = null;
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).id == id) {
                inimigo =  inimigos.get(i);
            }
        }
        return inimigo;
    }
}

