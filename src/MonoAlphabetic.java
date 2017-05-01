
/**
 * Mono-alphabetic is a cipher method that map every character to a different
 * character. 'a' to 'z' only
 * 
 * @author yuhu
 *
 */
public class MonoAlphabetic implements Cipher {

	// constant
	private static char[] KEY = { 'd', 'k', 'v', 'q', 'f', 'i', 'b', 'j', 'w', 'p', 'e', 's', 'c', 'x', 'h', 't', 'm',
			'y', 'a', 'u', 'o', 'l', 'r', 'g', 'z', 'n' };

	@Override
	/**
	 * Encrypt text by mono-alphabetic method using private key array.
	 * 
	 * @param plainText
	 *            text that needs to be encrypted.
	 * @return return the encrypted text.
	 */
	public String encrypt(String plainText) {
		String encrypt = "";
		// go through every char in the plainText
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			// turn the char to the corresponding char in the key array
			if (c > 96 && c < 123) { // a to z only
				encrypt += KEY[c - 'a'];
			}
		}
		return encrypt;
	}

	@Override
	/**
	 * Decipher text by mono-alphabetic method with a known key array.
	 * 
	 * @param cipherText
	 *            text that needs to be decipher.
	 * @return return the deciphered text.
	 */
	public String decrypt(String cipherText) {
		String plainText = "";
		// go through every char in the cipherText
		for (int i = 0; i < cipherText.length(); i++) {
			// find the corresponding index in the key array
			for (int keyIndex = 0; keyIndex < KEY.length; keyIndex++) {
				// the keyIndex is the original char
				if (KEY[keyIndex] == cipherText.charAt(i)) {
					plainText += Character.toString((char) (keyIndex + 'a'));
					break;
				}
			}
		}
		return plainText;
	}

}
