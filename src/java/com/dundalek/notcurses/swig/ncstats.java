/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public class ncstats {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ncstats(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ncstats obj) {
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
        NCJNI.delete_ncstats(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRenders(long value) {
    NCJNI.ncstats_renders_set(swigCPtr, this, value);
  }

  public long getRenders() {
    return NCJNI.ncstats_renders_get(swigCPtr, this);
  }

  public void setWriteouts(long value) {
    NCJNI.ncstats_writeouts_set(swigCPtr, this, value);
  }

  public long getWriteouts() {
    return NCJNI.ncstats_writeouts_get(swigCPtr, this);
  }

  public void setFailed_renders(long value) {
    NCJNI.ncstats_failed_renders_set(swigCPtr, this, value);
  }

  public long getFailed_renders() {
    return NCJNI.ncstats_failed_renders_get(swigCPtr, this);
  }

  public void setFailed_writeouts(long value) {
    NCJNI.ncstats_failed_writeouts_set(swigCPtr, this, value);
  }

  public long getFailed_writeouts() {
    return NCJNI.ncstats_failed_writeouts_get(swigCPtr, this);
  }

  public void setRaster_bytes(long value) {
    NCJNI.ncstats_raster_bytes_set(swigCPtr, this, value);
  }

  public long getRaster_bytes() {
    return NCJNI.ncstats_raster_bytes_get(swigCPtr, this);
  }

  public void setRaster_max_bytes(int value) {
    NCJNI.ncstats_raster_max_bytes_set(swigCPtr, this, value);
  }

  public int getRaster_max_bytes() {
    return NCJNI.ncstats_raster_max_bytes_get(swigCPtr, this);
  }

  public void setRaster_min_bytes(int value) {
    NCJNI.ncstats_raster_min_bytes_set(swigCPtr, this, value);
  }

  public int getRaster_min_bytes() {
    return NCJNI.ncstats_raster_min_bytes_get(swigCPtr, this);
  }

  public void setRender_ns(long value) {
    NCJNI.ncstats_render_ns_set(swigCPtr, this, value);
  }

  public long getRender_ns() {
    return NCJNI.ncstats_render_ns_get(swigCPtr, this);
  }

  public void setRender_max_ns(int value) {
    NCJNI.ncstats_render_max_ns_set(swigCPtr, this, value);
  }

  public int getRender_max_ns() {
    return NCJNI.ncstats_render_max_ns_get(swigCPtr, this);
  }

  public void setRender_min_ns(int value) {
    NCJNI.ncstats_render_min_ns_set(swigCPtr, this, value);
  }

  public int getRender_min_ns() {
    return NCJNI.ncstats_render_min_ns_get(swigCPtr, this);
  }

  public void setRaster_ns(long value) {
    NCJNI.ncstats_raster_ns_set(swigCPtr, this, value);
  }

  public long getRaster_ns() {
    return NCJNI.ncstats_raster_ns_get(swigCPtr, this);
  }

  public void setRaster_max_ns(int value) {
    NCJNI.ncstats_raster_max_ns_set(swigCPtr, this, value);
  }

  public int getRaster_max_ns() {
    return NCJNI.ncstats_raster_max_ns_get(swigCPtr, this);
  }

  public void setRaster_min_ns(int value) {
    NCJNI.ncstats_raster_min_ns_set(swigCPtr, this, value);
  }

  public int getRaster_min_ns() {
    return NCJNI.ncstats_raster_min_ns_get(swigCPtr, this);
  }

  public void setWriteout_ns(long value) {
    NCJNI.ncstats_writeout_ns_set(swigCPtr, this, value);
  }

  public long getWriteout_ns() {
    return NCJNI.ncstats_writeout_ns_get(swigCPtr, this);
  }

  public void setWriteout_max_ns(int value) {
    NCJNI.ncstats_writeout_max_ns_set(swigCPtr, this, value);
  }

  public int getWriteout_max_ns() {
    return NCJNI.ncstats_writeout_max_ns_get(swigCPtr, this);
  }

  public void setWriteout_min_ns(int value) {
    NCJNI.ncstats_writeout_min_ns_set(swigCPtr, this, value);
  }

  public int getWriteout_min_ns() {
    return NCJNI.ncstats_writeout_min_ns_get(swigCPtr, this);
  }

  public void setCellelisions(long value) {
    NCJNI.ncstats_cellelisions_set(swigCPtr, this, value);
  }

  public long getCellelisions() {
    return NCJNI.ncstats_cellelisions_get(swigCPtr, this);
  }

  public void setCellemissions(long value) {
    NCJNI.ncstats_cellemissions_set(swigCPtr, this, value);
  }

  public long getCellemissions() {
    return NCJNI.ncstats_cellemissions_get(swigCPtr, this);
  }

  public void setFgelisions(long value) {
    NCJNI.ncstats_fgelisions_set(swigCPtr, this, value);
  }

  public long getFgelisions() {
    return NCJNI.ncstats_fgelisions_get(swigCPtr, this);
  }

  public void setFgemissions(long value) {
    NCJNI.ncstats_fgemissions_set(swigCPtr, this, value);
  }

  public long getFgemissions() {
    return NCJNI.ncstats_fgemissions_get(swigCPtr, this);
  }

  public void setBgelisions(long value) {
    NCJNI.ncstats_bgelisions_set(swigCPtr, this, value);
  }

  public long getBgelisions() {
    return NCJNI.ncstats_bgelisions_get(swigCPtr, this);
  }

  public void setBgemissions(long value) {
    NCJNI.ncstats_bgemissions_set(swigCPtr, this, value);
  }

  public long getBgemissions() {
    return NCJNI.ncstats_bgemissions_get(swigCPtr, this);
  }

  public void setDefaultelisions(long value) {
    NCJNI.ncstats_defaultelisions_set(swigCPtr, this, value);
  }

  public long getDefaultelisions() {
    return NCJNI.ncstats_defaultelisions_get(swigCPtr, this);
  }

  public void setDefaultemissions(long value) {
    NCJNI.ncstats_defaultemissions_set(swigCPtr, this, value);
  }

  public long getDefaultemissions() {
    return NCJNI.ncstats_defaultemissions_get(swigCPtr, this);
  }

  public void setRefreshes(long value) {
    NCJNI.ncstats_refreshes_set(swigCPtr, this, value);
  }

  public long getRefreshes() {
    return NCJNI.ncstats_refreshes_get(swigCPtr, this);
  }

  public void setSprixelemissions(long value) {
    NCJNI.ncstats_sprixelemissions_set(swigCPtr, this, value);
  }

  public long getSprixelemissions() {
    return NCJNI.ncstats_sprixelemissions_get(swigCPtr, this);
  }

  public void setSprixelelisions(long value) {
    NCJNI.ncstats_sprixelelisions_set(swigCPtr, this, value);
  }

  public long getSprixelelisions() {
    return NCJNI.ncstats_sprixelelisions_get(swigCPtr, this);
  }

  public void setSprixelbytes(long value) {
    NCJNI.ncstats_sprixelbytes_set(swigCPtr, this, value);
  }

  public long getSprixelbytes() {
    return NCJNI.ncstats_sprixelbytes_get(swigCPtr, this);
  }

  public void setAppsync_updates(long value) {
    NCJNI.ncstats_appsync_updates_set(swigCPtr, this, value);
  }

  public long getAppsync_updates() {
    return NCJNI.ncstats_appsync_updates_get(swigCPtr, this);
  }

  public void setInput_errors(long value) {
    NCJNI.ncstats_input_errors_set(swigCPtr, this, value);
  }

  public long getInput_errors() {
    return NCJNI.ncstats_input_errors_get(swigCPtr, this);
  }

  public void setInput_events(long value) {
    NCJNI.ncstats_input_events_set(swigCPtr, this, value);
  }

  public long getInput_events() {
    return NCJNI.ncstats_input_events_get(swigCPtr, this);
  }

  public void setHpa_gratuitous(long value) {
    NCJNI.ncstats_hpa_gratuitous_set(swigCPtr, this, value);
  }

  public long getHpa_gratuitous() {
    return NCJNI.ncstats_hpa_gratuitous_get(swigCPtr, this);
  }

  public void setCell_geo_changes(long value) {
    NCJNI.ncstats_cell_geo_changes_set(swigCPtr, this, value);
  }

  public long getCell_geo_changes() {
    return NCJNI.ncstats_cell_geo_changes_get(swigCPtr, this);
  }

  public void setPixel_geo_changes(long value) {
    NCJNI.ncstats_pixel_geo_changes_set(swigCPtr, this, value);
  }

  public long getPixel_geo_changes() {
    return NCJNI.ncstats_pixel_geo_changes_get(swigCPtr, this);
  }

  public void setFbbytes(long value) {
    NCJNI.ncstats_fbbytes_set(swigCPtr, this, value);
  }

  public long getFbbytes() {
    return NCJNI.ncstats_fbbytes_get(swigCPtr, this);
  }

  public void setPlanes(long value) {
    NCJNI.ncstats_planes_set(swigCPtr, this, value);
  }

  public long getPlanes() {
    return NCJNI.ncstats_planes_get(swigCPtr, this);
  }

  public ncstats() {
    this(NCJNI.new_ncstats(), true);
  }

}
