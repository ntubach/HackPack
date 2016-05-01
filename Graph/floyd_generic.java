public class floyd_generic {

    static int oo = (int) 1e9;

    public static void main(String[] args){
        int[][] G;
        // example graph, normally you would read in from the problem
        G = new int[][]{
                {0,1,2,3,4,25},
                {oo,0,6,7,8,9},
                {oo,oo,0,10,11,12},
                {oo,oo,oo,0,13,14},
                {oo,oo,oo,oo,0,15},
                {oo,oo,oo,oo,oo,0}
        };

        int[][] D;
        D = floyd(G);

        int start = 0;
        int end = 5;
        System.out.println("shortest path from "+start+" to "+end+" is "+D[start][end]);
    }

    public static int[][] floyd(int[][] G){

        // this retains the original graph, not always necessary for every problem
        int n = G[0].length;
        int[][] D = new int[n][n];
        for(int x = 0; x<n; x++){
            System.arraycopy(G[x], 0, D[x], 0, n);
        }

        // run floyd on our graph copy since it will be changing values
        for(int k = 0; k<n; k++){
            for(int x = 0; x<n; x++){
                for(int y = 0; y<n; y++){
                    if (D[x][k]+D[k][y] < D[x][y]) {
                        D[x][y] = D[x][k] + D[k][y];
                    }
                }
            }
        }
        return D;
    }
}
