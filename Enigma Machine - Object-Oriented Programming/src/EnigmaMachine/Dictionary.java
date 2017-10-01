/*
Enigma Machine Dictionary
by Ben Avery
9/25/17
v1.1
 */

package EnigmaMachine;

import Interfaces.Interfaces;
import java.util.ArrayList;

public class Dictionary implements Interfaces.DictionaryInterface{
    private ArrayList<Character> characterSet = new ArrayList<Character>();
    private final String charSet;

    public Dictionary() {
        //constructor that adds character set to arraylist
        charSet = "! \" # $ % & ' ( ) * + , - . /"
                + "          0 1 2 3 4 5 6 7 8 9"
                + "          : ; < = > ? @"
                + "          A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
                + "          [ \\ ] ^ _ `"
                + "          a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + "          { | } ~";
        String charSet2 = charSet.replaceAll(" ", "");
        String charSet3 = charSet2.concat(" ");
        //adds the letters to the arraylist
        for (int i=0; i<charSet3.length(); i++) {
            char letter = charSet3.charAt(i);
            characterSet.add(letter);
        }
    }
    public ArrayList<Character> getDictArray() {
        return characterSet;
    }
}
