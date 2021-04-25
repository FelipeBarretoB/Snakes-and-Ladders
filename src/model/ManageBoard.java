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
	
	public String getPrintInOrder() {
		return printInOrder;
	}


	public void setPrintInOrder(String printInOrder) {
		this.printInOrder = printInOrder;
	}


	public Score getRoot() {
		return root;
	}


	public void setRoot(Score root) {
		this.root = root;
	}


	public Space getEnd() {
		return end;
	}


	public void setEnd(Space end) {
		this.end = end;
	}


	public String getPrint() {
		return print;
	}


	public void setPrint(String print) {
		this.print = print;
	}


	public int getAscii() {
		return ascii;
	}


	public void setAscii(int ascii) {
		this.ascii = ascii;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public int getS() {
		return s;
	}


	public void setS(int s) {
		this.s = s;
	}


	public int getE() {
		return e;
	}


	public void setE(int e) {
		this.e = e;
	}


	public String getK() {
		return k;
	}


	public void setK(String k) {
		this.k = k;
	}


	public ManageBoard() {
		ascii=65;	
		root= new Score(null,null,null,0, 'a');
	}

	public int getNumOfLadders() {
		return numOfLadders;
	}


	public void setNumOfLadders(int numOfLadders) {
		this.numOfLadders = numOfLadders;
	}
	
	public Players getPlayers() {
		return players;
	}

	public void setPlayers(Players players) {
		this.players = players;
	}

	

	public void createBoard(int n, int m, int s, int e,String players) {
		this.n=n;
		this.m=m;
		this.s=s;
		this.e=e;
		if((int)players.charAt(0) >= 48 && (int)players.charAt(0) <= 57){
			this.players = new Players(Integer.parseInt(players));
		}else {
			this.players = new Players(players.length(), players);
		}//3 3 1 1 #%
		
		System.out.println("players"+this.players.stringPlayers());
		print="";
		ascii=65;
		numOfLadders=1;
		int dim=n*m;
		end = new Space( null,  null,  null,  null,  dim,  null);
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		createSnakes(s);
		createLadders(e);
		//System.out.println(end.getRight().getRight().getDown().getSpace());
		//print(dim+1, m, n, end, m-1, false);
		connectNeighbours(dim+1, m, end, m-1, false);
		connectUpAndDown(dim+1, n,m, end, m, m, n, false);
		organizePlayerInSpaces();
		
	}

	public String printString() {
		return printString( n*m,  print, m,  n,  m,  n, false);
	}

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

	/*
	private void print(int dim, int m, int n, Space next, int c, boolean side) {
		if(dim!=0) {
			System.out.println(c);
			if(c!=0) {
				if(next.getRight()!=null && !side){
					dim--;
					c--;
					System.out.println(next.getSpace()+" a "+next.getRight().getSpace());
					print( dim,  m,  n,  next.getRight(), c, side);
				}
				if(next.getLeft()!=null && side){
					dim--;
					c--;
					System.out.println(next.getSpace()+" a "+next.getLeft().getSpace());
					print=next.getLeft().getSpace()+" "+print;
					print( dim,  m,  n,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()!=null){
					dim--;
					System.out.println(next.getSpace()+" a "+next.getDown().getSpace());
					print+="\n"+next.getDown().getSpace();
					print( dim,  m,  n,  next.getDown(), c, side);
				}
			}

		}
	}
	*/
	public void createLadders(int numOfLadders) {
		if(numOfLadders!=0) {
			createLadders(m*n,  m,  n,  end,  true, 0);
			createLadders(numOfLadders-1);
		}
	}

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

	public void createSnakes(int numOfSnakes) {
		if(numOfSnakes!=0) {
			createSnakes(m*n, m, n, end, false, 0);
			createSnakes(numOfSnakes-1);
		}
	}

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
	
	private int findSpaceFoSnake(int space, int dim, int m, int n) {
		if(space<=m*n && space>dim-m && dim!=0) {
			return dim-m;
		}else {
			n--;
			return findSpaceFoSnake(space, m*n, m, n);
		}
	}
	
	private int findSpaceFoLadder(int space, int dim, int m, int n) {
		if(space<=m*n && space>dim-m) {
			return dim;
		}else {
			n++;
			return findSpaceFoLadder(space, m*n, m, n);
		}
	}

	public String actionPlayers() {
		movePlayersByOrder();
		if(confirmVictory() > -1) {
			addValuesToRoot(winner.getIcon(), (winner.getTimesMoved())*(m*n), root);
			printInOrder="";
			inOrderScore(root);
			return "Juego terminado, ganador: "+winner.getIcon()+ "\n" + printBoardInGame();
			
		}
		organizePlayerInSpaces();
		return printBoardInGame();
	}
	public int confirmVictory() {
		int x = getPlayerSpace(players.getSize()-1);
		return x;
	}
	
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
	
	private void movePlayersByOrder() {
		int x = getPlayerOnTurn(players.getSize()-1);
		players.get(x).setTurn(false);
		players.get(x).getNext().setTurn(true);	
		movePlayer(players.get(x));
	}
	
	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}
	
	public void movePlayer(Player p) {
		int x = rollDie();
		System.out.println(x);
		p.addDiceScores(x);
		p.setTimesMoved(p.getTimesMoved()+1);
		p.setInSpace(p.getInSpace() + x);
		System.out.println("moves "+p.getTimesMoved());
	}
	
	private int getPlayerOnTurn(int i) {
		int x = -1;
		if(players.get(i).isTurn()) {
			x = i;
		}else {
			x = getPlayerOnTurn(i-1);
		}
		return x;
	}
	
	public String printBoardInGame() {
		print = "";
		return printBoardInGame( n*m,  print, m,  n,  m,  n, false);
	}//3 3 1 1 #%
	
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
	
	
	private void organizePlayerInSpaces() {
		int x = players.getSize();
		clearPlayersInSpaces(m*n);
		setPlayerInSpace(x-1);
	}
	
	private void setPlayerInSpace(int i) {
		
		if(i != -1) {
			setPlayerInSpace(players.get(i).getIcon(),players.get(i).getInSpace(), i);
			i--;
			setPlayerInSpace(i);
		}
	}
	
	private void setPlayerInSpace(char icon, int spaceNum, int i) {
		Space s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
		s.addPlayerIn(icon);
		if(s.getSpecial() != null) {
			try {
				Integer.parseInt(s.getSpecial());
				String ladder = s.getSpecial();
				if(findMatchingLadder(spaceNum +1, ladder) != null) {
					clearPlayersInSpaces(m*n);
					findMatchingLadder(spaceNum +1, ladder).addPlayerIn(icon);
					players.get(i).setInSpace(findMatchingLadder(spaceNum +1, ladder).getSpace());
				}
			}catch(NumberFormatException ne){
				String snake = s.getSpecial();
				if(findMatchingSnake(spaceNum-1, snake) != null) {
					clearPlayersInSpaces(m*n);
					findMatchingSnake(spaceNum-1, snake).addPlayerIn(icon);
					players.get(i).setInSpace(findMatchingLadder(spaceNum +1, snake).getSpace());
				}
			}
		}/*else {
			s.addPlayerIn(icon);
		}*/
	}
	
	private Space findMatchingLadder(int spaceNum, String ladder) {
		if(spaceNum <= m*n) {
			Space s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
			if(s.getSpecial() != null && s.getSpecial().equals(ladder)) {
				return s;
			}else {
				return findMatchingLadder((spaceNum+1), ladder);
			}
		}else {
			return null;
		}
	}
	
	private Space findMatchingSnake(int spaceNum, String snake) {
		if(spaceNum > 0) {
			Space s = getByDim(spaceNum, m*n, m, n, end, m-1, false);
			if(s.getSpecial() != null && s.getSpecial().equals(snake)) {
				return s;
			}else {
				return findMatchingSnake((spaceNum-1), snake);
			}
		}else {
			return null;
		}
	}
	
	private void clearPlayersInSpaces(int dim) {
		if(dim > 0) {
			getByDim(dim, m*n, m, n, end, m-1, false).setPlayersIn("");
			dim--;
			clearPlayersInSpaces(dim);
		}
		
	}
	
	/*private void setPlayerInSpace(Space s, int dim) {
		String positions = "";
		for(int i = dim; i >= 1; i--) {
			if(s.getSpace()==players.get(i).getInSpace()) {
				s.addPlayerIn(players.get(i).getIcon());
			}else {
				setPlayerInSpace(s, dim);
			}
		}
		
	}*/
	
	/*private String findPlayer(int space, Player p) {
		System.out.println(players.getFirst().getIcon() + " " + p.getIcon());
		System.out.println(playersInSpace);
		if(p.getInSpace() == space) {
				if(!playersInSpace.equals("")) {
					if(p.getIcon() != playersInSpace.charAt(0)) {
						System.out.println("ans: " + playersInSpace);
						playersInSpace += p.getIcon();
						p = p.getNext();
						findPlayer(space, p);
					}else {
						return playersInSpace;
					}
				}else {
					System.out.println("ans: " + playersInSpace);
					playersInSpace += p.getIcon();
					p = p.getNext();
					findPlayer(space, p);
				}
		}else {
			if(!playersInSpace.equals("")) {
				p = p.getNext();
				findPlayer(space, p);
			}else if(p.getIcon() == players.getFirst().getIcon()) {
				return playersInSpace;
			}
			
		}
		return playersInSpace;
	}3 3 1 1 #%
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


	private void connectNeighbours(int dim,int m, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()!=null && !side){
					dim--;
					c--;
					next.getRight().setLeft(next);
					connectNeighbours( dim,  m,  next.getRight(), c, side);
				}
				if(next.getLeft()!=null && side){
					dim--;
					c--;
					next.getLeft().setRight(next);

					connectNeighbours( dim,  m,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()!=null){
					dim--;
					next.getDown().setUp(next);

					connectNeighbours( dim,   m,  next.getDown(), c, side);
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

	//x representa la cantidad de filas
	//c representa la cantidad de columnas y se usa para avasar en la fila superior
	//z se usa para retroceder en la fila inferior 
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
	
	public void addValuesToRoot(char icon, int score, Score root) {
		if(root.getScore()==0) {
			System.out.println("pimer if");
			root.setScore(score);
			root.setPlayer(icon);
		}else if (root.getScore() >score){
			System.out.println("segundo if");
			if(root.getRight() == null) {
				root.setRight(new Score(root,null,null,0,'a'));
				addValuesToRoot(icon, score, root.getRight());
			}else {
				addValuesToRoot(icon, score, root.getRight());
			}
		}else {
			System.out.println("tercero if");
			if(root.getLeft()==null) {
				root.setLeft(new Score(root, null, null, 0, 'a'));
				addValuesToRoot(icon, score, root.getLeft());
			}else {
				addValuesToRoot(icon, score, root.getLeft());
			}
		}
	}


	public void inOrderScore(Score root) {
		if(root!=null) {
			System.out.println("pasa");
			inOrderScore(root.getRight());
			
			printInOrder+= root.getPlayer() + " "+ root.getScore()+"\n";
			
			inOrderScore(root.getLeft());
		}
	}
	int c=0;
	 void printInorder(Score node){
		 System.out.println(c++);
	        if (node == null) {
	            return;
	        }
	 
	        /* first recur on left child */
	        printInorder(node.getRight());
	 
	        /* then print the data of node */
	       printInOrder+= node.getPlayer() + " "+ node.getScore()+"\n";
	 
	        /* now recur on right child */
	        printInorder(node.getLeft());
	    }
}

