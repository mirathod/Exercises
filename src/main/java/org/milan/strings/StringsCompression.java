package org.milan.strings;

public class StringsCompression {

    public static void main(String[] args) {
        String s1 = "ssssuuuummmmmmiiiittttttttttttt";
        StringsCompression sc = new StringsCompression();
        System.out.println("Compression of " + s1 + " is : " + sc.compression(s1));
        s1 = "Jaain";
        System.out.println("Compression of " + s1 + " is : " + sc.compression(s1));

    }

    public String compression(String input) {
        if (input != null) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            char prev = input.charAt(0);
            for (int i = 1; i < input.length(); i++) {
                char curr = input.charAt(i);
                if (prev == curr) {
                    count++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    prev = curr;
                    count = 1;
                }
            }
            sb.append(prev);
            sb.append(count);
            if (sb.length() < input.length()) {
                return sb.toString();
            } else {
                return input;
            }

        } else {
            return "Empty String";
        }
    }
}
