
public class Sorcerer extends Player{
	
	//hpm=hp modifier
	//dmgRes= sebz�s ellen�ll�s
	private static final int HPM=30;
	private static final String DMGRES="magic";




	
	public Sorcerer(int hp, int mp, String Name)
	{
		super(hp-HPM,mp,Name, DMGRES);
		
	}
	


}
