package com.me.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;



public class Acc {


	public String add() throws IOException {
		
		File file=new File("D:\\eclipse-oxygen\\PhotoUpAndDown\\src\\main\\resources\\3.png");
		InputStream io=new FileInputStream(file);
		byte data[]=new byte[io.available()];
		io.read(data);
		io.close();
		String string=Base64.getEncoder().encodeToString(data);
		return string;
	}
}
