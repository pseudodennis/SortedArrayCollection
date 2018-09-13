import java.util.Scanner;

/*	Dale, Joyce, Weems (4th) p154 #30:
 *	Using the ArrayBoundedStack class, create an application EditString that
 *	prompts the user for a string and then repeatedly prompts the user for changes to
 *	the string, until the user enters an X, indicating the end of changes. Legal change
 *	operations are:
 *		U — make all letters uppercase
 *		L — make all letters lowercase
 *		R — reverse the string
 *		C a b — change all occurrences of 'a' to 'b'
 *		Z — undo the most recent change
 *		X — end changes and exit
 *	You may assume a “friendly user,” that is, the user will not enter anything illegal. When
 *	the user is finished the resultant string is printed. For example, if the user enters:
 *		All dogs go to heaven
 *		U
 *		R
 *		Z
 *		C O A
 *		C A t
 *		Z
 *	the output from the program will be “ALL DAGS GA TA HEAVEN”
 */

public class EditString
{
	public static void main(String[] args)
	{
		ArrayBoundedStack<StringBuilder> stackOfText = new ArrayBoundedStack<StringBuilder>();
		stackOfText = initialPrompt(stackOfText);

		String entry = subsequentPrompt();

		while (!entry.equalsIgnoreCase("X"))							// exit the program if 'X'
		{
			try
			{
				switch (entry.toUpperCase().charAt(0))
				{
					case 'U':
					{
						System.out.println("Making all letters uppercase...");
						toUpper(stackOfText);
						System.out.println(stackOfText.top());
						break;
					}
					case 'L':
					{
						System.out.println("Making all letters lowercase...");
						toLower(stackOfText);
						System.out.println(stackOfText.top());
						break;
					}
					case 'R':
					{
						System.out.println("Reversing the string...");
						reversed(stackOfText);
						System.out.println(stackOfText.top());
						break;
					}
					case 'C':
					{
						System.out.println("Making the changes...");
						change(stackOfText, entry);
						System.out.println(stackOfText.top());
						break;
					}
					case 'Z':
					{
						System.out.print("Undoing...");
						undo(stackOfText);
						System.out.println("\n" + stackOfText.top());
						break;
					}
					default:
					{
						System.out.println("You did not make a valid entry, please try again...");
						break;
					}
				} // end switch
			} // end try
			catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
			}
			entry = subsequentPrompt();
		}

		System.out.println("Your final text is...");
		System.out.println(stackOfText.top());

	} // end of main()

	// text transform methods:
	public static void toUpper(ArrayBoundedStack<StringBuilder> stack)
	{
		StringBuilder upper = new StringBuilder(stack.top().toString().toUpperCase());
		stack.push(upper);
	}

	public static void toLower(ArrayBoundedStack<StringBuilder> stack)
	{
		StringBuilder lower = new StringBuilder(stack.top().toString().toLowerCase());
		stack.push(lower);
	}

	public static void reversed(ArrayBoundedStack<StringBuilder> stack)
	{
		StringBuilder temp = new StringBuilder(stack.top());
		stack.push(temp.reverse());
	}

	public static void change(ArrayBoundedStack<StringBuilder> stack, String entry)
	{
		String[] changes = entry.split(" ");
		StringBuilder replacements = new StringBuilder(stack.top().toString().replace(changes[1], changes[2]));
		stack.push(replacements);
	}

	public static void undo(ArrayBoundedStack<StringBuilder> stack)
	{
		StringBuilder redo = stack.top();
		stack.pop();
		if (stack.isEmpty())
		{
			stack.push(redo);
			System.out.println("\tNothing to undo!");
		}
	}


	// user prompts
	public static String subsequentPrompt()
	{
		System.out.println("\nPlease enter your change:");							// TODO: list the options
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static ArrayBoundedStack<StringBuilder> initialPrompt(ArrayBoundedStack<StringBuilder> stackOfText)
	{
		System.out.println("Please enter some text:");
		Scanner scanner = new Scanner(System.in);
		StringBuilder text = new StringBuilder(scanner.nextLine());
		stackOfText.push(text);
		return stackOfText;
	}

}	// end EditString class