package com.boxysystems.jgoogleanalytics;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: shameed
 * Date: Mar 20, 2008
 * Time: 3:45:26 PM
 */
public class FocusPoint_UT extends TestCase {

  public void testGetContentURI_Simple() throws Exception{
    TrackPoint trackPoint = new TrackPoint("BoxySystems");
    String contentURI = trackPoint.getContentURI();
    assertNotNull(contentURI);
    assertEquals("/BoxySystems",contentURI);
  }

  public void testGetContentURI_OneLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint childTrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    String contentURI = childTrackPoint.getContentURI();
    assertNotNull(contentURI);
    assertEquals("/BoxySystems/LibraryFinder",contentURI);
  }

  public void testGetContentURI_TwoLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint child1TrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    TrackPoint child2TrackPoint = new TrackPoint("FindLibraryDialog", child1TrackPoint);
    String contentURI = child2TrackPoint.getContentURI();
    assertNotNull(contentURI);
    assertEquals("/BoxySystems/LibraryFinder/FindLibraryDialog",contentURI);
  }

  public void testGetContentURI_ThreeLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint child1TrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    TrackPoint child2TrackPoint = new TrackPoint("FindLibraryDialog", child1TrackPoint);
    TrackPoint child3TrackPoint = new TrackPoint("RegexPattern", child2TrackPoint);
    String contentURI = child3TrackPoint.getContentURI();
    assertNotNull(contentURI);
    assertEquals("/BoxySystems/LibraryFinder/FindLibraryDialog/RegexPattern",contentURI);
  }

  public void testGetContentTitle_Simple() throws Exception{
    TrackPoint trackPoint = new TrackPoint("BoxySystems");
    String contentTitle = trackPoint.getContentTitle();
    assertNotNull(contentTitle);
    assertEquals("BoxySystems",contentTitle);
  }

  public void testGetContentTitle_OneLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint childTrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    String contentTitle = childTrackPoint.getContentTitle();
    assertNotNull(contentTitle);
    assertEquals("BoxySystems-LibraryFinder",contentTitle);
  }

  public void testGetContentTitle_TwoLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint child1TrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    TrackPoint child2TrackPoint = new TrackPoint("FindLibraryDialog", child1TrackPoint);
    String contentTitle = child2TrackPoint.getContentTitle();
    assertNotNull(contentTitle);
    assertEquals("BoxySystems-LibraryFinder-FindLibraryDialog",contentTitle);
  }

  public void testGetContentTitle_ThreeLevel() throws Exception{
    TrackPoint parentTrackPoint = new TrackPoint("BoxySystems");
    TrackPoint child1TrackPoint = new TrackPoint("LibraryFinder", parentTrackPoint);
    TrackPoint child2TrackPoint = new TrackPoint("FindLibraryDialog", child1TrackPoint);
    TrackPoint child3TrackPoint = new TrackPoint("RegexPattern", child2TrackPoint);
    String contentTitle = child3TrackPoint.getContentTitle();
    assertNotNull(contentTitle);
    assertEquals("BoxySystems-LibraryFinder-FindLibraryDialog-RegexPattern",contentTitle);
  }

}
