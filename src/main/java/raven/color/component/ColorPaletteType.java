package raven.color.component;

import raven.color.ColorPicker;
import raven.color.component.utils.DefaultColorPaletteData;
import raven.color.component.utils.DefaultColorPaletteItemPainter;
import raven.color.component.utils.MaterialColorPaletteData;
import raven.color.component.utils.TailwindColorPaletteData;

public enum ColorPaletteType {
    DEFAULT, TAILWIND, MATERIAL;

    public void apply(ColorPicker colorPicker) {
        if (this == DEFAULT) {
            colorPicker.getColorPalette().setColorData(new DefaultColorPaletteData());
            colorPicker.getColorPalette().setItemPainter(new DefaultColorPaletteItemPainter());
        } else if (this == TAILWIND) {
            TailwindColorPaletteData colorPaletteData = new TailwindColorPaletteData();
            colorPicker.getColorPalette().setColorData(colorPaletteData);
            colorPicker.getColorPalette().setItemPainter(colorPaletteData.getPainter());
        } else if (this == MATERIAL) {
            MaterialColorPaletteData colorPaletteData = new MaterialColorPaletteData();
            colorPicker.getColorPalette().setColorData(colorPaletteData);
            colorPicker.getColorPalette().setItemPainter(colorPaletteData.getPainter());
        }
    }
}
