package oliveira;

import java.util.Scanner;

public class Test {

    public static void main(String[] args)
    {
        String newUserPassword = PromptString("Type a password: ");
        User newUser = new User(newUserPassword);

        System.out.println(newUser.toString());

        try {
            System.out.println("Hashing user password... ");
            NSALoginController.hashUserPassword(newUser);

            System.out.println("Resut ==> ");
            System.out.println(newUser.toString()); //print the results to see the diff

            String userPasswordForTest = PromptString("\nPlease type the password to verify it: ");
            newUser.setPassword(userPasswordForTest);

            Boolean passwordMatched = NSALoginController.verifyPassword(newUser);

            if(passwordMatched == true)
                System.out.println("\nThe Password Matched!!!");
            else
                System.out.println("\nOoops you typed a wrong password.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String PromptString(String promptMessage)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(promptMessage);

        return scanner.nextLine();
    }
}
