package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestManager
{	
	
	Map<Integer, List<Table>> map = new HashMap<Integer, List<Table>>(); 
	Map<ClientsGroup, Table> seatings = new HashMap<ClientsGroup, Table>(); 
   public RestManager (List<Table> tables)
   {	for(Table t:tables) {
	   		if(map.keySet().contains(t.size))
	   			map.get(t.size).add(t);
	   		else
	   			map.put(t.size, new ArrayList<Table>() {{add(t);}});
   		}
	  
   }

   // new client(s) show up
   public void onArrive (ClientsGroup group)
   {   
	   if (map.get(group.size) != null && map.get(group.size).size() > 0) {
		   Table t = map.get(group.size).remove(0);
		   seatings.put(group, t);
	   } 
	   		
	   
   }

// client(s) leave, either served or simply abandoning the queue
   public void onLeave (ClientsGroup group)
   {
	   
	   if (seatings.keySet().contains(group)) {
		   Table t = seatings.remove(group);
		   map.get(group.size).add(t);
	   }
   }

   // return table where a given client group is seated, 
   // or null if it is still queuing or has already left
   public Table lookup (ClientsGroup group)
   {
      return seatings.get(group);
   }
}