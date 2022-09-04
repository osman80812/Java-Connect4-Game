Bilal Osman - osman353
Hamza Gelle - gelle107
Contributions:
Bilal has done the board.java and the searching algorithms for the board.
Hamza has done the most of the game.java and the commenting

To run the program, you simply run it using the play button on the code or by using the terminal. During the
program, it will ask the user to input numbers or regular responses.

There are no assumptions.

There are some things that were different than how the rubric intended it. First, there are tow drop and four
checking functions. From what I could tell from the rubric it seemed only one of each function of the drop and check
was needed. I had a checker function that returned a number in case the AI needed to block the user from winning.
I had two of those for the normal and expert mode. Similarly there is a connect winner function for both modes
as well as two drop functions. I thought by separating similar algorithms it would make it easier to understand
for me to code.

There might be a bug in the system where there could be some out of bound issues when checking for a row
of characters in the board. However, I think I have fixed all of those issues on the code.

There were a few outside resources used:
1. https://ssaurel.medium.com/creating-a-connect-four-game-in-java-f45356f1d6ba
- this site was used to get the general idea of how a connect4 algorithm in java might be coded
2. https://gist.github.com/jonathan-irvin/97537512eb65a8bbcb9a
- this site was used to better understand how to sort through locations of the board(or 2D arrays) to find
the same characters in a row; specifically the upward and downward diagonal search.
