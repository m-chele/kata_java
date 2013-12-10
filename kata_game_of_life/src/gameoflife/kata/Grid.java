package gameoflife.kata;

import java.util.ArrayList;


/**
 * Created by michele on 06/12/13.
 */
public class Grid
{
    private ArrayList<ArrayList<Cell>> grid;

    public Grid(String startingPositions)
    {
        String[] gridRows = startingPositions.split("\n");

        grid = new ArrayList<ArrayList<Cell>>(gridRows.length);

        int rowIndex = 0;
        for (String row : gridRows)
        {
            grid.add(new ArrayList<Cell>(row.length()));
            for (String val : row.split("(?!^)"))
            {
                grid.get(rowIndex).add(new Cell(val));
            }
            rowIndex++;
        }
    }

    public String nextGeneration()
    {
        String nextGeneration = "";

        for (ArrayList<Cell> row : grid)
        {
            for (Cell cell : row)
            {
                if (cell.isLive())
                {
                    nextGeneration += ".";
                }
                else
                {
                    nextGeneration += "*";
                }
            }
        }
        return nextGeneration;
    }


    public int getLivingNeighboursCount(int rowIndex, int cellIndex)
    {
        int living = 0;
        if (grid.get(rowIndex).get(cellIndex + 1).isLive())
        {
            living++;
        }

        return living;
    }


    public ArrayList<Cell> getAvailableNeighborgs(int rowIndex, int cellIndex)
    {
        ArrayList<Cell> neighborgs = new ArrayList<Cell>();

        neighborgs.add(grid.get(rowIndex - 1).get(cellIndex - 1));
        neighborgs.add(grid.get(rowIndex - 1).get(cellIndex));
        neighborgs.add(grid.get(rowIndex - 1).get(cellIndex + 1));
        neighborgs.add(grid.get(rowIndex).get(cellIndex - 1));
        neighborgs.add(grid.get(rowIndex).get(cellIndex + 1));
        neighborgs.add(grid.get(rowIndex + 1).get(cellIndex - 1));
        neighborgs.add(grid.get(rowIndex + 1).get(cellIndex));
        neighborgs.add(grid.get(rowIndex + 1).get(cellIndex + 1));

        // horizontal single line
//        if (rowIndex >= 0 && rowIndex < grid.size())
//        {
//            if (cellIndex >= 0 && cellIndex < grid.get(rowIndex).size() - 2)
//            {
//                // next
//                neighborgs.add(grid.get(rowIndex).get(cellIndex + 1));
//            }
//            if (cellIndex >= 0 && cellIndex < grid.get(rowIndex).size())
//            {
//                // previous
//                neighborgs.add(grid.get(rowIndex).get(cellIndex - 1));
//            }
//        }
        return neighborgs;

    }
}
