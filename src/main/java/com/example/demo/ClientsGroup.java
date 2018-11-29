package com.example.demo;


import java.util.Objects;
import java.util.UUID;

public class ClientsGroup implements Comparable
{
   public final int size; // number of clients
   private final String id = UUID.randomUUID().toString();
   
   public ClientsGroup(int size) {
	   this.size = size;
   }
@Override
public int hashCode() {
	return Objects.hash(size);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof ClientsGroup))
		return false;
	ClientsGroup other = (ClientsGroup) obj;
	return size == other.size && id.equals(other.id);
}
@Override
public String toString() {
	return "ClientsGroup [size=" + size + "]";
}
@Override
public int compareTo(Object o) {
	return this.size > ((ClientsGroup)o).size ? 1 :-1 ;
}
   
   
}

