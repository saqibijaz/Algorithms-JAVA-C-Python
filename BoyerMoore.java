
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap; 
import java.util.Map; 

/** Class BoyerMoore **/
public class BoyerMoore {
    public HashMap<Character, Integer> mismatchShiftsTable = new HashMap<Character, Integer>();

    public void populateBadMatchTable(String Pattern) {
        int lenOfPattern = Pattern.length();
        for (int ind = 0; ind < lenOfPattern; ind++) {
            char underLight = Pattern.charAt(ind);
            int max = Math.max(1, lenOfPattern - ind - 1);
            this.mismatchShiftsTable.put(underLight, max);
        }
    }

    public int searchSubString(String Pattern, String Text) {
        populateBadMatchTable(Pattern);
        int numOfSkips = 0;
        for (int i = 0; i <= Text.length() - Pattern.length(); i += numOfSkips) {
            numOfSkips = 0;
            for (int j = Pattern.length() - 1; j >= 0; j--) {
                if (Pattern.charAt(j) != Text.charAt(i + j)) {
                    if (this.mismatchShiftsTable.get(Text.charAt(i + j)) != null) {
                        numOfSkips = this.mismatchShiftsTable.get(Text.charAt(i + j));
                        break;
                    } else {
                        numOfSkips = Pattern.length();
                        break;
                    }
                }
                if (numOfSkips == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Boyer Moore Algorithm Test\n");
        System.out.println("\nEnter Text\n");
        String text = br.readLine();
        System.out.println("\nEnter Pattern\n");
        String pattern = br.readLine();
        BoyerMoore bm = new BoyerMoore();
        int k=bm.searchSubString(pattern, text);
        System.out.println(k);
    }
}
