package com.lz.security.certificate.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtils {

    private static final int DEFAULT_KEY_SIZE = 2048;

    private static Logger log = LoggerFactory.getLogger(RsaUtils.class);

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
        if (rsa.equals("publicKey")) {
            // 获取公钥
            return readFile("/rsa/pub.key");
        } else if (rsa.equals("privateKey")) {
            // 获取私钥
            return readFile("/rsa/pri.key");
        }
        return null;
    }

    public static byte[] readFile(String fileName) throws IOException {
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = RsaUtils.class.getResourceAsStream(fileName);
            baos = new ByteArrayOutputStream();
            // 设置缓冲区域
            byte[] buff = new byte[1024];
            // 记录实际读取的长度
            int len;
            // read 将字节流读取到 定义 的 data 中，len 记录每次读取的长度，当 is 的数据读完之后len的值则为-1
            while ((len = is.read(buff)) > 0) {
                baos.write(buff, 0, len);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            if (is != null) {
                is.close();
            }
            if (baos != null) {
                baos.close();
            }
        }
    }

    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String secret, int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename, publicKeyBytes);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    private static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes);
    }
}