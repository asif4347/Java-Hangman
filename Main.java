import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in =new Scanner(System.in);
        int total_guesses=8;
        int  n = rand.nextInt(9) ;
        HangmanLexicon lex=new HangmanLexicon();
        String word=lex.getWord(n);
        StringBuffer sb=new StringBuffer(word);
        StringBuffer showWord=new StringBuffer();
        for (int itr=0;itr<sb.length();itr++){
            showWord.append("-");
        }
        //System.out.print(word);
        System.out.print("Your Word Looks Like: "+showWord);
    while (total_guesses!=0) {
        System.out.print("\nEnter the Guess: ");
        char guess = Character.toUpperCase(in.next().charAt(0));
        int i = 0;
        for (int itr = 0; itr < sb.length(); itr++) {
            if (guess == sb.charAt(itr)) {
                showWord.setCharAt(itr, guess);
                i=1;
            }
        }
        if(i==0) {
            total_guesses--;
            System.out.println("The Word has no Letter :"+guess);
        }
        System.out.println("Total Guesses Left: " + total_guesses);
        System.out.println("Your Word Looks Like: " + showWord);
        if(showWord.toString().equals(sb.toString())){
            System.out.println("You Won!");
            break;
        }
    }
    if(total_guesses==0){
        System.out.println("You Lost");
    }
    }
}
