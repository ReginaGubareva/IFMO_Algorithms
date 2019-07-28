package main.firstweek;

import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Counting a+b^2;
 * @author Regina Gubareva
 * @since 09.09.2018
 */

public class Sum{
     public static BigInteger countingSum(BufferedReader reader){
		 Scanner scan = new Scanner(reader);
		 BigInteger a = scan.nextBigInteger();
		 BigInteger b = scan.nextBigInteger();

		 BigInteger answer = BigInteger.ZERO;
		 b = b.multiply(b);
		 answer = answer.add(a);
		 answer = answer.add(b);

		 return answer;
	 }
}