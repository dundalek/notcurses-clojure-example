/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.dundalek.notcurses.swig;

public interface NCConstants {
  public final static long NCALPHA_HIGHCONTRAST = 0x30000000L;
  public final static long NCALPHA_TRANSPARENT = 0x20000000L;
  public final static long NCALPHA_BLEND = 0x10000000L;
  public final static long NCALPHA_OPAQUE = 0x00000000L;
  public final static int NCPALETTESIZE = 256;
  public final static long NC_NOBACKGROUND_MASK = 0x8700000000000000L;
  public final static long NC_BGDEFAULT_MASK = 0x0000000040000000L;
  public final static long NC_BG_RGB_MASK = 0x0000000000ffffffL;
  public final static long NC_BG_PALETTE = 0x0000000008000000L;
  public final static long NC_BG_ALPHA_MASK = 0x30000000L;
  public final static int WCHAR_MAX_UTF8BYTES = 4;
  public final static long NCSTYLE_MASK = 0xffff;
  public final static long NCSTYLE_ITALIC = 0x0010;
  public final static long NCSTYLE_UNDERLINE = 0x0008;
  public final static long NCSTYLE_UNDERCURL = 0x0004;
  public final static long NCSTYLE_BOLD = 0x0002;
  public final static long NCSTYLE_STRUCK = 0x0001;
  public final static int NCSTYLE_NONE = 0;
  public final static long NCOPTION_INHIBIT_SETLOCALE = 0x0001L;
  public final static long NCOPTION_NO_CLEAR_BITMAPS = 0x0002L;
  public final static long NCOPTION_NO_WINCH_SIGHANDLER = 0x0004L;
  public final static long NCOPTION_NO_QUIT_SIGHANDLERS = 0x0008L;
  public final static long NCOPTION_PRESERVE_CURSOR = 0x0010L;
  public final static long NCOPTION_SUPPRESS_BANNERS = 0x0020L;
  public final static long NCOPTION_NO_ALTERNATE_SCREEN = 0x0040L;
  public final static long NCOPTION_NO_FONT_CHANGES = 0x0080L;
  public final static long NCOPTION_DRAIN_INPUT = 0x0100L;
  public final static long NCOPTION_SCROLLING = 0x0200L;
  public final static long NCOPTION_CLI_MODE = (0x0040L|0x0002L|0x0010L|0x0200L);
  public final static int NCMICE_NO_EVENTS = 0;
  public final static int NCMICE_MOVE_EVENT = 0x1;
  public final static int NCMICE_BUTTON_EVENT = 0x2;
  public final static int NCMICE_DRAG_EVENT = 0x4;
  public final static int NCMICE_ALL_EVENTS = 0x7;
  public final static long NCPLANE_OPTION_HORALIGNED = 0x0001L;
  public final static long NCPLANE_OPTION_VERALIGNED = 0x0002L;
  public final static long NCPLANE_OPTION_MARGINALIZED = 0x0004L;
  public final static long NCPLANE_OPTION_FIXED = 0x0008L;
  public final static long NCPLANE_OPTION_AUTOGROW = 0x0010L;
  public final static long NCPLANE_OPTION_VSCROLL = 0x0020L;
  public final static int NCBOXMASK_TOP = 0x0001;
  public final static int NCBOXMASK_RIGHT = 0x0002;
  public final static int NCBOXMASK_BOTTOM = 0x0004;
  public final static int NCBOXMASK_LEFT = 0x0008;
  public final static int NCBOXGRAD_TOP = 0x0010;
  public final static int NCBOXGRAD_RIGHT = 0x0020;
  public final static int NCBOXGRAD_BOTTOM = 0x0040;
  public final static int NCBOXGRAD_LEFT = 0x0080;
  public final static int NCBOXCORNER_MASK = 0x0300;
  public final static long NCBOXCORNER_SHIFT = 8;
  public final static long NCVISUAL_OPTION_NODEGRADE = 0x0001L;
  public final static long NCVISUAL_OPTION_BLEND = 0x0002L;
  public final static long NCVISUAL_OPTION_HORALIGNED = 0x0004L;
  public final static long NCVISUAL_OPTION_VERALIGNED = 0x0008L;
  public final static long NCVISUAL_OPTION_ADDALPHA = 0x0010L;
  public final static long NCVISUAL_OPTION_CHILDPLANE = 0x0020L;
  public final static long NCVISUAL_OPTION_NOINTERPOLATE = 0x0040L;
  public final static long NCREEL_OPTION_INFINITESCROLL = 0x0001L;
  public final static long NCREEL_OPTION_CIRCULAR = 0x0002L;
  public final static int NCPREFIXCOLUMNS = 7;
  public final static int NCIPREFIXCOLUMNS = 8;
  public final static int NCBPREFIXCOLUMNS = 9;
  public final static int NCPREFIXSTRLEN = (7+1);
  public final static int NCIPREFIXSTRLEN = (8+1);
  public final static int NCBPREFIXSTRLEN = (9+1);
  public final static long NCMENU_OPTION_BOTTOM = 0x0001L;
  public final static long NCMENU_OPTION_HIDING = 0x0002L;
  public final static long NCPROGBAR_OPTION_RETROGRADE = 0x0001;
  public final static long NCTABBED_OPTION_BOTTOM = 0x0001L;
  public final static long NCPLOT_OPTION_LABELTICKSD = 0x0001;
  public final static long NCPLOT_OPTION_EXPONENTIALD = 0x0002;
  public final static long NCPLOT_OPTION_VERTICALI = 0x0004;
  public final static long NCPLOT_OPTION_NODEGRADE = 0x0008;
  public final static long NCPLOT_OPTION_DETECTMAXONLY = 0x0010;
  public final static long NCPLOT_OPTION_PRINTSAMPLE = 0x0020;
  public final static long NCREADER_OPTION_HORSCROLL = 0x0001L;
  public final static long NCREADER_OPTION_VERSCROLL = 0x0002L;
  public final static long NCREADER_OPTION_NOCMDKEYS = 0x0004L;
  public final static long NCREADER_OPTION_CURSOR = 0x0008L;
}
