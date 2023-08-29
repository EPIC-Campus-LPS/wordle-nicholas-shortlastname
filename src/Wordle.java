public class Wordle{
    private String secretword;
    private String letters = " a b c d e f g h i j k l m n o p q r s t u v w x y z ";
    public Wordle(String word){
        this.secretword = word;
    }
    public boolean guessCorrect(String guess){
        if(guess.equals(secretword)){
            return true;
        }
        else{
            return false;
        }
    }
    public String getHint(String guess){
        //split the guess word into a list, so they can be indexed, then initialize the string containing the hint
        String[] guessLetters = guess.split("");
        String hint = "";
        //for each letter in the words, which should be 5
        for(int i = 0; i < 5; i++){
            if(secretword.indexOf(guessLetters[i]) == i){
                hint += guessLetters[i];
            }// if the index and letter is the same, add the letter to the hint
            else if (secretword.contains(guessLetters[i])){
                hint += "+";
            }//if the letter is in the answer but not in that index, add a + to the hint
            else{
                hint += "*";
                letters = letters.replace(guessLetters[i], " ");
            }//if it isn't in the word altogether, add * to the hint and remove the letter as a possible letter in the string
        }
        return hint;
    }
    public String getSecretWord(){
        return secretword;
    }
    public String getLetters(){
        return letters;
    }
}
