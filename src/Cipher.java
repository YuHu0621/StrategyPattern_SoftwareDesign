
/**
 * Abstract Cipher interface that provide encrypt and decipher function for a
 * cipher machine
 * 
 * @author yuhu
 *
 */
public interface Cipher {

	/**
	 * encrypt a plain text
	 * 
	 * @param plainText
	 *            input plainText that needs to be encrypt
	 * @return return the encrypted text
	 */
	public String encrypt(String plainText);

	/**
	 * decrypt a plain text
	 * 
	 * @param cipherText
	 *            cipher text that needs to be decrypt
	 * @return return the decrypted text
	 */
	public String decrypt(String cipherText);
}
