const std = @import("std");
const Builder = std.build.Builder;
const allocator = std.testing.allocator;
const process = std.process;
const path = std.fs.path;

pub fn build(b: *Builder) !void {
    // Standard target options allows the person running `zig build` to choose
    // what target to build for. Here we do not override the defaults, which
    // means any target is allowed, and the default is native. Other options
    // for restricting supported target set are available.
    const target = b.standardTargetOptions(.{});

    // Standard release options allow the person running `zig build` to select
    // between Debug, ReleaseSafe, ReleaseFast, and ReleaseSmall.
    const mode = b.standardReleaseOptions();

    const notcurses_source_path = "deps/notcurses";

    const notcurses = b.addStaticLibrary("notcurses", null);
    notcurses.setTarget(target);
    notcurses.setBuildMode(mode);
    notcurses.linkLibC();

    notcurses.linkSystemLibrary("ncurses");
    notcurses.linkSystemLibrary("readline");
    notcurses.linkSystemLibrary("unistring");
    notcurses.linkSystemLibrary("z");

    notcurses.addIncludeDir(notcurses_source_path ++ "/include");
    notcurses.addIncludeDir(notcurses_source_path ++ "/build/include");
    notcurses.addIncludeDir(notcurses_source_path ++ "/src");
    notcurses.addCSourceFiles(&[_][]const u8{
        notcurses_source_path ++ "/src/lib/blit.c",
        notcurses_source_path ++ "/src/lib/debug.c",
        notcurses_source_path ++ "/src/lib/direct.c",
        notcurses_source_path ++ "/src/lib/fade.c",
        notcurses_source_path ++ "/src/lib/fd.c",
        notcurses_source_path ++ "/src/lib/fill.c",
        notcurses_source_path ++ "/src/lib/input.c",
        notcurses_source_path ++ "/src/lib/kitty.c",
        notcurses_source_path ++ "/src/lib/layout.c",
        notcurses_source_path ++ "/src/lib/linux.c",
        notcurses_source_path ++ "/src/lib/menu.c",
        notcurses_source_path ++ "/src/lib/metric.c",
        notcurses_source_path ++ "/src/lib/notcurses.c",
        notcurses_source_path ++ "/src/lib/plot.c",
        // notcurses_source_path ++ "/src/lib/png.c",
        notcurses_source_path ++ "/src/lib/progbar.c",
        notcurses_source_path ++ "/src/lib/reader.c",
        notcurses_source_path ++ "/src/lib/reel.c",
        notcurses_source_path ++ "/src/lib/render.c",
        notcurses_source_path ++ "/src/lib/selector.c",
        notcurses_source_path ++ "/src/lib/signal.c",
        notcurses_source_path ++ "/src/lib/sixel.c",
        notcurses_source_path ++ "/src/lib/sprite.c",
        notcurses_source_path ++ "/src/lib/stats.c",
        notcurses_source_path ++ "/src/lib/tabbed.c",
        notcurses_source_path ++ "/src/lib/termdesc.c",
        notcurses_source_path ++ "/src/lib/tree.c",
        notcurses_source_path ++ "/src/lib/visual.c",
        notcurses_source_path ++ "/src/compat/compat.c",
    }, &[_][]const u8{
        "-DUSE_MULTIMEDIA=none",
        "-DUSE_QRCODEGEN=OFF",
        "-DPOLLRDHUP=0x2000",
    });

    const jni = b.addSharedLibrary("notcurses-jni", null, b.version(0, 1, 0));
    jni.setTarget(target);
    jni.setBuildMode(mode);
    jni.install();
    jni.linkLibC();
    jni.setOutputDir("target/native");

    jni.addCSourceFiles(&[_][]const u8{
        "src/swig/notcurses_wrap.c"
    }, &[_][]const u8{
        "-Wno-deprecated",
    });

    const JAVA_HOME = try process.getEnvVarOwned(allocator, "JAVA_HOME");
    defer allocator.free(JAVA_HOME);

    const java_include = try path.join(allocator, &.{JAVA_HOME, "include"});
    defer allocator.free(java_include);
    jni.addIncludeDir(java_include);

    const java_include_linux = try path.join(allocator, &.{JAVA_HOME, "include", "linux"});
    defer allocator.free(java_include_linux);
    jni.addIncludeDir(java_include_linux);

    jni.addIncludeDir(notcurses_source_path ++ "/include");
    jni.linkLibrary(notcurses);

    const jni_step = b.step("notcurses-jni", "Build the notcurses JNI lib");
    jni_step.dependOn(&jni.step);
}
