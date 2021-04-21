package com.cpllz.the16th.util.aes;

/**
 * AES 128bit 加密解密工具类
 *
 * @author dufy
 */

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


public class AesEncryptUtil2 {

    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
    private static String KEY = "12345678901234561234567890123456";

    private static String IV = "12345678901234561234567890123456";


    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";//默认的加密算法
    static {
        Security.addProvider(new BouncyCastleProvider());
    }


    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password,String IV) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            byte[] byteContent = content.getBytes("UTF-8");
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            byte[] rawKey = password.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec,iv);// 初始化为加密模式的密码器
            byte[] result = cipher.doFinal(byteContent);// 加密

            //return new String(Base64.encode(result), "UTF-8");
            return new String(Base64.encodeBase64String(result));
        } catch (Exception ex) {
            System.out.println(ex);
            // Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password,String IV) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            byte[] rawKey = password.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,iv);
            //执行操作
            //byte[] result = cipher.doFinal(Base64.decode(content));
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, "UTF-8");
        } catch (Exception ex) {
        }

        return null;
    }


        /*
	    private static SecretKeySpec getSecretKey(final String password) {
	        //返回生成指定算法密钥生成器的 KeyGenerator 对象
	        KeyGenerator kg = null;

	        try {
	            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

	            //AES 要求密钥长度为 128
	            kg.init(128, new SecureRandom(password.getBytes()));

	            //生成一个密钥
	            SecretKey secretKey = kg.generateKey();
	            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
	        } catch (NoSuchAlgorithmException ex) {
			     System.out.println(ex.getMessage());

	        }

	        return null;
	    }
        */
    /**
     * 测试
     */
    public static void main(String args[]) throws Exception {

        String test1 = "wuwenzhe";
        String test = new String(test1.getBytes(), "UTF-8");
        String data = null;
        String key = KEY;
        String iv = IV;
        // /g2wzfqvMOeazgtsUVbq1kmJawROa6mcRAzwG1/GeJ4=
        data = encrypt(test, key, iv);
        System.out.println("data = " + data);
        //data = "Np2SpQ54XVSpMu8wceQc/Q==";
        System.out.println("数据：" + test);
        System.out.println("加密：" + data);
        String jiemi = decrypt(data, key, iv).trim();
        System.out.println("解密：" + jiemi);


    }

}
