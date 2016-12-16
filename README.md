# Chest-Refill-API

Discription:
This is a small api I made that allows you to quickly refill a chest's inventory with items in random slots. It has two different methods you can use.

Wish to use the API?
If you wish to use the API just add this class into your plugin.
https://github.com/kicjow/Chest-Refill-API/blob/master/src/me/BadBones69/chestrefillapi/ChestRefillAPI.java

1: ChestRefillAPI.refillChest(Location chest, ArrayList<ItemStack> items)
  - This allows you to refill a chest with all the items that are in the list.


  
2: ChestRefillAPI.refillChest(Location chest, HashMap<ItemStack, Integer> items, Integer maxItems)
  - This allows you to use the built in chance system to pick only the items that are successfull and have a cap on the amount of them that show in the chest. The chance system is a <Chance>/100 system but it can be changed if you edit the code.
