package gameoflife.kata;

/**
 * Created by michele on 06/12/13.
 */
public class Cell
{

    private final boolean live;

    public Cell(String p)
    {
        live = "*".equals(p) ? true : false;
    }

    public boolean isLive()
    {
        return live;
    }

}
