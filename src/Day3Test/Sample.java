package Day3Test;

import Day3.Bank;
import java.util.List;

public class Sample {
    public static final String Line1 = "987654321111111";
    public static final String Line2 = "811111111111119";
    public static final String Line3 = "234234234234278";
    public static final String Line4 = "818181911112111";

    public static final Bank Bank1 = new Bank(Line1);
    public static final Bank Bank2 = new Bank(Line2);
    public static final Bank Bank3 = new Bank(Line3);
    public static final Bank Bank4 = new Bank(Line4);

    public static final int Joltage1 = 98;
    public static final int Joltage2 = 89;
    public static final int Joltage3 = 78;
    public static final int Joltage4 = 92;

    public static final int TotalLargestJoltage = 357;

    public static final List<String> Lines = List.of(Line1, Line2, Line3, Line4);
    public static final List<Bank> Banks = List.of(Bank1, Bank2, Bank3, Bank4);
}