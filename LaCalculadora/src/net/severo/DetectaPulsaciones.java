package net.severo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class DetectaPulsaciones implements ActionListener {
	public DetectaPulsaciones(LogicaDeCalculadora logic, JLabel display) {
		super();
		this.logic = logic;
		this.display = display;
	}

	private LogicaDeCalculadora logic;
	private JLabel display;

	@Override
	public void actionPerformed(ActionEvent e) {
		logic.pressDigit(Integer.parseInt(e.getActionCommand()));
		display.setText(logic.getDisplay());

	}

}
