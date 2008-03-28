package com.boxysystems.jgoogleanalytics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Simple class peforming HTTP Get method on the requested url
 *
 * @author : Siddique Hameed
 * @version : 0.1
 */

public class HTTPGetMethod {
  private static final String GET_METHOD_NAME = "GET";
  private static final String SUCCESS_MESSAGE = "Track Successfull!";

  private boolean verboseMode;

  public void setVerboseMode(boolean verboseMode) {
    this.verboseMode = verboseMode;
  }

  public void request(String urlString) {
    try {
      log("urlString = " + urlString);
      URL url = new URL(urlString);
      HttpURLConnection urlConnection = openURLConnection(url);
      urlConnection.setInstanceFollowRedirects(true);
      urlConnection.setRequestMethod(GET_METHOD_NAME);
      urlConnection.connect();
      int responseCode = getResponseCode(urlConnection);
      if (responseCode != HttpURLConnection.HTTP_OK) {
        log("Error tracking , url = " + urlString);
      } else {
        log(SUCCESS_MESSAGE);
      }
    } catch (Exception e) {
      log(e.getMessage());
    }
  }

  protected int getResponseCode(HttpURLConnection urlConnection) throws IOException {
    return urlConnection.getResponseCode();
  }

  private HttpURLConnection openURLConnection(URL url) throws IOException {
    return (HttpURLConnection) url.openConnection();
  }

  private void log(String message) {
    if (verboseMode) {
      System.out.println(message);
    }
  }


}
