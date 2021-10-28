package common.Encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import joptsimple.internal.Strings;
import org.apache.commons.codec.binary.Hex;

public class DesEncryption {

    public static String DESGetKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] key = secretKey.getEncoded();

            String result = Hex.encodeHexString(key);

            byte[] kk = Hex.decodeHex(result);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Strings.EMPTY;
    }

    public static String DESEncrypt(String plaintString, String DESKey) {
        try {

            byte[] key = Hex.decodeHex(DESKey);

            DESKeySpec desKeySpec = new DESKeySpec(key);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key2);

            byte[] result = cipher.doFinal(plaintString.getBytes());

            return Hex.encodeHexString(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Strings.EMPTY;
    }

    public static String DESDecipher(String plaintString, String DESKey) {
        try {

            byte[] key = Hex.decodeHex(DESKey);

            DESKeySpec desKeySpec = new DESKeySpec(key);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key2);

            byte[] result = cipher.doFinal(Hex.decodeHex(plaintString));

            return new String(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Strings.EMPTY;
    }
}
