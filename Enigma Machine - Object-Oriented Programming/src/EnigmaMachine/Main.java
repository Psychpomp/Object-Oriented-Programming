/*
Enigma Machine
by Ben Avery
9/27/17
v1.4
 */

package EnigmaMachine;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        //TODO Clean this mess up
        //GUI window = new GUI();
        //SwingUtilities.invokeLater(window);
        Scanner scr = new Scanner(System.in);
        InputOutput outputInt1 = new InputOutput();
        Rotors rotors = new Rotors();
        outputInt1.startMenu();
        char option;
        //menu option loop:
        do {
            option = scr.next().charAt(0);
            if(option=='e'||option=='E') {
                //runs lineIn, and appends the input char to the string origMessage.
                for (int i=0; i<25; i++) System.out.println();
                String a;
                int count = 1;
                do {
                    a = outputInt1.lineIn();
                    if(!a.equals("exit")) {
                        char b = a.charAt(0);
                        char o = rotors.encrypt(b, count);
                        String origMessage = outputInt1.messageStore(b);
                        String encMessage = outputInt1.encMesageStore(o);
                        System.out.println();
                        System.out.println("Your original message was: " + origMessage);
                        System.out.println("Your encrypted message is: " + encMessage);
                        count += 1;
                    }
                }while(!a.equals("exit"));
                System.out.println();
                outputInt1.startMenu();
            } else if(option=='o') {
                //settings menu
                outputInt1.configMenu();
                char choice;
                do {
                    choice = scr.next().charAt(0);
                    if (choice == '1') {
                        outputInt1.configMenu();
                    } else if (choice == '2') {
                        outputInt1.configMenu();
                    } else if (choice == '3') {
                        outputInt1.configMenu();
                    } else {
                        System.out.println("Please choose a valid option:");
                    }
                } while (choice != 'b');
                outputInt1.startMenu();
            } else if (option!='q') {
                System.out.println("Please choose a valid option:");
            }
        } while(option!='q');
        scr.close();
    }
}
