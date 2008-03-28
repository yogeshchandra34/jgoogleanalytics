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

//$var_utmac='UA-000000-1'; //enter the new urchin code
//$var_utmhn='yourdomain.com'; //enter your domain
//$var_utmn=rand(1000000000,9999999999);//random request number
//$var_cookie=rand(10000000,99999999);//random cookie number
//$var_random=rand(1000000000,2147483647); //number under 2147483647
//$var_today=time(); //today
//$var_referer=$_SERVER['HTTP_REFERER']; //referer url
//
//$var_uservar='-'; //enter your own user defined variable
//$var_utmp='/rss/'.$_SERVER['REMOTE_ADDR']; //this example adds a fake page request to the (fake) rss directory (the viewer IP to check for absolute unique RSS readers)
//
//$urchinUrl='http://www.google-analytics.com/__utm.gif?utmwv=1&utmn='.$var_utmn.'&utmsr=-&utmsc=-&utmul=-&utmje=0&utmfl=-&utmdt=-&utmhn='.$var_utmhn.'&utmr='.$var_referer.'&utmp='.$var_utmp.'&utmac='.$var_utmac.'&utmcc=__utma%3D'.$var_cookie.'.'.$var_random.'.'.$var_today.'.'.$var_today.'.'.$var_today.'.2%3B%2B__utmb%3D'.$var_cookie.'%3B%2B__utmc%3D'.$var_cookie.'%3B%2B__utmz%3D'.$var_cookie.'.'.$var_today.'.2.2.utmccn%3D(direct)%7Cutmcsr%3D(direct)%7Cutmcmd%3D(none)%3B%2B__utmv%3D'.$var_cookie.'.'.$var_uservar.'%3B';
//


  public String buildURL(TrackPoint trackPoint) {

//      http://www.google-analytics.com/__utm.gif?utmwv=3&utmn=1637201610&utme=&utmcs=UTF-8&utmsr=1280x800&utmsc=32-bit&utmul=en-us
// &utmje=1&utmfl=9.0%20%20r47&utmcn=1&utmdt=libraryfinder%20-%20Google%20Code&utmhn=code.google.com&utmhid=1841910313
// &utmr=http://plugins.intellij.net/plugin/?id=51&utmp=/p/libraryfinder/&utmac=UA-18071-1
// &utmcc=__utma%3D247248150.1814692369.1202829249.1206108360.1206310618.28%3B%2B__utmz%3D247248150.1206310618.28.18.utmcsr%3Dplugins.intellij.net%7Cutmccn%3D(referral)%7Cutmcmd%3Dreferral%7Cutmcct%3D%252Fplugin%252F%3B
//    URL url = new URL("&utmac=UA-2184000-1&utmdt="+focuPoint.getContentTitle()+"&utmp="+focuPoint.getContentURI());
    StringBuffer url = new StringBuffer(TRACKING_URL_Prefix);
    url.append("?utmwv=1"); //Urchin/Analytics version
    url.append("&utmn=" + random.nextInt()); //634440486
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
    //&utmcc=__utma%3D247248150.1814692369.1202829249.1206454660.1206537858.33%3B%2B__utmz%3D247248150.1206395957.31.20.utmcsr%3D106.gmodules.com%7Cutmccn%3D(referral)%7Cutmcmd%3Dreferral%7Cutmcct%3D%252Fig%252Fifr%3B
    url.append("&utmcc=__utma%3D247248150.1814692369.1202829249.1206454660.1206537858.33%3B%2B__utmz%3D247248150.1206395957.31.20.utmcsr%3Dhttp://BoxySystems.com%7Cutmccn%3D(referral)%7Cutmcmd%3Dreferral%7Cutmcct%3D%252Fig%252Fifr%3B");

//&utmcc= //cookie settings
//	__utma=
//					21661308. //cookie number
//					1850772708. //number under 2147483647
//					1169320752. //time (20-01-2007) cookie first set
//					1172328503. //time (24-02-2007) cookie previous set
//					1172935717. //time (03-03-2007) today
//					3;+
//	__utmb=
//					21661308;+ //cookie number
//	__utmc=
//					21661308;+ //cookie number
//	__utmz=
//					21661308. //cookie number
//					1172936273. //time (03-03-2007) today
//					3.
//					2.
//		utmccn=(organic)| //utm_campaign
//		utmcsr=google| //utm_source
//		utmctr=seo+optimal+keyword+density| //utm_term
//		utmcmd=organic;+ //utm_medium
//
//    return url.toString();
    return url.toString();
  }
}
