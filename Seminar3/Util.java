package java_class.Seminar3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Util {
    private static final int M = 10;
    private static final int N = 10;

    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
    }

    private static void breadth_first_search(int mat[][], int i, int j, int x, int y) {
        boolean[][] visited = new boolean[M][N];
        Queue<Node> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }
        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from the source to the destination has the length of " + min_dist);
        } else {
            System.out.println("The destination cannot be reached.");
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        };

        breadth_first_search(mat, 0, 0, 3, 7);
    }
}

class Node {
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
