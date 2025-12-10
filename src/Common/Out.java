package Common;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;

public class Out
{
    public static void PrintLine(@NotNull String format, Object... args)
    {
        System.out.println(MessageFormat.format(format, args));
    }
}
