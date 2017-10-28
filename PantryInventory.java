/**
 * 
 * @author Kyle Jonson
 *
 */
import java.util.*;
import java.io.*;
public class PantryInventory {
	
	public HashMap<Integer,String> inventory;
	public HashMap<String,Integer> data;
	public String inventoryPath = "";
	public String dataPath = "";
	public String date;
	
	
	public void start(String date){
		this.date = date;
		createInventory();
	}
	
	public String searchInventory(int barcode){
		return inventory.get(Integer.valueOf(barcode));
	}
	
	public void createInventory(){
		try{
			File file = new File(inventoryPath + date);
			if(!file.exists()){
				throw new FileNotFoundException();
			}
			Scanner scan = new Scanner(file);
			Integer key;
			String value;
			while(scan.hasNext()){
				key = Integer.parseInt(scan.next());
				value = scan.next();
				inventory.put(key, value);
			}
			scan.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
