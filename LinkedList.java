//I am the sole author of the work in this repository.

// Implementation of lists, using doubly linked elements, and dummy nodes.
// Starter class for List-based lab.

import structure5.*;
import java.util.Iterator;

public class LinkedList<E> extends DoublyLinkedList<E>
{
	/**
	* Number of elements within the list.
	*/
	protected int count;
	/**
	* Reference to head of the list.
	*/
	protected DoublyLinkedNode<E> head;
	/**
	* Reference to tail of the list.
	*/
	protected DoublyLinkedNode<E> tail;

	/**
	* Constructs an empty list.
	*
	* @post constructs an empty list
	*
	*/
	public LinkedList()
	{
		head = new DoublyLinkedNode<E>(null, tail, null);
		tail = new DoublyLinkedNode<E>(null, null, head);
		count = 0;
	}

	/**
	* Determine the number of elements in the list.
	*
	* @post returns the number of elements in list
	*
	* @return The number of elements found in the list.
	*/
	public int size()
	{
		return count;
	}

	/**
	* Determine if the list is empty.
	*
	* @post returns true iff the list has no elements.
	*
	* @return True iff list has no values.
	*/
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	* Remove all values from list.
	*
	* @post removes all the elements from the list
	*/
	public void clear()
	{
		head = new DoublyLinkedNode<E>(null, tail, null);
		tail = new DoublyLinkedNode<E>(null, null, head);
		count = 0;
	}

	/**
	* A private routine to add an element after a node.
	* @param value the value to be added
	* @param previous the node the come before the one holding value
	* @pre previous is non null
	* @post list contains a node following previous that contains value
	*/
	protected void insertAfter(E value, DoublyLinkedNode<E> previous)
	{
		DoublyLinkedNode<E> current = new DoublyLinkedNode<E>(value, previous.next(), previous);
		count++;

		previous.setNext(current);
		current.next().setPrevious(current);
	}

	/**
	* A private routine to remove a node.
	* @param node the node to be removed
	* @pre node is non null
	* @post node node is removed from the list
	* @return the value of the node removed
	*/
	protected E remove(DoublyLinkedNode<E> node)
	{
		node.previous().setNext(node.next());
		node.next().setPrevious(node.previous());
		count--;
		return node.value();
	}


	/**
	* Add a value to the head of the list.
	*
	* @pre value is not null
	* @post adds element to head of list
	*
	* @param value The value to be added.
	*/
	public void addFirst(E value)
	{
		// construct a new element at the head
		head.setNext(new DoublyLinkedNode<E>(value, head.next(), head));
		count++;
	}

	/**
	* Add a value to the tail of the list.
	*
	* @pre value is not null
	* @post adds new value to tail of list
	*
	* @param value The value to be added.
	*/
	public void addLast(E value)
	{
		// construct new element at the tail
		tail.setPrevious(new DoublyLinkedNode<E>(value, tail, tail.previous()));
		count++;
	}

	/**
	* Remove a value from the head of the list.
	* Value is returned.
	*
	* @pre list is not empty
	* @post removes first value from list
	*
	* @return The value removed from the list.
	*/
	public E removeFirst()
	{
		Assert.pre(!isEmpty(),"List is empty.");
		return remove(head.next());
	}

	/**
	* Remove a value from the tail of the list.
	*
	* @pre list is not empty
	* @post removes value from tail of list
	*
	* @return The value removed from the list.
	*/
	public E removeLast()
	{
		Assert.pre(!isEmpty(),"List is empty.");
		return remove(tail.previous());
	}

	/**
	* Get a copy of the first value found in the list.
	*
	* @pre list is not empty
	* @post returns first value in list.
	*
	* @return A reference to first value in list.
	*/
	public E getFirst()
	{
		Assert.pre(!isEmpty(),"List is empty.");
		return head.next().value();
	}

	/**
	* Get a copy of the last value found in the list.
	*
	* @pre list is not empty
	* @post returns last value in list.
	*
	* @return A reference to the last value in the list.
	*/
	public E getLast()
	{
		Assert.pre(!isEmpty(),"List is empty.");
		return tail.previous().value();
	}

	/**
	* Insert the value at location.
	*
	* @pre 0 <= i <= size()
	* @post adds the ith entry of the list to value o
	* @param i the index of this new value
	* @param o the the value to be stored
	*/
	public void add(int i, E o)
	{
		Assert.pre((0 <= i) && (i <= size()), "Index out of range.");

		DoublyLinkedNode<E> current = head.next();
		int j = 0;
		while(j < i){
			current = current.next();
			j++;
		}
		insertAfter(o, current.previous());
	}

