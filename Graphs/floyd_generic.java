public class floyd_generic {

    static int oo = (int) 1e9;

    public static void main(String[] args){
        int[][] G;
        int[][] D;

        G = new int[][]{
                {0,1,2,3,4,5},
                {oo,0,6,7,8,9},
                {oo,oo,0,10,11,12},
                {oo,oo,oo,0,13,14},
                {oo,oo,oo,oo,0,15},
                {oo,oo,oo,oo,oo,0}
        };

        int n = G[0].length;
        D = new int[n][n];
        for(int x = 0; x<n; x++){
            for(int y = 0; y<n; y++){
                D[x][y] = G[x][y];
            }
        }

        for(int k = 0; k<6; k++){
            for(int x = 0; x<6; x++){
                for(int y = 0; y<6; y++){
                    if (D[x][k]+D[k][y] < D[x][y]) {
                        D[x][y] = D[x][k] + D[k][y];
                    }
                }
            }
        }

        int start = 0;
        int end = 5;
        System.out.println(D[start][end]);
    }
}
