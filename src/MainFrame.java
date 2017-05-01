import javax.swing.JFrame;

public class MainFrame {

	/**
	 * main method create a JFrame that contains a Cipher Panel.
	 * @param args no input argument.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cryptography machine");
		frame.add(new CipherPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

}
