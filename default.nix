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

    # notcurses dependencies
    libunistring
    ncurses
    qrcodegen
    readline
    zlib
  ];
}
