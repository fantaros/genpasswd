package io.github.fantaros.password.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGenerator {
	public static void main(String[] args) throws IOException {
		char[] keyboard = new char[]{' ', '`','~','1','!','2','@','3','#','4','$','5','%','6','^','7','&','8','*','9','(','0',')','-','_','=','+','q','Q','w','W','e','E','r','R','t','T','y','Y','u','U','i','I','o','O','p','P','[','{',']','}','|','a','A','s','S','d','D','f','F','g','G','h','H','j','J','k','K','l','L',';',':','\'','"','z','Z','x','X','c','C','v','V','b','B','n','N','m','M',',','<','.','>','/','?'};
		int[] codes = new int[2];
		int start = 2;
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
				} else {
					System.out.println("error condition");
					sb.append("å");
				}
			}
			String rs = sb.toString();
			if(!(rs.indexOf("å") > -1)) {
					tw.write(rs);
				System.out.println(rs);
			} else {
				System.out.println("error:"+rs);
			}
			for (int j = 0; j < codes.length; ++j) {
				codes[j] = codes[j] + 1;
				if (codes[j] < keyboard.length - 1) {
					break;
				} else {
					codes[j] = 0;
				}
			}
		}
		tw.flush();
		tw.close();
	}
}
