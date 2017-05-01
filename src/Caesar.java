/**
 * Caesar is a cipher algorithm that shift every character by a constant
 * 
 * @author yuhu
 *
 */
public class Caesar implements Cipher {

	// Constant
	private static int SHIFT_CONSTANT = 3;

	/**
	 * Encrypt the text by shifting every letter down by three.
	 * 
	 * @return return the encrypted text.
	 * @param plainText
	 *            the text that need to be encrypted.
	 */
	@Override
	public String encrypt(String plainText) {
		String cipherText = "";
		// Go through every char in the plainText
		for (int i = 0; i < plainText.length(); i++) {
			// Shift by SHIFT_CONSTANT and wrap the edge
			int c = (plainText.charAt(i) + SHIFT_CONSTANT) % 255;
			cipherText += (char) c;
		}
		return cipherText;
	}

	/**
	 * Decrypt the text by shifting every letter back by three.
	 * 
	 * @return return the deciphered text.
	 * @param cipherText
	 *            the text that need to be deciphered.
	 */
	@Override
	public String decrypt(String cipherText) {
		String plainText = "";
		// Go through every char in the cipherText
		for (int i = 0; i < cipherText.length(); i++) {
			// Shift back by the SHIFT_CONSTANT
			int c = cipherText.charAt(i) - SHIFT_CONSTANT;
			// Wrap the edges
			if (c < 0) {
				c = 255 + c;
			}
			plainText += (char) c;
		}
		return plainText;
	}

}
