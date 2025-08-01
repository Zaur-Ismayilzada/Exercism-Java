class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {
        int[][] res = new int[size][size];

        int start = 1;
        int end   = size * size;
        int col   = 0;
        int row   = 0;

        String dir = "right";

        fill(res, start, end, row, col, size, dir); 

        return res;
    }

    void fill(int[][] res, int start, int end, int row, int col, int size, String dir){
        if (start > end)return;

        if (res[row][col] != 0){
            dir          = new_direction(dir);
            int[] coords = new_coords(row, col, dir);
            row          = coords[0];
            col          = coords[1];
        }

        res[row][col] = start;
        start++;

        int[] coords = new_coords(row, col, dir);
        int t_row    = coords[0];
        int t_col    = coords[1];

        if (!((t_row < size && t_row >= 0) && (t_col < size && t_col >= 0) && (res[t_row][t_col] == 0))){
            dir    = new_direction(dir);
            coords = new_coords(row, col, dir);
            row    = coords[0];
            col    = coords[1];
            fill(res, start, end, row, col, size, dir);
            return;
        }

        fill(res, start, end, t_row, t_col, size, dir);
    }

    String new_direction(String dir){
        String result = dir;
        if (dir.equals("right"))
            result = "down";
        else if (dir.equals("down"))
            result = "left";
        else if (dir.equals("left"))
            result = "up";
        else if (dir.equals("up"))
            result = "right";

        return result;
    }

    int[] new_coords(int row, int col, String dir){
        if (dir.equals("right"))
            col++;
        else if (dir.equals("down"))
            row++;
        else if (dir.equals("left"))
            col--;
        else if (dir.equals("up"))
            row--;

        return new int[]{row, col};
    } 
}
