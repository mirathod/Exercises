package org.milan.test;

import java.io.IOException;
import java.math.BigDecimal;

public class Test2 {
	public static void main(String[] args) throws IOException {
		Test2 t = new Test2();
		//
		BigDecimal bd = t.amount(new BigDecimal(43), 2);
		System.out.println(bd);
	}

	BigDecimal amount(BigDecimal b, int deci) {
		if (b.scale() != deci) {
			String s = "0.";
			for (int i = 0; i < deci; i++) {
				s = s + "0";
			}
			BigDecimal no = new BigDecimal(s);
			return b.add(no);
		} else {
			return b;
		}
	}
}
