package com.hashedin.webclient;



import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
//import org.testng.annotations.Test;

import org.testng.annotations.Test;

import com.hashedin.data.ReadPropertiesFile;

public class IderaWebclient extends ReadPropertiesFile
{
	
	/* For post Method use below parameters to be passed 
	 * String urlTypeHttp -- http or https
	 * String urlPort -- 9275
	 * String baseUrl -- ec2-54-80-107-33.compute-1.amazonaws.com
	 * String urlMethod -- /IderaCoreServices/Applications
	 * String urlParameterJson -- {\"Name\":\"Yogesh\",\"Abbreviation\":\"Yogesh1\",\"Version\":\"Yogesh1\",\"ServiceBaseUrl\":\"y2k\"}
	 * String urlContentType -- application/json
	 */
	private static ReadPropertiesFile read;
	public IderaWebclient() {
		read = new ReadPropertiesFile();
    	read.loadConfig();  
	}

	
	@Test
	public static void POST()//(String urlTypeHttp, String urlPort, String baseUrl, String urlMethod , String urlParameterJson , String urlContentType)
	{
		
			    DefaultHttpClient httpclient = new DefaultHttpClient();
			    try {
			      // specify the host, protocol, and port

			  //ReadPropertiesFile read = new ReadPropertiesFile();
			    //	read.loadConfig();
			    	
			      HttpHost target = new HttpHost(read.getHost(),read.getPort(),read.getProtocol());
			      
			      // specify the get request
			      HttpPost getRequest = new HttpPost("/IderaCoreServices/Applications");
                
			      
			      StringEntity se = new StringEntity( "{\"Name\":\"Yogesh\",\"Abbreviation\":\"Yogesh1\",\"Version\":\"Yogesh1\",\"ServiceBaseUrl\":\"y2k\"}");
			      se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			      getRequest.setEntity(se);
			      System.out.println("executing request to " + target);

			      HttpResponse httpResponse = httpclient.execute(target, getRequest);
			      HttpEntity entity = httpResponse.getEntity();

			      System.out.println("----------------------------------------");
			      System.out.println(httpResponse.getStatusLine());
			      Header[] headers = httpResponse.getAllHeaders();
			      for (int i = 0; i < headers.length; i++) {
			        System.out.println(headers[i]);
			      }
			      System.out.println("----------------------------------------");

			      if (entity != null) {
			        System.out.println(EntityUtils.toString(entity));
			      }

			    } catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			      // When HttpClient instance is no longer needed,
			      // shut down the connection manager to ensure
			      // immediate deallocation of all system resources
			      httpclient.getConnectionManager().shutdown();
			    }
			  }
	
	     
	
	
	/* For get Method use below parameters to be passed 
	 * String urlTypeHttp -- http or https
	 * String urlPort -- 9275
	 * String baseUrl -- ec2-54-80-107-33.compute-1.amazonaws.com
	 * String urlMethod -- /IderaCoreServices/Applications
	 */
	
 @Test
 public static void GET()
	        {
		
			    DefaultHttpClient httpclient = new DefaultHttpClient();
			    try {
			      // specify the host, protocol, and port
			      HttpHost target = new HttpHost(read.getHost(),read.getPort(),read.getProtocol());
			      
			      // specify the get request
			      HttpGet getRequest = new HttpGet("/IderaCoreServices/Applications");
                
			      
			      System.out.println("executing request to " + target);

			      HttpResponse httpResponse = httpclient.execute(target, getRequest);
			      HttpEntity entity = httpResponse.getEntity();

			      System.out.println("----------------------------------------");
			      System.out.println(httpResponse.getStatusLine());
			      Header[] headers = httpResponse.getAllHeaders();
			      for (int i = 0; i < headers.length; i++) {
			        System.out.println(headers[i]);
			      }
			      System.out.println("----------------------------------------");

			      if (entity != null) {
			        System.out.println(EntityUtils.toString(entity));
			      }

			    } catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			      // When HttpClient instance is no longer needed,
			      // shut down the connection manager to ensure
			      // immediate deallocation of all system resources
			      httpclient.getConnectionManager().shutdown();
			      
			      
			   
			      }
			  
	            }
		
}