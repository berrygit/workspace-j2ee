package network.tcp;

public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public String sayHello(String words) {
		if ("hello".equals(words)) {
			return "hello";
		}
		else {
			return "bye bye";
		}
	}
}
