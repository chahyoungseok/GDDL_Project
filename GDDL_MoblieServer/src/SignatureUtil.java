

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignatureUtil {

	public static String applySHA256(String input) {
	        StringBuffer hexString = new StringBuffer();
	        byte[] hash;

	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            hash = digest.digest(input.getBytes("UTF-8"));

	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toString((0xff & hash[i]) + 0x100, 16).substring(1);
	                hexString.append(hex);
	            }
	            return hexString.toString();

	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
