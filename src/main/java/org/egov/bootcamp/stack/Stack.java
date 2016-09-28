package org.egov.bootcamp.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<E> {

	private int count = 0;
	private Object[] items;

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Object push(E element) {
		return addElement(element);
	}

	public Object pop() {
		return isEmpty() ? null : removeElement();
	}

	private Object removeElement() {
		Object element = items[size() - 1];
		items = Arrays.copyOf(items, size() - 1);
		count--;
		return element;
	}

	public List<Object> toArray() {
		List<Object> list = new ArrayList<Object>();
		if (!isEmpty()) {
			for (Object element : items) {
				list.add(element);
			}
		}
		return list;
	}

	public boolean contains(E element) {
		boolean hasElement = false;
		validate(element);
		if (!isEmpty()) {
			for (Object item : items) {
				if (item.equals(element)) {
					hasElement = true;
				}
			}
		}
		return hasElement;
	}

	private Object addElement(E element) {
		validate(element);
		items = isEmpty() ? new Object[1] : Arrays.copyOf(items, size() + 1);
		items[count++] = element;
		return element;
	}

	private void validate(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
	}
}
