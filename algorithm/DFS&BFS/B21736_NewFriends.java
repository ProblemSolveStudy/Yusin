import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x;
    private int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class NewFriends{
    private int n,m,result=0;
    private int[] dx = {-1,1,0,0},dy = {0,0,-1,1};
    private boolean[][] check;
    private char[][] arr;
    Queue<Node> q = new LinkedList();
    NewFriends() throws IOException {
        B21736_NewFriends.st = new StringTokenizer(B21736_NewFriends.bf.readLine()," ");
        n = Integer.parseInt(B21736_NewFriends.st.nextToken());
        m = Integer.parseInt(B21736_NewFriends.st.nextToken());
        arr = new char[n][m];
        check = new boolean[n][m];
        ArrMake();
        bfs();
        OutPut();
    }

    private void bfs() {
        for(int i=0;i<n;i++)
        {
            for(int j = 0 ; j<m;j++)
            {
                if(arr[i][j]!='I' || check[i][j])
                    continue;
                q.add(new Node(i,j));
                check[i][j]=true;
                while(!q.isEmpty())
                {
                    Node node = q.poll();
                    int x = node.getX();
                    int y = node.getY();
                    for(int k=0;k<4;k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx>=0&&ny>=0&&nx<n&&ny<m)
                        {
                            if(arr[nx][ny]!='X'&&!check[nx][ny]) {
                                q.add(new Node(nx, ny));
                                check[nx][ny] = true;
                                if(arr[nx][ny]=='P')
                                    result++;
                            }
                        }
                    }
                }
            }
        }
    }

    private void ArrMake() throws IOException {
        for(int i = 0 ; i<n ;i++) {
            String str = B21736_NewFriends.bf.readLine();
            for(int j=0;j<m;j++)
                arr[i][j]=str.charAt(j);
        }
    }

    private void OutPut() {
        if(result!=0)
            System.out.println(result);
        else
            System.out.println("TT");
    }

}

public class B21736_NewFriends {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        NewFriends nf = new NewFriends();
        bf.close();
    }
}
