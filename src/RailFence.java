
/**
 * RailFence is a cipher method that encrypt text by spreading text on three
 * rails in zigzag order.
 * 
 * @author yuhu
 *
 */
public class RailFence implements Cipher {

	/**
	 * Rail Fence algorithm encrypt message by reorder the letter There are
	 * three fences, the plainText has its letter relocate on the three fence in
	 * the zigzag order.
	 * 
	 * @return return encrypted text by rail fence method
	 * @param plainText
	 *            the text that need to be encrypted by rail fence method
	 */
	@Override
	public String encrypt(String plainText) {
		// Three rails
		String a = "";
		String b = "";
		String c = "";
		// Three start indexes
		int indexA = 0;
		int indexB = 1;
		int indexC = 2;

		// Top rail
		while (indexA < plainText.length()) {
			a += plainText.charAt(indexA);
			indexA += 4;
		}
		// Mid rail
		while (indexB < plainText.length()) {
			b += plainText.charAt(indexB);
			indexB += 2;
		}
		// bottom rail
		while (indexC < plainText.length()) {
			c += plainText.charAt(indexC);
			indexC += 4;
		}
		// Combine 3 rails
		String cipherText = a + b + c;
		return cipherText;
	}

	/**
	 * Decipher recover the zigzag message that spread in three rails back to
	 * one string
	 * 
	 * @return return plainText
	 * @param cipherText
	 *            the encrypted text that need to be deciphered.
	 */
	@Override
	public String decrypt(String cipherText) {
		int len = cipherText.length();
		char[] plainText = new char[len];
		// Three rails' indexes
		int indexA = 0;
		int indexB = 1;
		int indexC = 2;
		// Go through all char in the cipherText
		for (int i = 0; i < len; i++) {
			if (indexA < len) { // Top
				plainText[indexA] = cipherText.charAt(i);
				indexA += 4;
			} else if (indexB < len) { // Mid
				plainText[indexB] = cipherText.charAt(i);
				indexB += 2;
			} else if (indexC < len) { // Bottom
				plainText[indexC] = cipherText.charAt(i);
				indexC += 4;
			}
		}
		// deciphered text
		String decipherText = new String(plainText);
		return decipherText;
	}

}
