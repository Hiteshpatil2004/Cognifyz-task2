import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int score = calculatePasswordStrength(password);
        String feedback = evaluatePasswordStrength(score);

        System.out.println("Password Strength: " + feedback);

        scanner.close();
    }

    public static int calculatePasswordStrength(String password) {
        int score = 0;

        // Length check
        if (password.length() >= 8) {
            score += 2;
        }

        // Presence of uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score += 2;
        }

        // Presence of lowercase letters
        if (password.matches(".*[a-z].*")) {
            score += 2;
        }

        // Presence of numbers
        if (password.matches(".*\\d.*")) {
            score += 2;
        }

        // Presence of special characters
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            score += 2;
        }

        return score;
    }

    public static String evaluatePasswordStrength(int score) {
        if (score >= 10) {
            return "Strong";
        } else if (score >= 6) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
