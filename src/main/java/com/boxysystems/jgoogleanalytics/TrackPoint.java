package com.boxysystems.jgoogleanalytics;

/**
 * Tracking point of the application. It can represent data points like application load, application module, user actions etc.
 *
 * @author : Siddique Hameed
 * @version : 0.1
 */

public class TrackPoint {

  private String name;
  private TrackPoint parentTrackPoint;
  private static final String URI_SEPARATOR = "/";
  private static final String TITLE_SEPARATOR = "-";

  public TrackPoint(String name) {
    this.name = name;
  }

  public TrackPoint(String name, TrackPoint parentTrackPoint) {
    this(name);
    this.parentTrackPoint = parentTrackPoint;
    this.parentTrackPoint = parentTrackPoint;
  }

  public String getName() {
    return name;
  }

  public TrackPoint getParentFocusPoint() {
    return parentTrackPoint;
  }

  public String getContentURI() {
    StringBuffer contentURIBuffer = new StringBuffer();
    getContentURI(contentURIBuffer, this);
    return contentURIBuffer.toString();
  }

  public String getContentTitle() {
    StringBuffer titleBuffer = new StringBuffer();
    getContentTitle(titleBuffer, this);
    return titleBuffer.toString();
  }

  private void getContentURI(StringBuffer contentURIBuffer, TrackPoint trackPoint) {
    TrackPoint parentFocuPoint = trackPoint.getParentFocusPoint();

    if (parentFocuPoint != null) {
      getContentURI(contentURIBuffer, parentFocuPoint);
    }
    contentURIBuffer.append(URI_SEPARATOR);
    contentURIBuffer.append(trackPoint.getName());
  }

  private void getContentTitle(StringBuffer titleBuffer, TrackPoint trackPoint) {
    TrackPoint parentFocuPoint = trackPoint.getParentFocusPoint();

    if (parentFocuPoint != null) {
      getContentTitle(titleBuffer, parentFocuPoint);
      titleBuffer.append(TITLE_SEPARATOR);
    }
    titleBuffer.append(trackPoint.getName());
  }
}
