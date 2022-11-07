package com.dxl.example.java.net;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class NetClient {

	@Test
	public void client() throws IOException {
		Socket socket = new Socket("127.0.0.1",8080);
		SocketChannel channel = socket.getChannel();
		System.out.println(String.valueOf(channel.isConnected()));

		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String request,response;
		request = "duxl";
		printWriter.println(request);
		printWriter.flush();
		System.out.println(bufferedReader.readLine());
	}
}
