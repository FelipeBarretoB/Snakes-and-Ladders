package model;

import java.util.Random;

public class ManageBoard {

	//The end of the board
	private Space end;
	//The print for the board
	private String print;
	//The letter for the snakes
	private int ascii;
	//The number of ladders
	private int numOfLadders;
	//The lines of the board
	private int n;
	//The columns of the board
	private int m;
	//Number of snakes in the board
	private int s;
	//Number of ladders in the board
	private int e;
	//The players in the game
	private String k;
	//players
	private Players players;
	//The root of the binary tree
	private Score root;
	//Prints the binary tree in order
	private String printInOrder;
	// The winner
	private Player winner;
	
	/**
	*The method returns the value of printInOrder <br>
    *<b>pre: The creation of printInOrder </b> 
	*<b>post: Returns the value of printInOrder </b>
	*@return String, the value of printInOrder
	*/
	public String getPrintInOrder() {
		return printInOrder;
	}

	/**
	*The method gives a new value to the field:printInOrder <br>
    *<b>pre: The creation of printInOrder </b> 
	*<b>post: Changes the value of printInOrder </b>
	*@param printInOrder, the new value for the field: printInOrder
	*/
	public void setPrintInOrder(String printInOrder) {
		this.printInOrder = printInOrder;
	}

	/**
	*The method returns the value of root <br>
    *<b>pre: The creation of root </b> 
	*<b>post: Returns the value of root </b>
	*@return Score, the value of root
	*/
	public Score getRoot() {
		return root;
	}

	/**
	*The method gives a new value to the field:root <br>
    *<b>pre: The creation of root </b> 
	*<b>post: Changes the value of root </b>
	*@param root, the new value for the field: root
	*/
	public void setRoot(Score root) {
		this.root = root;
	}

	/**
	*The method returns the value of end <br>
    *<b>pre: The creation of end </b> 
	*<b>post: Returns the value of end </b>
	*@return Space, the value of end
	*/
	public Space getEnd() {
		return end;
	}


	/**
	*The method gives a new value to the field: end <br>
    *<b>pre: The creation of end </b> 
	*<b>post: Changes the value of end </b>
	*@param end, the new value for the field: end
	*/
	public void setEnd(Space end) {
		this.end = end;
	}

	/**
	*The method returns the value of print <br>
    *<b>pre: The creation of print </b> 
	*<b>post: Returns the value of print </b>
	*@return String, the value of print
	*/
	public String getPrint() {
		return print;
	}

	/**
	*The method gives a new value to the field: print <br>
    *<b>pre: The creation of print </b> 
	*<b>post: Changes the value of print </b>
	*@param print, the new value for the field: print
	*/
	public void setPrint(String print) {
		this.print = print;
	}

	/**
	*The method returns the value of ascii <br>
    *<b>pre: The creation of ascii </b> 
	*<b>post: Returns the value of ascii </b>
	*@return int, the value of ascii
	*/
	public int getAscii() {
		return ascii;
	}

	/**
	*The method gives a new value to the field: ascii <br>
    *<b>pre: The creation of ascii </b> 
	*<b>post: Changes the value of ascii </b>
	*@param ascii, the new value for the field: ascii
	*/
	public void setAscii(int ascii) {
		this.ascii = ascii;
	}

	/**
	*The method returns the value of n <br>
    *<b>pre: The creation of n </b> 
	*<b>post: Returns the value of n </b>
	*@return int, the value of n
	*/
	public int getN() {
		return n;
	}

	/**
	*The method gives a new value to the field: n <br>
    *<b>pre: The creation of n </b> 
	*<b>post: Changes the value of n </b>
	*@param n, the new value for the field: n
	*/
	public void setN(int n) {
		this.n = n;
	}

	/**
	*The method returns the value of m <br>
    *<b>pre: The creation of m </b> 
	*<b>post: Returns the value of m </b>
	*@return int, the value of m
	*/
	public int getM() {
		return m;
	}

	/**
	*The method gives a new value to the field: m <br>
    *<b>pre: The creation of m </b> 
	*<b>post: Changes the value of m </b>
	*@param m, the new value for the field: m
	*/
	public void setM(int m) {
		this.m = m;
	}

