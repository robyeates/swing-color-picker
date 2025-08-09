package raven.color.component.utils;

import java.awt.*;

public interface ColorPaletteItemPainter {

    Dimension getItemSize();

    int getMaxRow();

    int getItemGap();

    void paintItem(Graphics g, Color color, float width, float height);
}
