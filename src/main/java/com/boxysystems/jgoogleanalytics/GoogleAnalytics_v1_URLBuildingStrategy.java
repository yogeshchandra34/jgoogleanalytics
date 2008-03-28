package com.boxysystems.jgoogleanalytics;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * URL building logic for the earlier versions of google analytics (urchin.js)
 *
 * @author : Siddique Hameed
 * @version : 0.1
 */

public class GoogleAnalytics_v1_URLBuildingStrategy implements URLBuildingStrategy {
  private TrackPoint appTrackPoint;
  private String googleAnalyticsTrackingCode;

  private static final String TRACKING_URL_Prefix = "http://www.google-analytics.com/__utm.gif";

  private static final Random random = new Random();
  private static String hostName = "localhost";

  static {
    try {
      hostName = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException e) {
      //ignore this
    }
  }


  public GoogleAnalytics_v1_URLBuildingStrategy(String appName, String googleAnalyticsTrackingCode) {
    this.googleAnalyticsTrackingCode = googleAnalyticsTrackingCode;
    this.appTrackPoint = new TrackPoint(appName);
  }

  public GoogleAnalytics_v1_URLBuildingStrategy(String appName, String appVersion, String googleAnalyticsTrackingCode) {
    this.googleAnalyticsTrackingCode = googleAnalyticsTrackingCode;
    this.appTrackPoint = new TrackPoint(appVersion, new TrackPoint(appName));
  }


  public String buildURL(TrackPoint trackPoint) {
    trackPoint.setParentTrackPoint(appTrackPoint);
    StringBuffer url = new StringBuffer(TRACKING_URL_Prefix);
    url.append("?utmwv=1"); //Urchin/Analytics version
    url.append("&utmn=" + random.nextInt());
    url.append("&utmcs=UTF-8"); //document encoding
    url.append("&utmsr=1440x900"); //screen resolution
    url.append("&utmsc=32-bit"); //color depth
    url.append("&utmul=en-us"); //user language
    url.append("&utmje=1"); //java enabled
    url.append("&utmfl=9.0%20%20r28"); //flash
    url.append("&utmcr=1"); //carriage return
    url.append("&utmdt=" + trackPoint.getContentTitle()); //The optimum keyword density //document title
    url.append("&utmhn=" + hostName);//document hostname
    url.append("&utmr=http://BoxySystems.com"); //referer URL
    url.append("&utmp=" + trackPoint.getContentURI());//document page URL
    url.append("&utmac=" + googleAnalyticsTrackingCode);//Google Analytics account
    url.append("&utmcc=__utma%3D247248150.1814692369.1202829249.1206454660.1206537858.33%3B%2B__utmz%3D247248150.1206395957.31.20.utmcsr%3Dhttp://BoxySystems.com%7Cutmccn%3D(referral)%7Cutmcmd%3Dreferral%7Cutmcct%3D%252Fig%252Fifr%3B");
    return url.toString();
  }
}
