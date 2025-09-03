package test;

import co.rob.SimpleColorPicker;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class TestColor extends JFrame {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        EventQueue.invokeLater(() -> {
            Color color = SimpleColorPicker.showDialog(new JFrame(), "Pick Highlight Color", new SimpleColorPicker());
            if (color != null) {
                System.out.println("--------------");
                System.out.println("Color selected: " + color);
            }
            System.exit(0);
        });
    }
}
