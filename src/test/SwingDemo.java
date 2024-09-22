package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingDemo {
	private static void createAndShowGUI() {
	        // Create a new JFrame
	        JFrame frame = new JFrame("Swing Demo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 200);

	        // Create a JPanel to hold the components
	        JPanel panel = new JPanel();

	        // Create a JLabel and a JButton
	        JLabel label = new JLabel("Hello, Swing!");
	        JButton button = new JButton("Click Me");

	        // Add an ActionListener to the button
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Show a warning message when the button is clicked
	                JOptionPane.showMessageDialog(frame, "Button was clicked!", "Warning", JOptionPane.WARNING_MESSAGE);
	            }
	        });

	        // Add components to the panel
	        panel.add(label);
	        panel.add(button);

	        // Add the panel to the frame
	        frame.add(panel);

	        // Display the frame
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        // Schedule a job for the event dispatch thread
	        SwingUtilities.invokeLater(SwingDemo::createAndShowGUI);
	    }
}
