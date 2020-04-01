
#include iostream
#include string
using namespace std;

/* cases when all characters of pattern are different */
void NaiveAlgoOptimized(string patternToCheck, string Text)
{
    int PatternLength = patternToCheck.size();
    int TextLength = Text.size();
    int TextIterator = 0;
    while (TextIterator <= TextLength - PatternLength)
    {
        int PatternMatch;
        for (PatternMatch = 0; PatternMatch < PatternLength; PatternMatch++)
        { //inner loop to check if the match is found
            if (Text[TextIterator + PatternMatch] != patternToCheck[PatternMatch])
            {
                break;
            }
        }
        if (PatternMatch == 0) //the first index is mis match
        {
            TextIterator = TextIterator + 1;
        }
        else if (PatternMatch == PatternLength) //if the match from the loop is found
        {
            cout << "Pattern found at index " << TextIterator << endl;
            TextIterator = TextIterator + PatternLength; //moving window same as PatternMatch
        }

        else
        {
            TextIterator = TextIterator + PatternMatch; //since all characters are different so its okay to slide the window by PatternMatch
        }
    }
}
//
int main()
{
    string Text = "ABCEABCDABCEABCD";
    string patternToCheck = "ABCD";
    NaiveAlgoOptimized(patternToCheck, Text);
    return 0;
}
