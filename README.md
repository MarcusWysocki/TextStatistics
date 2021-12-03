This api lets you calculate statistics of a .txt file. 

To run, simply download the project. Add the text file you want to test into the data folder and change the PATH variable in the Main.
Click run and it should be good!


--RULES--

1. Certain punctuation not included in letter count. <br />
    a. Symbols removed are ; : - " , . ? ! * { } [ ] < > + = <br />
    b. Although many symbols can be used to format numbers, they are more commonly used at the end of words
        where they should not be counted. <br />
    c. Slashes are rarely used with words and commonly used to format numbers. The example included them in the number,
        so they are included here. <br />
2. Formatted numbers include no symbols in the middle of the numbers save slashes.
3. Hyphens are not included in letter count.
4. Quotations are not included in letter count.
5. Strings of characters that are neither letters nor numbers are excluded.
6. Maximum word length is 45 as that is the longest word in the English language. Words that are greater are ignored.

Future considerations:
- Distinguishing between a formatted number (01/01/2000) a pure letter word (hello) or a mix of the two (Nintendo64).
    This would be to determine if number formatting symbols should be included or not.
