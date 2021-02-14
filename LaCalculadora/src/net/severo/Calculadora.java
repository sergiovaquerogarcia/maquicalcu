package net.severo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {
	public Calculadora() {
		super("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		LogicaDeCalculadora logic = new LogicaDeCalculadora();
		JLabel display = new JLabel("0", SwingConstants.RIGHT);
		ActionListener digitListener = new DetectaPulsaciones(logic, display);
		ActionListener operatorListener = new DetectarOperaciones(logic, display);
		JPanel buttonsPanel = new JPanel(new GridLayout(6, 3));
		agregarBoton(buttonsPanel,"AC",operatorListener);
		agregarBoton(buttonsPanel,"+",operatorListener);
		buttonsPanel.add(new JButton("-"));
		buttonsPanel.add(new JButton("C"));
		buttonsPanel.add(new JButton("*"));
		buttonsPanel.add(new JButton("/"));
		agregarBoton(buttonsPanel,"7",digitListener);
		buttonsPanel.add(new JButton("8"));
		agregarBoton(buttonsPanel,"9",digitListener);
		//buttonsPanel.add(new JButton("4"));
		agregarBoton(buttonsPanel,"4",digitListener);
		agregarBoton(buttonsPanel,"5",digitListener);
		buttonsPanel.add(new JButton("6"));
		agregarBoton(buttonsPanel,"1",digitListener);
		agregarBoton(buttonsPanel,"2",digitListener);
		//buttonsPanel.add(new JButton("2"));
		agregarBoton(buttonsPanel,"3",digitListener);
		buttonsPanel.add(new JButton("."));
		buttonsPanel.add(new JButton("0"));
		agregarBoton(buttonsPanel,"=",operatorListener);
		getContentPane().add(display, BorderLayout.NORTH);
		getContentPane().add(buttonsPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	private void agregarBoton(Container ventanaPrincipal, String texto, ActionListener efecto) {
		JButton button = new JButton(texto);
		if (efecto != null) {
			button.addActionListener(efecto);
		} else {
			button.setEnabled(false);
		}
		ventanaPrincipal.add(button);

	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Calculadora gui = new Calculadora();
			}
		});
	}
}
