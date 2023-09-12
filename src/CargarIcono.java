import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CargarIcono implements Icon{

    String ruta;
    int ancho;
    int alto;

    public CargarIcono (String ruta, int ancho, int alto){

        this.ruta=ruta;
        this.ancho=ancho;
        this.alto=alto;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = new ImageIcon(this.getClass().getResource(this.ruta)).getImage();
        g.drawImage(image, x, y, c);
    }

    @Override
    public int getIconWidth() {
        return this.ancho;
    }

    @Override
    public int getIconHeight() {
        return this.alto;
    }
}
