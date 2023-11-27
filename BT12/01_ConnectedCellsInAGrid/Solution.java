public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int tmp = 0, max = 0;
        
        //check for all cells in the matrix
        for(int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.get(0).size(); y++) {
                tmp = dfs(x, y, matrix);
                if (tmp > max) max = tmp;
            }
        }
        
        return max;   
    }
    
    private static int dfs(int x, int y, List<List<Integer>> matrix) {
        
        
        if (x < 0 || y < 0                                      
            //(x, y) out of bound
            || x > matrix.size() - 1 || y > matrix.get(0).size() - 1   
            //(x, y) out of bound
            || matrix.get(x).get(y) < 1) {                      
            //matrix[x][y] is visited (matrix[x][y] = -1) 
            //or it is not a filled cell (matrix[x][y] = 0)
                return 0;
            }
        
        //marked current cell as visited: matrix[x][y] = -1
        List<Integer> tmp = matrix.get(x);
        tmp.set(y, -1);
        matrix.set(x, tmp);
        
        //when current cell = 1, the total cells in connected cells is 1
        int count = 1;
        //recursively checking for all directions from current cells (check adjacency cells)
        for (int newX = x - 1; newX <= x + 1; newX++) {
            for (int newY = y - 1; newY <= y + 1; newY++) {
                count = count + dfs(newX, newY, matrix);
            }
        }
        
        return count;
    }