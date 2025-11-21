package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final String TITLE = "print input and history GUI";
    private final Controller controller = new SimpleController();
    private final JFrame frame = new JFrame(TITLE);

    /**
     *  Build first GUI.
     */
    public SimpleGUI() {
        final JPanel canva = new JPanel();
        canva.setLayout(new BorderLayout());

        final JTextField inputSting = new JTextField();
        final JTextArea textArea = new JTextArea(10, 20);
        canva.add(inputSting, BorderLayout.NORTH);
        canva.add(textArea, BorderLayout.CENTER);
        final JPanel panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");
        panelButton.add(print, BorderLayout.CENTER);
        panelButton.add(history, BorderLayout.LINE_END);
        canva.add(panelButton, BorderLayout.SOUTH);
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                controller.setNextString(inputSting.getText());
                controller.printsCurrentString();
                inputSting.setText("");
            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                textArea.setText("");
                for (final String string : controller.getHistoryPrintedString()) {
                    textArea.append(string + "\n");
                }
            }
        });
    }

    private void display() {
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
