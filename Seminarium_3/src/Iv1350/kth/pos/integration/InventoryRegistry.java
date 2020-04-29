package Iv1350.kth.pos.integration;

import java.util.ArrayList;

public class InventoryRegistry {
    private ArrayList<Item> itemsarr;

    /**
     * The constructor for the inventory system, creates a few items to simmulate that they are already there in the "real" database
     */
    public InventoryRegistry() {
        this.itemsarr = new ArrayList<>();

        ItemDTO kottDTO = new ItemDTO(0001, "Nöttkött", 30, 75);
        Item kott = new Item(kottDTO, 5);

        ItemDTO ostDTO = new ItemDTO(0002, "Ost", 4, 170);
        Item ost = new Item(ostDTO, 9);

        ItemDTO cigDTO = new ItemDTO(0003, "Cigarett", 32, 67);
        Item cigg = new Item(cigDTO, 15);

        ItemDTO eggDTO = new ItemDTO(0004, "Ägg", 5, 45);
        Item egg = new Item(eggDTO, 1);

        ItemDTO ToaPapperDTO = new ItemDTO(0005, "Toa Papper", 25, 75);
        Item toapapper = new Item(ToaPapperDTO, 5);

        ItemDTO kycklingDTO = new ItemDTO(0006, "Kyckling", 0, 30);
        Item kyckling = new Item(kycklingDTO, 5);

        itemsarr.add(kott);
        itemsarr.add(cigg);
        itemsarr.add(ost);
        itemsarr.add(egg);
        itemsarr.add(toapapper);
        itemsarr.add(kyckling);
    }

    /**
     * Cheacks if an item ID is valid and either returns the itemDTO for the object if found, or a null object if not
     * @param itemID    the desired item ID to find coresponding itemDTO
     * @return either returns the itemDTO for the item ID or a nullobject if not found
     */
    public ItemDTO isItemIDValid(int itemID) {
        for (int i = 0; i < itemsarr.size(); i++) {
            if (itemsarr.get(i).getItemID() == itemID) {
                return itemsarr.get(i).getItemDTO();
            }
        }
        return null;
    }
    /**
     * Updates the inventory after a sale, and removes the amount of sold items from the quantity for that item
     * @param items The items sold during the sale.
     */
    public void updateStock(ArrayList<Item> items){
        for(int i = 0; i<this.itemsarr.size();i++){
            for(int k = 0; i<items.size();i++){
                if(this.itemsarr.get(i).getItemDTO().getItemIdentifyer() == items.get(k).getItemDTO().getItemIdentifyer()){
                    this.itemsarr.get(i).setAmount(this.itemsarr.get(i).getAmountOfItem()-items.get(k).getAmountOfItem());
                }
            }
        }
    }
}
