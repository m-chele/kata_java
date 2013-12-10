import gameoflife.kata.Cell;
import gameoflife.kata.Grid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michele on 06/12/13.
 */
public class MyTest
{
    @Test
    public void single_cell_will_dead()
    {
        Grid grid = new Grid("*");
        assertEquals(".", grid.nextGeneration());
    }

    @Test
    public void single_row_one_dead_between_two_living_inverts_status()
    {
        Grid grid = new Grid("*.*");
        assertEquals(".*.", grid.nextGeneration());
    }

    @Test
    public void cell_life_status() throws Exception
    {
        Cell living = new Cell("*");
        assertEquals(living.isLive(), true);
        Cell dead = new Cell(".");
        assertEquals(dead.isLive(), false);
    }

    @Test
    public void living_neighbours_in_a_row() throws Exception
    {
        Grid grid = new Grid("**");
        assertEquals(1, grid.getLivingNeighboursCount(0, 0));
    }

    @Test
    public void available_neighborgs_in_a_row_are_2() throws Exception
    {
        String singleRowConfiguration = "........\n";
        Grid grid = new Grid(singleRowConfiguration);

        assertEquals(2, grid.getAvailableNeighborgs(0, 3).size());
    }

    @Test
    public void available_neighborgs_in_2_rows_are_5() throws Exception
    {
        String twoRowsConfiguration = "........\n";
        twoRowsConfiguration += "....*...\n";
        Grid grid = new Grid(twoRowsConfiguration);

        assertEquals(5, grid.getAvailableNeighborgs(0, 3).size());
    }

    @Test
    public void available_neighborgs_in_3_rows_are_8() throws Exception
    {
        String threeRowsConfiguration = "........\n";
        threeRowsConfiguration += "........\n";
        threeRowsConfiguration += "........\n";
        Grid grid = new Grid(threeRowsConfiguration);

        assertEquals(8, grid.getAvailableNeighborgs(1, 3).size());
    }

    // test limite superiore: vicini in riga 0
    // test limite inferiore: vicini in riga ultima
    // test limite sinistro: vicini in cella 0
    // test limite dstrodr: vicini in cella ultima

}
