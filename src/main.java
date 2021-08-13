import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static void main(String[] args) 
	{
		
		String username="";
		String classs="";
		String castID="";
		System.out.println("Welcome to the Game! Please enter your username:");
		try {
			Scanner sc=new Scanner(System.in);
			username=sc.nextLine();
		}catch(Exception e) {
			e.printStackTrace();
		} 

		//itemek és szörnyek bevitele sztoriba
	    System.out.println(username);
	    Inventory inv=new Inventory();
	    InventoryItem easteregg=new InventoryItem(0, "Egg of Easter", 1);
	    InventoryItem shield=new InventoryItem(1, "Shield", 1);
		InventoryItem grimoire=new InventoryItem(2, "Grimoire", 1);
		InventoryItem dragonegg=new InventoryItem(3, "Dragon egg", 1);
		InventoryItem sword=new InventoryItem(4, "Kotetsu", 1);
	    Dragon süsü=new Dragon(Integer.MIN_VALUE);
	    Demon demon=new Demon(-40);
	    CaveRuins cave=new CaveRuins(-40);
	    CityGuard guard=new CityGuard(0);
	    WiseWoman wisewoman=new WiseWoman(+20);
	    Library library=new Library(-40);
	    WarPrep warprep=new WarPrep(0);
	    Siege siege=new Siege(-30);
	    Goblin goblin=new Goblin(-35);
	    
	    //kaszt választás player számára
	    boolean loop=true;
	    boolean IsValidInput=true;
	    System.out.println("Please choose your class! 1 for Warrior, 2 for Sorcerer");
	    while(IsValidInput)
	    {
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		castID=sc.nextLine();
			
			
	    			if(castID.equals("1") || castID.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    }
	    Player player;
	    if(castID.equals("1"))
	    	player=new Warrior(100, 100, username);
	    else
	    	player=new Sorcerer(100, 100, username);
	    
	    
	    
	    String input1 = null;
	    String input2 = null;
	    String input3 = null;
	    String input4 = null;
	    String input5 = null;
	    String input6 = null;
	    String input7 = null;
	    String input8 = null;
	    String input9 = null;
	    
	    //Maga a játék
	    while(loop) {
	    	boolean playerkilledgoblin=false;
	    	//minden try input-os rész a sztori egy adott része
	    	//ahol a játékos tud interakcióba lépni a világgal
	    	
	    	try {
				input1 = readFile("1.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input1);
	    	System.out.println("1 - Attack Goblin, 2 - Remain hidden");
		    IsValidInput=true;
		    while(IsValidInput)
		    {
		    	try {
		    		Scanner sc=new Scanner(System.in);
		    		classs=sc.nextLine();
				
				
		    			if(classs.equals("1") || classs.equals("2"))
		    				IsValidInput=false;
		    			else
							{
								System.out.println("Please choose a valid number.");
								IsValidInput=true;
							}
					
				
		    	}catch(Exception e) 
		    		{
		    			e.printStackTrace();
		    		}
		    }
	    	if(classs.equals("1"))
	    		{
	    		
	    			System.out.println("The Goblin put up a resistance against your attacks. His rusty sword wounded you but its nothing too serious. You killed the creature."
	    					+ "The woman thanks for your assistance and both of you continue on your own paths.");
	    			if(player.getDmgRes().equals(goblin.getDmgType()))
	    			{
						player.sethp(player.gethp()+goblin.getHpchange()+30);
						
						System.out.println("Your remaining HP is:");
	    			System.out.println(player.gethp());}
	    			
	    			else {
	    			player.sethp(player.gethp()+goblin.getHpchange()+20);
	    			System.out.println("Your remaining HP is:");
	    			System.out.println(player.gethp());
	    			}
	    			playerkilledgoblin=true;
	    		}
	    	else
	    	{
	    		System.out.println("The Goblin saw you hiding in the bushes. He wounded the woman and ran towards you."
	    				+ "You couldn't prepare to defend yourself, so he cut you and ran away.");
	    		if(player.getDmgRes().equals(goblin.getDmgType())) {
	    			System.out.println("Your remaining HP is:");
					player.sethp(player.gethp()+goblin.getHpchange()+15);
					System.out.println(player.gethp());}
	    		else {
	    			System.out.println("Your remaining HP is:");
	    			player.sethp(player.gethp()+goblin.getHpchange());
	    			System.out.println(player.gethp());}
	    		
	    	}
	    	//ellenõrzés hogy a playernek van-e elegendõ HP-ja hogy folytassa a játékot
	    	if(player.gethp()<1)
	    		loop=false;
	    	
	    	try {
				input2 = readFile("2.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input2);
	    	System.out.println("1 - Explore the forbidden area, 2 - Go on with your journey");
		    IsValidInput=true;
		    while(IsValidInput)
		    {	
		    	try {
		    		Scanner sc=new Scanner(System.in);
		    		classs=sc.nextLine();
				
				
		    			if(classs.equals("1") || classs.equals("2"))
		    				IsValidInput=false;
		    			else
							{
								System.out.println("Please choose a valid number.");
								IsValidInput=true;
							}
					
				
		    	}catch(Exception e) 
		    		{
		    			e.printStackTrace();
		    		}
		    }
	    	if(classs.equals("1"))
	    	{
	    		System.out.println("This library is filled with magic and when you try to go into the forbidden area this magic pressure hurts you. After a while the pressure goes away.");
	    		if(player.getDmgRes().equals(library.getDmgType()))
	    			player.sethp(player.gethp()+library.getHpchange()+30);
	    		System.out.println("Your remaining HP is:");
	    		player.sethp(player.gethp()+library.getHpchange()+15);
	    		System.out.println(player.gethp());
	    		System.out.println("You fund a Grimoire.");
	    		inv.AddToInventory(grimoire);
	    	}
	    	else
	    		System.out.println("You conntinue with your journey.");
	    	System.out.println("You check your backpack it contains:");
	    	//ki listázza a player inventory-ját
	    	inv.ListItems(null);
	    	
	    	if(player.gethp()<1)
	    		loop=false;
	    	try {
				input3 = readFile("3.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input3);
	    	System.out.println("1 - Explore the cave, 2 - Go on with your journey");
		    IsValidInput=true;
	    	while(IsValidInput)
	    {
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    }
	    	if(classs.equals("1"))
	    	{
	    		if(player.getDmgRes().equals(cave.getDmgType()))
	    		{
	    			player.sethp(player.gethp()+cave.getHpchange()+20);
	    		}
	    		else
	    		player.sethp(player.gethp()+cave.getHpchange()+10);
	    		System.out.println("The cave was filled with traps. At the end of the cave you found a tresaure chest.");
	    		System.out.println("You opened the chest and you found a:");
	    		System.out.println("Sword. When you inspect it you can find its name. Its called: Kotetsu. Congratulations you got: Kotetsu");
    			inv.AddToInventory(sword);
	    		if(castID.equals("1"))
	    		{
	    			System.out.println("Beside the sword: a shield. Its the finest shield you ever saw in your life. It can be dwarven craftsmanship. Congratulations you found: Shield");
	    			inv.AddToInventory(shield);
	    		}
	    		if(castID.equals("2"))
	    			{
	    				System.out.println("Beside the sword: an Egg. When you inspect it you can feel a warm breath under the shell. Congratulations you found: Dragon Egg");
	    				inv.AddToInventory(dragonegg);
	    			}
	    	}
	    	else
	    		System.out.println("You continue with your journey");
	    	
	    	System.out.println("You check your backpack it contains:");
	    	inv.ListItems(null);
	    	
	    	if(player.gethp()<1)
	    		loop=false;
	    	
	    	try {
				input4 = readFile("4.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input4);
	    	System.out.println("1 - Greet the woman, 2 - Ask for directions");
		    IsValidInput=true;
	    	while(IsValidInput)
	    {
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    }
	    	if(classs.equals("1"))
	    	{	
	    		if(playerkilledgoblin)
	    		{
	    		System.out.println("While you are speaking with the woman, another one comes out from the house. Its the one you saved. She thanks for your help again and heals you. After that they show you where is the city.");
	    		player.sethp(player.gethp()+wisewoman.getHpchange());
	    		System.out.println(player.gethp());
	    		}
	    		else
	    			System.out.println("The woman shows you the way to the city.");
	    	}
	    	else
	    		System.out.println("After a while you can find the city on your own.");
	    	
	    	
	    	if(player.gethp()<1)
	    		loop=false;
	    	try {
				input5 = readFile("5.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input5);
	    	System.out.println("1 - Speak with the guards, 2 - Find a job in the guild");
		    IsValidInput=true;
	    	while(IsValidInput)
	    {
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    }
	    	if(classs.equals("1"))
	    		System.out.println("The guard tells you about the dragon which lives in nearby. He says the dragon can attack anytime soon.");
	    	else
	    		System.out.println("At the adventurer guild they tell you about a dragon. There is a quest to subdue the dragon. You are thinking about accepting it when suddenly you hear shouting from the street. They are yelling and screaming: the dragon is here.");
	    	System.out.println("You check your backpack it contains:");
	    	inv.ListItems(null);
	    	if(player.gethp()<1)
	    		loop=false;
	    	try {
				input6 = readFile("6.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input6);
	    	System.out.println("1 - Shield yourself from fire, 2 - Show something interesting to the Dragon");
		    IsValidInput=true;
	    	while(IsValidInput)
	    	{
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	if(classs.equals("1"))
	    	{
	    		System.out.println("How do you want to shield yourself? 1 - Powerful magic 2 - Shield");
	    		IsValidInput=true;
		    	while(IsValidInput)
		    	{
		    	try {
		    		Scanner sc=new Scanner(System.in);
		    		classs=sc.nextLine();
				
				
		    			if(classs.equals("1") || classs.equals("2"))
		    				IsValidInput=false;
		    			else
							{
								System.out.println("Please choose a valid number.");
								IsValidInput=true;
							}
					
				
		    	}catch(Exception e) 
		    		{
		    			e.printStackTrace();
		    		}
		    	}
		    	if(classs.equals("1")) {
		    		System.out.println("The Dragon laughs at your puny attempt to shield yourself with magic. Its common sense that the Dragons can penetrate magic defense.");
		    		player.sethp(player.gethp()+süsü.getHpchange());
		    		}
		    	if(classs.equals("2") && shield.getCunt()>0) {
		    		System.out.println("The Dragon lets out a raging inferno from his mouth. You raised your shield and while everything is melting around you the shield is holding but barely. After what it looks like an hour to you the Dragon laughs and let you live.");
		    		inv.RemoveFromInventory(shield);
		    		}
	    	}
	    	if(classs.equals("2") && dragonegg.getCunt()>0 && castID.equals("2"))
	    	{
	    		System.out.println("The Dragon recognises the Egg in your hand and asks you to exchange the city and your life for that egg. You humbly accept it.");
	    		inv.RemoveFromInventory(dragonegg);
	    	}
	    		
	    	
	    	if(player.gethp()<1)
	    		loop=false;
	    	inv.ListItems(null);
	    	try {
				input7 = readFile("7.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input7);
	    	System.out.println("1 - Attack the Demon, 2 - Try to flee");
		    IsValidInput=true;
	    	while(IsValidInput)
	    	{
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	if(classs.equals("1") && grimoire.getCunt()>0) {
	    		System.out.println("You feel a power surge coming from your backpack and it shields you from the Demons attack. You can easily defeat the Demon.");
	    		
	    	}
	    	if(classs.equals("1"))
	    	{
	    		System.out.println("With a long and difficult fight you are triumphant.");
	    		player.sethp(player.gethp()+demon.getHpchange());
	    	}
	    	if(player.gethp()<1)
	    		loop=false;
	    	inv.ListItems(null);
	    	try {
				input8 = readFile("8.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input8);
	    	System.out.println("1 - Focus on defensive, 2 - Focus on attack");
		    IsValidInput=true;
	    	while(IsValidInput)
	    	{
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	if(classs.equals("1"))
	    		System.out.println("You tell the King to focus on the defensive and fight a prolonged war.");
	    	else
	    		System.out.println("You tell the King that he must capture the castle as soon as possible.");
	    	if(player.gethp()<1)
	    		loop=true;
	    	
	    	inv.ListItems(null);
	    	try {
				input9 = readFile("9.txt");
			} catch (FileNotFoundException e) {
				System.err.println("Could not find the file: " + e.getMessage());
				e.printStackTrace();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	    	System.out.println(input9);
	    	System.out.println("1 - Use powerful magic 2 - Use powerful martial arts");
		    IsValidInput=true;
	    	while(IsValidInput)
	    	{
	    	try {
	    		Scanner sc=new Scanner(System.in);
	    		classs=sc.nextLine();
			
			
	    			if(classs.equals("1") || classs.equals("2"))
	    				IsValidInput=false;
	    			else
						{
							System.out.println("Please choose a valid number.");
							IsValidInput=true;
						}
				
			
	    	}catch(Exception e) 
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	if(classs.equals("1") && grimoire.getCunt()>0 && castID.equals("2"))
	    	{
	    		System.out.println("You sacrifice the power of the Grimoire and you put the Ancient Defensive spell on friendly soldiers. With that they are triumphant.");
	    	}
	    	if(classs.equals("1") && grimoire.getCunt()>0 && castID.equals("1"))
	    	{
	    		System.out.println("You cannot utilize the power of Grimoire and soon you are overrun by the enemy. You are dead.");
	    	}
	    	if(classs.equals("1") && castID.equals("1"))
	    	{
	    		System.out.println("Why are you a fool? You are a Warrior and you tried to use magic. The magical backlash kills you and everybody around you. You are dead.");
	    	}
	    	if(classs.equals("1") && castID.equals("2"))
	    	{
	    		System.out.println("Even if you can cast powerful fireballs, lightning bolts...they are not enough. The opposing knights are charging through your lines. You are dead.");
	    	}
	    	if(classs.equals("2") && castID.equals("2"))
	    		System.out.println("You are a fool. You studied magic for decades why are you trying to swing swords? Of course your enemy just parried your attack and with the same parry he killed you.");
	    	if(classs.equals("2") && castID.equals("1"))
	    		System.out.println("Even if you are a master swordsman you have your limits. After hours of battle you are tired. You cant move your arms, you cannot feel your legs. Your death is swift and painless in honor of your skills.");
	    	if(classs.equals("2") && sword.getCunt()>0 && castID.equals("1"))
	    		System.out.println("Your legendary sword and your skills make it easy for you. Kotetsu cuts through anything they put up against you in defense. You singlehandedly can capture the castle and thats what you did. Your side is triumphant.");
	    	
	    	
	    	loop=false;
	    	System.out.println("Your story ends here "+username+". I hope you had fun.");
	    }
	    
	    
		
		
		

	}
	//beolvasáshoz szükséges függvény
	public static String readFile(String fileUtvonal) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileUtvonal));

		String szoveg = "";
		String sor = null;
		while((sor=br.readLine())!=null) {
			szoveg += sor + "\n";
		}
		String result = szoveg;
		
		br.close();
		
		return result;
	}

}