package test.utils;

import raven.color.component.utils.ColorPaletteData;
import raven.color.component.utils.ColorPaletteItemPainter;
import raven.color.component.utils.DefaultColorPaletteItemPainter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialColorPaletteData implements ColorPaletteData {

    private List<Color> listColors;

    public MaterialColorPaletteData() {
        init();
    }

    private void init() {
        listColors = new ArrayList<>();

        // Pink
        listColors.add(new Color(252, 228, 236)); // pink-50
        listColors.add(new Color(248, 187, 208)); // pink-100
        listColors.add(new Color(244, 143, 177)); // pink-200
        listColors.add(new Color(240, 98, 146));  // pink-300
        listColors.add(new Color(236, 64, 122));  // pink-400
        listColors.add(new Color(233, 30, 99));   // pink-500
        listColors.add(new Color(216, 27, 96));   // pink-600
        listColors.add(new Color(194, 24, 91));   // pink-700
        listColors.add(new Color(173, 20, 87));   // pink-800
        listColors.add(new Color(136, 14, 79));   // pink-900

        // Deep Purple
        listColors.add(new Color(237, 231, 246)); // deep-purple-50
        listColors.add(new Color(209, 196, 233)); // deep-purple-100
        listColors.add(new Color(179, 157, 219)); // deep-purple-200
        listColors.add(new Color(149, 117, 205)); // deep-purple-300
        listColors.add(new Color(126, 87, 194));  // deep-purple-400
        listColors.add(new Color(103, 58, 183));  // deep-purple-500
        listColors.add(new Color(94, 53, 177));   // deep-purple-600
        listColors.add(new Color(81, 45, 168));   // deep-purple-700
        listColors.add(new Color(69, 39, 160));   // deep-purple-800
        listColors.add(new Color(49, 27, 146));   // deep-purple-900

        // Indigo
        listColors.add(new Color(232, 234, 246)); // indigo-50
        listColors.add(new Color(197, 202, 233)); // indigo-100
        listColors.add(new Color(159, 168, 218)); // indigo-200
        listColors.add(new Color(121, 134, 203)); // indigo-300
        listColors.add(new Color(92, 107, 192));  // indigo-400
        listColors.add(new Color(63, 81, 181));   // indigo-500
        listColors.add(new Color(57, 73, 171));   // indigo-600
        listColors.add(new Color(48, 63, 159));   // indigo-700
        listColors.add(new Color(40, 53, 147));   // indigo-800
        listColors.add(new Color(26, 35, 126));   // indigo-900

        // Light Blue
        listColors.add(new Color(225, 245, 254)); // light-blue-50
        listColors.add(new Color(179, 229, 252)); // light-blue-100
        listColors.add(new Color(129, 212, 250)); // light-blue-200
        listColors.add(new Color(79, 195, 247));  // light-blue-300
        listColors.add(new Color(41, 182, 246));  // light-blue-400
        listColors.add(new Color(3, 169, 244));   // light-blue-500
        listColors.add(new Color(3, 155, 229));   // light-blue-600
        listColors.add(new Color(2, 136, 209));   // light-blue-700
        listColors.add(new Color(2, 119, 189));   // light-blue-800
        listColors.add(new Color(1, 87, 155));    // light-blue-900

        // Teal
        listColors.add(new Color(224, 242, 241)); // teal-50
        listColors.add(new Color(178, 223, 219)); // teal-100
        listColors.add(new Color(128, 203, 196)); // teal-200
        listColors.add(new Color(77, 182, 172));  // teal-300
        listColors.add(new Color(38, 166, 154));  // teal-400
        listColors.add(new Color(0, 150, 136));   // teal-500
        listColors.add(new Color(0, 137, 123));   // teal-600
        listColors.add(new Color(0, 121, 107));   // teal-700
        listColors.add(new Color(0, 105, 92));    // teal-800
        listColors.add(new Color(0, 77, 64));     // teal-900

        // Light Green
        listColors.add(new Color(241, 248, 233)); // light-green-50
        listColors.add(new Color(220, 237, 200)); // light-green-100
        listColors.add(new Color(197, 225, 165)); // light-green-200
        listColors.add(new Color(174, 213, 129)); // light-green-300
        listColors.add(new Color(156, 204, 101)); // light-green-400
        listColors.add(new Color(139, 195, 74));  // light-green-500
        listColors.add(new Color(124, 179, 66));  // light-green-600
        listColors.add(new Color(104, 159, 56));  // light-green-700
        listColors.add(new Color(85, 139, 47));   // light-green-800
        listColors.add(new Color(51, 105, 30));   // light-green-900

        // Lime
        listColors.add(new Color(249, 251, 231)); // lime-50
        listColors.add(new Color(240, 244, 195)); // lime-100
        listColors.add(new Color(230, 238, 156)); // lime-200
        listColors.add(new Color(220, 231, 117)); // lime-300
        listColors.add(new Color(212, 225, 87));  // lime-400
        listColors.add(new Color(205, 220, 57));  // lime-500
        listColors.add(new Color(192, 202, 51));  // lime-600
        listColors.add(new Color(175, 180, 43));  // lime-700
        listColors.add(new Color(158, 157, 36));  // lime-800
        listColors.add(new Color(130, 119, 23));  // lime-900

        // Deep Orange
        listColors.add(new Color(251, 233, 231)); // deep-orange-50
        listColors.add(new Color(255, 204, 188)); // deep-orange-100
        listColors.add(new Color(255, 171, 145)); // deep-orange-200
        listColors.add(new Color(255, 138, 101)); // deep-orange-300
        listColors.add(new Color(255, 112, 67));  // deep-orange-400
        listColors.add(new Color(255, 87, 34));   // deep-orange-500
        listColors.add(new Color(244, 81, 30));   // deep-orange-600
        listColors.add(new Color(230, 74, 25));   // deep-orange-700
        listColors.add(new Color(216, 67, 21));   // deep-orange-800
        listColors.add(new Color(191, 54, 12));   // deep-orange-900

        // Blue Gray
        listColors.add(new Color(236, 239, 241)); // blue-gray-50
        listColors.add(new Color(207, 216, 220)); // blue-gray-100
        listColors.add(new Color(176, 190, 197)); // blue-gray-200
        listColors.add(new Color(144, 164, 174)); // blue-gray-300
        listColors.add(new Color(120, 144, 156)); // blue-gray-400
        listColors.add(new Color(96, 125, 139));  // blue-gray-500
        listColors.add(new Color(84, 110, 122));  // blue-gray-600
        listColors.add(new Color(69, 90, 100));   // blue-gray-700
        listColors.add(new Color(55, 71, 79));    // blue-gray-800
        listColors.add(new Color(38, 50, 56));    // blue-gray-900
    }

    @Override
    public void add(Color color) {
    }

    @Override
    public void remove(Color color) {
    }

    @Override
    public void clear() {
    }

    @Override
    public int size() {
        return listColors.size();
    }

    @Override
    public Color get(int index) {
        return listColors.get(index);
    }

    public ColorPaletteItemPainter getPainter() {
        return new DefaultColorPaletteItemPainter() {
            private final Dimension itemSize = new Dimension(26, 20);

            @Override
            public Dimension getItemSize() {
                return itemSize;
            }

            @Override
            public int getMaxRow() {
                return 9;
            }

            @Override
            protected float getArc() {
                return 0;
            }

            @Override
            public int getItemGap() {
                return 0;
            }
        };
    }
}
