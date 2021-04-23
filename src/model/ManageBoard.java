package model;

import java.text.BreakIterator;
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

	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}

	public void createBoard(int n, int m, int s, int e,String players) {
		this.n=n;
		this.m=m;
		this.s=s;
		this.e=e;
		this.players = new Players(players.length(), players);
		print="";
		ascii=65;
		numOfLadders=1;
		int dim=n*m;
		end = new Space( "f",  null,  null,  null,  null,  dim,  null);
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		createSnakes(s);
		createLadders(e);
		connectNeighbours(dim+1, m, end, m-1, false);
		connectUpAndDown(dim+1, m,n, end, m, m, n, false);

		
		
	}

	public String printString() {
		return printString( n*m,  print, m,  n,  m,  n, false);
	}

	private void setBoard(int dim, int m, int n, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()==null && !side){
					next.setRight(new Space("f",null,null,null,null,dim,null));
					dim--;
					c--;
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}else if(next.getRight()!=null && !side){
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}
				if(next.getLeft()==null && side){
					next.setLeft(new Space("f",null,null,null,null,dim,null));
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
					next.setDown(new Space("f",null,null,null,null,dim,null));
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
					System.out.println(next.getLeft().getSpace());
					print=next.getLeft().getSpace()+" "+print;
					print( dim,  m,  n,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()!=null){
					dim--;
					System.out.println(next.getDown().getSpace());
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
		if(spaceForLadder>m*(n-1) || spaceForLadder>dim-m || spaceForLadder==1) {
			createLadders( dim,  m,  n,  next,    side,  spaceForLadder);
		}else {
			if(getByDim(spaceForLadder, dim, m, n, next, m-1, false).getSpecial()==null) {
				getByDim(spaceForLadder, dim, m, n, next, m-1, false).setSpecial(""+numOfLadders);
				getByDim(getRandomDim(dim, m, n, side , spaceForLadder), dim, m, spaceForLadder, next, m-1, false).setSpecial(""+numOfLadders);
				numOfLadders++;
			}else {
				createLadders(spaceForLadder, m, n, next, side, spaceForLadder);
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
			int f=findSpaceFoLadder( space,  m*1,  m,  1);
			if( x<=dim && x>findSpaceFoLadder( space,  m*1,  m,  1)&& getByDim(x, m*n, m, n, end, m-1, false).getSpecial()==null) {
				return x;
			}else {
				System.out.println("s"+space);
				System.out.println(x);
				System.out.println(f);
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
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();
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
						print+="[ "+getByDim(dim, m*n, m, n, end, m-1, false).getSpace();
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


}

