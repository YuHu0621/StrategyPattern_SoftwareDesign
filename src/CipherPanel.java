import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * CipherPanel is a JPanel that encrypt and decipher texts with Copy, Caesar
 * Cipher and Rail fence Cipher methods.
 * 
 * @author yuhu
 *
 */
public class CipherPanel extends JPanel {
	// Global variables
	private String plainText;
	private String cipherText;
	private Cipher myCipher;

	// BUTTONS and TextField
	private JTextField ptTextField;
	private JTextField ctTextField;
	private JButton encrypt;
	private JButton decrypt;
	private Choice cipherMethods;

	// LABELS
	private JLabel ptTitle;
	private JLabel ctTitle;

	// PANELS
	private JPanel buttonPanel;
	private JPanel centerPanel;

	// CONSTANT
	private static int COPY = 0;
	private static int CAESAR = 1;
	private static int RAILFENCE = 2;
	private static int MONOALPHA = 3;

	/**
	 * constructor create a JPanel that allows three types of cryptography.
	 */
	public CipherPanel() {

		setLayout(new BorderLayout());
		// NORTH
		setNorth();

		// CENTER
		setCenterPanel();

		// SOUTH
		setSouthPanel();

		// SET BUTTONS
		setButtons();

		// SET STRATEGY
		selectStrategy(cipherMethods.getSelectedIndex());
	}

	/**
	 * Set north panel which has a title.
	 */
	private void setNorth() {
		JLabel title = new JLabel("Cryptography");
		add(title, BorderLayout.NORTH);
	}

	/**
	 * set center panel which allows user input of text.
	 */
	private void setCenterPanel() {
		ptTitle = new JLabel("Plain text");
		ctTitle = new JLabel("Cipher text");
		ptTextField = new JTextField();
		ctTextField = new JTextField();
		centerPanel = new JPanel(new GridLayout(2, 2));
		centerPanel.add(ptTitle);
		centerPanel.add(ptTextField);
		centerPanel.add(ctTitle);
		centerPanel.add(ctTextField);
		add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * set South Panel which allows user choosing encrypt or decipher strategy.
	 */
	private void setSouthPanel() {
		buttonPanel = new JPanel(new FlowLayout());
		encrypt = new JButton("Encrypt");
		decrypt = new JButton("Decrypt");
		cipherMethods = new Choice();
		cipherMethods.add("Copy");
		cipherMethods.add("Caesar Ciphwe");
		cipherMethods.add("Rail Fence");
		cipherMethods.add("Mono-alphabetic");
		cipherMethods.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int i = cipherMethods.getSelectedIndex();
				selectStrategy(i);
			}
		});
		buttonPanel.add(encrypt);
		buttonPanel.add(decrypt);
		buttonPanel.add(cipherMethods);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * Set the buttons.
	 */
	private void setButtons() {
		setEncryptButton();
		setDecryptButton();

	}

	/**
	 * Select the strategy that user wants for encrypt/decipher.
	 */
	private void selectStrategy(int choiceIndex) {

		if (choiceIndex == COPY) {
			myCipher = new Copy();
		} else if (choiceIndex == CAESAR) {
			myCipher = new Caesar();
		} else if (choiceIndex == RAILFENCE) {
			myCipher = new RailFence();
		} else if (choiceIndex == MONOALPHA) {
			myCipher = new MonoAlphabetic();
		}

	}

	/**
	 * Set action listener of encrypt button.
	 */
	private void setEncryptButton() {
		encrypt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				plainText = ptTextField.getText();
				if (plainText.length() == 0) {
					// if the user forgets to enter plainText
					ptTextField.setText("Please enter text that you want to encrypt");
				}
				String cipher = myCipher.encrypt(plainText);
				ctTextField.setText(cipher);
			}

		});
	}

	/**
	 * set action listener of decipher button.
	 */
	private void setDecryptButton() {
		decrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cipherText = ctTextField.getText();
				if (cipherText.length() == 0) {
					// if the user forgets to enter cipherText
					ctTextField.setText("Please enter text that you want to decrypt");
				}
				String plainText = myCipher.decrypt(cipherText);
				ptTextField.setText(plainText);
			}

		});
	}
}
