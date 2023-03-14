//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class b1260 {
//    static int n;
//    static int m;
//    static int v;
//
//    static int[][] arr;
//    static boolean[] b;
//
//    static Queue<Integer> q = new LinkedList<>();
//    public static void dfs(int v){
//        b[v]=true;
//        System.out.print(v + " ");
//        for(int i=0;i<=n ; i++)
//        {
//            if(arr[v][i]==1&&!b[i])
//                dfs(i);
//        }
//    }
//    public static void bfs(int v){
//        q.add(v);
//        b[v]=true;
//        while(!q.isEmpty()) {
//            v = q.poll();
//            System.out.print(v + " ");
//            for(int i=1 ; i<=n;i++)
//            {
//                if(arr[v][i]==1 && !b[i])
//                {
//                    q.add(i);
//                    b[i]=true;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        v = Integer.parseInt(st.nextToken());
//        arr = new int[n+1][n+1];
//        b = new boolean[n+1];
//        for(int i = 0 ; i<m;i++) {
//            st = new StringTokenizer(bf.readLine()," ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            arr[a][b] = arr[b][a] = 1;
//        }
//        dfs(v);
//        System.out.println();
//        b = new boolean[n+1];
//        bfs(v);
//        bf.close();
//    }
//
//}