with import <nixpkgs> {};
stdenv.mkDerivation {
  name = "notcurses-env";
  buildInputs = [
    bash
    clojure
    git
    gnused
    graalvm11-ce
    zig
    swig4
    which

    # notcurses tool dependencies
    cmake
    pkg-config
    # notcurses lib dependencies
    libunistring
    ncurses
    qrcodegen
    readline81
    zlib
  ];
}
