with import <nixpkgs> {};
stdenv.mkDerivation {
  name = "notcurses-env";
  buildInputs = [
    bash
    clojure
    git
    graalvm11-ce
    zig
    swig4

    # notcurses dependencies
    libunistring
    ncurses
    qrcodegen
    readline
    zlib
  ];
}
