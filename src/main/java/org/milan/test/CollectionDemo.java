package org.milan.test;
import java.util.HashMap;
import java.util.Map;

public class CollectionDemo {
	

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("abc", "test1");
		map.put("xyz", "test2");
		System.out.println(map);
	}
	
}
class Test{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
