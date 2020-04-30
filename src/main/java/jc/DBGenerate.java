package jc;

import java.io.File;


import jc.common.util.QRCodeUtil;
import jc.common.util.SignatureUtil;

public class DBGenerate {

	public static void main(String args[]) throws Exception {
//		ServiceGenerator.generate("pay_operator");
		
		File file = new File("/Users/zero/Desktop/all20200426.png");
		QRCodeUtil.encode("https://s.zjkccb.com/aps/buybal-api/v1.0/cashier/juheRedirect?qrCode=https%3A%2F%2Fqr.95516.com%2F04901380%2F457591", "", file, true);
//		
//		for(int i = 1; i<21; i+=2) {
//			
//			System.out.println("yshxym"+i+".xyz");
//		}
		
//		System.out.println(SignatureUtil.encodeMD5("QWEasdpay1."));
	}
}
