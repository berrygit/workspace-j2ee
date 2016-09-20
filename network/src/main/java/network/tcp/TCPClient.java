package network.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, UnknownHostException, IOException, ClassNotFoundException {
		String interfaceName = SayHelloService.class.getName();

		Method method = SayHelloService.class.getMethod("SayHello", String.class);

		Object[] arguments = {"hello"};

		Socket socket = new Socket("127.0.0.1", 1234);

		ObjectOutputStream op = new ObjectOutputStream(socket.getOutputStream());
		op.writeUTF(interfaceName);
		op.writeUTF(method.getName());
		op.writeObject(method.getParameterTypes());
		op.writeObject(arguments);

		ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
		Object result = oi.readObject();

		System.out.println((String) result);

		socket.close();
	}
}
