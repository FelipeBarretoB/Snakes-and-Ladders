package model;

import java.util.Random;

public class ManageBoard {

	public ManageBoard() {}
	Space end;

	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}

	public void createBoard(int n, int m, int s, int e, String k) {
		int dim=n*m;
		end = new Space( "f",  null,  null,  null,  null,  dim,  "");
		dim--;
		setBoard( dim,  m,  n,end, m-1, false);
		print( dim+1,  m,  n,  end,  m-1,  false);
	}

	private void setBoard(int dim, int m, int n, Space next, int c, boolean side) {
		if(dim!=0) {
			if(c!=0) {
				
				if(next.getRight()==null && !side){
					next.setRight(new Space("f",null,null,null,null,dim,""));

					//System.out.println(dim);
					dim--;
					c--;
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}else if(next.getRight()!=null && !side){
					setBoard( dim,  m,  n,  next.getRight(), c, side);
				}
				if(next.getLeft()==null && side){
					next.setLeft(new Space("f",null,null,null,null,dim,""));

					//System.out.println(dim);
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
					//System.out.println(dim);
					dim--;
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}else if(next.getDown()!=null){
					setBoard( dim,  m,  n,  next.getDown(), c, side);
				}
			}

		}
	}
	
	private void print(int dim, int m, int n, Space next, int c, boolean side) {
		System.out.println("dim "+dim);
		if(dim!=0) {
			System.out.println("c"+c);
			if(c!=0) {
				
				System.out.println("if 1");
				System.out.println(next.getRight()!=null && !side);
				if(next.getRight()!=null && !side){
					dim--;
					c--;
					System.out.println(next.getSpace());
					print( dim,  m,  n,  next.getRight(), c, side);
				}
				System.out.println("if 2");
				System.out.println("if 2 "+next.getLeft()!=null && side);
				 if(next.getLeft()!=null && side){
					dim--;
					c--;
					System.out.println(next.getSpace());
					print( dim,  m,  n,  next.getLeft(), c, side);
				}
			}else {
				side=!side;
				c=m-1;
				System.out.println("if 3");
				System.out.println("if 3 "+next.getDown()!=null);
				if(next.getDown()!=null){
					dim--;
					System.out.println(next.getSpace());
					print( dim,  m,  n,  next.getDown(), c, side);
				}
			}

		}
	}


}

