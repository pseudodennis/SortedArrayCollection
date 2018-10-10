import java.util.Arrays;

public class SACollectionExtended<T> extends SortedArrayCollection<T>
{

	public SACollectionExtended()
	{
	}

	public SACollectionExtended(int capacity)
	{
		super(capacity);
	}


	/**
	 * creates and returns a string that correctly represents the current
	 * collection. Such a method could prove useful for testing and debugging
	 * the class and for testing and debugging applications that use the class.
	 * Assume each stored element already provides its own reasonable `toString`
	 * method.
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		String prefix = "[ ";
		String postfix = " ]";
		String delimiter = ", ";

		if (this.numElements == 0)
		{
			return prefix + postfix;
		}
		else
		{
			StringBuilder returnString = new StringBuilder(prefix);
			//returnString.append(prefix);
			for (T e : super.elements)
			{
				returnString.append(e.toString());
				returnString.append(delimiter);
			}
			returnString.replace(returnString.lastIndexOf(delimiter), (returnString.lastIndexOf(delimiter)) + (delimiter.length()), "");
			returnString.append(postfix);

			return returnString.toString();
		}


	}


	/**
	 * returns null if the collection is empty, otherwise returns the
	 * smallest element of the collection.
	 * @return
	 */
	public T smallest()
	{
		if (numElements==0)
			return null;
		else
			return elements[0];
	}

	/**
	 * returns a count of the number of  elements e in the
	 * collection that are greater than element, that is such that `e.compareTo
	 * (element)` is > 0.
	 * @param element
	 * @return
	 */
	public int greater(T element)
	{
		int index = Arrays.binarySearch(elements, element);
		return numElements-index-1;
	}

	/**
	 * creates and returns a new `SortedArrayCollection` object that is a
	 * combination of this object and the argument object.
	 * @param other
	 * @return
	 */
	public SACollectionExtended<T> combine(SACollectionExtended<T> other)
	{
		if (other.numElements == 0)
			return this;
		else if (this.numElements == 0)
			return other;
		else
		{
			SACollectionExtended<T> newSAC = new SACollectionExtended<>(this.numElements + other.size());
			for (T o : other.elements)
				newSAC.add(o);
			for (T t : this.elements)
				newSAC.add(t);
			return newSAC;
		}
	}


} // end SACollectionExtended
