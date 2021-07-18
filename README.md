
# Notcurses Clojure example

[Notcurses](https://notcurses.com/) is a moderm library for building terminal UIs with advanced graphics support. This is a demo showing how to use it with [Clojure](https://clojure.org/).

Bindings are generated with [SWIG](http://swig.org/) and compiled using [Zig](https://andrewkelley.me/post/zig-cc-powerful-drop-in-replacement-gcc-clang.html) (any C compiler could be used, but I find Zig easiest to use because it includes powerful yet simple build system instead of relying on additional complex tools). [GraalVM](https://www.graalvm.org/) native-image is used to compile it to a binary executable.

![Notcurses demo](https://user-images.githubusercontent.com/755611/114319180-d83ac400-9aff-11eb-8b50-3e9a388b91c7.png)

Tested on Linux, might require some tweaks to run on macOS. Please let me know or open a PR if you get the demo running on macOS.

### Dependencies

- Easiest way to get dependencies is to install [Nix](https://nixos.org/download.html) package manager.  
  Running `nix-shell` will drop you in a shell with all dependencies pulled in.

- Otherwise install Clojure, SWIG, Zig, GraalVM and [Notcurses deps](https://github.com/dankamongmen/notcurses/blob/master/INSTALL.md) using a preferred way for your OS.

#### Pull in Notcurses source code

Since packaged versions of Notcurses are often outdated, we pull and build it from source:

```sh
git clone https://github.com/dankamongmen/notcurses.git deps/notcurses
cd deps/notcurses
git checkout v2.3.10  # latest release at the time of writing
mkdir build && cd build
cmake -DUSE_MULTIMEDIA=none -DUSE_PANDOC=OFF -DUSE_DOCTEST=OFF ..
# We just need `cmake` to generate some headers, no need to actually `make` since rest will be handled by Zig.
```

### Build and run

Build everything with:
```sh
scripts/compile
```

Run the binary:
```sh
target/demo
```

With the bindings compiled demo can be also run with the Clojure CLI:
```sh
clojure -Mnative -m demo.main
```

### Limitations

- Notcurses API for setters often uses pointers to primitive types to set their value, which does not work in Java since it only supports passing primitive types by value. Therefore functions to set channels properties like `ncchannels_set_*` need to be reimplemented in Clojure or Java.
- I didn't go through the whole API, some bindings might need additional tweaks to work.

### Related

See also the demo implemented in [Zig](https://github.com/dundalek/notcurses-zig-example).

### License

Dual-licensed under MIT or the [Unlicense](https://unlicense.org/).

Includes [Native Utils](https://github.com/adamheinrich/native-utils) licensed under MIT.
