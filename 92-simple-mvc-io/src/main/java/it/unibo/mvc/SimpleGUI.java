package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * A very simple program using a graphical interface.
 * 
 */

public final class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame(TITLE);

    /**
     *  Build first GUI.
     */
    public SimpleGUI() {
        final JPanel canva = new JPanel();
        canva.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea(10, 40);
        canva.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("save");
        canva.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    controller.writeString(textArea.getText());
                } catch (final IOException e) {
                    e.printStackTrace(); //NOPMD write text fail we print the error
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Launches application.
     * 
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
