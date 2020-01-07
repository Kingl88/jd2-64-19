package by.it.academy.design_bureau.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptUtils {

    public static final String STRING_256 = "%064x"; // 64 знака 16-битная система сисления
    public static final int SALT_SIZE = 20;


    public static String getSHA256(String input, String salt) { //метод для шифрования по алгоритму SHA-256.
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // содание экземпляра класса MessageDigest использующий алгоритм шифрования SHA-256.
            md.reset(); // како-то сброс по умолчанию. ???
            md.update(stringToBytes(salt)); // используем метод так как включаем в сообщение несколько блоков ( нашу "соль" и сообщение).
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8)); // тоже самое что и --->
            //md.update(input.getBytes(StandardCharsets.UTF_8));
            //byte[] digest = md.digest();
            // получение дайджест сообщения в виде массива байт.
            return String.format(STRING_256, new BigInteger(1, digest));//преобразуем в стороку с 64 символами 16-ти ричной системы счисления (1 - положительное число).
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting password", e);
        }
    }

    public static byte[] generateSalt() { // генерация массива байт "соли".
        SecureRandom random = new SecureRandom(); // тоже самое что Random, но более криптонадежный.
        byte[] bytes = new byte[SALT_SIZE];
        random.nextBytes(bytes); // заполняем массив байтов значениями.
        return bytes;
    }

    public static String generateSaltString() { // преобразования массива байт в строку.
        return byteToString(generateSalt());
    }

    public static String byteToString(byte[] salt) { // шифруем массив байтов "соли".
        return Base64.getEncoder().encodeToString(salt);
    }

    public static byte[] stringToBytes(String bytes) { // дешифруем строку в массив байтов "соли".
        return Base64.getDecoder().decode(bytes);
    }

    public static void main(String[] args) {
        String pass = "pass1";
        String salt = EncryptUtils.generateSaltString();
        System.out.println("salt = " + salt);
        System.out.println("pass = " + pass);

        String hash = EncryptUtils.getSHA256(pass, salt);
        System.out.println("hash " + hash);

    }
}
