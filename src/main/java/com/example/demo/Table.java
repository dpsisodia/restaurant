package com.example.demo;

import java.util.Objects;

public class Table
{
   public final int size; // number of chairs
   
   public Table(int size) {
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
	if (!(obj instanceof Table))
		return false;
	Table other = (Table) obj;
	return size == other.size;
}

@Override
public String toString() {
	return "Table [size=" + size + "]";
}
   
}

