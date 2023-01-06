import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;;

public class BFS_direct {
        private static LinkedList<Integer> adj[];
        private static int V;
        public BFS_direct(int s){
            V=s;
            this.adj=new LinkedList[s];
            for(int i=0;i<s;i++){
                adj[i]=new LinkedList<>();
            }
            
        }
        public static void addedge(int n,int m){
            adj[n].add(m);
            // adj[m].add(n);
        }
        public static void bfs(int b){
            boolean[] visit=new boolean[V];
            Queue<Integer> q= new LinkedList<>();
            visit[b]=true;
            q.offer(b);
            while(!q.isEmpty()){
                int u=q.poll();
                System.out.println("BFS Traversal : "+u);
                for(int i:adj[u]){
                    if(!visit[i]){
                        visit[i]=true;
                        q.offer(i);
                    }
                }
            }
        }
    public static void main(String[] args) {
        BFS_direct g=new BFS_direct(4);
        addedge(0,1);
        addedge(0,2);
        addedge(1,2);
        addedge(2,0);
        addedge(2,3);
        addedge(3,3);
        System.out.println(Arrays.toString(adj));
        bfs(2);
    }
    
}
