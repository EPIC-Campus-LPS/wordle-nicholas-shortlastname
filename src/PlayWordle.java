import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
public class PlayWordle {
    public static void main(String[] args) {
        //variable to check if you have gotten the
        //call getWords to get the words, get a random number 0-999, and choose which word is assigned to said random number
        String[] words = getWords();
        int randNum = (int)(Math.random()*1000);
        String chosenWord = words[randNum];
        //Create instance of wordle, take user input 6 times, print hints and letter, end after 6 guesses or the guess is correct
        Wordle game = new Wordle(chosenWord);
        Scanner nameScan = new Scanner(System.in);
        System.out.println("Your 5 letter Wordle word is waiting!");
        for(int i = 1; i < 6; i++) {
            System.out.println("Possible Letters: " + game.getLetters());
            System.out.print("What is your guess " + i + " --> ");
            String nextGuess = nameScan.nextLine();
            if(game.guessCorrect(nextGuess)){
                System.out.println("Congratulations!");
                break;
            }
            else {
                String hint = game.getHint(nextGuess);
                System.out.println("Here is your hint --> " + hint);
                if(i == 5){
                    System.out.println("Sorry you are out of guesses");
                }
            }
        }
        System.out.println("The word was " + game.getSecretWord());
    }

    public static String[] getWords() {
        //new 1000 string long list, new counter variable for indexing words, call file
        String[] list = new String[1000];
        int wordNum = 0;
        File listOfWords = new File("C:\\Users\\nicholasu750_lpsk12\\IdeaProjects\\wordle-nicholas-shortlastname\\words1000.txt");
        //throw error exception something
        Scanner myReader;
        try {
            myReader = new Scanner(listOfWords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //while there are more lines, add them one at a time to the 1000 string list, with increasing indexes
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            list[wordNum] = data;
            wordNum += 1;
        }
        return list; //return the list with all the words
    }
}