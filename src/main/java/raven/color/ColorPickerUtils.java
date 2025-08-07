package raven.color;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class ColorPickerUtils {

    public static Shape createShape(float size, float border, float margin) {
        Area area = new Area(new Ellipse2D.Float(margin, margin, size - margin * 2f, size - margin * 2f));
        float borderSize = (size / 2f * border);
        float centerSize = (size - borderSize * 2f) + margin * 2f;
        area.subtract(new Area(new Ellipse2D.Float(borderSize - margin, borderSize - margin, centerSize, centerSize)));
        return area;
    }
}
