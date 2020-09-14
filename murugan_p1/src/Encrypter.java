public class Encrypter
{
    private String givenInput;

    public String encrypt(String givenInput)
    {
        this.givenInput = givenInput;

        int integers;
        int[] integerArray;
        String[] encryptedString;
        String encryptedValue;

        integerArray    = new int[givenInput.length()];
        encryptedString = new String[givenInput.length()];

        //converting the given string to integers
        integers = Integer.parseInt(givenInput);

        //loop Iterates through each character in the given string and stores in an integer array
        for(int i = givenInput.length()-1; i >= 0; i--)
        {
            integerArray[i] = integers % 10;
            integers        = integers / 10;
        }

        add7(integerArray);
        moduloBy10(integerArray);
        swapFirstThird(integerArray);
        swapSecondFourth(integerArray);

        //loop iterates through each character in the given string and converts string array to string

        encryptedValue = "";

        for(int i = 0; i < givenInput.length(); i++)
        {
            encryptedString[i] = String.valueOf(integerArray[i]);
            encryptedValue = encryptedValue + encryptedString[i];
        }

        return encryptedValue;
    }

    //Precondition:  This function takes an integer array as parameter
    //Postcondition: This function adds 7 to the integers in the array
    public void add7(int[] integerArray)
    {
        for(int i = givenInput.length() - 1; i >= 0; i--)
        {
            integerArray[i] = integerArray[i] + 7;
        }
    }

    //Precondition:  This function takes an integer array as parameter
    //Postcondition: This function divides the integer by 10 and stores the remainder in the integer array.
    public void moduloBy10(int[] integerArray)
    {
        for(int i = givenInput.length() - 1; i >= 0; i--)
        {
            integerArray[i] = integerArray[i] % 10;
        }
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
}