	/**
	*The method returns the value of s <br>
    *<b>pre: The creation of s </b> 
	*<b>post: Returns the value of s </b>
	*@return int, the value of s
	*/
	public int getS() {
		return s;
	}

	/**
	*The method gives a new value to the field: s <br>
    *<b>pre: The creation of s </b> 
	*<b>post: Changes the value of s </b>
	*@param s, the new value for the field: s
	*/
	public void setS(int s) {
		this.s = s;
	}

	/**
	*The method returns the value of e <br>
    *<b>pre: The creation of e </b> 
	*<b>post: Returns the value of e </b>
	*@return int, the value of e
	*/
	public int getE() {
		return e;
	}

	/**
	*The method gives a new value to the field: e <br>
    *<b>pre: The creation of e </b> 
	*<b>post: Changes the value of e </b>
	*@param e, the new value for the field: e
	*/
	public void setE(int e) {
		this.e = e;
	}

	/**
	*The method returns the value of k <br>
    *<b>pre: The creation of k </b> 
	*<b>post: Returns the value of k </b>
	*@return String, the value of k
	*/
	public String getK() {
		return k;
	}

	/**
	*The method gives a new value to the field: k <br>
    *<b>pre: The creation of k </b> 
	*<b>post: Changes the value of k </b>
	*@param k, the new value for the field: k
	*/
	public void setK(String k) {
		this.k = k;
	}

	/**
	*The constructor of the class ManageBoard <br>
    *<b>pre: The creation of ascii and root</b> 
	*<b>post: gives a value to ascii and root </b>
	*/
	public ManageBoard() {
		ascii=65;	
		root= new Score(null,null,null,0, 'a');
	}
	
	/**
	*The method returns the value of numOfLadders <br>
    *<b>pre: The creation of numOfLadders </b> 
	*<b>post: Returns the value of numOfLadders </b>
	*@return int, the value of numOfLadders
	*/
	public int getNumOfLadders() {
		return numOfLadders;
	}

	/**
	*The method gives a new value to the field: numOfLadders <br>
    *<b>pre: The creation of numOfLadders </b> 
	*<b>post: Changes the value of numOfLadders </b>
	*@param numOfLadders, the new value for the field: numOfLadders
	*/
	public void setNumOfLadders(int numOfLadders) {
		this.numOfLadders = numOfLadders;
	}
	
	/**
	*The method returns the value of players <br>
    *<b>pre: The creation of players </b> 
	*<b>post: Returns the value of players </b>
	*@return Players, the value of players
	*/
	public Players getPlayers() {
		return players;
	}
	/**
	*The method gives a new value to the field: players <br>
    *<b>pre: The creation of players </b> 
	*<b>post: Changes the value of players </b>
	*@param players, the new value for the field: players
	*/
	public void setPlayers(Players players) {
		this.players = players;
	}

	
	/**
	*The method creates the board for the game <br>
    *<b>pre: The creation of the methods: setBoard, createSnakes, createLadders, connectNeighBours, connectUpAndDown and organizePlayerInSpaces </b> 
	*<b>post: The creation of a linked list that represents the board, with the players, snakes, and ladders on it </b>
	*@param n, the amount of rows the board has 
	*@param m, the amount of columns the board has
	*@param s, the amount of snakes on the board
	*@param e, the amount of ladders on the board
	*@param players, the players in the game 
	*/
	public void createBoard(int n, int m, int s, int e,String players) {
		this.n=n;
		this.m=m;
		this.s=s;
		this.e=e;
		if((int)players.charAt(0) >= 48 && (int)players.charAt(0) <= 57){
			this.players = new Players(Integer.parseInt(players));
		}else {
			this.players = new Players(players.length(), players);
		}
		print="";
		ascii=65;
		numOfLadders=1;
		int dim=n*m;
		end = new Space( null,  null,  null,  null,  dim,  null);
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		createSnakes(s);
		createLadders(e);
		connectNeighbors(dim+1, m, end, m-1, false);
		connectUpAndDown(dim+1, n,m, end, m, m, n, false);
		organizePlayerInSpaces();
		
	}
	
	/**
	*The method calls the private method printString and gives it the necessary parameters <br>
    *<b>pre: The creation of the private method printString and at least 1 use of the method createBoard </b> 
	*<b>post: Changes and returns the value of the String print </b>
	*@return String, the new value of print
	*/
	public String printString() {
		return printString( n*m,  print, m,  n,  m,  n, false);
	}

