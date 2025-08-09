package raven.color.component;

import com.formdev.flatlaf.util.ScaledEmptyBorder;
import com.formdev.flatlaf.util.UIScale;
import raven.color.component.utils.ColorPaletteData;
import raven.color.component.utils.ColorPaletteItemPainter;

import javax.swing.*;
import java.awt.*;

public class ColorPaletteComponent extends JComponent {

    private ColorPaletteData colorData;
    private ColorPaletteItemPainter itemPainter;

    public ColorPaletteComponent(ColorPaletteData colorData, ColorPaletteItemPainter itemPainter) {
        this.colorData = colorData;
        this.itemPainter = itemPainter;
        init();
    }

    private void init() {
        setBorder(new ScaledEmptyBorder(10, 10, 10, 10));
    }

    public ColorPaletteData getColorData() {
        return colorData;
    }

    public void setColorData(ColorPaletteData colorData) {
        this.colorData = colorData;
    }

    public ColorPaletteItemPainter getItemPainter() {
        return itemPainter;
    }

    public void setItemPainter(ColorPaletteItemPainter itemPainter) {
        this.itemPainter = itemPainter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Insets insets = getInsets();
        int x = insets.left;
        int y = insets.top;
        int width = getWidth() - (insets.left + insets.right);
        int gap = UIScale.scale(itemPainter.getItemGap());
        Dimension itemSize = UIScale.scale(itemPainter.getItemSize());
        int itemCount = colorData.size();
        int column = (width + gap) / (itemSize.width + gap);

        int targetWidth = (column * itemSize.width) + ((column - 1) * gap);
        x += (width - targetWidth) / 2;

        for (int i = 0; i < itemCount; i++) {
            int row = i / column;
            int col = i % column;

            Color color = colorData.get(i);

            int lx = x + col * (itemSize.width + gap);
            int ly = y + row * (itemSize.height + gap);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setClip(g.getClip());
            g2.translate(lx, ly);
            itemPainter.paintItem(g2, color, itemSize.width, itemSize.height);
            g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        int maxRow = itemPainter.getMaxRow();
        int gap = UIScale.scale(itemPainter.getItemGap());
        Insets insets = getInsets();
        Dimension itemSize = UIScale.scale(itemPainter.getItemSize());
        int height = (maxRow * itemSize.height) + ((maxRow - 1) * gap) + (insets.top + insets.bottom);
        return new Dimension(50, height);
    }
}
