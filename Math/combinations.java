public class combinations {
    public static void main(String[] args) {
        combination("", "abcd");
    }

    private static void combination(String prefix, String str){
        int n = str.length();
        if (n > 0) {
            System.out.println(prefix + str.charAt(0));
            combination(prefix + str.charAt(0), str.substring(1));
            combination(prefix, str.substring(1));
        }
    }
}
