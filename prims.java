import javax.swing.text.html.HTMLDocument.BlockElement;
import java.util.*;

public class prims {
    private static int V;
    public static int minkey(int k[],boolean v[]){
        int min_indx=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(v[i]==false && k[i]<min){
                min=k[i];
                min_indx=i;
            }
        }
        return min_indx;
    }

    public static void prim_mst(int g[][]){
        int parent[]=new int[V];
        int key[]=new int[V];
        boolean visit[] = new boolean[V];
        for(int i=1;i<V;i++){
            key[i]=Integer.MAX_VALUE;
            visit[i]=false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int j=0;j<V;j++){
            int u=minkey(key,visit);
            visit[u]=true;
            for(int v=0;v<V;v++){
                if(g[u][v]!=0 && g[u][v]<key[v] && visit[v]==false){
                    key[v]=g[u][v];
                    parent[v]=u;
                }
            }
        }
        prim_print(parent,g);
    }
    private static void prim_print(int[] parent, int[][] g) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + g[i][parent[i]]);
    }

    public static void main(String[] args) {
        int graph[][]={{0,2,0,6,0},{2,0,3,8,5},{0,3,0,0,7},{6,8,0,0,9},{0,5,7,9,0}};
        V=graph.length;
        prim_mst(graph);
    }
}
