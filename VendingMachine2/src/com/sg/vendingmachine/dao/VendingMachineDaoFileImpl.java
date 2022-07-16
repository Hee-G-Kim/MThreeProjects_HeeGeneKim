package com.sg.vendingmachine.dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sg.vendingmachine.dto.Item;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

	private Map<String, Item> items = new HashMap<>();

	// Reading and writing to a file
	/*
	 * To start, we'll create two constants in our DAO — one for the name of the
	 * file that holds all the item data and one for the delimiter (two colons).
	 * Add the following constants near the top of your VendingMachineDaoFileImpl
	 * class:
	 */
	// public static final String ROSTER_FILE = "roster.txt";
	private final String ROSTER_FILE;
	public static final String DELIMITER = "::";

	public VendingMachineDaoFileImpl() {
		ROSTER_FILE = "inventory-test.txt";
	}

	public VendingMachineDaoFileImpl(String rosterTextFile) {
		ROSTER_FILE = rosterTextFile;
	}

	// unmarshalling
	private Item unmarshallItem(String itemAsText) {
		// itemAsText is expecting a line read in from our file.
		// For example, it might look like this:
		// 1234::Ada::Lovelace::Java-September1842
		//
		// We then split that line on our DELIMITER - which we are using as ::
		// Leaving us with an array of Strings, stored in itemTokens.
		// Which should look like this:
		// ______________________________________
		// | | | | |
		// |1234|Ada|Lovelace|Java-September1842|
		// | | | | |
		// --------------------------------------
		// [0] [1] [2] [3]
		String[] itemTokens = itemAsText.split(DELIMITER);
		// Given the pattern above, the item Id is in index 0 of the array.
		String itemId = itemTokens[0];
		// Which we can then use to create a new Item object to satisfy
		// the requirements of the Item constructor.
		Item itemFromFile = new Item(itemId);
		// However, there are 3 remaining tokens that need to be set into the
		// new item object. Do this manually by using the appropriate setters.
		// Index 1 - FirstName
		
		itemFromFile.setName(itemTokens[1]);
		
		// Index 2 - LastName
		itemFromFile.setPrice(Float.parseFloat(itemTokens[2]));
		// Index 3 - Cohort
		itemFromFile.setStockAmt(Integer.parseInt(itemTokens[3]));
		// We have now created a item! Return it!
		return itemFromFile;
	}

	/*
	 * //create a method that reads the roster file into memory: This method will
	 * follow the algorithm described in the Data Marshaling and Unmarshaling
	 * lesson: 1. Open the file for reading. 2. For each line in the file, do the
	 * following: a. Read the line into a String variable. b. Pass the line to our
	 * unmarshallItem method to parse it into Item c. Put the newly created
	 * and initialized Item object into the item map. 3. Close the 􀂦le.
	 */
	private void loadRoster() throws VendingMachinePersistenceException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			//System.out.println(new File(ROSTER_FILE).getAbsolutePath());
			scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
		} catch (FileNotFoundException e) {
			throw new VendingMachinePersistenceException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// currentItem holds the most recent item unmarshalled
		Item currentItem;
		// Go through ROSTER_FILE line by line, decoding each line into a
		// Item object by calling the unmarshallItem method.
		// Process while we have more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a Item
			currentItem = unmarshallItem(currentLine);
			// We are going to use the item id as the map key for our item object.
			// Put currentItem into the map using item id as the key
			items.put(currentItem.getItemId(), currentItem);
		}
		// close scanner
		scanner.close();
	}

	// Marshalling
	private String marshallItem(Item aItem) {
		// We need to turn a Item object into a line of text for our file.
		// For example, we need an in memory object to end up like this:
		// 4321::Charles::Babbage::Java-September1842
		// It's not a complicated process. Just get out each property,
		// and concatenate with our DELIMITER as a kind of spacer.
		// Start with the item id, since that's supposed to be first.
		String itemAsText = aItem.getItemId() + DELIMITER;
		// add the rest of the properties in the correct order:
		// FirstName
		itemAsText += aItem.getName() + DELIMITER;
		// LastName
		itemAsText += aItem.getPrice() + DELIMITER;
		// Cohort - don't forget to skip the DELIMITER here.
		itemAsText += aItem.getStockAmt();
		// We have now turned a item to text! Return it!
		return itemAsText;
	}

	/*
	 * Writes all items in the roster out to a ROSTER_FILE. See loadRoster for
	 * file format.
	 *
	 * @throws VendingMachineDaoException if an error occurs writing to the file
	 */
	private void writeRoster() throws VendingMachinePersistenceException {
		// NOTE FOR APPRENTICES: We are not handling the IOException - but
		// we are translating it to an application specific exception and
		// then simple throwing it (i.e. 'reporting' it) to the code that
		// called us. It is the responsibility of the calling code to
		// handle any errors that occur.
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(ROSTER_FILE));
		} catch (IOException e) {
			throw new VendingMachinePersistenceException("Could not save item data.", e);
		}
		// Write out the Item objects to the roster file.
		// NOTE TO THE APPRENTICES: We could just grab the item map,
		// get the Collection of Items and iterate over them but we've
		// already created a method that gets a List of Items so
		// we'll reuse it.
		String itemAsText;
		List<Item> itemList = this.getAllItems();
		for (Item currentItem : itemList) {
			// turn a Item into a String
			itemAsText = marshallItem(currentItem);
			// write the Item object to the file
			out.println(itemAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

	// --------------------------------------------

	@Override
	public Item addItem(String itemId, Item item) throws VendingMachinePersistenceException {
		loadRoster();
		Item newItem = items.put(itemId, item);
		writeRoster();
		return newItem;
	}

	/*
	 * @Override public Item addItem(String itemId, Item item) { //
	 * *??? Item prevItem = items.put(itemId, item); // ??is null
	 * System.out.println("prevItem: " + prevItem); // ??why return return
	 * prevItem; }
	 */

	@Override
	public List<Item> getAllItems() throws VendingMachinePersistenceException {
		loadRoster();
		return new ArrayList(items.values());
	}
	/*
	 * @Override public List<Item> getAllItems() { // we get the hashmap
	 * values and return in an arraylist return new
	 * ArrayList<Item>(items.values()); }
	 */

	@Override
	public Item getItem(String itemId) throws VendingMachinePersistenceException {
		loadRoster();
		return items.get(itemId);
	}
	/*
	 * @Override public Item getItem(String itemId) { return
	 * items.get(itemId); }
	 */

	@Override
	public Item removeItem(String itemId) throws VendingMachinePersistenceException {
		loadRoster();
		Item removedItem = items.remove(itemId);
		writeRoster();
		return removedItem;
	}
	/*
	 * @Override public Item removeItem(String itemId) { Item
	 * removedItem = items.remove(itemId); return removedItem; }
	 */

}
