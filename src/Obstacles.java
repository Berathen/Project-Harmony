
public class Obstacles {
	
	private int hpchange;
	private String dmgType;
	private String Name;
	private int ID;
	
	
	public Obstacles(int hpchange, String dmgType, String Name, int ID) {
		super();
		this.hpchange = hpchange;
		this.dmgType = dmgType;
		this.Name=Name;
		this.ID=ID;
	}
	public int getHpchange() {
		return hpchange;
	}
	public void setHpchange(int hpchange) {
		this.hpchange = hpchange;
	}
	public String getDmgType() {
		return dmgType;
	}
	public void setDmgType(String dmgType) {
		this.dmgType = dmgType;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	

}
