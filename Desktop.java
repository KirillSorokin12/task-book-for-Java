package desktop.view.desktop1;

import desktop.view.StartButtonWindow;

import javax.swing.*;

public class Desktop {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StartButtonWindow());
    }
}
