package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class RestManager
{	
	PriorityBlockingQueue<ClientsGroup> queue = new PriorityBlockingQueue<ClientsGroup>();
	Map<Integer, List<Table>> map = new ConcurrentHashMap<Integer, List<Table>>(); 
	Map<ClientsGroup, Table> seatings = new ConcurrentHashMap<ClientsGroup, Table>(); 
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
	   if(!attemptSeating(group)) 
		   queue.add(group);
	   		
	   
   }

// client(s) leave, either served or simply abandoning the queue
   public void onLeave (ClientsGroup group)
   {
	   
	   if (seatings.keySet().contains(group)) {
		   Table t = seatings.remove(group);
		   map.get(group.size).add(t);
	   } else 
		   if(queue.remove(group)) {
			   group = queue.peek();
			   if(attemptSeating(group))
				   queue.remove(group);
		   }

   }

   // return table where a given client group is seated, 
   // or null if it is still queuing or has already left
   public Table lookup (ClientsGroup group)
   {
      return seatings.get(group);
   }
  
   public boolean attemptSeating(ClientsGroup group) {
	if (map.get(group.size) != null && map.get(group.size).size() > 0) {
		   Table t = map.get(group.size).remove(0);
		   seatings.put(group, t);
		   return true;
	   }
	return false;
   }
}