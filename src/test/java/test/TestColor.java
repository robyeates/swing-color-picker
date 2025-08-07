package test;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import net.miginfocom.swing.MigLayout;
import raven.color.ColorPicker;

import javax.swing.*;
import java.awt.*;

public class TestColor extends JFrame {

    public TestColor() {
        super("Test Swing ColorPicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 800));
        setLocationRelativeTo(null);

        setLayout(new MigLayout("al center center,wrap"));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:10;" +
                "[light]background:#E6E6E6;" +
                "[dark]background:#363636;");
        add(colorPicker);

        JButton cmd = new JButton("show as dialog");
        cmd.addActionListener(e -> {
            Color color = ColorPicker.showDialog(this, "Pick Color", cmd.getBackground());
            if (color != null) {
                cmd.setBackground(color);
            }
        });
        add(cmd);
        colorPicker.addColorChangedListener((color, event) -> {
            cmd.setBackground(color);
        });
    }

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        EventQueue.invokeLater(() -> new TestColor().setVisible(true));
    }
}
