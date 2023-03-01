package com.example.demo.utils;

import com.example.demo.constants.KeyConstants;
import com.example.demo.exception.DecryptionFailure;
import com.example.demo.exception.EncryptionFailure;
import com.example.demo.exception.KeyGenerationFailure;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AESOperations {

    private static final String MY_KEY = "secret key is a string";

    public static SecretKeySpec getSecretKey(){
        try {
            byte[] byteKey = MY_KEY.getBytes("UTF-8");
            byteKey = Arrays.copyOf(byteKey,16);

            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey,"AES");
            return secretKeySpec;
        }catch (Exception exception){
            throw new KeyGenerationFailure("secret key generation failed");
        }

    }

    // encryption
    public static String encryptTextUsingAES(String input){
        try {
            Cipher cipherText = Cipher.getInstance("AES");
            cipherText.init(Cipher.ENCRYPT_MODE, KeyConstants.KEY_SPEC);
            return Base64.getEncoder().encodeToString(cipherText.doFinal(input.getBytes("UTF-8")));
        }catch (Exception exception){
            throw new EncryptionFailure("Encryption failure");
        }
    }

    //decryption
    public static String decryptCipherToString(String cipherText){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, KeyConstants.KEY_SPEC);
            return new String(cipher.doFinal(Base64.getDecoder()
                    .decode(cipherText)));
        }catch (Exception exception){
            throw new DecryptionFailure("Decryption failed");
        }
    }
}
