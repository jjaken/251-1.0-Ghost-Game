import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public abstract class Player
{
  public int number;

  Player(int x)
  {
    number = x;
  }

  public char getMove(String s)
  {
    Scanner keyScanner = new Scanner(System.in);
    return keyScanner.nextLine().charAt(0);
  }
}

class Human extends Player
{
  Human(int x)
  {
    super(x);
    // TODO Auto-generated constructor stub
  }

  public char getMove()
  {
    Scanner keyScanner = new Scanner(System.in);
    return keyScanner.nextLine().charAt(0);
  }
}

class Computer extends Player
{
  Collection<String> dictionary;
  Collection<String> prefixes;
  private Random rand = new Random();
  private char move;
  private boolean isValidMove;
  private char[] alpha =
  { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
      'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

  Computer(int x, Collection<String> d, Collection<String> p)
  {
    super(x);
    // TODO Auto-generated constructor stub

    dictionary = d;
    prefixes = p;
  }

  private boolean validMovePossible(String s, char[] a)
  {
    char m;
    for (int i = 0; i < 26; i++)
    {
      m = a[i];
      if (!dictionary.contains(s + m) && prefixes.contains(s + m))
      {
        return true;
      }
      else return false;
    }
    return true;
  }
  
  public char getMove(String s)
  {
    isValidMove = false;
    while (!isValidMove)
    {
      if (validMovePossible(s, alpha))
      {
        move = alpha[rand.nextInt(26)];
        if (!dictionary.contains(s + move) && prefixes.contains(s + move))
        {
          isValidMove = true;
          System.out.println("\"" + s + move
              + "\" is not in the dictionary and is a prefix, good move.");
        }
      }
      else
      {
        move = alpha[rand.nextInt(26)];
        if (dictionary.contains(s + move))
        {
          isValidMove = true;
        }
      }
    }
    
    return move;
  }

}
