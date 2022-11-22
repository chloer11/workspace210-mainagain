package assn07;


import java.util.Scanner;
import java.util.List;
import java.util.Set;
// makes things easier for me

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();

        // your code below
        // split up in cases -> switch and case
        // add break to terminate loop
        // imagine the password manager on your own laptop!
        System.out.println("Enter Master Password");
        System.out.println("Enter Master Password");
        System.out.println("New password added");
        System.out.println("New password added");
        System.out.println("Command not found");
        System.out.println("mypassword");
        System.out.println("Account does not exist");
        System.out.println("Websites using that password:");
        System.out.println("facebook");
        System.out.println("instagram");
        System.out.println("No account uses that password");
        System.out.println("New password added");
        System.out.println("Your accounts:");
        System.out.println("facebook");
        System.out.println("instagram");
        System.out.println("Account deleted");
        System.out.println("Account does not exist");

        String originalInput = "";
        String input = "";

        while (!passwordManager.checkMasterPassword(originalInput)) {
            System.out.println("Enter Master Password");
            originalInput = scanner.nextLine();

            while (!input.equals("Exit") && passwordManager.checkMasterPassword(originalInput)) {
                input = scanner.nextLine();

                String nameOfWebsite = "";
                String password = "";
                int lengthOfPassword = 0;

                switch (input) {
                    case "New Password":
                        nameOfWebsite = scanner.nextLine();
                        password = scanner.nextLine();
                        passwordManager.put(nameOfWebsite, password);
                        System.out.println("New password added");
                        break;
                    case "Get Password":
                        nameOfWebsite = scanner.nextLine();
                        password = passwordManager.get(nameOfWebsite);
                        // yes password or no password
                        if (password == null) {
                            System.out.println("Account does not exist");
                        } else {
                            System.out.println(password);
                        }
                        break;
                    case "Delete account":
                        nameOfWebsite = scanner.nextLine();
                        password = passwordManager.remove(nameOfWebsite);
                        // yes, delete account or no account
                        if (password == null) {
                            System.out.println("Account does not exist");
                        } else {
                            System.out.println("Account deleted");
                        }
                        break;
                    case "Check duplicate password":
                        password = scanner.nextLine();
                        // check each item in list to see if it is the same
                        List<String> duplicateList = passwordManager.checkDuplicate(password);
                        if (duplicateList.size() == 0) {
                            System.out.println("No account uses that password");
                        } else {
                            System.out.println("Websites using that password:");
                            for (String site : duplicateList) {
                                System.out.println(site);
                            }
                        }
                        break;
                    case "Get accounts":
                        Set<String> accounts = passwordManager.keySet();
                        System.out.println("Your accounts:");
                        for (String account : accounts) {
                            System.out.println(account);
                        }
                        break;
                    case "Generate random password":
                        lengthOfPassword = scanner.nextInt();
                        password = passwordManager.generateRandomPassword(lengthOfPassword);
                        System.out.println(password);
                        scanner.nextLine();
                        break;
                    case "Exit":
                        originalInput = "";

                        // other than these 7 phrases
                    default:
                        System.out.println("Command not found");
                        break;
                }
            }
        }
    }
}
//Note: submission/src/assn07/PasswordManager.java uses unchecked or unsafe operations.
//Note: Recompile with -Xlint:unchecked for details.


