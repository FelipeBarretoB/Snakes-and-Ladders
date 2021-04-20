package model;

import java.util.Random;

public class ManageBoard {

	public ManageBoard() {}
	Space end;
	String print;

	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}

	//m son las columnas
	//n las filas	
	//representa cuantas columnas hay
	public void createBoard(int n, int m, int s, int e, String k) {
		int dim=n*m;
		end = new Space( "f",  null,  null,  null,  null,  dim,  "");
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		//System.out.println(end.getSpace());
		print( dim+1,  m,  n,  end,  m-1,  false);
		connectNeighbours(dim+1, m, end, m-1, false);
		//getByDim( 3, dim,  m,  n,  end,  m-1,  false);
		//System.out.println(getByDim( 13, dim+1,  m,  n,  end,  m-1,  false).getSpace());
		x(dim+1, m,n, end, m, m, n, false);
		
		//getByDim(5, dim+1, m, n, end, m-1, false).setDown(getByDim(4, dim, m, n, end, m-1, false));
		//getByDim(4, dim+1, m, n, end, m-1, false).setUp(getByDim(5, dim, m, n, end, m-1, false));
		//System.out.println(getByDim(5, dim+1, m, n, end, m-1, false).getDown().getSpace());
		//System.out.println(getByDim(4, dim+1, m, n, end, m-1, false).getUp().getSpace());
	
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



	private void connectNeighbours(int dim,int m, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				if(next.getRight()!=null && !side){
					dim--;
					c--;
					next.getRight().setLeft(next);
					System.out.println(next.getRight().getSpace()+" a "+next.getRight().getLeft().getSpace());
					connectNeighbours( dim,  m,  next.getRight(), c, side);
				}
				if(next.getLeft()!=null && side){
					dim--;
					c--;
					next.getLeft().setRight(next);
					System.out.println(next.getLeft().getSpace()+" a "+next.getLeft().getRight().getSpace());
					connectNeighbours( dim,  m,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				if(next.getDown()!=null){
					dim--;
					next.getDown().setUp(next);
					System.out.println(next.getDown().getSpace()+" a "+next.getDown().getUp().getSpace());
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
	private void x(int dim,int n,int m, Space next, int c,int z, int x, boolean side) {
		if(x!=1) {
				if(c!=0) {
					System.out.println("Current c ="+c);
					System.out.println("Current z ="+z);
					System.out.println("Current dim ="+dim);
					System.out.println("Current dim-(c-1) ="+(dim-(c-1)));
					System.out.println("Current dim-z ="+(dim-z));
					getByDim(dim-(c-1), m*n, m, n, next, m-1, side).setDown(getByDim(dim-z, m*n, m, n, next, m-1, side));
					getByDim(dim-z, m*n, m, n, next, m-1, side).setUp(getByDim(dim-(c-1), m*n, m, n, next, m-1, side));
					System.out.println(getByDim(dim-(c-1), m*n, m, n, next, m-1, side).getDown().getSpace());
					System.out.println(getByDim(dim-z, m*n, m, n, next, m-1, side).getUp().getSpace());
					z++;
					c--;
					x(dim, n, m, next, c, z, x, side);
				}else {
					dim=dim-m;
					x--;
					c=m;
					z=m;
					x(dim, n, m, next, c, z, x, side);
				}
		}

	}


}

