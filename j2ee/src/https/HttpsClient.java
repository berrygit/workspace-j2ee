package https;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;

import org.apache.tomcat.jni.SSLContext;

import com.sun.net.ssl.TrustManager;

public class HttpsClient {  
    
    /**
     * 测试 https 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
        // init https  
        HttpsClient.init();
        
        URL url = new URL("https://ugame.net.cn:8443/UGameCenter/ugametime");  
        url.openConnection();  
        InputStream in = url.openStream();  
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));  
        String line = null;  
        while ((line = buf.readLine()) != null){  
            System.out.println(line);  
        }  
        buf.close();  
        in.close();  
          
//        System.out.println("-- finished --");  
    }  
      
    / 
     * 初始化 
     */  
    public static void init() {  
        try {  
            SSLContext sslCtx = SSLContext.getInstance("TLS");  
            sslCtx.init(null, new TrustManager[]{new MyTrustManager()}, null);  
            SSLSocketFactory sslSocketFactory = sslCtx.getSocketFactory();  
            HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);  
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {  
                @Override  
                public boolean verify(String hostname, SSLSession session) {  
                    return true;  
                }  
            });  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
/**
 * 默认信任服务端根证书
 */
class MyTrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		return;
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		return;
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
