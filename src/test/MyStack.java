package test;

import java.util.ArrayList;

public class MyStack {
	ArrayList<String> data = new ArrayList<>();

	public boolean isEmpty() {
		if (data.isEmpty())
			return true;
		else
			return false;
	}

	public int size() {
		return data.size();
	}

	public void push(String pos) {
		data.add(pos);
	}

	public void pop() {
		data.remove(data.size() - 1);
	}
	public String getTop() {
		if(isEmpty()) {
			return null;
		}
		return data.get(data.size()-1);
	}
}
