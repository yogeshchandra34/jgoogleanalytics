package com.boxysystems.jgoogleanalytics;

import junit.framework.TestCase;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: SHAMEED
 * Date: Mar 23, 2008
 * Time: 5:52:35 PM
 */
public class JGoogleAnalyticsTracker_UT extends TestCase {

  private TrackPoint parentTrackPoint = new TrackPoint("JGoogleAnalyticsTest");
  private TrackPoint syncChildFocuPoint = new TrackPoint("TrackingSynchronously", parentTrackPoint);
  private TrackPoint asyncChildFocuPoint = new TrackPoint("TrackingAsynchronously", parentTrackPoint);


  public void testTrackSynchronously_LibraryFinder() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("LibraryFinder", "v1.3.1", "UA-2184000-1");
    tracker.setVerboseMode(true);
    tracker.trackSynchronously(syncChildFocuPoint);
  }

  public void testTrackAsynchronously_LibraryFinder() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("LibraryFinder", "v1.3.1", "UA-2184000-1");
    tracker.setVerboseMode(true);
    tracker.trackAsynchronously(asyncChildFocuPoint);
    Thread.sleep(3000);
  }

  public void testTrackSynchronously_AOPWorld() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("AOPWorld", "UA-941218-1");
    tracker.setVerboseMode(true);
    tracker.trackSynchronously(syncChildFocuPoint);
  }

  public void testTrackAsynchronously_AOPWorld() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("AOPWorld", "UA-941218-1");
    tracker.setVerboseMode(true);
    tracker.trackAsynchronously(asyncChildFocuPoint);
    Thread.sleep(3000);
  }

  public void testTrackSynchronously_TheRandomHomepage() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("TheRandomHomepage.com", "UA-941159-1");
    tracker.setVerboseMode(true);
    tracker.trackSynchronously(syncChildFocuPoint);
  }

  public void testTrackAsynchronously_TheRandomHomepage() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("TheRandomHomepage.com", "UA-941159-1");
    tracker.setVerboseMode(true);
    tracker.trackAsynchronously(asyncChildFocuPoint);
    Thread.sleep(3000);
  }

  public void testTrackSynchronously_Madras_fm() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("Madras.fm", "UA-1657019-1");
    tracker.setVerboseMode(true);
    tracker.trackSynchronously(syncChildFocuPoint);
  }

  public void testTrackAsynchronously_Madras_fm() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("Madras.fm", "UA-1657019-1");
    tracker.setVerboseMode(true);
    tracker.trackAsynchronously(asyncChildFocuPoint);
    Thread.sleep(3000);
  }

  public void testTrackSynchronously_BoxySystems() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("BoxySystems.com", "UA-1657036-1");
    tracker.setVerboseMode(true);
    tracker.trackSynchronously(syncChildFocuPoint);
  }

  public void testTrackAsynchronously_BoxySystems() throws Exception {
    JGoogleAnalyticsTracker tracker = new JGoogleAnalyticsTracker("BoxySystems.com", "UA-1657036-1");
    tracker.setVerboseMode(true);
    tracker.trackAsynchronously(asyncChildFocuPoint);
    Thread.sleep(3000);
  }

}
