package model;

import java.time.LocalDate;

public class Game extends Product {

	private String developer;

	public Game(int id, String name, int type, double price, String platform, LocalDate releaseYear, String developer) {
		super(id, name, type, price, platform, releaseYear);
		this.developer = developer;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Developer: %s\n", getDeveloper());
	}
}
