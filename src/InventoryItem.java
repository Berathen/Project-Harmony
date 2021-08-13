
public class InventoryItem {
	
	private int ID;
	private String Name;
	private int cunt;
	
	public InventoryItem(int iD, String name, int cunt) {
		super();
		ID = iD;
		Name = name;
		this.cunt = cunt;
	}
	
	public int getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCunt() {
		return cunt;
	}
	public void setCunt(int cunt) {
		this.cunt = cunt;
	}

}
