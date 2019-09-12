package com.dxl.example.java.net;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaNetTest {


	@Test
	public void serverSockeTest() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		Socket accept = serverSocket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
		PrintWriter out = new PrintWriter(accept.getOutputStream(), true);
		String request,response;
		while((request = in.readLine()) != null){
			if(request.equals("Done")){
				break;
			}
			response = processResponse(request);
			out.println(response);
		};

	}

	private String processResponse(String request) {
		System.out.println("receive"+request);

		return "hai:"+request;
	}
}
