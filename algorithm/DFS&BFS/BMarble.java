//package BaekJoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//class Node {
//    private int rx, ry, bx, by, cnt;
//
//    Node(int rx, int ry, int bx, int by, int cnt) {
//        this.rx = rx;
//        this.ry = ry;
//        this.bx = bx;
//        this.by = by;
//        this.cnt = cnt;
//    }
//
//    public int getRx() {
//        return rx;
//    }
//
//    public int getRy() {
//        return ry;
//    }
//
//    public int getBx() {
//        return bx;
//    }
//
//    public int getBy() {
//        return by;
//    }
//
//    public int getCnt() {
//        return cnt;
//    }
//}
//
//class MarbleEscape {
//    private int n, m, cnt, hx, hy;
//    private char[][] arr;
//    private int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
//    private boolean[][][][] check;
//    Node red, blue;
//
//    MarbleEscape() throws IOException {
//        BMarble.st = new StringTokenizer(BMarble.bf.readLine(), " ");
//        n = Integer.parseInt(BMarble.st.nextToken());
//        m = Integer.parseInt(BMarble.st.nextToken());
//        arr = new char[n][m];
//        check = new boolean[n][m][n][m];
//        ArrMake();
//        OutPut(bfs());
//    }
//
//    private int bfs() {
//        Queue<Node> q = new LinkedList<>();
//        q.add(new Node(red.getRx(), red.getRy(), blue.getBx(), blue.getBy(), 1));
//        check[red.getRx()][red.getRy()][blue.getBx()][blue.getBy()] = true;
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//            int rx = node.getRx();
//            int ry = node.getRy();
//            int bx = node.getBx();
//            int by = node.getBy();
//            cnt = node.getCnt();
//            if (cnt > 10) {
//                return -1;
//            }
//            for (int i = 0; i < 4; i++) {
//                int nrx = rx;
//                int nry = ry;
//                int nbx = bx;
//                int nby = by;
//
//                boolean rh = false;
//                boolean bh = false;
//
//                while (arr[nrx + dx[i]][nry + dy[i]] != '#') {
//                    nrx += dx[i];
//                    nry += dy[i];
//
//                    if (nrx == hx && nry == hy) {
//                        rh = true;
//                        break;
//                    }
//                }
//                while (arr[nbx + dx[i]][nby + dy[i]] != '#') {
//                    nbx += dx[i];
//                    nby += dy[i];
//                    if (nbx == hx && nby == hy) {
//                        bh = true;
//                        break;
//                    }
//                }
//                if (bh)
//                    continue;
//                if (rh && !bh) {
//                    return cnt;
//                }
//                if (nrx == nbx && nry == nby) {
//                    if (i == 0) {
//                        if (rx > bx) nrx -= dx[i];
//                        else nbx -= dx[i];
//                    } else if (i == 1) {
//                        if (ry < by) nry -= dy[i];
//                        else nby -= dy[i];
//                    } else if (i == 2) {
//                        if (rx < bx) nrx -= dx[i];
//                        else nbx -= dx[i];
//                    } else {
//                        if (ry > by) nry -= dy[i];
//                        else nby -= dy[i];
//                    }
//                }
//                if (!check[nrx][nry][nbx][nby]) {
//                    check[nrx][nry][nbx][nby] = true;
//                    q.add(new Node(nrx, nry, nbx, nby, cnt + 1));
//                }
//            }
//        }
//        return -1;
//    }
//
//    private void ArrMake() throws IOException {
//        for (int i = 0; i < n; i++) {
//            String str = BMarble.bf.readLine();
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = str.charAt(j);
//                if (arr[i][j] == 'O') {
//                    hx = i;
//                    hy = j;
//                } else if (arr[i][j] == 'R')
//                    red = new Node(i, j, 0, 0, 0);
//                else if (arr[i][j] == 'B')
//                    blue = new Node(0, 0, i, j, 0);
//            }
//        }
//    }
//
//    private void OutPut(int v) {
//        System.out.println(v);
//    }
//}
//
//public class BMarble {
//    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//
//    public static void main(String[] args) throws IOException {
//        MarbleEscape marbleEscape = new MarbleEscape();
//        bf.close();
//    }
//}
