package model;

import java.util.Random;

public class ManageBoard {

	private Space end;
	private String print;
	private int ascii;
	public ManageBoard() {
		ascii=65;	
	}


	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}

	public void createBoard(int n, int m, int s, int e, String k) {
		int dim=n*m;
		end = new Space( "f",  null,  null,  null,  null,  dim,  "");
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		//print( dim+1,  m,  n,  end,  m-1,  false);
		connectNeighbours(dim+1, m, end, m-1, false);
		System.out.println(printString(dim+1,"", m, n, m,n, false));
		connectUpAndDown(dim+1, m,n, end, m, m, n, false);

	}

	private void setBoard(int dim, int m, int n, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()==null && !side){
					next.setRight(new Space("f",null,null,null,null,dim,""));
					dim--;
					c--;
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}else if(next.getRight()!=null && !side){
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}
				if(next.getLeft()==null && side){
					next.setLeft(new Space("f",null,null,null,null,dim,""));
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
					next.setDown(new Space("f",null,null,null,null,dim,""));
					dim--;
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}else if(next.getDown()!=null){
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}
			}

		}
	}

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


	public void createSnakes(int dim, int m, int n, Space next, int c, boolean side, int s) {
		Random random = new Random();
		int spaceForSnake=random.nextInt(m*n - 1 + n) + 1;
		if(getByDim(spaceForSnake, dim, m, n, next, c, side).getSpecial().equals(" ")) {
			getByDim(spaceForSnake, dim, m, n, next, c, side).setSpecial(new Character((char)ascii).toString());
			getByDim(getRandomDim(dim, m, n), dim, m, spaceForSnake, next, c, side).setSpecial(new Character((char)ascii).toString());
			ascii++;
		}else {
			createSnakes(dim, m, n, next, c, side, spaceForSnake);
		}
		
	}

	public int getRandomDim( int dim, int m, int n) {
		Random random = new Random();
		int x=random.nextInt(m*n - 1 + n) + 1;
		if(x<dim-m) {
			return x;
		}else {
			return getRandomDim(dim, m, n);
		}
	}

	public String printString(int dim, String print,int m, int n, int c, int x,boolean side) {
		if(x!=0) {
			if(c!=0) {
				if(!side) {
					print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpace()+" ";
					c--;
					dim--;
					return printString(dim, print, m, n, c,x,side);
				}else {
					print+=getByDim(dim, m*n, m, n, end, m-1, false).getSpace()+" ";
					c--;
					dim++;
					//System.out.print(dim+" ");
					return printString(dim, print, m, n, c,x,side);
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

