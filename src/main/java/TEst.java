import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class TEst {

    public static void main(String[] args) {
        System.out.println(FindBigNum(728295696));
    }

    static long FindBigNum(long n) {

        String str = "";

        for (long l = 1L; l <= n; l++) {
            str += Long.toBinaryString(l);
        }

        BigInteger result = binaryToDecimal(str);

        String output = result.mod(new BigInteger("1000000007")).toString();
        return Long.parseLong(output);
    }

    static BigInteger binaryToDecimal(String input) {
        BigInteger result = new BigInteger("0");

        BigInteger base = new BigInteger("1");

        BigInteger multiplier = new BigInteger("2");


        int len = input.length();
        for (int i = len - 1; i >= 0; i--) {
            if (input.charAt(i) == '1')
                result = result.add(base);
            base = base.multiply(multiplier);
        }

        return result;
    }
}


