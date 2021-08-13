


public class Player{
	private int hp;
	private int mp;
	private String Name;
	private String dmgRes;
	
	public Player()
	{
		this.hp=100;
		this.mp=100;
		this.Name="Player";
		this.dmgRes="";
	}
	
	public Player(String Name, String dmgRes)
	{
		this.hp=100;
		this.mp=100;
		this.Name=Name;
		this.dmgRes=dmgRes;
	}
	
	public Player(int hp, int mp, String Name, String dmgRes)
	{
		this.hp=hp;
		this.mp=mp;
		this.Name=Name;
		this.dmgRes=dmgRes;
	}
	
	public int gethp()
	{
		return hp;
	}
	
	public int getmp()
	{
		return mp;
	}
	
	public void sethp(int hp)
	{
		this.hp=hp;
	}
	
	public void setmp(int mp)
	{
		this.mp=mp;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDmgRes() {
		return dmgRes;
	}

	public void setDmgRes(String dmgRes) {
		this.dmgRes = dmgRes;
	}

	
	
	
	

}
