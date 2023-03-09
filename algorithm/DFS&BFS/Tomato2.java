import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private int x;
    private int y;
    Node(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    int GetX(){
        return this.x;
    }
    int GetY(){
        return this.y;
    }
}

class Tomato{
    private Queue<Node> q = new LinkedList();
    private int n;
    private int m;
    private int[][] arr;
    private int result;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    Tomato(int m,int n){
        this.n=n;
        this.m=m;
        this.arr = new int[n][m];
        this.result = Integer.MIN_VALUE;
    }
    void OutPut(){
        System.out.println(result);
        return;
    }
    void ArrMake() throws IOException{
        for(int i = 0 ; i<n;i++)
        {
            StringTokenizer st = new StringTokenizer(Tomato2.bf.readLine()," ");
            for(int j = 0 ; j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)
                    q.add(new Node(i,j));
            }
        }
    }
    void bfs(){
        while(!q.isEmpty())
        {
            Node node = q.poll();
            int x = node.GetX();
            int y = node.GetY();
            for(int i = 0 ; i<4;i++)
            {
                int nx = x+this.dx[i];
                int ny = y+this.dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m)
                {
                    if(arr[nx][ny]==0)
                    {
                        q.add(new Node(nx,ny));
                        arr[nx][ny]=arr[x][y]+1;
                    }
                }
            }
        }
        for(int i = 0 ; i<n;i++)
        {
            for(int j = 0 ; j<m;j++)
            {
                if(arr[i][j]==0) {
                    result = -1;
                    return;
                }
                result = Math.max(result,arr[i][j]);
            }
        }
        result-=1;
    }
}

public class Tomato2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Tomato tomato = new Tomato(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        tomato.ArrMake();
        tomato.bfs();
        tomato.OutPut();
        bf.close();
    }
}