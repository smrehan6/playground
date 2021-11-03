package smr.playground.problems;

public class RotationCypher {

    public static void main(String[] args) {
        System.out.println(crypt("All-convoYs-9-be:Alert1.", 4));
        System.out.println("Epp-gsrzsCw-3-fi:Epivx5.");
        System.out.println(crypt("abcdZXYzxy-999.@", 200));
        System.out.println("stuvRPQrpq-999.@");
    }

    static String crypt(String input, int factor) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char x = (char) (c + factor % 26);
                if (Character.isUpperCase(c) && x > 'Z'
                        || Character.isLowerCase(c) && x > 'z') {
                    x = (char) (x - 26);
                }
                sb.append(x);
            } else if (Character.isDigit(c)) {
                char x = (char) (c + factor % 10);
                if (x > '9') {
                    x = (char) (x - 10);
                }
                sb.append(x);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
