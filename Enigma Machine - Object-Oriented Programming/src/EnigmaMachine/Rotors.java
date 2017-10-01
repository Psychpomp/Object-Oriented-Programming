/*
Enigma Machine Rotors
by Ben Avery
9/25/17
v1.1
 */

package EnigmaMachine;

import Interfaces.Interfaces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Rotors implements Interfaces.RotorsInterface{
    private static ArrayList<Character> characterSet = new ArrayList<Character>();
    private static ArrayList<Character> rotor1 = new ArrayList<Character>();
    private static ArrayList<Character> rotor2 = new ArrayList<Character>();
    private static ArrayList<Character> rotor3 = new ArrayList<Character>();
    private static ArrayList<Character> rotor4 = new ArrayList<Character>();
    private static ArrayList<Character> rotor5 = new ArrayList<Character>();
    private static ArrayList<Character> reflector = new ArrayList<Character>();
    private static ArrayList<Boolean> whichRotorsActive = new ArrayList<Boolean>(Arrays.asList(true, true, true, false, false));

    public Rotors() {
        //constructor fills all 5 rotors to characterSet order:
        Dictionary dict = new Dictionary();
        characterSet = dict.getDictArray();
        rotor1 = (ArrayList<Character>) characterSet.clone();
        rotor2 = (ArrayList<Character>) characterSet.clone();
        rotor3 = (ArrayList<Character>) characterSet.clone();
        rotor4 = (ArrayList<Character>) characterSet.clone();
        rotor5 = (ArrayList<Character>) characterSet.clone();
        reflector = (ArrayList<Character>) characterSet.clone();
        //Collections.shuffles all 5 rotor arrays to build them uniquely:
        Random rnd = new Random(50);
        Collections.shuffle(rotor1, rnd);
        Collections.shuffle(rotor2, rnd);
        Collections.shuffle(rotor3, rnd);
        Collections.shuffle(rotor4, rnd);
        Collections.shuffle(rotor5, rnd);
        Collections.shuffle(reflector, rnd);
        //makes sure nothing is paired to itself in the reflector:
        ArrayList<Character> sorted = new ArrayList<Character>(reflector.size());
        for (int i=0; i<reflector.size(); i++) {
            if (reflector.get(i) == characterSet.get(i)) {
                try {
                    char temp = reflector.get(i);
                    reflector.set(i, reflector.get(i + 1));
                    reflector.set(i + 1, temp);
                } catch (IndexOutOfBoundsException e) {
                    char temp = reflector.get(i);
                    reflector.set(i, reflector.get(reflector.size() - i + 1));
                    reflector.set((reflector.size() - i + 1), temp);
                }
            }
        }
        //pairs up reflector:
        for (int i=0; i<reflector.size(); i++) {
            char a = reflector.get(i); //'
            Character b = characterSet.get(i);//+
            int c = reflector.indexOf(b);//position of + in reflector
            int d = characterSet.indexOf(a);//desired position of +
            char e = reflector.get(d);
            if((sorted.indexOf(a)==-1)&&(sorted.indexOf(b)==-1)) {
                Collections.swap(reflector, c, d);
                sorted.add(a);
                sorted.add(b);
            }
        }
    }
    public char encrypt(char input, int counter) {
        char b = input;//A
        int c;
        //rotor tick by offset:
        try {
            c = characterSet.indexOf(b)+counter; //1
        } catch(IndexOutOfBoundsException e) {
            c = characterSet.size()-characterSet.indexOf(b)+counter;
        }
        //first wheel:
        try {
            c = characterSet.indexOf(rotor3.get(c))-counter; //2 or C
        } catch(IndexOutOfBoundsException e) {
            c = characterSet.size()+characterSet.indexOf(rotor3.get(c))-counter;
        }
        //second wheel:
        c = characterSet.indexOf(rotor2.get(c)); //3 or D
        //third wheel:
        c = characterSet.indexOf(rotor1.get(c)); //5 or F
        //reflector:
        c = rotor1.indexOf(reflector.get(c)); //letter S
        c = rotor2.indexOf(characterSet.get(c)); //E
        try {
            c = characterSet.indexOf(characterSet.get(c))+counter; //F?
        } catch(IndexOutOfBoundsException e) {
            c = characterSet.size()-characterSet.indexOf(characterSet.get(c))+counter; //F?
        }
        try {
            c = rotor3.indexOf(characterSet.get(c))-counter; //2
        } catch(IndexOutOfBoundsException e) {
            c = characterSet.size()+rotor3.indexOf(characterSet.get(c))-counter; //2
        }
        b = characterSet.get(c);
        return b;
    }

    public void selectRotors() {
        //Lets the user select 3 rotors from a set of 5
        char a;
        Scanner scr = new Scanner(System.in);
        System.out.println("Please choose 3 rotors:");
        for(int i=1; i<6; i++) {
            do {
                System.out.println("Press Y to select rotor " + i + " or press N to discard it:");
                a = scr.next().charAt(0);
                if(a=='y'||a=='Y') {
                    whichRotorsActive.set(i-1, true);
                } else {
                    whichRotorsActive.set(i-1, false);
                }
            } while(a!='y'&&a!='Y'&&a!='n'&&a!='N');
        }
    }
}
