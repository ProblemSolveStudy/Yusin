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
    private Queue<Node> q = new LinkedList();                   //노드값을 큐에 저장하기 위함
    private int n;                                              //x좌표
    private int m;                                              //y좌표
    private int[][] arr;                                        //그래프 크기(상자크기)
    private int result;                                         //카운팅갯수
    private int[] dx = {-1,1,0,0};                              //x값의 4방향 확인을 위한 좌표값
    private int[] dy = {0,0,-1,1};                              //y값의 4방향 확인을 위한 좌표값
    Tomato(int m,int n){                                        //생성자를 통한 초기화
        this.n=n;
        this.m=m;
        this.arr = new int[n][m];
        this.result = Integer.MIN_VALUE;
    }
    void OutPut(){
        System.out.println(result);                             //결과값 출력
    }
    void ArrMake() throws IOException{          //배열생성 어차피 객체내에서만 사용하기에 this가 필요없음
        for(int i = 0 ; i<n;i++)
        {
            StringTokenizer st = new StringTokenizer(Tomato2.bf.readLine()," ");
            for(int j = 0 ; j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)
                    q.add(new Node(i,j));       //배열생성시 익은 토마토의 노드값을 큐에 저장해놓음
            }
        }
    }
    void bfs(){                                         //그래프 형식으로 봐야하기 떄문에 x,y좌표를 사용함
        while(!q.isEmpty())
        {
            Node node = q.poll();                       //아까 빼놓은 익은 토마토의 노드값을 저장함
            int x = node.GetX();                        //익은 토마토의 x좌표
            int y = node.GetY();                        //익은 토마토의 y좌표
            for(int i = 0 ; i<4;i++)
            {
                int nx = x+this.dx[i];                  //4방향에 있는 안익은 토마토를 찾기위함
                int ny = y+this.dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m)            //노드의 위치가 토마토상자를 벗어나면 안됨 그러므로 조건값을 줌
                {
                    if(arr[nx][ny]==0)                  //주변에 익지 않은 토마토가 있다면 카운팅을 해줌
                    {
                        q.add(new Node(nx,ny));         //그리고 그 익지 않은 토마토의 노드 값을 저장함 (익지않은걸 익은것처럼 표한하기 위함)
                        arr[nx][ny]=arr[x][y]+1;        //익지 않은 토마토를 익게 만듬
                    }                                   //주변에 익지않은 토마토가 없을 때까지 반복함 하지만 비어있는 공간이라면 스킵함
                }
            }
        }
        for(int i = 0 ; i<n;i++)
        {
            for(int j = 0 ; j<m;j++)
            {
                if(arr[i][j]==0) {                      //비어있는 공간때문에 토마토가 익지 않았다면 그 토마토는 익지 않기 떄문에 익지 않는다고 표현해줘야함
                    result = -1;
                    return;
                }
                result = Math.max(result,arr[i][j]);    //상자 안에 있는 값중에 최대값을 찾기 위함(어디에 카운팅 최대값이 있는지 모르기떄문에 손수 다 찾아서 확인해야함)
            }
        }
        result-=1;                                      //만약 모든 토마토가 익었거나 아니면 익어있었더라면 하나를 줄여서 출력하면 조건에 맞출수 있음
    }
}

public class Tomato2 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Tomato tomato = new Tomato(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        tomato.ArrMake();           //배열생성
        tomato.bfs();               //bfs를 통한 값 찾기
        tomato.OutPut();            //bfs를 통한 값을 출력
        bf.close();
    }
}