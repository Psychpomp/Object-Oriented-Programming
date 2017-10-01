/*
Enigma Machine Interfaces
by Ben Avery
9/25/17
v1.1
 */

package Interfaces;

import java.util.ArrayList;

public class Interfaces {
    public interface InputOutputInterface {
        void startMenu();  //prints the starting menu
        void configMenu(); //prints the settings menu
        String fileIn();   //allows user to chose a file to be encrypted
        String lineIn();   //allows user to input a character to be encrypted
        void fileOrKB();   //allows user to choose to read from file or line in
        int blockSize();   //allows user to choose the block size
        void validate();   //validates encryption
        String messageStore(char a); //takes an input char and appends it to a string
    }
    public interface DictionaryInterface {
        ArrayList getDictArray(); //copies the character set/dictionary
    }
    public interface RotorsInterface {
        void selectRotors();      //allows the user to select which rotors to use
        char encrypt(char input, int counter);       //encrypts an input character
    }
    public interface BaseConverter {
        void baseConvert();       //will convert the input string's base type
    }
}
