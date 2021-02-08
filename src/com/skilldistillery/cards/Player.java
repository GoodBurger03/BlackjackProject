package com.skilldistillery.cards;

public class Player {
private String name;

public Player() {
	
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

// toString
@Override
public String toString() {
	  StringBuilder builder = new StringBuilder();
	    builder.append("Player [name=");
	    builder.append(name);
	    builder.append("]");
	    return builder.toString();
	  }


}
