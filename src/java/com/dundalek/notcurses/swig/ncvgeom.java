/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncvgeom {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncvgeom(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncvgeom obj) {
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
        NCJNI.delete_ncvgeom(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPixy(long value) {
    NCJNI.ncvgeom_pixy_set(swigCPtr, this, value);
  }

  public long getPixy() {
    return NCJNI.ncvgeom_pixy_get(swigCPtr, this);
  }

  public void setPixx(long value) {
    NCJNI.ncvgeom_pixx_set(swigCPtr, this, value);
  }

  public long getPixx() {
    return NCJNI.ncvgeom_pixx_get(swigCPtr, this);
  }

  public void setCdimy(long value) {
    NCJNI.ncvgeom_cdimy_set(swigCPtr, this, value);
  }

  public long getCdimy() {
    return NCJNI.ncvgeom_cdimy_get(swigCPtr, this);
  }

  public void setCdimx(long value) {
    NCJNI.ncvgeom_cdimx_set(swigCPtr, this, value);
  }

  public long getCdimx() {
    return NCJNI.ncvgeom_cdimx_get(swigCPtr, this);
  }

  public void setRpixy(long value) {
    NCJNI.ncvgeom_rpixy_set(swigCPtr, this, value);
  }

  public long getRpixy() {
    return NCJNI.ncvgeom_rpixy_get(swigCPtr, this);
  }

  public void setRpixx(long value) {
    NCJNI.ncvgeom_rpixx_set(swigCPtr, this, value);
  }

  public long getRpixx() {
    return NCJNI.ncvgeom_rpixx_get(swigCPtr, this);
  }

  public void setRcelly(long value) {
    NCJNI.ncvgeom_rcelly_set(swigCPtr, this, value);
  }

  public long getRcelly() {
    return NCJNI.ncvgeom_rcelly_get(swigCPtr, this);
  }

  public void setRcellx(long value) {
    NCJNI.ncvgeom_rcellx_set(swigCPtr, this, value);
  }

  public long getRcellx() {
    return NCJNI.ncvgeom_rcellx_get(swigCPtr, this);
  }

  public void setScaley(long value) {
    NCJNI.ncvgeom_scaley_set(swigCPtr, this, value);
  }

  public long getScaley() {
    return NCJNI.ncvgeom_scaley_get(swigCPtr, this);
  }

  public void setScalex(long value) {
    NCJNI.ncvgeom_scalex_set(swigCPtr, this, value);
  }

  public long getScalex() {
    return NCJNI.ncvgeom_scalex_get(swigCPtr, this);
  }

  public void setBegy(long value) {
    NCJNI.ncvgeom_begy_set(swigCPtr, this, value);
  }

  public long getBegy() {
    return NCJNI.ncvgeom_begy_get(swigCPtr, this);
  }

  public void setBegx(long value) {
    NCJNI.ncvgeom_begx_set(swigCPtr, this, value);
  }

  public long getBegx() {
    return NCJNI.ncvgeom_begx_get(swigCPtr, this);
  }

  public void setLeny(long value) {
    NCJNI.ncvgeom_leny_set(swigCPtr, this, value);
  }

  public long getLeny() {
    return NCJNI.ncvgeom_leny_get(swigCPtr, this);
  }

  public void setLenx(long value) {
    NCJNI.ncvgeom_lenx_set(swigCPtr, this, value);
  }

  public long getLenx() {
    return NCJNI.ncvgeom_lenx_get(swigCPtr, this);
  }

  public void setMaxpixely(long value) {
    NCJNI.ncvgeom_maxpixely_set(swigCPtr, this, value);
  }

  public long getMaxpixely() {
    return NCJNI.ncvgeom_maxpixely_get(swigCPtr, this);
  }

  public void setMaxpixelx(long value) {
    NCJNI.ncvgeom_maxpixelx_set(swigCPtr, this, value);
  }

  public long getMaxpixelx() {
    return NCJNI.ncvgeom_maxpixelx_get(swigCPtr, this);
  }

  public void setBlitter(ncblitter_e value) {
    NCJNI.ncvgeom_blitter_set(swigCPtr, this, value.swigValue());
  }

  public ncblitter_e getBlitter() {
    return ncblitter_e.swigToEnum(NCJNI.ncvgeom_blitter_get(swigCPtr, this));
  }

  public ncvgeom() {
    this(NCJNI.new_ncvgeom(), true);
  }

}
