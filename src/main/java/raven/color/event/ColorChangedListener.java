package raven.color.event;

import java.awt.*;
import java.util.EventListener;

public interface ColorChangedListener extends EventListener {

    void colorChanged(Color color, ColorChangeEvent colorChangeEvent);
}
