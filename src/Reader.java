import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {

    // Attributes

    File textfile;
    Scanner scan;
    Map<Character, Integer> charMap;
    Map<String, Integer> wordMap;
    int totalCharCount = 0;
    int totalWordCount = 0;

    // Constructor

    public Reader(String filePath) throws  Exception{
        textfile = new File(filePath);
        scan = new Scanner(textfile);
        charMap = charReader();
        wordMap = wordReader();
    }

    // Methods

    public Map<Character, Integer> charReader(){
        charMap = new HashMap<>();
        while (scan.hasNext()){
            String word = scan.next().toLowerCase();
            for (Character c : word.toCharArray()){
                int temp = 0;
                if(charMap.containsKey(c)){
                    temp = charMap.get(c);
                }
                if(Character.isLetter(c)) {
                    charMap.put(c, temp + 1);
                    totalCharCount++;
                }
            }
        }
        return charMap;
    }

    public Map<String, Integer> wordReader() throws Exception{
        wordMap = new HashMap<>();
        Scanner scan = new Scanner(textfile);
        while (scan.hasNext()){
            String tempWord = scan.next();
            int temp = 0;
            if(wordMap.containsKey(tempWord)){
                temp = wordMap.get(tempWord);
            }
            wordMap.put(tempWord, temp  + 1);
            totalWordCount++;
        }
        return wordMap;
    }

    public void toPrintLetters(){
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()){
            System.out.println("Character: " + entry.getKey() + " appears " + entry.getValue() + " time(s)");
        }
    }

    public void toPrintWords(){
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()){
            System.out.println("Word: " + entry.getKey() + " appears " + entry.getValue() + " time(s)");
        }
    }

    // Getters

    public Map<Character, Integer> getCharMap() {
        return charMap;
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public int getTotalCharCount() {
        return totalCharCount;
    }

    public int getTotalWordCount() {
        return totalWordCount;
    }
}
