class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int longestVDiagonal = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] lenGrid = new int[4][rows][cols];
        int[][] directions = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int col = 0; col < cols; col++) {
            for(int iRow = 0, iCol = col; iRow < rows && iCol < cols;iRow += directions[0][0], iCol += directions[0][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iRow == 0) {
                        lenGrid[2][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow-1][iCol-1]) {
                            lenGrid[2][iRow][iCol] = lenGrid[2][iRow-1][iCol-1] + 1;
                        } else {
                            lenGrid[2][iRow][iCol] = 1;
                        }
                    }
                }
            }
            for(int iRow = rows -1, iCol = col; iRow >= 0 && iCol < cols;iRow += directions[3][0], iCol += directions[3][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iRow == rows -1) {
                        lenGrid[1][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow + 1][iCol-1]) {
                            lenGrid[1][iRow][iCol] = lenGrid[1][iRow + 1][iCol-1] + 1;
                        } else {
                            lenGrid[1][iRow][iCol] = 1;
                        }
                    }
                }
            }
        }

        for (int col = cols -1; col >=0; col--) {
            for(int iRow = 0, iCol = col; iRow < rows && iCol >= 0;iRow += directions[1][0], iCol += directions[1][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iRow == 0) {
                        lenGrid[3][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow-1][iCol+1]) {
                            lenGrid[3][iRow][iCol] = lenGrid[3][iRow-1][iCol+1] + 1;
                        } else {
                            lenGrid[3][iRow][iCol] = 1;
                        }
                    }
                }
            }
            for(int iRow = rows-1, iCol = col; iRow >= 0 && iCol >= 0; iRow += directions[2][0], iCol += directions[2][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iRow == rows -1) {
                        lenGrid[0][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow + 1][iCol +1]) {
                            lenGrid[0][iRow][iCol] = lenGrid[0][iRow + 1][iCol+1] + 1;
                        } else {
                            lenGrid[0][iRow][iCol] = 1;
                        }
                    }
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            for(int iRow = row, iCol = 0; iRow < rows && iCol < cols;iRow += directions[0][0], iCol += directions[0][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iCol == 0) {
                        lenGrid[2][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow-1][iCol-1]) {
                            lenGrid[2][iRow][iCol] = lenGrid[2][iRow-1][iCol-1] + 1;
                        } else {
                            lenGrid[2][iRow][iCol] = 1;
                        }
                    }
                }
            }
            for(int iRow = row, iCol = cols -1; iRow < rows && iCol >= 0;iRow += directions[1][0], iCol += directions[1][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iCol == cols -1) {
                        lenGrid[3][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow - 1][iCol+1]) {
                            lenGrid[3][iRow][iCol] = lenGrid[3][iRow - 1][iCol+1] + 1;
                        } else {
                            lenGrid[3][iRow][iCol] = 1;
                        }
                    }
                }
            }
        }

        for (int row = rows -2; row >=0; row--) {
            for(int iRow = row, iCol = 0; iRow >= 0 && iCol < cols;iRow += directions[3][0], iCol += directions[3][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iCol == 0) {
                        lenGrid[1][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow+1][iCol-1]) {
                            lenGrid[1][iRow][iCol] = lenGrid[1][iRow+1][iCol-1] + 1;
                        } else {
                            lenGrid[1][iRow][iCol] = 1;
                        }
                    }
                }
            }
            for(int iRow = row, iCol = cols-1; iRow >= 0 && iCol >= 0; iRow += directions[2][0], iCol += directions[2][1]) {
                if(grid[iRow][iCol] != 1) {
                    if(iCol == cols -1) {
                        lenGrid[0][iRow][iCol] = 1;
                    } else {
                        if(grid[iRow][iCol] != grid[iRow + 1][iCol +1]) {
                            lenGrid[0][iRow][iCol] = lenGrid[0][iRow + 1][iCol+1] + 1;
                        } else {
                            lenGrid[0][iRow][iCol] = 1;
                        }
                    }
                }
            }
        }

        
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    for(int dir = 0; dir < directions.length; dir++) {
                        int iRow = row + directions[dir][0];
                        int iCol = col + directions[dir][1];
                        int gridValue = 0;
                        int length = 1;
                        int maxLength =1;
                        longestVDiagonal = Math.max(longestVDiagonal, maxLength);
                        while(iRow >=0 && iCol >= 0 && iRow < rows && iCol < cols && (grid[iRow][iCol]^2) == gridValue) {
                            maxLength = length + Math.max(lenGrid[(dir) % 4][iRow][iCol], lenGrid[(dir + 1) % 4][iRow][iCol]);
                            longestVDiagonal = Math.max(longestVDiagonal, maxLength);
                            length++;
                            iRow = iRow + directions[dir][0];
                            iCol = iCol + directions[dir][1];
                            gridValue = gridValue^2;
                        }
                    }
                }
            }
        }
        return longestVDiagonal;
    }
}