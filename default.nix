with import <nixpkgs> { };
stdenv.mkDerivation {
  name = "notcurses-env";
  buildInputs = [
    bash
    clojure
    git
    gnused
    graalvm-ce
    zig
    swig4
    which

    # notcurses tool dependencies
    cmake
    pkg-config
    # notcurses lib dependencies
    libdeflate
    libunistring
    ncurses
    qrcodegen
    readline
    zlib
  ];
  shellHook = ''
    # OpenJDK seems to crash more often than GraalVM
    # JAVA_HOME points to graal, set JAVA_CMD to use graal with Clojure CLI
    export JAVA_CMD="$JAVA_HOME/bin/java"
  '';
}
