/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncselector_item {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncselector_item(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncselector_item obj) {
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
        NCJNI.delete_ncselector_item(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOption(String value) {
    NCJNI.ncselector_item_option_set(swigCPtr, this, value);
  }

  public String getOption() {
    return NCJNI.ncselector_item_option_get(swigCPtr, this);
  }

  public void setDesc(String value) {
    NCJNI.ncselector_item_desc_set(swigCPtr, this, value);
  }

  public String getDesc() {
    return NCJNI.ncselector_item_desc_get(swigCPtr, this);
  }

  public ncselector_item() {
    this(NCJNI.new_ncselector_item(), true);
  }

}
