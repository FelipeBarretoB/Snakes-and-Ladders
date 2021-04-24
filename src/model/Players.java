package model;

public class Players {
	public Player first;
	public Player last;
	
	public Players(int amount) {
		first = new Player ((char) 33);
		Player aux = first;
		addPlayers(amount, aux);
	}
	
	public Players(int amount, String names) {
		first = new Player ((char) names.charAt(amount-1));
		Player aux = first;
		addPlayers(amount-1, aux, names);
	}
	
	public void addPlayers(int amount, Player aux, String names) {
		if(amount > 0) {
			aux.setNext(new Player((char) (names.charAt(amount-1))));
			amount--;
			addPlayers(amount,aux);
		}else {
			last = aux;
			last.setNext(first);
		}
	}
	
	public void addPlayers(int amount, Player aux) {
		if(amount > 0) {
			aux.setNext(new Player((char) (33 + amount)));
			amount--;
			addPlayers(amount,aux);
		}else {
			last = aux;
			last.setNext(first);
		}
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
