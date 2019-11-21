package jc;

import java.io.File;
import java.io.IOException;


import jc.common.util.QRCodeUtil;
import jc.mybatis.extension.generate.ServiceGenerator;

public class DBGenerate {

	public static void main(String args[]) throws Exception {
		ServiceGenerator.generate("pay_operator");
//		File file = new File("/Users/zero/Desktop/yunshanghua.png");
//		QRCodeUtil.encode("http://nxt.nongxinyin.com/buybal-api/v1.0/cashier/initializ/9BD66948EDE4AFA7038F647350BEB80D", "", file, true);
	}
}
