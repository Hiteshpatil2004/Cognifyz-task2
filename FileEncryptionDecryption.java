import java.io.*;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("File Encryption/Decryption");
            System.out.print("Enter 'encrypt' for encryption or 'decrypt' for decryption: ");
            String operation = reader.readLine();

            System.out.print("Enter input file name/path: ");
            String inputFile = reader.readLine();

            System.out.print("Enter output file name/path: ");
            String outputFile = reader.readLine();

            if (operation.equalsIgnoreCase("encrypt")) {
                encryptFile(inputFile, outputFile);
                System.out.println("File encrypted successfully.");
            } else if (operation.equalsIgnoreCase("decrypt")) {
                decryptFile(inputFile, outputFile);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid operation. Please enter 'encrypt' or 'decrypt'.");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptFile(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    // Simple encryption algorithm: increment ASCII value by 1
                    encryptedLine.append((char) (c + 1));
                }
                bw.write(encryptedLine.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder decryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    // Simple decryption algorithm: decrement ASCII value by 1
                    decryptedLine.append((char) (c - 1));
                }
                bw.write(decryptedLine.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
