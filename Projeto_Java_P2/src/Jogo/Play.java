package Jogo;

import Jogo.Armazenar.PersonagensService;
import Jogo.Personagens.Heroi;
import Jogo.Personagens.Inimigo;
import Jogo.Personagens.Raca;
import Jogo.Tela.TelaJogo;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws IOException {
        Heroi heroi = new Heroi(Raca.ELFO, 1, "A", 1);
        Inimigo inimigo = new Inimigo(Raca.ELFO, 1, "A", 1);
        PersonagensService armazen = new PersonagensService();
        TelaJogo tela = new TelaJogo();
        while (true){
            System.out.println("Opções de aplicação [1] Criar e armazenar personagem [2] Edita personagem [3] Começar o jogo");
            Scanner decisao = new Scanner(System.in);
            int escolha = decisao.nextInt();
            if (escolha == 1) {
                int i = 0;
                while (i == 0) {
                    Scanner criacaoString = new Scanner(System.in);
                    Scanner criacaoNum = new Scanner(System.in);
                    System.out.println("Você gostaria de criar um heroi [H] ou um inimigo [I]?");
                    String classe = criacaoString.next().toUpperCase();
                    if (classe.toCharArray()[0] == 'H') {
                        System.out.println("A qual raça seu heroi pertence? ELFO [1] OGRO [2] HUMANO [3] GOBLIN [4] GNOMO [5]");
                        int escolhaRaca = criacaoNum.nextInt();
                        Raca raca = null;
                        switch (escolhaRaca) {
                            case 1 -> raca = Raca.ELFO;
                            case 2 -> raca = Raca.OGRO;
                            case 3 -> raca = Raca.HUMANO;
                            case 4 -> raca = Raca.GOBLIN;
                            case 5 -> raca = Raca.GNOMO;
                        }
                        System.out.println("Qual o nível do seu heroi?");
                        int level = criacaoNum.nextInt();
                        System.out.println("Qual o nome do seu heroi?");
                        String nome = criacaoString.next();
                        System.out.println("Qual o ID do seu heroi?");
                        int id = criacaoNum.nextInt();
                        Heroi x = new Heroi(raca, level, nome, id);
                        armazen.addHeroi(x);
                        System.out.println("Deseja continuar a criação personagem (S/N)");
                        String continuar = criacaoString.next().toUpperCase();
                        if (continuar.equalsIgnoreCase("N")) {
                            i = 1;
                        }
                    }
                    if (classe.toCharArray()[0] == 'I') {
                        System.out.println("A qual raça seu inimigo pertence? ELFO [1] OGRO [2] HUMANO [3] GOBLIN [4] GNOMO [5]");
                        int escolhaRaca = criacaoNum.nextInt();
                        Raca raca = null;
                        switch (escolhaRaca) {
                            case 1 -> raca = Raca.ELFO;
                            case 2 -> raca = Raca.OGRO;
                            case 3 -> raca = Raca.HUMANO;
                            case 4 -> raca = Raca.GOBLIN;
                            case 5 -> raca = Raca.GNOMO;
                        }
                        System.out.println("Qual o nível do seu inimigo?");
                        int level = criacaoNum.nextInt();
                        System.out.println("Qual o nome do seu inimigo?");
                        String nome = criacaoString.next();
                        System.out.println("Qual o ID do seu inimigo?");
                        int id = criacaoNum.nextInt();
                        Inimigo x = new Inimigo(raca, level, nome, id);
                        armazen.addInimigo(x);
                        System.out.println("Deseja continuar a criação personagem (S/N)");
                        String continuar = criacaoString.next().toUpperCase();
                        if (continuar.equalsIgnoreCase("N")) {
                            i = 1;
                        }
                    }
                }
            }
            if(escolha == 2){
                Scanner criacaoString = new Scanner(System.in);
                Scanner criacaoNum = new Scanner(System.in);
                System.out.println("Digite o Id do personagem");
                int id = criacaoNum.nextInt();
                System.out.println("Você quer mudar um Heroi [H] ou Inimigo [I]?");
                String heroiOuInimigo = criacaoString.next().toUpperCase();
                System.out.println("Oque você quer mudar Nome [N] level [L]?");
                String nomeOuLevel = criacaoString.next().toUpperCase();
                if(heroiOuInimigo.equalsIgnoreCase("H")){
                    if (nomeOuLevel.equalsIgnoreCase("N")){
                        System.out.println("Digite o nome novo");
                        String nome = criacaoString.next();
                        armazen.atualizar(nome, id, heroi);
                    }
                    else {
                        System.out.println("Digite o Level novo");
                        Integer level = criacaoNum.nextInt();
                        armazen.atualizar(level, id, heroi);
                    }
                }
                else{
                    if (nomeOuLevel.equalsIgnoreCase("N")){
                        System.out.println("Digite o nome novo");
                        String nome = criacaoString.next();
                        armazen.atualizar(nome, id, inimigo);
                    }
                    else {
                        System.out.println("Digite o Level novo");
                        Integer level = criacaoNum.nextInt();
                        armazen.atualizar(level, id, inimigo);
                    }
                }
            }
            if (escolha == 3) {
                Random random = new Random();
                Inimigo enemy = inimigo;
                Heroi hero = heroi;
                Scanner personagens = new Scanner(System.in);
                if (!armazen.herois.isEmpty()) {
                    System.out.println("Escolha o seu Heroi pelo id");
                    hero = armazen.getPersonagemHeroi(personagens.nextInt());
                }
                if (!armazen.inimigos.isEmpty()) {
                    System.out.println("Escolha o seu Inimigo pelo id");
                    enemy = armazen.getPersonagemInimigo(personagens.nextInt());
                }
                while (true) {
                    tela.tela();
                    if (tela.ataque == 1) {
                        int vezInimigo = random.nextInt(1, 9);
                        tela.ataque = 0;
                        System.out.println("Heroi:");
                        hero.socar(enemy);
                        System.out.println("-----------------------");
                        System.out.println("Inimigo:");
                        if (vezInimigo <= 3) {
                            enemy.socar(hero);
                        }
                        if (vezInimigo > 3 && vezInimigo <= 6) {
                            enemy.curar();
                        }
                        if (vezInimigo > 6) {
                            enemy.correr(hero);
                        }
                        System.out.println("-----------------------");
                        System.out.println("Vida atual do Inimigo " + enemy.vida);
                        System.out.println("Vida atual do Heroi " + hero.vida);
                        System.out.println("-----------------------");
                    }
                    if (tela.corre == 1) {
                        int vezInimigo = random.nextInt(1, 9);
                        tela.ataque = 0;
                        System.out.println("Heroi:");
                        int valorCorrida = hero.correr(enemy);
                        System.out.println("-----------------------");
                        System.out.println("Inimigo:");
                        if (valorCorrida == 0) {
                            if (vezInimigo <= 5) {
                                enemy.socar(hero);
                            }
                            if (vezInimigo > 5) {
                                enemy.curar();
                            }
                            System.out.println("-----------------------");
                            System.out.println("Vida atual do Inimigo " + enemy.vida);
                            System.out.println("Vida atual do Heroi " + hero.vida);
                            System.out.println("-----------------------");
                            tela.corre = 0;
                        } else {
                            tela.frame.setVisible(false);
                            break;
                        }
                    }
                    if (tela.heal == 1) {
                        int vezInimigo = random.nextInt(1, 9);
                        tela.heal = 0;
                        System.out.println("Heroi:");
                        hero.curar();
                        System.out.println("-----------------------");
                        System.out.println("Inimigo:");
                        if (vezInimigo <= 3) {
                            enemy.socar(hero);
                        }
                        if (vezInimigo > 3 && vezInimigo <= 6) {
                            enemy.curar();
                        }
                        if (vezInimigo > 6) {
                            enemy.correr(hero);
                        }
                        System.out.println("-----------------------");
                        System.out.println("Vida atual do Inimigo " + enemy.vida);
                        System.out.println("Vida atual do Heroi " + hero.vida);
                        System.out.println("-----------------------");
                    }
                    if (tela.special == 1) {
                        int vezInimigo = random.nextInt(1, 9);
                        tela.special = 0;
                        System.out.println("Heroi:");
                        hero.ataqueHeroi(enemy);
                        System.out.println("-----------------------");
                        System.out.println("Inimigo:");
                        if (vezInimigo <= 3) {
                            enemy.socar(hero);
                        }
                        if (vezInimigo > 3 && vezInimigo <= 6) {
                            enemy.curar();
                        }
                        if (vezInimigo > 6) {
                            enemy.correr(hero);
                        }
                        System.out.println("-----------------------");
                        System.out.println("Vida atual do Inimigo " + enemy.vida);
                        System.out.println("Vida atual do Heroi " + hero.vida);
                        System.out.println("-----------------------");
                    }
                    }
                }
            }
        }
    }


