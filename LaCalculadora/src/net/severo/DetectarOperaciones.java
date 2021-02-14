package net.severo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class DetectarOperaciones implements ActionListener {
	public DetectarOperaciones(LogicaDeCalculadora logic, JLabel display) {
		super();
		this.logic = logic;
		this.display = display;
	}

	private LogicaDeCalculadora logic;
	private JLabel display;

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("+")) {
			logic.pressOperator(LogicaDeCalculadora.OPERATOR_SUM);
		} else if (command.equals("-")) {
			logic.pressOperator(LogicaDeCalculadora.OPERATOR_SUB);
		} else if (command.equals("*")) {
			logic.pressOperator(LogicaDeCalculadora.OPERATOR_MUL);
		} else if (command.equals("/")) {
			logic.pressOperator(LogicaDeCalculadora.OPERATOR_DIV);
		} else if (command.equals("AC")) {
			logic.pressReset();
		} else if (command.equals("=")) {
			logic.pressEqual();
		} else if (command.equals("C")) {
			logic.pressDelete();
		}
		display.setText(logic.getDisplay());

	}

}
