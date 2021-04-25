package model;

public class Players {
	private Player first;
	private Player last;
	private int size;
	
	/**
	*The constructor method creates an objet Players that has an amount of players <br>
    *<b>pre: To create the objet players is needed the amount of players that are going to be added</b> 
	*<b>post: Creates an objet player with a genereated char that is going to be the first, and sets the size to 1 </b>
	*@param int, the amount of Players
	*/
	public Players(int amount) {
		first = new Player ((char) 33);
		first.setTurn(true);
		size = 1;
		addPlayers(amount, first);
	}
	/**
	*The constructor method creates an objet Players that has an amount of players <br>
    *<b>pre: To create the objet players is needed the amount of players that are going to be added and the icons</b> 
	*<b>post: Creates an objet player with a given char that is going to be the first, and sets the size to 1 </b>
	*@param int, the amount of Players
	*@param String, the icons of the Players
	*/
	public Players(int amount, String names) {
		first = new Player ((char) names.charAt(amount-1));
		first.setTurn(true);
		size = 1;
		addPlayers(amount-2, first, names);
	}
	
	public void addPlayers(int amount, Player aux, String names) {
		if(amount >= 0) {
			aux.setNext(new Player((char) (names.charAt(amount))));
			size++;
			amount--;
			addPlayers(amount,aux.getNext(), names);
		}else {
			last = aux;
			last.setNext(first);
			
		}
	}
	public void addPlayers(int amount, Player aux) {
		if(amount > 0) {
			aux.setNext(new Player((char) (33 + amount)));
			size++;
			amount--;
			addPlayers(amount,aux);
		}else {
			last = aux;
			last.setNext(first);
		}
	}
	
	public String stringPlayers() {
		String pstr = getPlayersIcons(size-1);
		return pstr;
	}
	
	public String getPlayersIcons(int s) {
		if(s >= 0) {
			char p = get(s).getIcon();
			s--;
			return p + getPlayersIcons(s);
		}
		return "";
	}
	
	public Player get(int pos) {
		Player p = null;
		if(pos < size) {
			p = getPlayer(pos, first);
		}
		return p;
	}
	
	public Player getPlayer(int a, Player aux) {
		if(a > 0) {
			a--;
			aux = getPlayer(a, aux.getNext());
		}
		return aux;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Player getFirst() {
		return first;
	}

	public void setFirst(Player first) {
		this.first = first;
	}

	public Player getLast() {
		return last;
	}

	public void setLast(Player last) {
		this.last = last;
	}
	
	
}
