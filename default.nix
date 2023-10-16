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
}
