import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<InventoryItem> Inventory=new ArrayList<>();
	
	public void AddToInventory(InventoryItem Item)
	{
		for (InventoryItem inventoryItem : Inventory) {
			if(inventoryItem.getID()==Item.getID()) {
				inventoryItem.setCunt(inventoryItem.getCunt()+1);
				return;
			}
		}
		Inventory.add(Item);
	}
	public void RemoveFromInventory(InventoryItem Item)
	{

		Inventory.remove(Item);
		
	}
	
	public void DecreaseInventoryItem(InventoryItem Item)
	{
		for (InventoryItem inventoryItem : Inventory) {
			if(inventoryItem.getID()==Item.getID()) {
				inventoryItem.setCunt(inventoryItem.getCunt()-1);
				if(inventoryItem.getCunt()==0)
					RemoveFromInventory(inventoryItem);
				return;
			}
		}

	}
	public void ListItems(InventoryItem Item)
	{
		for(InventoryItem inventoryItem: Inventory)
		{
			System.out.println(inventoryItem.getName());
		}
	}

}
