/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class nccapabilities {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected nccapabilities(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(nccapabilities obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        NCJNI.delete_nccapabilities(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setColors(long value) {
    NCJNI.nccapabilities_colors_set(swigCPtr, this, value);
  }

  public long getColors() {
    return NCJNI.nccapabilities_colors_get(swigCPtr, this);
  }

  public void setUtf8(boolean value) {
    NCJNI.nccapabilities_utf8_set(swigCPtr, this, value);
  }

  public boolean getUtf8() {
    return NCJNI.nccapabilities_utf8_get(swigCPtr, this);
  }

  public void setRgb(boolean value) {
    NCJNI.nccapabilities_rgb_set(swigCPtr, this, value);
  }

  public boolean getRgb() {
    return NCJNI.nccapabilities_rgb_get(swigCPtr, this);
  }

  public void setCan_change_colors(boolean value) {
    NCJNI.nccapabilities_can_change_colors_set(swigCPtr, this, value);
  }

  public boolean getCan_change_colors() {
    return NCJNI.nccapabilities_can_change_colors_get(swigCPtr, this);
  }

  public void setHalfblocks(boolean value) {
    NCJNI.nccapabilities_halfblocks_set(swigCPtr, this, value);
  }

  public boolean getHalfblocks() {
    return NCJNI.nccapabilities_halfblocks_get(swigCPtr, this);
  }

  public void setQuadrants(boolean value) {
    NCJNI.nccapabilities_quadrants_set(swigCPtr, this, value);
  }

  public boolean getQuadrants() {
    return NCJNI.nccapabilities_quadrants_get(swigCPtr, this);
  }

  public void setSextants(boolean value) {
    NCJNI.nccapabilities_sextants_set(swigCPtr, this, value);
  }

  public boolean getSextants() {
    return NCJNI.nccapabilities_sextants_get(swigCPtr, this);
  }

  public void setBraille(boolean value) {
    NCJNI.nccapabilities_braille_set(swigCPtr, this, value);
  }

  public boolean getBraille() {
    return NCJNI.nccapabilities_braille_get(swigCPtr, this);
  }

  public nccapabilities() {
    this(NCJNI.new_nccapabilities(), true);
  }

}
