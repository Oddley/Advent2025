package Day3;

import java.util.List;

public class Calculations {
    public static int LargestTotalJoltage(List<Bank> banks)
    {
        int sum = 0;
        for (var bank : banks)
        {
            sum += bank.LargestJoltage();
        }
        return sum;
    }
}
