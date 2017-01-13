package io.github.fantaros.password.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PhonePassGen {
	public static void main(String[] args) throws IOException {
		char[] keyboard = new char[]{'0','1','2','3','4','5','6','7','8','9'};
		int start = 9;
		int end = 9;
		int[] codes = new int[11];
		for(int i = 0;i < end; ++i) {
			if (i < start) {
				codes[i] = 0;
			} else {
				codes[i] = -1;
			}
		}
		codes[9] = 6;
		codes[10] = 1; 
		File passwordFile = new File("D:/shared/pnum.txt");
		passwordFile.createNewFile();
		FileWriter tw = new FileWriter(passwordFile, false);
		while (codes[end - 1] < keyboard.length) {
			StringBuffer sb = new StringBuffer();
			for (int i = codes.length - 1; i >= 0; --i) {
				if(codes[i] >= 0) {
					sb.append(keyboard[codes[i]]);
				} else {
					System.out.println("error condition");
					sb.append("※");
				}
			}
			sb.append("\n");
			String rs = sb.toString();
			if(!(rs.indexOf("※") > -1)) {
				tw.write(rs);
				System.out.println(rs);
			} else {
				System.out.println(" error:"+rs);
			}
			for (int j = 0; j < end; ++j) {
				codes[j] = codes[j] + 1;
				if (codes[j] < keyboard.length) {
					break;
				} else {
					if (j == end - 1) {
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
