
public class Warrior extends Player {
	
	//hpm=hp modifier
	//dmgRes= sebz�s ellen�ll�s
	private static final int HPM=30;
	private static final String DMGRES="physical";

	
	public Warrior(int hp, int mp, String Name)
	{
		super(hp+HPM,mp,Name, DMGRES);
		
	}
	



}
