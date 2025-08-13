package raven.color;

import raven.color.event.ColorChangeEvent;
import raven.color.event.ColorChangedListener;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ColorPickerSelectionModel {

    protected EventListenerList listenerList = new EventListenerList();
    private BufferedImage hueImage;
    private BufferedImage colorImage;
    private Color selectedColor;
    private float hue = 0;

    private float oldHue = -1f;
    private float oldHueArc;
    private float oldColorArc;

    public ColorPickerSelectionModel() {
    }

    public BufferedImage getHueImage(int width, int height, float arc) {
        createHueColor(width, height, arc);
        return hueImage;
    }

    public BufferedImage getColorImage(int width, int height, float arc) {
        createColorImage(width, height, arc);
        return colorImage;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        setSelectedColor(selectedColor, true);
    }

    public void setSelectedColor(Color selectedColor, boolean changeHue) {
        if (selectedColor == null) {
            selectedColor = getDefaultColor();
        }
        if (!Objects.equals(this.selectedColor, selectedColor)) {
            boolean hueChanged = false;
            if (changeHue) {
                this.hue = toHueColor(selectedColor);
            } else {
                // check is only alpha changed
                if (isAlphaChangedOnly(this.selectedColor, selectedColor)) {
                    hueChanged = true;
                }
            }
            this.selectedColor = selectedColor;
            fireColorChanged(new ColorChangeEvent(this, hueChanged));
        }
    }

    private boolean isAlphaChangedOnly(Color color1, Color color2) {

        if (color1 == null || color2 == null) {
            return false;
        }

        int r1 = color1.getRed();
        int g1 = color1.getGreen();
        int b1 = color1.getBlue();
        int a1 = color1.getAlpha();

        int r2 = color2.getRed();
        int g2 = color2.getGreen();
        int b2 = color2.getBlue();
        int a2 = color2.getAlpha();
        return r1 == r2 && g1 == g2 && b1 == b2 && a1 != a2;
    }

    public float getHue() {
        return hue;
    }

    public void setHue(float hue) {
        if (hue < 0f) {
            hue = 0f;
        } else if (hue > 1f) {
            hue = 1f;
        }
        if (this.hue != hue) {
            this.hue = hue;
            if (selectedColor != null) {
                float[] hsb = Color.RGBtoHSB(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue(), null);
                Color oldColor = selectedColor;
                int alpha = oldColor.getAlpha();
                selectedColor = Color.getHSBColor(hue, hsb[1], hsb[2]);
                if (alpha != 255) {
                    selectedColor = new Color(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue(), alpha);
                }
            }
            fireColorChanged(new ColorChangeEvent(this, true));
        }
    }

    protected Color getDefaultColor() {
        return Color.WHITE;
    }

    private float toHueColor(Color color) {
        if (color == null) {
            return 0f;
        }
        return Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
    }

    private void createHueColor(int width, int height, float arc) {
        if (width <= 0 || height <= 0) {
            return;
        }
        if (hueImage == null || (hueImage.getWidth() != width || hueImage.getHeight() != height || oldHueArc != arc)) {
            hueImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = hueImage.createGraphics();
            if (arc > 0) {
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));
                g2.setComposite(AlphaComposite.SrcIn);
            }
            for (int i = 0; i < width; i++) {
                float v = (float) i / (float) width;
                g2.setColor(Color.getHSBColor(v, 1f, 1f));
                g2.drawLine(i, 0, i, height);
            }
            g2.dispose();
            oldHueArc = arc;
        }
    }

    private void createColorImage(int width, int height, float arc) {
        if (width <= 0 || height <= 0) {
            return;
        }
        if (colorImage == null || (colorImage.getWidth() != width || colorImage.getHeight() != height || oldColorArc != arc) || oldHue != hue) {
            colorImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = colorImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint primary = new GradientPaint(0f, 0f, Color.WHITE, width, 0f, Color.getHSBColor(hue, 1f, 1f));
            GradientPaint shade = new GradientPaint(0f, 0f, new Color(0, 0, 0, 0), 0f, height, new Color(0, 0, 0, 255));
            g2.setPaint(primary);
            g2.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));
            g2.setPaint(shade);
            g2.fill(new RoundRectangle2D.Float(0, 0, width, height, arc, arc));
            g2.dispose();
            oldHue = hue;
            oldColorArc = arc;
        }
    }

    public void addChangeListener(ColorChangedListener listener) {
        listenerList.add(ColorChangedListener.class, listener);
    }

    public void removeChangeListener(ColorChangedListener listener) {
        listenerList.remove(ColorChangedListener.class, listener);
    }

    public void fireColorChanged(ColorChangeEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ColorChangedListener.class) {
                ((ColorChangedListener) listeners[i + 1]).colorChanged(getSelectedColor(), event);
            }
        }
    }
}
