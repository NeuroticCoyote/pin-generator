import java.util.*;

public class pinGenerator {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the name: ");
        String inputName = userInput.nextLine();
        System.out.println("Please enter the account number (e.g. 13561342): ");
        int accountNumber = userInput.nextInt();
        System.out.println("Please enter the sort code number (e.g. 711313): ");
        int sortCodeNumber = userInput.nextInt();

        generatePin(inputName, sortCodeNumber, accountNumber);
        System.out.println("Name:" + inputName);
        System.out.println("------------------");

        userInput.close();
    }

    public static String generatePin(String name, int sortCode, int accountNumber) {
        Random random = new Random();
        boolean isRuleCheckOK;
        String paddedPin;
        int maxRetries = 0;

        do {
            CheckRuleSet ruleChecker = new CheckRuleSet();
            int upperLimit = ruleChecker.lengthRule();

            int randomPin = random.nextInt(upperLimit);
            paddedPin = String.format("%04d", randomPin); // so we can pad with leading zeros if needed
            System.out.println("Attempting to check pin: " + paddedPin);
            isRuleCheckOK = ruleChecker.checkRules(name, paddedPin, accountNumber, sortCode);
            
            maxRetries++;
            if (isRuleCheckOK == true) {
                ruleChecker.updatePinHistory(name, paddedPin);
            }
        }
        while (isRuleCheckOK == false && maxRetries < 10);

        if (maxRetries == 10) {
            System.out.println("ERROR: max number of retries hit, cancelling pin generation.");
        } 
        else {
            System.out.println("------------------");
            System.out.println("Generated pin:" + paddedPin);
        }

        return paddedPin;
    }
}