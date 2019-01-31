package net.severo;

public class LogicaDeCalculadora {
	public static final int OPERATOR_NONE = 0;
	public static final int OPERATOR_SUM = 1;
	public static final int OPERATOR_SUB = 2;
	public static final int OPERATOR_MUL = 3;
	public static final int OPERATOR_DIV = 4;

	private int accumulator;
	private int currentOperand;
	private int currentOperator;
	private boolean operandAvailable;

	/**
	 * Creates a new instance of the calculator logic. In its initial state the
	 * calculator displays just a zero, the value of its internal accumulator is
	 * also zero and there is no operator pending to be applied.
	 *
	 */
	public LogicaDeCalculadora() {
		pressReset();
	}

	/**
	 * Returns the information that should be shown at the display of the calculator
	 * for its current state.
	 *
	 * @return The information to be shown at the display.
	 *
	 */
	public String getDisplay() {
		String display;
		if (operandAvailable) {
			display = Integer.toString(currentOperand);
		} else {
			display = Integer.toString(accumulator);
		}
		return display;
	}

	/**
	 * Notifies that the user has pressed a button with a digit.
	 *
	 * @param digit The digit the user has pressed (0 to 9).
	 *
	 */
	public void pressDigit(int digit) {
		currentOperand = currentOperand * 10 + digit;
		operandAvailable = true;
	}

	/**
	 * Notifies that the user has pressed a button with an operand.
	 *
	 * @param operator The operand expressed with one of the constants OPERATOR_ADD,
	 *                 OPERATOR_SUB, OPERATOR_MUL or OPERATOR_DIV.
	 *
	 */
	public void pressOperator(int operator) {
		if (operandAvailable) {
			performPendingOperation();
		}
		expectNewOperand(operator);
	}

	/**
	 * Notifies that the user has pressed the "=" button.
	 *
	 */
	public void pressEqual() {
		if (operandAvailable) {
			performPendingOperation();
		}
		expectNewOperand(OPERATOR_NONE);
	}

	/**
	 * Notifies that the user has pressed the "C" button, which removes the last
	 * digit that was typed by the user.
	 *
	 */
	public void pressDelete() {
		currentOperand /= 10;
		if (currentOperand == 0) {
			operandAvailable = false;
		}
	}

	/**
	 * Notifies that the user has pressed the "AC" button, which resets the state of
	 * the calculator to its initial state (display 0, accumulator 0, no pending
	 * operators.)
	 *
	 */
	public void pressReset() {
		accumulator = 0;
		expectNewOperand(OPERATOR_NONE);
	}

	private void expectNewOperand(int operator) {
		currentOperator = operator;
		currentOperand = 0;
		operandAvailable = false;
	}

	private void performPendingOperation() {
		switch (currentOperator) {
		case OPERATOR_NONE:
			accumulator = currentOperand;
			break;
		case OPERATOR_SUM:
			accumulator += currentOperand;
			break;
		case OPERATOR_SUB:
			accumulator -= currentOperand;
			break;
		case OPERATOR_MUL:
			accumulator *= currentOperand;
			break;
		case OPERATOR_DIV:
			accumulator /= currentOperand;
			break;
		}
	}
}
