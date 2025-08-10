package raven.color.component.utils;

import java.awt.*;

public interface ColorPaletteData {

    void add(Color color);

    void remove(Color color);

    void clear();

    int size();

    Color get(int index);
}
