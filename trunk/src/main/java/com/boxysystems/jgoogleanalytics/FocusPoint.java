package com.boxysystems.jgoogleanalytics;

/**
 * Focus point of the application. It can represent data points like application load, application module load, user actions, error events etc.
 *
 * @author : Siddique Hameed
 * @version : 0.1
 */

public class FocusPoint {

  private String name;
  private FocusPoint parentFocusPoint;
  private static final String URI_SEPARATOR = "/";
  private static final String TITLE_SEPARATOR = "-";

  public FocusPoint(String name) {
    this.name = name;
  }

  public FocusPoint(String name, FocusPoint parentFocusPoint) {
    this(name);
    this.parentFocusPoint = parentFocusPoint;
    this.parentFocusPoint = parentFocusPoint;
  }

  public String getName() {
    return name;
  }


  public void setParentTrackPoint(FocusPoint parentFocusPoint) {
    this.parentFocusPoint = parentFocusPoint;
  }

  public FocusPoint getParentFocusPoint() {
    return parentFocusPoint;
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

  private void getContentURI(StringBuffer contentURIBuffer, FocusPoint focusPoint) {
    FocusPoint parentFocuPoint = focusPoint.getParentFocusPoint();

    if (parentFocuPoint != null) {
      getContentURI(contentURIBuffer, parentFocuPoint);
    }
    contentURIBuffer.append(URI_SEPARATOR);
    contentURIBuffer.append(focusPoint.getName());
  }

  private void getContentTitle(StringBuffer titleBuffer, FocusPoint focusPoint) {
    FocusPoint parentFocuPoint = focusPoint.getParentFocusPoint();

    if (parentFocuPoint != null) {
      getContentTitle(titleBuffer, parentFocuPoint);
      titleBuffer.append(TITLE_SEPARATOR);
    }
    titleBuffer.append(focusPoint.getName());
  }
}
