/**
 * Copy is a cipher method that simply copy over the text message
 * 
 * @author yuhu
 *
 */
public class Copy implements Cipher {

	@Override
	/**
	 * Copy method encrypt by copy
	 * 
	 * @param plainText
	 *            the text that needs to be copied
	 * @return return the copied text
	 */
	public String encrypt(String plainText) {
		return plainText;
	}

	@Override
	/**
	 * Copy method decrypt by copy
	 * 
	 * @return cipherText return the original text
	 * @param the
	 *            text that copied text
	 */
	public String decrypt(String cipherText) {
		return cipherText;
	}

}
