/*
Enigma Machine Plugboard
by Ben Avery
9/16/17
v1.0
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class Plugboard {
    //TODO Change the plugboard to allow the user to pair 47 out of 94 from the new character set instead of 20/26
    private HashMap<Character, Character> hmapDefault = new HashMap<Character, Character>();
    private HashMap<Character, Character> hmapCustom = new HashMap<Character, Character>();
    public static boolean defSelected = true;

    public void defaultPairing() {
        String alphabetKeysL = "abcdefghijklmnopqrstuvwxyz";
        String alphabetValuesL = "krionacgdbjltfmqeshpuvwxyz";
        String alphabetKeysU = alphabetKeysL.toUpperCase();
        String alphabetValuesU = alphabetValuesL.toUpperCase();
        for(int i = 0; i<alphabetKeysL.length(); ++i) {
            char a = alphabetKeysL.charAt(i);
            char b = alphabetValuesL.charAt(i);
            hmapDefault.put(a, b);
        }
        System.out.println("Default Pairing Selected:");
        System.out.println(hmapDefault);
        for(int i = 0; i<alphabetKeysU.length(); ++i) {
            char z = alphabetKeysU.charAt(i);
            char y = alphabetValuesU.charAt(i);
            hmapDefault.put(z, y);
        }
        defSelected = true;

    }

    public void customPairing() {
        Scanner scr = new Scanner(System.in);
        String alphabetKeys = "abcdefghijklmnopqrstuvwxyz";
        String alphabetKeysU = alphabetKeys.toUpperCase();
        int length = alphabetKeys.length();
        for(int i = 0; i<length; ++i) {
            char letter = alphabetKeys.charAt(i);
            System.out.println("Enter a letter to pair with " + letter + ":");
            char pair = scr.next().charAt(0);
            while(hmapCustom.containsValue(pair)) {
                System.out.println("You can't use the same letter twice.");
                System.out.println("Enter a new letter to pair with " + letter + ":");
                pair = scr.next().charAt(0);
            }
            hmapCustom.put(letter, pair);
        }
        defSelected = false;
        System.out.println("Custom Pairing Selected:");
        System.out.println(hmapCustom);
        for(int i = 0; i<26; ++i) {

        }
    }

    public char flipChar(char a) {
        if(defSelected = true) {
            char b = hmapDefault.get(a);
            a = b;
        } else if (defSelected = false) {
            char c = hmapCustom.get(a);
            a = c;
        }
        return a;
    }
}
