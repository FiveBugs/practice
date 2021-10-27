package bootstart;

import common.Encrypt.DesEncryption;

public class DesEncrypt {
    public static void main(String[] args) {
        String srcString = "DES解密字符串";

        String encryptKey = DesEncryption.DESGetKey();

        String encryptString = DesEncryption.DESEncrypt(srcString, encryptKey);

        String plain = DesEncryption.DESDecipher(encryptString, encryptKey);

        System.out.println(encryptString);
    }
}
