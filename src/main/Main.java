package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	public void pickNewLocation(JButton button) {
		Random random = new Random();
		int width = 700;
		int height = 500;

		button.setLocation(random.nextInt(width), random.nextInt(height));

		if (button.getLocation().x >= width || button.getLocation().y >= height) {
			pickNewLocation(button);
		}
	}

	private void initialize() {
		frame = new JFrame("Click Me!");
		frame.setSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		JButton btnClickMe = new JButton("Click Me!");
		btnClickMe.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				pickNewLocation(btnClickMe);
			}
		});
		btnClickMe.setBounds(347, 269, 89, 23);
		frame.getContentPane().add(btnClickMe);
	}

}
