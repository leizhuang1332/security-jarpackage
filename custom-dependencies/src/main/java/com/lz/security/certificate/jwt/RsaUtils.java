package com.lz.security.certificate.jwt;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtils {

    private static final int DEFAULT_KEY_SIZE = 2048;


    /**
     * 从文件中读取公钥
     *
     * @return 公钥对象
     * @throws Exception
     */
    public static PublicKey getPublicKey() throws Exception {
        byte[] bytes = generateKey("publicKey");
        return getPublicKey(bytes);
    }

    /**
     * 从文件中读取密钥
     *
     * @return 私钥对象
     * @throws Exception
     */
    public static PrivateKey getPrivateKey() throws Exception {
        byte[] bytes = generateKey("privateKey");
        return getPrivateKey(bytes);
    }

    /**
     * 获取公钥
     *
     * @param bytes 公钥的字节形式
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * 获取密钥
     *
     * @param bytes 私钥的字节形式
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    /**
     * 根据密文，生存rsa公钥和私钥,并写入指定文件
     *
     * @param rsa 秘钥类型
     */
    private static byte[] generateKey(String rsa) throws Exception {
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        SecureRandom secureRandom = new SecureRandom("www.youzidata.com".getBytes());
//        keyPairGenerator.initialize(DEFAULT_KEY_SIZE, secureRandom);
//        KeyPair keyPair = keyPairGenerator.genKeyPair();
        if (rsa.equals("publicKey")) {
            // 获取公钥
//            byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
//            return Base64.getEncoder().encode(publicKeyBytes);

            byte[] publicKeyBytes = ("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALjN2jPNQCPqFuqLrKyOlBan/r1qXiB2" +
                    "ugRyZoYSZ0VLcIScdj2PO1hI3Ch2wbzcogdfE77gwoXgOI0VR1F5250CAwEAAQ==").getBytes();
            return publicKeyBytes;
        } else if (rsa.equals("privateKey")) {
            // 获取私钥
//            byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
//            return Base64.getEncoder().encode(privateKeyBytes);
            byte[] privateKeyBytes = ("MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAuM3aM81AI+oW6ous" +
                    "rI6UFqf+vWpeIHa6BHJmhhJnRUtwhJx2PY87WEjcKHbBvNyiB18TvuDCheA4jRVH" +
                    "UXnbnQIDAQABAkARzIG/i30p+FnMrTcsR28r33JBfAUky0qPMxV8xDj+C2P/i2U5" +
                    "TQSCF2YnV4Rps844MnePPQkS6+rbjJmaX5QBAiEA6jza9InRvJgHY4PayDPkEmGO" +
                    "kTYWiMkzl83b4/UO6+ECIQDJ+ULF+RWDVGBI/42L0VEkacLkc9aK2qWUcGbtn4iH" +
                    "PQIgaHqcb1bJ5oUpRooZnBMJN+mr3blyc7DLAnsgCZ3U+gECIQCbYF9nD6zmIFYG" +
                    "MlrA8iE7IwWkXBzzKytwW1xDd5Q/fQIhAN4gqWlQyK21uHCGVK+iGv5DMjvwlYZ0" +
                    "9RDdUFzj/Jwi").getBytes();
            return privateKeyBytes;
        }
        return null;
    }
}