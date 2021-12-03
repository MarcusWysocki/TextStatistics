import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
//import org.junit.jupiter.api.Test;

public class Main {

    final static String PATH = "data/bible_daily.txt";

    /**
     * Longest word in the english language is 45 letters. I think this is a good upper bound, bigger is nonsensical.
     * The Index of the array is the word length. The value at the index is the word count.
     */
    static int[] counts = new int[45];
    static int numWord = 0; //The total number of words discovered.
    static ArrayList<Integer> maxLengthsList = new ArrayList<Integer>();


    /**
     *  Read line by line and then word by word using the default delimiter which is a space.
     * @param args not used.
     */
    public static void main(String args[]) {
        try {
            File myFile = new File(PATH);
            Scanner lineReader = new Scanner(myFile);

            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                Scanner wordReader = new Scanner(line);

                while (wordReader.hasNext()) {
                    String word = wordReader.next();
                    boolean passed = letterCount(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not accessed");
        }


        System.out.println("Word count = " + numWord);
        if (numWord != 0) {
            int totalLetters = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    totalLetters += ((i + 1) * counts[i]);
                }
            }
            double average = (double) totalLetters / (double) numWord;
            System.out.println("Average word length = " + String.format("%,.3f", average));

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    System.out.println("Number of words of length " + (i + 1) + " is " + counts[i]);
                }
            }

            List<Integer> maxLength = getMaxLength(counts);

            String maxxes = " " + maxLength.get(0);
            int mostFreqWord = counts[maxLength.get(0) - 1];

            //Build string
            if (maxLength.size() > 1) {
                for (int i = 1; i < maxLength.size(); i++) {
                    maxxes = maxxes + " & " + maxLength.get(i);
                }
            }

            System.out.println("The most frequent occurrence of a word length is " + mostFreqWord
                    + ", for word lengths of" + maxxes);
        } else {
            System.out.println("The file is empty");
        }
    }

    public static boolean letterCount(String word) {

        int length = shavePunctuation(word);
        if (length != 0 && length < 46) {
            //System.out.println(word + " " + length);
            counts[length - 1]++;
            numWord++;
        }

        return true;
    }

    /**
     * This method takes in a word and returns how many letters there are in it after removing all punctuation.
     * @param word is the word in question.
     * @return The number of letters. We don't need the word anymore, the only thing that matters is the no. letters.
     */
    public static int shavePunctuation(String word) {

        /**
         * The switch case contains all symbols that will be shaved from the front and back of words.
         */
        int length = word.length();

        for (int i = 0; i < word.length(); i++) {
            switch(word.charAt(i)) {
                case ';':
                case ':':
                case '-':
                case '"':
                case ',':
                case '.':
                case '?':
                case '!':
                case '*':
                case '{':
                case '}':
                case '[':
                case ']':
                case '<':
                case '>':
                case '+':
                case '=':
                    length--;
                    break;
                default:
                    break;
            }
        }

        return length;
    }

    public static ArrayList<Integer> getMaxLength(int[] wordCounts) {
        ArrayList<Integer> maxLength = new ArrayList<Integer>();
        int maxValue = 0;

        for (int i = 0; i < wordCounts.length; i++) {
            if (wordCounts[i] != 0) {
                if (wordCounts[i] > maxValue) {
                    maxValue = wordCounts[i];
                    maxLength.clear();
                    maxLength.add(i+1);
                } else if (wordCounts[i] == maxValue) {
                    maxLength.add(i+1);
                }
            }
        }
        maxLengthsList = maxLength;
        return maxLength;
    }
}
