package http.apache;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://www.baidu.com";

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);

		HttpResponse response = httpClient.execute(httpGet);

		HttpEntity entity = response.getEntity();

		System.out.println(entity.getContent());

	}
}
