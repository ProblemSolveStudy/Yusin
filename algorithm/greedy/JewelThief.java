package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewelThief {

		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int n= Integer.parseInt(st.nextToken());
			int k= Integer.parseInt(st.nextToken());
			int arr[][] = new int[n][2];
			int w[] = new int[k];
			
			for(int i=0;i<n;i++)
			{
				st = new StringTokenizer(bf.readLine()," ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr,(e1,e2)->{							//보석은 무게에 대해 오름차순 정렬하되, 무게가 같을 경우 가격에 대해 내림차순 정렬한다.
				if(e1[0]==e2[0])
					return e2[1]-e1[1];
				else
					return e1[0]-e2[0];
					
			});
			
			for(int i=0;i<k;i++)
				w[i]=Integer.parseInt(bf.readLine());
			long result=0;
			int c=0;
			Arrays.sort(w);										//가방무게를 오름차순으로 정렬한다.
			for(int i=0;i<k;i++)								//가방갯수까지 돌린다 이게 가능한 이유 정렬을 하였기 때문이다.
			{
				while(c<n&&arr[c][0]<=w[i])						//카운트가 값보다 작을때 그리고 오름차순으로 정렬해놓은 것에대한 값과 가방무게를 오름차순한 부분을 비교하여
					pq.add(arr[c++][1]);						//만약 값이 작거나 같다면 큐에 저장을한다
				if (!pq.isEmpty())
					result+=pq.poll();							//가방갯수에 따라 값을 저장하는대 그 값이 가방보다 작을때만 저장하기떄문에 큐 갯수는 가방 갯수에 따라 되는게아닌
			}													//값이 있는것만큼만 더하기 떄문에 문제가 없음
			
			System.out.println(result);
		}
	}
