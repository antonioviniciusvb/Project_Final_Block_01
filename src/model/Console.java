package model;

public class Console {

	private int quantityjoystick;
	private boolean cdPlayer;
	private String model;

	public Console(int quantityjoystick, boolean cdPlayer, String model) {
		super();
		this.quantityjoystick = quantityjoystick;
		this.cdPlayer = cdPlayer;
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQuantityjoystick() {
		return quantityjoystick;
	}

	public void setQuantityjoystick(int quantityjoystick) {
		this.quantityjoystick = quantityjoystick;
	}

	public boolean cdPlayer() {
		return cdPlayer;
	}

	public void setCdPlayer(boolean cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("Model: %s\nQuantity Joystick: %d\n", getModel(), getQuantityjoystick());
	}

}
