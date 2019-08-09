package observer.swingExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args){
        SwingObserverExample swingObserverExample = new SwingObserverExample();
        swingObserverExample.go();
    }

    private void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
    }

    private class AngelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it, you might regret");
        }
    }

    private class DevilListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, DO it!");
        }
    }
}
