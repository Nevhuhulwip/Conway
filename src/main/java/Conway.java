public class Conway {
    public static void main(String[] args)
    {
        int width=10, height=10;
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        System.out.println("Initial Generation");
        for (int i = 0; i <width ; i++)
        {
            for (int j = 0; j <height; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("*");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid,width , height);
    }

    static void nextGeneration(int grid[][], int width , int height)
    {
        int[][] future = new int[width][height];
        for (int l = 1; l <width  - 1; l++)
        {
            for (int m = 1; m < height - 1; m++)
            {

                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                aliveNeighbours -= grid[l][m];

                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;


                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;


                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i <width ; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("*");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}