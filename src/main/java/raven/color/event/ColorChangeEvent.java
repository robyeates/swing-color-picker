package raven.color.event;

import java.util.EventObject;

public class ColorChangeEvent extends EventObject {

    private final boolean hueChanged;

    public ColorChangeEvent(Object source, boolean hueChanged) {
        super(source);
        this.hueChanged = hueChanged;
    }

    public boolean isHueChanged() {
        return hueChanged;
    }
}
