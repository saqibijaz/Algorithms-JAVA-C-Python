

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/** Class BoyerMoore **/
public class Main
{
  public String pattern;
  int i, j, patternSize;
  int[] prefixArray;

  public Main (String pat)
  {
    pattern = pat;
    i = 1;
    j = 0;
    patternSize = pattern.length ();	//a variable to save pattern length
    prefixArray = new int[patternSize];
  }

  //an array to store prefix index values
  public void PrefixTable ()
  {
    while (i < patternSize)
      {
	while ((pattern.charAt (i) != pattern.charAt (j)) && (j > 0))
	  {
	    // if a first match is found but not the second
	    j = prefixArray[j - 1];
	  }

	if (pattern.charAt (i) == pattern.charAt (j))
	  {
	    //check if there is a match and check adjacents too
	    prefixArray[i] = j + 1;
	    i++;
	    j++;
	  }

	else
	  {			//in case of no match
	    prefixArray[i] = j;
	    i++;
	  }
      }
    for (int k = 0; k < prefixArray.length; ++k)
      {
	System.out.println ("Index " + k + " :" + prefixArray[k]);
      }
  }
  public static void main (String[]args) throws IOException
  {      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("PREFIX TABLE\n");

    System.out.println("\nEnter Pattern\n");
    String pattern = br.readLine();
    Main bm = new Main (pattern);
      bm.PrefixTable ();

  }

}
