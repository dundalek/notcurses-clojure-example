/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncmenu_section {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncmenu_section(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncmenu_section obj) {
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
        NCJNI.delete_ncmenu_section(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    NCJNI.ncmenu_section_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return NCJNI.ncmenu_section_name_get(swigCPtr, this);
  }

  public void setItemcount(int value) {
    NCJNI.ncmenu_section_itemcount_set(swigCPtr, this, value);
  }

  public int getItemcount() {
    return NCJNI.ncmenu_section_itemcount_get(swigCPtr, this);
  }

  public void setItems(ncmenu_item value) {
    NCJNI.ncmenu_section_items_set(swigCPtr, this, ncmenu_item.getCPtr(value), value);
  }

  public ncmenu_item getItems() {
    long cPtr = NCJNI.ncmenu_section_items_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ncmenu_item(cPtr, false);
  }

  public void setShortcut(ncinput value) {
    NCJNI.ncmenu_section_shortcut_set(swigCPtr, this, ncinput.getCPtr(value), value);
  }

  public ncinput getShortcut() {
    long cPtr = NCJNI.ncmenu_section_shortcut_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ncinput(cPtr, false);
  }

  public ncmenu_section() {
    this(NCJNI.new_ncmenu_section(), true);
  }

}
