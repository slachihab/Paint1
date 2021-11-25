import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.event.*;


public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    public Color c;
    public ArrayList<Figure> list = new ArrayList<>();
    public String nameFigure;
    public int x;
    public int y;

    public void setColor(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public Drawing() {
        super();
        this.c = Color.black;
        this.nameFigure = "Rectangle";
        this.list = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        switch (nameFigure) {
            case "Ellipse":
                list.add(new Ellipse(x, y, c));
                break;
            case "Circle":
                list.add(new Circle(x, y, c));
                break;
            case "Rect":
                list.add(new Rectangle(c, x, y));
                break;
            case "Square":
                list.add(new Square(x, y, c));
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //x = e.getX();
        //y = e.getY();
        //System.out.println("End of a the new " + nameFigure + " coloured " + c + " and terminating on :" + x + " " + y);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e)
    {
        list.get(list.size() - 1).setBoundingBox(e.getX() - x, e.getY() - y);
        paintComponent(this.getGraphics());

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }



    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.white);
        for (Figure f : list) {
            f.draw(g);
        }
    }

    public void erase()
    {
        list.clear();
        super.paintComponent(this.getGraphics());

    }
}
