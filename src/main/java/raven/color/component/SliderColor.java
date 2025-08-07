package raven.color.component;

import com.formdev.flatlaf.util.UIScale;
import raven.color.ColorPickerUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class SliderColor extends JComponent {

    private MouseAdapter mouseListener;

    public SliderColor() {
    }

    public void install() {
        mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    mouseChange(e.getPoint());
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    mouseChange(e.getPoint());
                }
            }
        };
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }

    public void uninstall() {
        if (mouseListener != null) {
            removeMouseListener(mouseListener);
            removeMouseMotionListener(mouseListener);
            mouseListener = null;
        }
    }

    private void mouseChange(Point point) {
        Insets insets = getInsets();
        int x = insets.left;
        int width = getWidth() - (insets.left + insets.right);
        int px = point.x - x;
        float v = ((float) px) / (float) width;

        v = Math.max(0f, Math.min(1f, v));
        valueChanged(v);
    }

    protected abstract void valueChanged(float v);

    protected abstract float getValue();

    @Override
    protected void paintComponent(Graphics g) {
        Insets insets = getInsets();
        int x = insets.left;
        int y = insets.top;
        int width = getWidth() - (insets.left + insets.right);
        int height = getHeight() - (insets.top + insets.bottom);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = height + UIScale.scale(8);
        int selectionX = (int) (x + width * getValue());
        int selectionY = (int) (y + height / 2f);

        paintSelection(g2, selectionX, selectionY, size);

        super.paintComponent(g);
    }

    protected void paintSelection(Graphics2D g2, int x, int y, int size) {
        g2.translate(x - size / 2f, y - size / 2f);

        g2.setColor(UIManager.getColor("Component.borderColor"));
        g2.fill(ColorPickerUtils.createShape(size, 0.6f, 0f));

        g2.setColor(Color.WHITE);
        g2.fill(ColorPickerUtils.createShape(size, 0.6f, UIScale.scale(1f)));
    }
}
