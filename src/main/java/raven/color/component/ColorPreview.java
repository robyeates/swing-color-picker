package raven.color.component;

import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class ColorPreview extends JComponent {

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    private Color color;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();

        float arc = UIScale.scale(10f);
        float border = UIScale.scale(1.5f);
        g2.setColor(UIManager.getColor("Component.borderColor"));
        g2.setComposite(AlphaComposite.SrcOver.derive(0.7f));
        Area area = new Area(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));
        area.subtract(new Area(new RoundRectangle2D.Float(border, border, width - border * 2, height - border * 2, arc - border, arc - border)));
        g2.fill(area);

        if (color != null) {
            g2.setColor(color);
            g2.setComposite(AlphaComposite.SrcOver);
            g2.fill(new RoundRectangle2D.Float(border, border, width - border * 2, height - border * 2, arc - border, arc - border));
        }
        g2.dispose();
        super.paintComponent(g);
    }
}
