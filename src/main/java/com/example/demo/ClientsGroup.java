package com.example.demo;

import java.util.Objects;

public class ClientsGroup
{
   public final int size; // number of clients
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
	return size == other.size;
}
@Override
public String toString() {
	return "ClientsGroup [size=" + size + "]";
}
   
   
}

