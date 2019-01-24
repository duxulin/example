package com.dxl.example.sso;

import org.springframework.web.filter.ServletContextRequestLoggingFilter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @Program SessionFilter
 * @Description
 * @Author duxl
 * @Create 2019/1/10 8:41
 */
public class SessionFilter  {
	public static void main(String[] args) {
		Cookie cookie = new Cookie("sessionId", "12342234jSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidjSessionidvaluejSessionidvaluejSessionidvaluejSessionidvaluejSessionidvaluejSessionidvaluejSessionidvaluejSessionidvalue");
		compressCookie(cookie);
	}

	private static void compressCookie(Cookie c){
		try {
			ByteArrayOutputStream bos = null;
			bos = new ByteArrayOutputStream();
			DeflaterOutputStream dos = new DeflaterOutputStream(bos);
			dos.write(c.getValue().getBytes());
			dos.close();
			System.out.println("before compress length:"+c.getValue().getBytes().length);
			String compress = new BASE64Encoder().encode(bos.toByteArray());
			System.out.println("after compress length:"+compress.getBytes().length);

			byte[] bytes = new BASE64Decoder().decodeBuffer(compress);

			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			InflaterInputStream iis = new InflaterInputStream(bis);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] bytes1 = new byte[1024];
			int count;
			while ((count = iis.read(bytes1))>=0){
				out.write(bytes1,0,count);
			}
			iis.close();
			System.out.println(new String(out.toByteArray()));

		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
