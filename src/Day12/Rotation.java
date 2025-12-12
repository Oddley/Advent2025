package Day12;

public record Rotation(IPackage Contents, int Count) implements IPackage
{
    @Override
    public int Width() {
        return Count%2==0 ? Contents.Width() : Contents.Height();
    }

    @Override
    public int Height() {
        return Count%2==0 ? Contents.Height() : Contents.Width();
    }

    @Override
    public int UnusedArea() {
        return Contents.UnusedArea();
    }

    @Override
    public boolean TestShape(int x, int y) {
        int transX;
        int transY;
        var remainder = Count%4;
        switch (remainder)
        {
            case 1:
                transX = y;
                transY = Width() - (x+1);
                break;
            case 2:
                transX = Width() - (x+1);
                transY = Height() - (y+1);
                break;
            case 3:
                transX = Height() - (y+1);
                transY = x;
                break;
            default:
                transX = x;
                transY = y;
                break;
        }
        return Contents.TestShape(transX, transY);
    }
}
