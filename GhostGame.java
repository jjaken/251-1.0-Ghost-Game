import java.io.*;
import java.util.*;

public class GhostGame
{
  public static void main(String args[]) throws FileNotFoundException
  {
    Scanner wordScanner = new Scanner(new File("enable1.txt"));
    Scanner keyboard = new Scanner(System.in);
    Collection<String> dictionary = new HashSet<String>();
    while (wordScanner.hasNextLine())
    {
      dictionary.add(wordScanner.nextLine());
    }

    Collection<String> prefixes = new HashSet<String>();
    Iterator<String> dictIt = dictionary.iterator();
    while (dictIt.hasNext())
    {
      String word = dictIt.next();
      String prefix = new String();
      for (int i = 0; i < (word.length() - 1); ++i)
      {
        prefix += word.charAt(i);
        prefixes.add(prefix);
      }
    }

    String s = new String();

    boolean gameOver = false;

    Player player1;
    Player player2;

    // Player 1 Selection
    char selection1;
    System.out.println("Should Player 1 be a Computer? Y/N");
    selection1 = keyboard.nextLine().charAt(0);
    if (selection1 == 'Y' || selection1 == 'y')
    {
      player1 = new Computer(1, dictionary, prefixes);

    }
    else if (selection1 == 'N' || selection1 == 'n')
    {
      player1 = new Human(1);
    }
    else
    {
      System.out.println("Incorrect answer given; human player chosen.");
      player1 = new Human(1);
    }
    // Player 2 Selection
    char selection2;
    System.out.println("Should Player 2 be a Computer? Y/N");
    selection2 = keyboard.nextLine().charAt(0);
    if (selection2 == 'Y' || selection2 == 'y')
    {
      player2 = new Computer(2, dictionary, prefixes);

    }
    else if (selection2 == 'N' || selection2 == 'n')
    {
      player2 = new Human(2);
    }
    else
    {
      System.out.println("Incorrect answer given; human player chosen.");
      player2 = new Human(2);
    }

    while (!gameOver)
    {
      // Player1 Move
      if (selection1 == 'Y' || selection1 == 'y')
      {
        System.out.println("Player1 moves.");
      }
      if (selection1 == 'N' || selection1 == 'n')
      {
        System.out.println("Player1's turn, make a move.");
      }
      s += player1.getMove(s);
      System.out.println("Player1's move:\"" + s + "\"");
      if (dictionary.contains(s))
      {
        System.out.println("\"" + s + "\"" + " is a word; Player"
            + player1.number + " loses");
        gameOver = true;
        System.exit(0);
      }
      else if (!prefixes.contains(s))
      {
        System.out.println("\"" + s + "\"" + " is not a valid prefix; Player"
            + player1.number + " loses");
        gameOver = true;
        System.exit(0);
      }

      // Player2 Move
      if (selection2 == 'Y' || selection2 == 'y')
      {
        System.out.println("Player2 moves.");
      }
      if (selection2 == 'N' || selection2 == 'n')
      {
        System.out.println("Player2's turn, make a move.");
      }
      s += player2.getMove(s);
      System.out.println("player2's move: \"" + s + "\"");
      if (dictionary.contains(s))
      {
        System.out.println("\"" + s + "\"" + " is a word; Player"
            + player2.number + " loses");
        gameOver = true;
        System.exit(0);
      }
      else if (!prefixes.contains(s))
      {
        System.out.println("\"" + s + "\"" + " is not a valid prefix; Player"
            + player2.number + " loses");
        gameOver = true;
        System.exit(0);
      }
    }
  }
}
