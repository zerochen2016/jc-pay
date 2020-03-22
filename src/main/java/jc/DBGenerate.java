package jc;

import java.io.File;


import jc.common.util.QRCodeUtil;

public class DBGenerate {

	public static void main(String args[]) throws Exception {
//		ServiceGenerator.generate("pay_operator");
		
		File file = new File("/Users/zero/Desktop/lianren20200318.png");
		QRCodeUtil.encode("https://xiangniupay.xtbank.com/ifsp-payweb/merPayReceive/00&5039028530859471881708657142016862", "", file, true);
		
//		for(int i = 1; i<31; i++) {
//			System.out.println("meirenxiangggggg"+i+".xyz");
//		}
	}
}
