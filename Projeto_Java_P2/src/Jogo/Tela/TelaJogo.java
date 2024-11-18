package Jogo.Tela;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class TelaJogo {
    public JFrame frame = new JFrame();
    private JLabel label;
    private ImageIcon backgorund;
    public int ataque = 0;
    public int corre = 0;
    public int heal = 0;
    public int special = 0;
    public void tela() throws IOException {
        try{
         backgorund = new ImageIcon(ImageIO.read(new File("/Jogo/Imagems/BACKGROUND.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        label = new JLabel(backgorund);
        label.setSize(frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
        frame.setSize(665, 500);
        frame.setTitle("Jogo Java");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        JButton atacar = new JButton(new ImageIcon("/Jogo/Imagems/Imagems/BOTAOATACAR.png"));
        atacar.setBounds(10, 405, 150, 50);
        JButton correr = new JButton(new ImageIcon("/Jogo/Imagems/Imagems/BOTAOCORRER.png"));
        correr.setBounds(170, 405, 150, 50);
        JButton curar = new JButton(new ImageIcon("/Jogo/Imagems/Imagems/BOTAOCURAR.png"));
        curar.setBounds(330, 405, 150, 50);
        JButton especial = new JButton(new ImageIcon("/Jogo/Imagems/Imagems/BOTAOESPECIAL.png"));
        especial.setBounds(490, 405, 150, 50);
        frame.add(atacar);
        frame.add(curar);
        frame.add(especial);
        frame.add(correr);
        frame.add(label);
        frame.setVisible(true);
        atacar.addActionListener(atack -> this.ataque = 1);
        correr.addActionListener(run -> this.corre = 1);
        curar.addActionListener(heal -> this.heal = 1);
        especial.addActionListener(special -> this.special = 1);
    }

}
