import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS_travel {
    private static LinkedList[] adj;
    private static int V;
    private static boolean visit[];
    public DFS_travel(int s) {
        V=s;
        visit = new boolean[V];
        this.adj=new LinkedList[s];
        for(int i=0;i<s;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public static void addedge(int m,int n){
        adj[m].add(n);
        adj[n].add(m);
    }
    public static void DFS(int c){
        visit[c]=true;
        System.out.print(c + "  ");
        Iterator<Integer> h=adj[c].listIterator();
        while(h.hasNext()){
            int a=h.next();
            if(!visit[a]){
                DFS(a);
            }
        }
        // System.out.println(Arrays.toString(adj));

    }
    public static void main(String[] args) {
        DFS_travel g=new DFS_travel(7);
        addedge(0,1);
        addedge(0,3);
        addedge(1,4);
        addedge(1,2);
        addedge(2,3);
        addedge(4,5);
        addedge(4,6);
        addedge(5,6);
        // addedge(3,2);
        System.out.println(Arrays.toString(adj));
        System.out.println("Depth First Traversal Graph ");
        DFS(0);
        
        

    }   
}