	/**
	* Remove and return the value at location i.
	*
	* @pre 0 <= i < size()
	* @post removes and returns the object found at that location.
	*
	* @param i the position of the value to be retrieved.
	* @return the value retrieved from location i (returns null if i invalid)
	*/
	public E remove(int i)
	{
		Assert.pre((0 <= i) && (i < size()), "Index out of range.");

		DoublyLinkedNode<E> current = head.next();
		int j = 0;
		while(j < i){
			current = current.next();
			j++;
		}
		return remove(current);
	}

	/**
	* Get the value at location i.
	*
	* @pre 0 <= i < size()
	* @post returns the object found at that location.
	*
	* @param i the position of the value to be retrieved.
	* @return the value retrieved from location i (returns null if i invalid)
	*/
	public E get(int i)
	{
		Assert.pre( (0 <= i) && (i < size()), "Index out of range.");

		DoublyLinkedNode<E> current = head.next();
		// search for the ith element of the list
		int j = 0;
		while (j < i){
			current = current.next();
			j++;
		}
		// return the value found
		return current.value();
	}

	/**
	* Set the value stored at location i to object o, returning the old value.
	*
	* @pre 0 <= i < size()
	* @post sets the ith entry of the list to value o, returns the old value.
	* @param i the location of the entry to be changed.
	* @param o the new value
	* @return the former value of the ith entry of the list.
	*/
	public E set(int i, E o)
	{
		Assert.pre( (0 <= i) && (i < size()), "Index out of range.");

		if (i >= size()) return null;
		DoublyLinkedNode<E> current = head.next();
		// search for the ith element of the list
		int j = 0;
		while (j < i){
			current = current.next();
			j++;
		}
		// get and return old value, update new value
		E temp = current.value();
		current.setValue(o);
		return temp;
	}

	/**
	* Determine the first location of a value in the list.
	*
	* @pre value is not null
	* @post returns the (0-origin) index of the value,
	*   or -1 if the value is not found
	*
	* @param value The value sought.
	* @return the index (0 is the first element) of the value, or -1
	*/
	public int indexOf(E value)
	{
		int i = 0;
		DoublyLinkedNode<E> current = head.next();
		// search for value or end of list, counting along the way
		while(current != tail && !current.value().equals(value)){
			current = current.next();
			i++;
		}
		// finger points to value, i is index
		if (current == tail){   // value not found, return indicator
			return -1;
		}
		else{   // value found, return index
			return i;
		}
	}

	/**
	* Determine the last location of a value in the list.
	*
	* @pre value is not null
	* @post returns the (0-origin) index of the value,
	*   or -1 if the value is not found
	*
	* @param value the value sought.
	* @return the index (0 is the first element) of the value, or -1
	*/
	public int lastIndexOf(E value)
	{
		int i = size()-1;
		DoublyLinkedNode<E> current = tail.previous();
		// search for the last matching value
		while (current != head && !current.value().equals(value)){
			current = current.previous();
			i--;
		}
		//current is set to desired index
		if(current == head){   // value not found, return indicator
			return -1;
		}
		else{   // value found, return index
			return i;
		}
	}

	/**
	* Check to see if a value is within the list.
	*
	* @pre value not null
	* @post returns true iff value is in the list
	*
	* @param value A value to be found in the list.
	* @return True if value is in list.
	*/
	public boolean contains(E value)
	{
		if(indexOf(value) == -1){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	* Remove a value from the list.  At most one value is removed.
	* Any duplicates remain.  Because comparison is done with "equals,"
	* the actual value removed is returned for inspection.
	*
	* @pre value is not null.  List can be empty.
	* @post first element matching value is removed from list
	*
	* @param value The value to be removed.
	* @return The value actually removed.
	*/
	public E remove(E value)
	{
		DoublyLinkedNode<E> current = head.next();
		while (current != tail && !current.value().equals(value)){
			current = current.next();
		}
		if(current != tail){
			// fix next field of element above
			current.previous().setNext(current.next());
			// fix previous field of element below
			current.next().setPrevious(current.previous());
			count--;		// fewer elements
			return current.value();
		}
		return tail.value();
	}

	/**
	* Construct an iterator to traverse the list.
	*
	* @post returns iterator that allows the traversal of list.
	*
	* @return An iterator that traverses the list from head to tail.
	*/
	public Iterator<E> iterator()
	{
		/**
		 * Students: once you have incorporated dummy nodes
		 * into your list implementation, please toggle the
		 * comments below. To understand why the lines below
		 * must be swapped, please consult the structure5
		 * source code for DoublyLinkedListIterator class.
		 */

		return new DoublyLinkedListIterator<E>(head,tail);
		//return new DoublyLinkedListIterator<E>(head);
	}

	/**
	* Construct a string representation of the list.
	*
	* @post returns a string representing list
	*
	* @return A string representing the elements of the list.
	*/
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		s.append("<LinkedList (" + count + "):");
		Iterator<E> li = iterator();
		while (li.hasNext())
		{
			s.append(" "+li.next());
		}
		s.append(">");
		return s.toString();
	}
}
