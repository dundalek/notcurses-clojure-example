/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncvisual_options {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncvisual_options(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncvisual_options obj) {
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
        NCJNI.delete_ncvisual_options(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setN(SWIGTYPE_p_ncplane value) {
    NCJNI.ncvisual_options_n_set(swigCPtr, this, SWIGTYPE_p_ncplane.getCPtr(value));
  }

  public SWIGTYPE_p_ncplane getN() {
    long cPtr = NCJNI.ncvisual_options_n_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_ncplane(cPtr, false);
  }

  public void setScaling(ncscale_e value) {
    NCJNI.ncvisual_options_scaling_set(swigCPtr, this, value.swigValue());
  }

  public ncscale_e getScaling() {
    return ncscale_e.swigToEnum(NCJNI.ncvisual_options_scaling_get(swigCPtr, this));
  }

  public void setY(int value) {
    NCJNI.ncvisual_options_y_set(swigCPtr, this, value);
  }

  public int getY() {
    return NCJNI.ncvisual_options_y_get(swigCPtr, this);
  }

  public void setX(int value) {
    NCJNI.ncvisual_options_x_set(swigCPtr, this, value);
  }

  public int getX() {
    return NCJNI.ncvisual_options_x_get(swigCPtr, this);
  }

  public void setBegy(long value) {
    NCJNI.ncvisual_options_begy_set(swigCPtr, this, value);
  }

  public long getBegy() {
    return NCJNI.ncvisual_options_begy_get(swigCPtr, this);
  }

  public void setBegx(long value) {
    NCJNI.ncvisual_options_begx_set(swigCPtr, this, value);
  }

  public long getBegx() {
    return NCJNI.ncvisual_options_begx_get(swigCPtr, this);
  }

  public void setLeny(long value) {
    NCJNI.ncvisual_options_leny_set(swigCPtr, this, value);
  }

  public long getLeny() {
    return NCJNI.ncvisual_options_leny_get(swigCPtr, this);
  }

  public void setLenx(long value) {
    NCJNI.ncvisual_options_lenx_set(swigCPtr, this, value);
  }

  public long getLenx() {
    return NCJNI.ncvisual_options_lenx_get(swigCPtr, this);
  }

  public void setBlitter(ncblitter_e value) {
    NCJNI.ncvisual_options_blitter_set(swigCPtr, this, value.swigValue());
  }

  public ncblitter_e getBlitter() {
    return ncblitter_e.swigToEnum(NCJNI.ncvisual_options_blitter_get(swigCPtr, this));
  }

  public void setFlags(long value) {
    NCJNI.ncvisual_options_flags_set(swigCPtr, this, value);
  }

  public long getFlags() {
    return NCJNI.ncvisual_options_flags_get(swigCPtr, this);
  }

  public void setTranscolor(long value) {
    NCJNI.ncvisual_options_transcolor_set(swigCPtr, this, value);
  }

  public long getTranscolor() {
    return NCJNI.ncvisual_options_transcolor_get(swigCPtr, this);
  }

  public void setPxoffy(long value) {
    NCJNI.ncvisual_options_pxoffy_set(swigCPtr, this, value);
  }

  public long getPxoffy() {
    return NCJNI.ncvisual_options_pxoffy_get(swigCPtr, this);
  }

  public void setPxoffx(long value) {
    NCJNI.ncvisual_options_pxoffx_set(swigCPtr, this, value);
  }

  public long getPxoffx() {
    return NCJNI.ncvisual_options_pxoffx_get(swigCPtr, this);
  }

  public ncvisual_options() {
    this(NCJNI.new_ncvisual_options(), true);
  }

}