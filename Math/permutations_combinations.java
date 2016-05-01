public class permutations_combinations 
{
	static int count = 0;
	public static void main (String[] args)
	{
		String str = "12345";
		doPermutations("", str);
		doCombinations("", str);
	}
	//Function to create permutations
	public static void doPermutations(String pre, String str)
	{
		if (str.length() == 0)
		{
			//This outputs the permutations
			System.out.println(pre);
		}			
		else
		{
			for(int i=0; i<str.length(); i++)
			{
				//Goes through each part of the string doing every permutation at each point
				doPermutations(pre + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
			}
		}
	}
	//Function to create combinations
    public static void doCombinations(String pre, String str)
	{
        if (str.length() > 0) 
		{
			//Prints out the combinations
            System.out.println(pre + str.charAt(0));
			
			//Create the combinations
            doCombinations(pre + str.charAt(0), str.substring(1));
            doCombinations(pre, str.substring(1));
        }    
	}
}
