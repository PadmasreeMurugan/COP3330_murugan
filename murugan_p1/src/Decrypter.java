public class Decrypter
{
    private String givenInput;

    public String decrypt(String givenInput)
    {
        this.givenInput = givenInput;

        int integers;
        int[] integerArray;
        String[] decryptedString;
        String decryptedValue;

        integerArray    = new int[givenInput.length()];
        decryptedString = new String[givenInput.length()];

        //converting the given string to integers
        integers = Integer.parseInt(givenInput);

        //loop Iterates through each character in the given string and stores in an integer array
        for(int i = givenInput.length()-1; i >= 0; i--)
        {
            integerArray[i] = integers % 10;
            integers        = integers / 10;
        }

        swapFirstThird(integerArray);
        swapSecondFourth(integerArray);
        performDecryption(integerArray);

        //loop iterates through each character in the given string and converts string array to string
        decryptedValue ="";

        for(int i = 0; i < givenInput.length(); i++)
        {
            decryptedString[i] = String.valueOf(integerArray[i]);
            decryptedValue= decryptedValue + decryptedString[i];
        }

        return decryptedValue;
    }

    //Precondition:  This function takes an integer array as parameter
    //Postcondition: This function swaps the integers in the index 0 and 2 of the integer array
    public void swapFirstThird(int[] integerArray)
    {
        int temp = integerArray[0];
        integerArray[0] = integerArray[2];
        integerArray[2] = temp;
    }

    //Precondition:  This function takes an integer array as parameter
    //Postcondition: This function swaps the integers in the index 1 and 3 of the integer array
    public void swapSecondFourth(int[] integerArray)
    {
        int temp = integerArray[1];
        integerArray[1] = integerArray[3];
        integerArray[3] = temp;
    }

    //Precondition:  This function takes an integer array as parameter
    //Postcondition: This function performs decryption operation based on the integer value
    public void performDecryption(int[] integerArray)
    {
        //loop iterates through each character in the given string
        for(int i = 0; i < givenInput.length(); i++)
        {
            //if the integer value is greater than or equal to 7, then it directly deducts 7
            if(integerArray[i] >= 7)
            {
                integerArray[i] = deduct7(integerArray[i]);
            }

            //if the integer value is less than 7, then it adds 10 and then deducts 7
            else if(integerArray[i] < 7)
            {
                integerArray[i] = add10(integerArray[i]);
                integerArray[i] = deduct7(integerArray[i]);
            }
        }
    }

    //Precondition:  This function takes an integer as parameter
    //Postcondition: This function deducts 7 from the integer value and returns the integer
    public int deduct7(int integer)
    {
        integer = integer - 7;
        return integer;
    }

    //Precondition:  This function takes an integer as parameter
    //Postcondition: This function adds 10 to the integer value and returns the integer
    public int add10 (int integer)
    {
        integer = integer + 10;
        return integer;
    }
}
