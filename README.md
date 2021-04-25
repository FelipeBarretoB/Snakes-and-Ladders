# Snakes-and-Ladders
This project is a creation of the snakes and ladders board game with out using any loops or arrays of any kind. The idea was to use recursion and linked list. This includes the board (A matrix of linked class) and a binary tree. 

The ladders are represented by numbers.

The Snakes are represented by capital letters.

The project has no GUI, the console displays three options.

1 play

2 show scores (only works after one game)

0 That closes the program.

If you press 1, then it asks for the game input, this consist of a String in the form of n: the number of rows, m: the number of columns, s: the number of snakes, e: the number of ladders, and a String of the players icon. For example, the input of a game with 2 players, 1 ladder, 2 snakes, and a board with the dimensions of 5 x 5 would look like: 5 5 2 1 $%. Bear in mind that if you ask for a number of snakes and ladders that is bigger dan the dimensions of the board, the input won’t be accepted, for example: 5 5 7 6 %$, this wont fit because every ladder and snake requires 2 spaces, and there can’t be a snake on the last tile, and there cant be any ladder on tile 1.
