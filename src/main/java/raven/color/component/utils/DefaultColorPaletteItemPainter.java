package raven.color.component.utils;

import com.formdev.flatlaf.util.UIScale;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DefaultColorPaletteItemPainter implements ColorPaletteItemPainter {

    private final Dimension itemSize = new Dimension(20, 20);

    @Override
    public Dimension getItemSize() {
        return itemSize;
    }

    @Override
    public int getMaxRow() {
        return 2;
    }

    @Override
    public int getItemGap() {
        return 10;
    }

    @Override
    public int getItemBorderSize() {
        return 3;
    }

    @Override
    public void paintItem(Graphics g, Color color, int width, int height, boolean isSelected, boolean hasFocus) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        float arc = UIScale.scale(5);
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));

        int border = UIScale.scale(getItemBorderSize());
        if (border > 0) {
            g2.translate(-border, -border);
            paintItemBorder(g2, width + border * 2, height + border * 2, isSelected, hasFocus);
        }

    }

    protected void paintItemBorder(Graphics2D g2, int width, int height, boolean isSelected, boolean hasFocus) {
        if (!(hasFocus)) {
            return;
        }
        g2.setComposite(AlphaComposite.SrcOver.derive(0.3f));
        float arc = UIScale.scale(5 + getItemBorderSize());
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));
    }
}
