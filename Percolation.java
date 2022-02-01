package com.miklewska;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private Boolean[][] grid; // true = open site, false = closed site
    private int grid_size;
    private int all_elements;
    private WeightedQuickUnionUF wuf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <= 0) throw new IllegalArgumentException("N must be greater than 0");
        grid_size = n;
        all_elements = n * n;
        grid = new Booelean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = false;
            }
        }
        wuf = new WeightedQuickUnionUF(all_elements + 2); // includes virtual top and bottom
    }

    //OWN: get flattened index to ues in wuf
    public int getFlattenedIndex(int row, int col){
        return col * grid_size + row;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if(grid[row][col] == false){
            grid[row][col] = true;
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        return grid[row][col];
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        int open = 0;
        for(int i = 0; i < grid_size; i++){
            for(int j = 0; j < grid_size; j++){
                if(grid[i][j] == true){
                    open++;
                }
            }
        }
        return open;
    }

    // does the system percolate?
    public boolean percolates(){
        return true;

    }

    // test client (optional)
    public static void main(String[] args){
        Percolation p = new Percolation(3);
        int c = 2;

    }
}
