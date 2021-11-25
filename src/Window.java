import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener
{
    Drawing draw = new Drawing();

    public Window(String Title, int x, int y)
    {
        //On crÃ©e une interface pour notre utilisateur
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contentPanel = this.getContentPane();

        JMenuBar m= new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem New = new JMenuItem("New");
        JMenuItem Open = new JMenuItem("Open");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem Quit = new JMenuItem("Quit");

        New.addActionListener(this);
        New.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        Open.addActionListener(this);
        Open.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        Save.addActionListener(this);
        Save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        Quit.addActionListener(this);
        Quit.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        menu1.add(New);
        menu1.add(Open);
        menu1.add(Save);
        menu1.add(Quit);
        m.add(menu1);
        JMenu menu2 = new JMenu("A Propos");
        JMenuItem creator = new JMenuItem("Creator");
        menu2.add(creator);
        creator.addActionListener(this);
        m.add(menu2);


        // Message de bienvenue pour l'utilisateur
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog( info, "          Bienvenue surPaint !\nPour commencer Ã  dessiner, cliquez sur Ok",
                "Pop-Up",JOptionPane.INFORMATION_MESSAGE);

        // On vient creer la palette de couleurs et de figures

        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new GridLayout(2,6));

        //Couleurs
        JButton noir = new JButton("Noir");
        noir.addActionListener(this);

        JButton rouge = new JButton("Rouge");
        rouge.addActionListener(this);

        JButton vert = new JButton("Vert");
        vert.addActionListener(this);

        JButton bleu = new JButton("Bleu");
        bleu.addActionListener(this);

        JButton jaune = new JButton("Jaune");
        jaune.addActionListener(this);

        JButton rose = new JButton("Rose");
        rose.addActionListener(this);

        JButton magenta = new JButton("Magenta");
        magenta.addActionListener(this);

        JButton orange = new JButton("Orange");
        orange.addActionListener(this);

        //Figure
        JButton ellipse = new JButton("Ellipse");
        ellipse.addActionListener(this);
        JButton cercle = new JButton("Circle");
        cercle.addActionListener(this);
        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(this);
        JButton carre = new JButton("Square");
        carre.addActionListener(this);




        //On vient maintenant mettre des couleurs de fonds Ã  nos boutons

        contentPanel.add(draw,"Center");
        noir.setBackground(Color.BLACK);
        noir.setOpaque(true);
        noir.setBorderPainted(false);
        noir.setForeground(Color.white);


        rouge.setBackground(Color.RED);
        rouge.setOpaque(true);
        rouge.setBorderPainted(false);


        vert.setBackground(Color.GREEN);
        vert.setOpaque(true);
        vert.setBorderPainted(false);

        bleu.setBackground(Color.BLUE);
        bleu.setOpaque(true);
        bleu.setBorderPainted(false);

        jaune.setBackground(Color.YELLOW);
        jaune.setOpaque(true);
        jaune.setBorderPainted(false);

        rose.setBackground(Color.PINK);
        rose.setOpaque(true);
        rose.setBorderPainted(false);

        magenta.setBackground(Color.MAGENTA);
        magenta.setOpaque(true);
        magenta.setBorderPainted(false);

        orange.setBackground(Color.ORANGE);
        orange.setOpaque(true);
        orange.setBorderPainted(false);

        //Ajout Ã  notre panneau
        SouthPanel.add(noir);
        SouthPanel.add(rouge);
        SouthPanel.add(vert);
        SouthPanel.add(bleu);
        SouthPanel.add(ellipse);
        SouthPanel.add(cercle);
        SouthPanel.add(jaune);
        SouthPanel.add(rose);
        SouthPanel.add(magenta);
        SouthPanel.add(orange);
        SouthPanel.add(rectangle);
        SouthPanel.add(carre);

        contentPanel.add(SouthPanel, "South");

        setJMenuBar(m);
        SouthPanel.setVisible(true);

        this.setVisible(true);
    }

    // But it's not enough, we must assign their function to each button too:
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        switch (cmd)
        {
            case "Noir":
                System.out.println("La couleur noire est sÃ©lectionnÃ©e !");
                draw.setColor(Color.black);
                break;
            case "Rouge":
                System.out.println("La couleur rouge est sÃ©lectionnÃ©e !");
                draw.setColor(Color.red);
                break;
            case "Vert":
                System.out.println("La couleur verte est sÃ©lectionnÃ©e !");
                draw.setColor(Color.green);
                break;
            case "Bleu":
                System.out.println("La couleur bleue est sÃ©lectionnÃ©e !");
                draw.setColor(Color.blue);
                break;
            case "Jaune":
                System.out.println("La couleur jaune est sÃ©lectionnÃ©e !");
                draw.setColor(Color.yellow);
                break;
            case "Rose":
                System.out.println("La couleur rose est sÃ©lectionnÃ©e !");
                draw.setColor(Color.pink);
                break;
            case "Magenta":
                System.out.println("La couleur magenta est sÃ©lectionnÃ©e !");
                draw.setColor(Color.magenta);
                break;
            case "Orange":
                System.out.println("La couleur orange est sÃ©lectionnÃ©e !");
                draw.setColor(Color.orange);
                break;
            case "Ellipse":
                System.out.println("La figure ellipse est sÃ©lectionnÃ©e !");
                draw.setNameFigure("Ellipse");
                break;
            case "Circle":
                System.out.println("La figure cercle est sÃ©lectionnÃ©e !");
                draw.setNameFigure("Circle");
                break;
            case "Rectangle":
                System.out.println("La figure rectangle est sÃ©lectionnÃ©e !");
                draw.setNameFigure("Rectangle");
                break;
            case "Square":
                System.out.println("La figure carrÃ© est sÃ©lectionnÃ©e !");
                draw.setNameFigure("Square");
                break;
            case "Creator":
                JOptionPane infoCreator = new JOptionPane();
                JOptionPane.showInternalMessageDialog(infoCreator, "Author :Sabrina HEMISSI", "Creator information", 1);
                break;
        }
    }

    /* Execution */
    public static void main(String args[])
    {
        Window win=new Window("Paint",800,600);
    }

}