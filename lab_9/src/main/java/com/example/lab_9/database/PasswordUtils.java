import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {

    // Метод для генерации случайной соли
    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return bytesToHex(saltBytes);
    }

    // Метод для хеширования пароля
    public static String hashPassword(String password) {
        String salt = generateSalt();
        String hashedPassword = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] saltBytes = hexToBytes(salt);

            byte[] combinedBytes = new byte[passwordBytes.length + saltBytes.length];
            System.arraycopy(passwordBytes, 0, combinedBytes, 0, passwordBytes.length);
            System.arraycopy(saltBytes, 0, combinedBytes, passwordBytes.length, saltBytes.length);

            byte[] hashBytes = digest.digest(combinedBytes);
            hashedPassword = bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

    // Метод для проверки пароля
    public static boolean checkPassword(String password, String hashedPassword, String salt) {
        String hashedInput = hashPassword(password + salt); // Добавляем соль к паролю перед хэшированием
        return hashedPassword.equals(hashedInput);
    }
    // Метод для хеширования пароля с использованием соли
    private static String hashPasswordWithSalt(String password, String salt) {
        String hashedPassword = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] saltBytes = hexToBytes(salt);

            byte[] combinedBytes = new byte[passwordBytes.length + saltBytes.length];
            System.arraycopy(passwordBytes, 0, combinedBytes, 0, passwordBytes.length);
            System.arraycopy(saltBytes, 0, combinedBytes, passwordBytes.length, saltBytes.length);

            byte[] hashBytes = digest.digest(combinedBytes);
            hashedPassword = bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

    // Вспомогательный метод для преобразования массива байт в строку шестнадцатеричного представления
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            hexStringBuilder.append(hex);
        }
        return hexStringBuilder.toString();
    }

    // Вспомогательный метод для преобразования строки шестнадцатеричного представления в массив байт
    private static byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(hex.substring(index, index + 2), 16);
            bytes[i] = (byte) j;
        }
        return bytes;
    }


    // Пример использования
    public static void main(String[] args) {
        String password = "myPassword";

        // Хеширование пароля
        String hashedPassword = hashPassword(password);
        System.out.println("Хэш пароля: " + hashedPassword);

        // Генерация случайной соли
        String salt = generateSalt();
        System.out.println("Соль: " + salt);

        // Проверка пароля
        boolean passwordMatches = checkPassword(password,hashedPassword, salt);
        System.out.println("Пароль совпадает: " + passwordMatches);
    }
}