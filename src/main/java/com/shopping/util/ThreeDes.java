package com.shopping.util;


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

public class ThreeDes {
	// 密钥                                                                                        
    private final static String SECRETKEY = "ygmxjstrwgs#yxda9$@fs2&%";
    // 向量  
    private final static String IV = "01234567";
    // 加解密统一使用的编码方式  
    private final static String ENCODING = "utf-8";
  
    /** 
     * 3DES加密 
     *  
     * @param plainText 普通文本 
     * @return 
     * @throws Exception  
     */  
    public static String encode(String plainText) throws Exception {  
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(SECRETKEY.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);  
  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);  
        byte[] encryptData = cipher.doFinal(plainText.getBytes(ENCODING));
        return Base64.encode(encryptData).replace(" ","");
    }  
  
    /** 
     * 3DES解密 
     *  
     * @param encryptText 加密文本 
     * @return 
     * @throws Exception 
     */  
    public static String decode(String encryptText) throws Exception {  
        Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(SECRETKEY.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);  
  
        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));  
  
        return new String(decryptData, ENCODING);
    }  
	 /*
     * 测试
     */
    public  static void main(String[] args){
		try {
			System.out.println(ThreeDes.decode("LNGfqfFplvY="));
//            System.out.println(ThreeDes.encode("lishicheng123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
