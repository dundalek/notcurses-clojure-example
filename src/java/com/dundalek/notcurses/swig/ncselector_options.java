/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncselector_options {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncselector_options(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncselector_options obj) {
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
        NCJNI.delete_ncselector_options(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTitle(String value) {
    NCJNI.ncselector_options_title_set(swigCPtr, this, value);
  }

  public String getTitle() {
    return NCJNI.ncselector_options_title_get(swigCPtr, this);
  }

  public void setSecondary(String value) {
    NCJNI.ncselector_options_secondary_set(swigCPtr, this, value);
  }

  public String getSecondary() {
    return NCJNI.ncselector_options_secondary_get(swigCPtr, this);
  }

  public void setFooter(String value) {
    NCJNI.ncselector_options_footer_set(swigCPtr, this, value);
  }

  public String getFooter() {
    return NCJNI.ncselector_options_footer_get(swigCPtr, this);
  }

  public void setItems(ncselector_item value) {
    NCJNI.ncselector_options_items_set(swigCPtr, this, ncselector_item.getCPtr(value), value);
  }

  public ncselector_item getItems() {
    long cPtr = NCJNI.ncselector_options_items_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ncselector_item(cPtr, false);
  }

  public void setDefidx(long value) {
    NCJNI.ncselector_options_defidx_set(swigCPtr, this, value);
  }

  public long getDefidx() {
    return NCJNI.ncselector_options_defidx_get(swigCPtr, this);
  }

  public void setMaxdisplay(long value) {
    NCJNI.ncselector_options_maxdisplay_set(swigCPtr, this, value);
  }

  public long getMaxdisplay() {
    return NCJNI.ncselector_options_maxdisplay_get(swigCPtr, this);
  }

  public void setOpchannels(long value) {
    NCJNI.ncselector_options_opchannels_set(swigCPtr, this, value);
  }

  public long getOpchannels() {
    return NCJNI.ncselector_options_opchannels_get(swigCPtr, this);
  }

  public void setDescchannels(long value) {
    NCJNI.ncselector_options_descchannels_set(swigCPtr, this, value);
  }

  public long getDescchannels() {
    return NCJNI.ncselector_options_descchannels_get(swigCPtr, this);
  }

  public void setTitlechannels(long value) {
    NCJNI.ncselector_options_titlechannels_set(swigCPtr, this, value);
  }

  public long getTitlechannels() {
    return NCJNI.ncselector_options_titlechannels_get(swigCPtr, this);
  }

  public void setFootchannels(long value) {
    NCJNI.ncselector_options_footchannels_set(swigCPtr, this, value);
  }

  public long getFootchannels() {
    return NCJNI.ncselector_options_footchannels_get(swigCPtr, this);
  }

  public void setBoxchannels(long value) {
    NCJNI.ncselector_options_boxchannels_set(swigCPtr, this, value);
  }

  public long getBoxchannels() {
    return NCJNI.ncselector_options_boxchannels_get(swigCPtr, this);
  }

  public void setFlags(long value) {
    NCJNI.ncselector_options_flags_set(swigCPtr, this, value);
  }

  public long getFlags() {
    return NCJNI.ncselector_options_flags_get(swigCPtr, this);
  }

  public ncselector_options() {
    this(NCJNI.new_ncselector_options(), true);
  }

}
