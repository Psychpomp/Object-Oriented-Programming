/*
Enigma Machine Input/Output
by Ben Avery
9/27/17
v1.2
 */

package EnigmaMachine;

import Interfaces.Interfaces;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputOutput implements Interfaces.InputOutputInterface {
    String origMessage = "";
    String encMessage = "";

    public void startMenu() {
        System.out.println("BEN'S ENIGMA MACHINE");
        System.out.println();
        System.out.println("MENU");
        System.out.println("E - Encrypt a message");
        System.out.println("S - Settings");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.println("Choose an option:");
    }
    public void configMenu() {
        System.out.println();
        System.out.println("SETTINGS");
        System.out.println("R - Pick 3 rotors to use out of 5");
        System.out.println("B - Go Back");
        System.out.println();
        System.out.println("Choose an option:");
    }
    public String fileIn() {
        //TODO: set up a filereader:
        Scanner scr = new Scanner(System.in);
        String input;
        boolean b = true;
        String fileString = "";
        System.out.println("Enter the path for the file you want to encrypt:");
        do {
            input = scr.next();
            if(b==false) {
                //if file path is invalid:
                System.out.println("Please enter a valid path for your file:");
            }
        } while(b == false);
        return fileString;
    }
    public String lineIn() {
        /*encrypts a single character, and checks against character set. Does the same thing as validate()
        currently except with a single character instead of a string.*/
        Scanner scr = new Scanner(System.in);
        boolean b;
        String input;
        System.out.println("Enter a character to encrypt or type 'exit' when finished:");
        do {
            input = scr.nextLine();
            for (int i=0; i<25; i++) System.out.println();
            Pattern p = Pattern.compile("[\\p{Alnum}\\p{Punct}\\s]{1}");
            Matcher m = p.matcher(input);
            b = m.matches();
            if(!b&&(!input.equals("exit"))) {
                //if character is invalid:
                System.out.println("Please enter a single valid character. Only the printable character set is allowed.");
            }
        } while(!b&&(!input.equals("exit")));
        return input;
    }
    public void fileOrKB() {
        //menu options to select either input from a file or from the keyboard
        boolean readFile = false;
        Scanner scr = new Scanner(System.in);
        System.out.println("F - Read input from a file");
        System.out.println("K - Read input from keyboard");
        System.out.println("Please choose an option:");
        int option = scr.next().charAt(0);
        if(option == 'f') {
            readFile = true;
            System.out.println("Now reading input from a file");
        }
        scr.close();
    }
    public int blockSize() {
        //Allows user to select a block size
        Scanner scr = new Scanner(System.in);
        System.out.println("Please enter a block size:");
        int size = scr.nextInt();
        scr.close();
        return size;
    }
    public void validate() {
        //makes sure the input string uses only character set characters
        Scanner scr = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a message to encrypt (printable characters only):");
        String input = scr.next();
        input = scr.next();
        Pattern p = Pattern.compile("[\\p{Alnum}\\p{Punct}\\s]*");
        Matcher m = p.matcher(input);
        boolean b = m.matches();
        int counter = 1;
        while(b == false) {
            //if character is invalid:
            System.out.println("Invalid character entered. Only the printable character set is allowed.");
            input = scr.nextLine();
            p = Pattern.compile("[\\p{Alnum}\\p{Punct}\\s]*");
            m = p.matcher(input);
            b = m.matches();
        }
    }
    public String messageStore(char a) {
        String b = Character.toString(a);
        origMessage += b;
        return origMessage;
    }
    public String encMesageStore(char b) {
        String a = Character.toString(b);
        encMessage += a;
        return encMessage;
    }
}
