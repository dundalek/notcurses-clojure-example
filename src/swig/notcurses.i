%module NC
%{
/* Includes the header in the wrapper code */
#include "notcurses/notcurses.h"
%}

/* https://stackoverflow.com/a/47787334 */
#define __attribute__(x)
#define __attribute(x)

/* Exclude varargs http://swig.org/Doc4.0/SWIGDocumentation.html#Vararg */
%ignore ncplane_printf;
%ignore ncplane_printf_aligned;
%ignore ncplane_printf_stained;
%ignore ncplane_printf_yx;
%ignore ncplane_vprintf;
%ignore ncplane_vprintf_aligned;
%ignore ncplane_vprintf_stained;
%ignore ncplane_vprintf_yx;

// Include constants in Java source, because loading them via JNI bridge confuses Graal.
// There is also some light post-processing with sed, see scripts/generate-swig.
%javaconst(1);

/* SWIG for the truly lazy */
/* Parse the header file to generate wrappers */
%include <stdint.i>
%include "notcurses/notcurses.h"
