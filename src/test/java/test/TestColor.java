package test;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import net.miginfocom.swing.MigLayout;
import raven.color.ColorPicker;
import raven.color.component.utils.DefaultColorPaletteItemPainter;
import raven.color.component.utils.TailwindColorPaletteData;
import test.utils.MaterialColorPaletteData;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TestColor extends JFrame {

    private final ColorPicker colorPicker;

    public TestColor() {
        super("Test Swing ColorPicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 800));
        setLocationRelativeTo(null);

        setLayout(new MigLayout("al center center", "[][300,fill]", "[fill]"));

        colorPicker = new ColorPicker();
        colorPicker.putClientProperty(FlatClientProperties.STYLE, "" +
                "border:10,10,10,10,$Component.borderColor,1,15;" +
                "[light]background:#E6E6E6;" +
                "[dark]background:#363636;");

        add(colorPicker);

        colorPicker.addColorChangedListener((color, event) -> {
            System.out.println("Color changed: " + color);
        });

        createOption();
    }

    // option
    private JCheckBox chEnablePalette;
    private JRadioButton rTailwindColor;
    private JRadioButton rMaterialColor;

    private void createOption() {
        JPanel panelOption = new JPanel(new MigLayout("wrap,fillx", "[fill]"));

        JPanel panelPalette = new JPanel(new MigLayout());

        panelPalette.setBorder(new TitledBorder("Options Color Palette"));

        chEnablePalette = new JCheckBox("Enable Palette", true);
        rTailwindColor = new JRadioButton("Tailwind Color", true);
        rMaterialColor = new JRadioButton("Material Color (custom)");

        ButtonGroup groupPalette = new ButtonGroup();

        groupPalette.add(rTailwindColor);
        groupPalette.add(rMaterialColor);

        chEnablePalette.addActionListener(e -> {
            boolean enable = chEnablePalette.isSelected();
            colorPicker.setColorPaletteEnabled(enable);
            rTailwindColor.setEnabled(enable);
            rMaterialColor.setEnabled(enable);
        });
        rTailwindColor.addActionListener(e -> {
            if (rTailwindColor.isSelected()) {
                applyColorStyle(colorPicker);
            }
        });

        rMaterialColor.addActionListener(e -> {
            if (rMaterialColor.isSelected()) {
                applyColorStyle(colorPicker);
            }
        });

        panelPalette.add(chEnablePalette);
        panelPalette.add(rTailwindColor);
        panelPalette.add(rMaterialColor);

        JButton cmdShowDialog = new JButton("show as dialog");
        cmdShowDialog.addActionListener(e -> {
            ColorPicker cp = new ColorPicker(colorPicker.getModel());
            cp.setColorPaletteEnabled(chEnablePalette.isSelected());
            applyColorStyle(cp);

            Color color = ColorPicker.showDialog(this, "Pick Color", cp);
            if (color != null) {
                System.out.println("--------------");
                System.out.println("Color selected: " + color);
            }
        });

        panelOption.add(panelPalette);
        panelOption.add(cmdShowDialog, "grow 0");

        add(panelOption);
    }

    private void applyColorStyle(ColorPicker colorPicker) {
        if (rTailwindColor.isSelected()) {
            colorPicker.getColorPalette().setColorData(new TailwindColorPaletteData());
            colorPicker.getColorPalette().setItemPainter(new DefaultColorPaletteItemPainter());
        } else if (rMaterialColor.isSelected()) {
            MaterialColorPaletteData materialColorPaletteData = new MaterialColorPaletteData();
            colorPicker.getColorPalette().setColorData(materialColorPaletteData);
            colorPicker.getColorPalette().setItemPainter(materialColorPaletteData.getPainter());
        }
    }


    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        EventQueue.invokeLater(() -> new TestColor().setVisible(true));
    }
}
