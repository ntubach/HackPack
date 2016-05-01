public class subsets {

    public static int N;

    public static void main(String[] args) {
        N = 4;
        boolean[] array = new boolean[N];
        subset(0, array);
    }

    public static void subset(int p, boolean[] in) {
        if (p == N) { // if you're at the end of the main set (resolve all branches)
            for(int i = 0; i < N; i++){
                if(in[i]) {
                    System.out.print(i);
                }
                else {
                    System.out.print("_"); // visualize an element isn't selected
                }
            }
            System.out.println();
            return;
        }
        // Step through, making both choices, works out recursively.
        in[p] = false;
        subset(p + 1, in); // branch where you don't include p

        in[p] = true;
        subset(p + 1, in); // branch where you include p
    }
}
