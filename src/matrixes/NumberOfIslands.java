package matrixes;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public class Solution {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        public int numIslands(char[][] grid) {
            if(grid==null || grid.length==0) return 0;
            int islands = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        islands++;
                        BFS(grid,i,j);
                    }
                }
            }
            return islands;
        }
        private void BFS(char[][] grid, int x, int y){
            grid[x][y] = '0';
            Queue<Point> q = new LinkedList<Point>();
            q.offer(new Point(x,y));
            while(q.size()>0){
                int size = q.size();
                Point p = q.poll();
                for(int i=0;i<size;i++){
                    for(int[] dir:dirs){
                        int x1 = p.x+dir[0];
                        int y1 = p.y+dir[1];
                        if(x1>=0 && y1>=0 && x1< grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
                            grid[x1][y1] = '0';
                            q.offer(new Point(x1,y1));
                        }
                    }
                }
            }
        }
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
