class Matrix {
    private int[][] arr;
    Matrix(String matrixAsString) {
        String[] strs = matrixAsString.split("\n");

        arr = getArray(strs);
    }

    int[] getRow(int rowNumber) {
        return arr[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] result = new int[arr.length];

        int index = 0;

        for (int i = 0; i < arr.length; i++){
            result[index] = arr[i][columnNumber - 1];
            index++; 
        }

        return result;
    }

    private int[][] getArray(String[] strs){
        int[][] result = new int[strs.length][];

        for (int i = 0; i < strs.length; i++){
            String[] temp = strs[i].split(" ");
            result[i] = new int[temp.length];

            for (int j = 0; j < temp.length; j++){
                result[i][j] = Integer.parseInt(temp[j]);
            }
        }

        return result;
    }
}
