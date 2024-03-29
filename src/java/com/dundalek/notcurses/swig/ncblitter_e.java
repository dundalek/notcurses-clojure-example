/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public final class ncblitter_e {
  public final static ncblitter_e NCBLIT_DEFAULT = new ncblitter_e("NCBLIT_DEFAULT");
  public final static ncblitter_e NCBLIT_1x1 = new ncblitter_e("NCBLIT_1x1");
  public final static ncblitter_e NCBLIT_2x1 = new ncblitter_e("NCBLIT_2x1");
  public final static ncblitter_e NCBLIT_2x2 = new ncblitter_e("NCBLIT_2x2");
  public final static ncblitter_e NCBLIT_3x2 = new ncblitter_e("NCBLIT_3x2");
  public final static ncblitter_e NCBLIT_BRAILLE = new ncblitter_e("NCBLIT_BRAILLE");
  public final static ncblitter_e NCBLIT_PIXEL = new ncblitter_e("NCBLIT_PIXEL");
  public final static ncblitter_e NCBLIT_4x1 = new ncblitter_e("NCBLIT_4x1");
  public final static ncblitter_e NCBLIT_8x1 = new ncblitter_e("NCBLIT_8x1");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ncblitter_e swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ncblitter_e.class + " with value " + swigValue);
  }

  private ncblitter_e(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ncblitter_e(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ncblitter_e(String swigName, ncblitter_e swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ncblitter_e[] swigValues = { NCBLIT_DEFAULT, NCBLIT_1x1, NCBLIT_2x1, NCBLIT_2x2, NCBLIT_3x2, NCBLIT_BRAILLE, NCBLIT_PIXEL, NCBLIT_4x1, NCBLIT_8x1 };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