	/**
	*The method uses recursion to create the board for the game and connect the linked list <br>
    *<b>pre: At least 1 use of the method createBoard </b> 
	*<b>post: Creates the board game from the field end </b>
	*@param dim, the product of the dimensions of the game (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@param next, the object of Space to which the next Space will be added too
	*@param c, the amount of Space objects the method has to add per row (m-1)
	*@param side, the side the method has to add the Space objects too. If side is false, it adds the next Space object to the right, else, it adds it to the left
	*/
	private void setBoard(int dim, int m, int n, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()==null && !side){
					next.setRight(new Space(null,null,null,null,dim,null));
					dim--;
					c--;
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}else if(next.getRight()!=null && !side){
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}
				if(next.getLeft()==null && side){
					next.setLeft(new Space(null,null,null,null,dim,null));
					dim--;
					c--;
					setBoard( dim,  m,  n,  next.getLeft(), c, side);
				}else if(next.getLeft()!=null && side){
					setBoard( dim,  m,  n,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()==null){
					next.setDown(new Space(null,null,null,null,dim,null));
					dim--;
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}else if(next.getDown()!=null){
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}
			}

		}
	}

	/**
	*The method uses recursion to call the private method createLadders and then call itself, this creates the ladders on the board<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the private method createLadders </b> 
	*<b>post: Adds the ladders in the Space objects of the board </b>
	*@param numOfLadders, the number of ladders it has to add to the board, in the first recursion this value is equal to the field e
	*/
	public void createLadders(int numOfLadders) {
		if(numOfLadders!=0) {
			createLadders(m*n,  m,  n,  end,  true, 0);
			createLadders(numOfLadders-1);
		}
	}
	/**
	*The adds a ladders from to beginning to end<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the methods, getByDim and getRandomDim </b> 
	*<b>post: Adds the two ends of a ladder to the board </b>
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@param next, the end of the board ( the field end)
	*@param side, is used in the method getRandomDim to signify it that it's looking for a space for a ladder
	*@param spaceForLadder, the potential space for the start of the ladders
	*/
	private void createLadders(int dim, int m, int n, Space next,  boolean side, int spaceForLadder) {
		Random random = new Random();
		spaceForLadder=random.nextInt(m*n - 1 + n) + 1;
		if(spaceForLadder>m*(n-1) || spaceForLadder>(dim-m) || spaceForLadder==1) {
			createLadders(dim,  m,  n,  next,    side,  spaceForLadder);
		}else {
			if(getByDim(spaceForLadder, dim, m, n, next, m-1, false).getSpecial()==null) {
				getByDim(spaceForLadder, dim, m, n, next, m-1, false).setSpecial(""+numOfLadders);
				getByDim(getRandomDim(dim, m, n, side , spaceForLadder), dim, m, spaceForLadder, next, m-1, false).setSpecial(""+numOfLadders);
				numOfLadders++;
			}else {
				createLadders(dim, m, n, next, side, spaceForLadder);
			}
		}
	}

	/**
	*The method uses recursion to call the private method createSnakes and then call itself, this creates the snakes on the board<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the private method createSnakes </b> 
	*<b>post: Adds the snakes in the Space objects of the board </b>
	*@param numOfSnakes, the number of snakes it has to add to the board, in the first recursion this value is equal to the field s
	*/
	public void createSnakes(int numOfSnakes) {
		if(numOfSnakes!=0) {
			createSnakes(m*n, m, n, end, false, 0);
			createSnakes(numOfSnakes-1);
		}
	}

	/**
	*The adds a snakes from to beginning to end<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the methods, getByDim and getRandomDim </b> 
	*<b>post: Adds the two ends of a snake to the board </b>
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@param next, the end of the board (the field end)
	*@param side, is used in the method getRandomDim to signify it that it's looking for a space for a ladder
	*@param spaceForSnake, the potential space for the start of the snake
	*/
	private void createSnakes(int dim, int m, int n, Space next, boolean side, int spaceForSnake) {
		Random random = new Random();
		spaceForSnake=random.nextInt(m*n - 1 + n) + 1;
		if(spaceForSnake>=m*n || spaceForSnake<m+1 || spaceForSnake<0) {
			createSnakes(dim, m, n, next,  side, spaceForSnake);
		}else {
			if(getByDim(spaceForSnake, dim, m, n, next, m-1, side).getSpecial()==null) {
				getByDim(spaceForSnake, dim, m, n, next, m-1, side).setSpecial(new Character((char)ascii).toString());
				getByDim(getRandomDim(dim, m, n, false, spaceForSnake), dim, m, spaceForSnake, next, m-1, side).setSpecial(new Character((char)ascii).toString());
				ascii++;
			}else {
				createSnakes(spaceForSnake, m, n, next, side, spaceForSnake);
			}
		}
	}

	
	/**
	*The method returns a suitable space for the end of a ladder or snake, depending of the value of snakeOrLadder<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the methods, findSpaceFoSnake, getByDim, findSpaceFoLadder  </b> 
	*<b>post: returns a suitable space for the end of a snake or ladder </b>
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@param next, the end of the board (the field end)
	*@param snakeOrLadder, if the method receives true, it will look for a space for the end of a ladder, else, it will look for the space for the tail of a snake
	*@param space, the place that the first part of the snake or ladder is
	*@return int, the space for the second part of the snake or ladder 
	*/
	private int getRandomDim( int dim, int m, int n, boolean snakeOrLadder, int space) {
		Random random = new Random();
		int x=random.nextInt(m*n - 1 + n) + 1;
		if(!snakeOrLadder) {
			if( x>0 && x<findSpaceFoSnake(space, m*n, m, n) && getByDim(x, m*n, m, n, end, m-1, false).getSpecial()==null) {
				return x;
			}else {
				return getRandomDim(dim, m, n, snakeOrLadder, space);
			}
		}else {
			if( x<=dim && x>findSpaceFoLadder( space,  m*1,  m,  1)&& getByDim(x, m*n, m, n, end, m-1, false).getSpecial()==null) {
				return x;
			}else {
				return getRandomDim(dim, m, n, snakeOrLadder,space);
			}
		}
	}
	
	/**
	*The method returns the spaces from where the second part of the snake can be added<br>
    *<b>pre: At least 1 use of the method createBoard </b> 
	*<b>post: returns a number, in any space smaller than this the second part of the snake can be added </b>
	*@param space, the place that the first part of the snake is
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@return int, the number that the second part of the snake has to be smaller
	*/
	private int findSpaceFoSnake(int space, int dim, int m, int n) {
		if(space<=m*n && space>dim-m && dim!=0) {
			return dim-m;
		}else {
			n--;
			return findSpaceFoSnake(space, m*n, m, n);
		}
	}
	
	/**
	*The method returns the spaces from where the second part of the ladder can be added<br>
    *<b>pre: At least 1 use of the method createBoard </b> 
	*<b>post: returns a number, in any space bigger than this the second part of the ladder can be added </b>
	*@param space, the place that the first part of the ladder is
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@return int, the number that the second part of the ladder has to be bigger
	*/
	private int findSpaceFoLadder(int space, int dim, int m, int n) {
		if(space<=m*n && space>dim-m) {
			return dim;
		}else {
			n++;
			return findSpaceFoLadder(space, m*n, m, n);
		}
	}

	/**
	*The method returns the string with the updated board with players<br>
    *<b>pre: the user has to make a line jump </b> 
	*<b>post: returns the board with the moved players by the dice </b>
	*@return String, the updated board
	*/
	public String actionPlayers() {
		movePlayersByOrder();
		organizePlayerInSpaces();
		if(confirmVictory() > -1) {
			addValuesToRoot(winner.getIcon(), (winner.getTimesMoved())*(m*n), root);
			printInOrder="";
			inOrderScore(root);
			return "Juego terminado, ganador: "+players.get(confirmVictory()).getIcon()+ "\n" + printBoardInGame();
			
		}
		return printBoardInGame();
	}
	
	/**
	*The method calls another to check if a player is in the n*m space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: returns the position of the winner or -1 if there's no winer yet </b>
	*@return int, the position of the winner
	*/
	public int confirmVictory() {
		int x = getPlayerSpace(players.getSize()-1);
		return x;
	}
	/**
	*The method checks if player is in the n*m space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: returns the position of the winner or -1 if there's no winer yet</b>
	*@return int, the position of the winner
	*/
	private int getPlayerSpace(int i) {
		int x = -1;
		if(i > -1) {
			if(players.get(i).getInSpace() >= n*m) {
				winner=players.get(i);
				x = i;
				
			}else {
				x = getPlayerSpace(i-1);
			}
		}
			
		return x;
	}
	/**
	*The method moves the player on turn to their corresponding space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: updates the space of the players</b>
	*/
	private void movePlayersByOrder() {
		int x = getPlayerOnTurn(players.getSize()-1);
		players.get(x).setTurn(false);
		players.get(x).getNext().setTurn(true);	
		movePlayer(players.get(x));
	}
	
	/**
	*The method simulates a dice by returning a random number from 1 to 6 <br>
	*@return int, a number from 1 to 6
	*/
	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}
	/**
	*The method moves a player to their corresponding space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: updates the space of the player following the number of the dice </b>
	*@param p, the player that is going to move
	*/
	public void movePlayer(Player p) {
		int x = rollDie();
		p.setTimesMoved(p.getTimesMoved()+1);
		p.setInSpace(p.getInSpace() + x);
	}
	/**
	*The method moves the players to their corresponding space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: returns the position of the player on turn</b>
	*@param int, the amount of players
	*@return int, the position of the player on turn
	*/
	private int getPlayerOnTurn(int i) {
		int x = -1;
		if(players.get(i).isTurn()) {
			x = i;
		}else {
			x = getPlayerOnTurn(i-1);
		}
		return x;
	}
	
	/**
	*The method to another that gets the string of the board<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: gets the updated board</b>
	*@return String, the updated board
	*/
	public String printBoardInGame() {
		print = "";
		return printBoardInGame( n*m,  print, m,  n,  m,  n, false);
	}//3 3 1 1 #%
	
	/**
	*The method gets every spacer and concatenates in a string the board<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: returns the updated board</b>
	*@return String, the updated board
	*/
	private String printBoardInGame(int dim, String print,int m, int n, int c, int x,boolean side) {
		if(x!=0) {
			if(c!=0) {
				if(!side) {
					if(dim>=10) {
						print+="["+getByDim(dim, m*n, m, n, end, m-1, false).getPlayersIn();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim--;
						return printBoardInGame(dim, print, m, n, c,x,side);
					}else {
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getPlayersIn();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim--;
						return printBoardInGame(dim, print, m, n, c,x,side);
					}
				}else {
					if(dim>=10) {
						print+="["+getByDim(dim, m*n, m, n, end, m-1, false).getPlayersIn();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim++;
						return printBoardInGame(dim, print, m, n, c,x,side);
					}else {
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getPlayersIn();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim++;
						return printBoardInGame(dim, print, m, n, c,x,side);
					}
				}

			}else {
				if(side) {
					dim--;
				}else {
					dim++;
				}
				dim=dim-(m);
				side=!side;
				c=m;
				print+="\n";
				x--;
				return printBoardInGame(dim, print, m, n, c,x,side);
			}

		}
		return print;
	}//3 3 1 1 #%
	
	/**
	*The method calls another methods, one to clear the last turn and another to organize the new turn<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: put the players in their corresponding spaces</b>
	*/
	private void organizePlayerInSpaces() {
		int x = players.getSize();
		clearPlayersInSpaces(m*n);
		setPlayerInSpace(x-1);
	}
	/**
	*The method organizes the new turn<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: put the players in their corresponding spaces</b>
	*@param int, the size of the players
	*/
	private void setPlayerInSpace(int i) {
		if(i != -1) {
			setPlayerInSpace(players.get(i));
			i--;
			setPlayerInSpace(i);
		}
	}
	/**
	*The method updates the player in a space, also checks if there's a snake or a
	* ladder to add the player to the corresponding space<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: put the players in their corresponding spaces</b>
	*@param Player, the one that is gonna be added to a Space
	*/
	private void setPlayerInSpace(Player p) {
		char icon = p.getIcon();
		int spaceNum = p.getInSpace();
		if(spaceNum <= m*n) {
			Space s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
			if(s.getSpecial() != null) {
				try {
					Integer.parseInt(s.getSpecial());
					String ladder = s.getSpecial();
					if(findMatchingLadder(spaceNum +1, ladder) != null) {
						//clearPlayer(p);
						findMatchingLadder(spaceNum +1, ladder).addPlayerIn(icon);
						p.setInSpace(findMatchingLadder(spaceNum +1, ladder).getSpace());
					}else {
						s.addPlayerIn(icon);
					}
				}catch(NumberFormatException ne){
					String snake = s.getSpecial();
					if(findMatchingSnake(spaceNum-1, snake) != null) {
						findMatchingSnake(spaceNum-1, snake).addPlayerIn(icon);
						p.setInSpace(findMatchingLadder(spaceNum -1, snake).getSpace());
					}else {
						s.addPlayerIn(icon);
					}
				}//3 3 1 1 #%
			}else {
				s.addPlayerIn(icon);
			}
		}else {
			p.setInSpace(n*m);
			setPlayerInSpace(p);
		}
		
	}
	/**
	*The method search a ladder next to it that matches with the one with the player<br>
    *<b>pre: a player has to fell in a ladder</b> 
	*<b>post: search the matching ladder</b>
	*@param String, the players ladder
	*@param spaceNum, the number of the Space that has the ladder
	*@return Space, the space that has the another ladder
	*/
	private Space findMatchingLadder(int spaceNum, String ladder) {
		Space s = null;
		if(spaceNum <= m*n) {
			s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
			if(s.getSpecial() != null && s.getSpecial().equals(ladder)) {
				return s;
			}else {
				return findMatchingLadder((spaceNum+1), ladder);
			}
		}else {
			
			return null;
		}
	}
	/**
	*The method search a snake previous to it that matches with the one with the player<br>
    *<b>pre: a player has to fell in a snake</b> 
	*<b>post: search the matching snake</b>
	*@param String, the players snake
	*@param spaceNum, the number of the Space that has the snake
	*@return Space, the space that has the another snake
	*/
	private Space findMatchingSnake(int spaceNum, String snake) {
		Space s = null;
		if(spaceNum > 0) {
			s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
			if(s.getSpecial() != null && s.getSpecial().equals(snake)) {
				return s;
			}else {
				return findMatchingSnake((spaceNum-1), snake);
			}
		}else {
			return null;
		}
	}
	/**
	*The method clears the players in the spaces<br>
    *<b>pre: the user has to make a line jump that call the method that calls this one</b> 
	*<b>post: clears the players in the spaces </b>
	*@param int, the dimensions of the board
	*/
	private void clearPlayersInSpaces(int dim) {
		if(dim > 0) {
			getByDim(dim, m*n, m, n, end, m-1, false).setPlayersIn("");
			dim--;
			clearPlayersInSpaces(dim);
		}
		
	}
	
	/**
	*The returns a String with the board<br>
    *<b>pre:  At least 1 use of the method createBoard</b> 
	*<b>post: returns a String with the board </b>
	*@return String, the game board with only snakes, ladders and numbers
	*/
	private String printString(int dim, String print,int m, int n, int c, int x,boolean side) {
		if(x!=0) {
			if(c!=0) {
				if(!side) {
					if(dim>=10) {				
						print+="["+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim--;
						return printString(dim, print, m, n, c,x,side);
					}else {
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();;
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim--;
						return printString(dim, print, m, n, c,x,side);
					}
				}else {
					if(dim>=10) {
						print+="["+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim++;
						return printString(dim, print, m, n, c,x,side);
					}else {
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();;
						if(getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()!=null) {
							print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpecial()+"] ";
						}else {
							print+=" ] ";
						}
						c--;
						dim++;
						return printString(dim, print, m, n, c,x,side);
					}
				}

			}else {
				if(side) {
					dim--;
				}else {
					dim++;
				}
				dim=dim-(m);
				side=!side;
				c=m;
				print+="\n";
				x--;
				return printString(dim, print, m, n, c,x,side);
			}

		}
		return print;
	}

	/**
	*The method connects the Space next with the Spaces to his right and left<br>
    *<b>pre: At least 1 use of the method create board</b> 
	*<b>post: Changes the board by adding new links between spaces</b>
	*@param dim, the product of the dimension of the board (m*n)
	*@param m, the amount of columns 
	*@param next, the Space object it will add to his neighbors
	*@param c,the amount of Space objects it has to check in each row (Starts at m-1)
	*@param side, dictates the side the method has to look for spaces, if side is false, it looks right, else, it looks left
	*/
	private void connectNeighbors(int dim,int m, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()!=null && !side){
					dim--;
					c--;
					next.getRight().setLeft(next);
					connectNeighbors( dim,  m,  next.getRight(), c, side);
				}
				if(next.getLeft()!=null && side){
					dim--;
					c--;
					next.getLeft().setRight(next);

					connectNeighbors( dim,  m,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()!=null){
					dim--;
					next.getDown().setUp(next);

					connectNeighbors( dim,   m,  next.getDown(), c, side);
				}
			}

		}
	}
	
	private Space getByDim(int find,int dim, int m, int n, Space next, int c, boolean side) {
		if(next.getSpace()!=find){
			if(dim!=0) {
				if(c!=0) {
					if(next!=null && !side){
						dim--;
						c--;
						return getByDim(find, dim,  m,  n,  next.getRight(), c, side);
					}
					if(next!=null && side){
						dim--;
						c--;
						return getByDim(find, dim,  m,  n,  next.getLeft(), c, side);
					}
				}else {
					side=!side;
					c=m-1;
					if(next!=null){
						dim--;
						return getByDim(find, dim,  m,  n,  next.getDown(), c, side);
					}
				}

			}
		}
		return next;

	}

	/**
	*The method connects the board of the game as if it was a matrix<br>
    *<b>pre: At least 1 use of the method createBoard, and the creation of the method getByDim </b> 
	*<b>post: connects all the objects of Space </b>
	*@param dim, the product of the dimensions of the board (m*n)
	*@param m, the columns of the board
	*@param n, the rows of the board
	*@param next, in this case, end, the start of the linked list
	*@param c, the amount of objects in a row the method has to join (m)
	*@param z, the amount of objects in a the next row the method has to join (m)
	*@param x, the amount of rows left to join (Starts as n)
	*/
	private void connectUpAndDown(int dim,int n,int m, Space next, int c,int z, int x, boolean side) {
		if(x!=1) {
			if(c!=0) {
				getByDim(dim-(c-1), m*n, m, n, next, m-1, side).setDown(getByDim(dim-z, m*n, m, n, next, m-1, side));
				getByDim(dim-z, m*n, m, n, next, m-1, side).setUp(getByDim(dim-(c-1), m*n, m, n, next, m-1, side));
				z++;
				c--;
				connectUpAndDown(dim, n, m, next, c, z, x, side);
			}else {
				dim=dim-m;
				x--;
				c=m;
				z=m;
				connectUpAndDown(dim, n, m, next, c, z, x, side);
			}
		}

	}
	
	/**
	*The adds a new value to the inverted binary tree<br>
    *<b>pre: the creation of the Class root</b> 
	*<b>post: Adds a new winner to the root try </b>
	*@param icon, the icon of the player that won
	*@param score, the score of the player that won
	*@param root, the start of the binary tree
	*/
	public void addValuesToRoot(char icon, int score, Score root) {
		if(root.getScore()==0) {
			root.setScore(score);
			root.setPlayer(icon);
		}else if (root.getScore() >score){
			if(root.getRight() == null) {
				root.setRight(new Score(root,null,null,0,'a'));
				addValuesToRoot(icon, score, root.getRight());
			}else {
				addValuesToRoot(icon, score, root.getRight());
			}
		}else {
			if(root.getLeft()==null) {
				root.setLeft(new Score(root, null, null, 0, 'a'));
				addValuesToRoot(icon, score, root.getLeft());
			}else {
				addValuesToRoot(icon, score, root.getLeft());
			}
		}
	}

	/**
	*The prints the values of the binary tree<br>
    *<b>pre: the creation of the Class root and field printInOrder</b> 
	*<b>post: Changes the value of printInOrder </b>
	*@param root, the start of the binary tree
	*/
	public void inOrderScore(Score root) {
		if(root!=null) {
			inOrderScore(root.getRight());
			
			printInOrder+= root.getPlayer() + " "+ root.getScore()+"\n";
			
			inOrderScore(root.getLeft());
		}
	}

}

