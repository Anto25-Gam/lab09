package it.unibo.mvc;

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame(TITLE);

    /**
     *  Builds second GUI.
     */
    public SimpleGUIWithFileChooser() {

        final JPanel canva = new JPanel();
        final JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());
        canva.setLayout(new BorderLayout());
        final JTextField pathField = new JTextField(controller.pathToString());
        pathField.setEnabled(false);
        final JButton browse = new JButton("Browse...");
        panelTop.add(pathField, BorderLayout.CENTER);
        panelTop.add(browse, BorderLayout.LINE_END);
        final JTextArea textArea = new JTextArea(10, 40);
        final JButton save = new JButton("save");
        canva.add(panelTop, BorderLayout.NORTH);
        canva.add(textArea, BorderLayout.CENTER);
        canva.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try {
                    controller.writeString(textArea.getText());
                } catch (final IOException e) {
                    e.printStackTrace(); //NOPMD if write text fail we print the error
                }
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int option = fileChooser.showOpenDialog(frame);

                if (option == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile().toPath());
                    pathField.setText(controller.pathToString());
                } else if (option == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, "error while selecting file", "error", JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }

}
