public class Test {

    public static void main(String args[]){

        String[] strings = new String[9];
        strings[0] = "1";
        strings[9] = "1";
        for (int i = 0; i <= strings.length; i++) {
            if (strings[i] != null) {
                System.out.println(strings[i]);
            }
        }
    }

}
