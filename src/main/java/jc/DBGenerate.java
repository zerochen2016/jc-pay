package jc;

import java.io.IOException;

import jc.mybatis.extension.generate.ServiceGenerator;

public class DBGenerate {

	public static void main(String args[]) throws IOException {
		ServiceGenerator.generate("pay_config_info");
	}
}
