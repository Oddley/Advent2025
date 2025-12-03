package Day3;

public class Bank {
    final String input;

    public Bank(String input)
    {
        this.input = input;
    }

    public int LargestJoltage()
    {
        return -1;
        // Not Implemented
    }

    @Override
    public boolean equals(Object obj)
    {
        return false;
        /* Not Implemented
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Bank other = (Bank) obj;
        return other.input.equals(this.input);
         */
    }
}
