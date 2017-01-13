package io.github.fantaros.password.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumGen {
	public static void main(String[] args) throws IOException {
		char[] keyboard = new char[]{'0','1','2','3','4','5','6','7','8','9'};
		int[] codes = new int[10];
		int start = 8;
		for(int i = 0;i < codes.length; ++i) {
			if (i < start) {
				codes[i] = 0;
			} else {
				codes[i] = -1;
			}
		}
		File passwordFile = new File("D:/p.txt");
		passwordFile.createNewFile();
		FileWriter tw = new FileWriter(passwordFile, true);
		while (codes[codes.length - 1] < keyboard.length - 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = codes.length - 1; i >= 0; --i) {
				if(codes[i] >= 0) {
					sb.append(keyboard[codes[i]]);
				}
			}
			String rs = sb.toString();
			tw.write(rs);
			System.out.println(rs);
			for (int j = 0; j < codes.length; ++j) {
				codes[j] = codes[j] + 1;
				if (codes[j] < keyboard.length) {
					break;
				} else {
					if (j == codes.length - 1) {
						break;
					}
					codes[j] = 0;
				}
			}
		}
		tw.flush();
		tw.close();
	}
}
