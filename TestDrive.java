
public class TestDrive
{

	public static void main(String[] args)
	{
		// setup first ArrayCollection
		String[] stringArray1 = {"Bravo", "Alpha", "Foxtrot", "Echo"};
		SACollectionExtended<String> stringCollection1 = new SACollectionExtended<>(stringArray1.length);
		for (String s : stringArray1)
			stringCollection1.add(s);


		// setup second ArrayCollection
		String[] stringArray2 = {"Delta", "Charlie"};
		SACollectionExtended<String> stringCollection2 = new SACollectionExtended<>(stringArray2.length);
//		for (String s : stringArray2)
//			stringCollection2.add(s);

		// combine into third collection
		SACollectionExtended<String> stringCollection3 = stringCollection1.combine(stringCollection2);


		// test methods
		System.out.println("Collection 1:\t\t" + stringCollection1.toString());
		System.out.println("Collection 2:\t\t" + stringCollection2.toString());
		System.out.println("Collection 1+2:\t\t" + stringCollection3.toString());

		System.out.println("Smallest element:\t" + stringCollection3.smallest());

		String search = "Delta";
		System.out.println("Number of elements greater than " + search + ":\t" + stringCollection3.greater(search));

	}

}
