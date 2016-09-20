package hessian;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

public class Test {
	public static void main(String[] args) throws IOException {

		Person person = new Person();

		// hessian序列化
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		HessianOutput ho = new HessianOutput(bo);
		ho.writeObject(person);

		// hessian反序列化读取对象
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		HessianInput hi = new HessianInput(bi);
		Person person2 = (Person) hi.readObject();
	}
}
