package model;

import java.time.LocalDate;

import project_final_block_01.util.Converter;

public abstract class Product {

	private int id;
	private String name;
	private int type;
	private double price;
	private String platform;
	private LocalDate releaseYear;

	public Product(int id, String name, int type, double price, String platform, LocalDate releaseYear) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.platform = platform;
		this.releaseYear = releaseYear;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getDescriptionType() {
		return type == 1 ? "Game" : "Console";
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public LocalDate getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(LocalDate releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {

		return String.format("Id: %d\nName: %s\nType: %s\nPrice: %.2f\nPlatform: %s\nReleaseYear", getId(), getName(), getDescriptionType(),
				getPrice(), getPlatform(), Converter.localDateToString(getReleaseYear()));
	}

}
