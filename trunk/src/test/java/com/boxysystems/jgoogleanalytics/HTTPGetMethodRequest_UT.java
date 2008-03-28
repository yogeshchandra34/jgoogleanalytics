package com.boxysystems.jgoogleanalytics;

import junit.framework.TestCase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Mar 20, 2008
 * Time: 3:37:15 PM
 */
public class HTTPGetMethodRequest_UT extends TestCase {

  public void testRequest_Success() throws Exception{
    MockHTTPGetMethod httpGetMethod = new MockHTTPGetMethod();
    httpGetMethod.setVerboseMode(true);
    httpGetMethod.request("http://www.BoxySystems.com");
    assertEquals(HttpURLConnection.HTTP_OK, httpGetMethod.responseCode);
  }

  public void testRequest_Failure() throws Exception{
    MockHTTPGetMethod httpGetMethod = new MockHTTPGetMethod();
    httpGetMethod.setVerboseMode(true);
    httpGetMethod.request("http://www.1213812938299229929299292.com");
    assertEquals(0, httpGetMethod.responseCode);
  }

  private class MockHTTPGetMethod extends HTTPGetMethod {
    int responseCode = 0;


    protected int getResponseCode(HttpURLConnection urlConnection) throws IOException {
      responseCode = super.getResponseCode(urlConnection);
      return responseCode;
    }
  }
}
