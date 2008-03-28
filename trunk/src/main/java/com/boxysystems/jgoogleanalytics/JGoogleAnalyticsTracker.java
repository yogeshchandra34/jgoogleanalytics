package com.boxysystems.jgoogleanalytics;

/**
 * Main class for tracking google analytics data.
 *
 * @author : Siddique Hameed
 * @version : 0.1
 * @see : <a href="http://JGoogleAnalytics.googlecode.com">http://JGoogleAnalytics.googlecode.com</a>
 */

public class JGoogleAnalyticsTracker {

  private URLBuildingStrategy urlBuildingStrategy = null;
  private boolean verboseMode = false;
  private HTTPGetMethod httpRequest = new HTTPGetMethod();

  /**
   * Simple constructor passing the application name & google analytics tracking code
   *
   * @param appName                     Application name (For ex: "LibraryFinder")
   * @param googleAnalyticsTrackingCode (For ex: "UA-2184000-1")
   */
  public JGoogleAnalyticsTracker(String appName, String googleAnalyticsTrackingCode) {
    this.urlBuildingStrategy = new GoogleAnalytics_v1_URLBuildingStrategy(appName, googleAnalyticsTrackingCode);
  }

  /**
   * Constructor passing the application name, application version & google analytics tracking code
   *
   * @param appName                     Application name (For ex: "LibraryFinder")
   * @param appVersion                  Application version (For ex: "1.3.1")
   * @param googleAnalyticsTrackingCode (For ex: "UA-2184000-1")
   */

  public JGoogleAnalyticsTracker(String appName, String appVersion, String googleAnalyticsTrackingCode) {
    this.urlBuildingStrategy = new GoogleAnalytics_v1_URLBuildingStrategy(appName, appVersion, googleAnalyticsTrackingCode);
  }


  /**
   * Setter injection for URLBuildingStrategy incase if you want to use a different url building logic.
   *
   * @param urlBuildingStrategy implemented instance of URLBuildingStrategy
   */
  public void setUrlBuildingStrategy(URLBuildingStrategy urlBuildingStrategy) {
    this.urlBuildingStrategy = urlBuildingStrategy;
  }


  /**
   * Run the tracker in verbose mode. It would log success & failure messages in the system's output console.
   * By default, it would run in non-verbose mode.
   *
   * @param verboseMode true or false
   */

  public void setVerboseMode(boolean verboseMode) {
    this.verboseMode = verboseMode;
    httpRequest.setVerboseMode(verboseMode);
  }

  /**
   * Track the trackPoint in the application synchronously. <br/>
   * <red><b>Please be cognizant while using this method. Since, it would have a peformance hit on the actual application.
   * Use it unless it's really needed</b></red>
   *
   * @param trackPoint Tracking point of the application like application load, user action etc.
   */


  public void trackSynchronously(TrackPoint trackPoint) {
    httpRequest.request(urlBuildingStrategy.buildURL(trackPoint));
  }

  /**
   * Track the trackPoint in the application asynchronously. <br/>
   *
   * @param trackPoint Tracking point of the application like application load, user action etc.
   */

  public void trackAsynchronously(TrackPoint trackPoint) {
    new TrackingThread(trackPoint).start();
  }

  private class TrackingThread extends Thread {
    private TrackPoint trackPoint;


    public TrackingThread(TrackPoint trackPoint) {
      this.trackPoint = trackPoint;
      this.setPriority(Thread.MIN_PRIORITY);
    }

    public void run() {
      httpRequest.request(urlBuildingStrategy.buildURL(trackPoint));
    }
  }
}
