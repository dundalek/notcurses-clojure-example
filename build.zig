const std = @import("std");
const Builder = std.build.Builder;
const process = std.process;
const path = std.fs.path;

pub fn build(b: *Builder) !void {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const allocator = gpa.allocator();
    // Standard target options allows the person running `zig build` to choose
    // what target to build for. Here we do not override the defaults, which
    // means any target is allowed, and the default is native. Other options
    // for restricting supported target set are available.
    const target = b.standardTargetOptions(.{});

    // Standard optimization options allow the person running `zig build` to select
    // between Debug, ReleaseSafe, ReleaseFast, and ReleaseSmall. Here we do not
    // set a preferred release mode, allowing the user to decide how to optimize.
    const optimize = b.standardOptimizeOption(.{});

    const notcurses_source_path = "deps/notcurses";

    const notcurses = b.addStaticLibrary(.{
        .name = "notcurses",
        .target = target,
        .optimize = optimize,
    });
    notcurses.linkLibC();

    notcurses.linkSystemLibrary("deflate");
    notcurses.linkSystemLibrary("ncurses");
    notcurses.linkSystemLibrary("readline");
    notcurses.linkSystemLibrary("unistring");
    notcurses.linkSystemLibrary("z");
    // even when passing -DUSE_QRCODEGEN=off we ge undefined symbol: qrcodegen_encodeBinary, so just link it
    notcurses.linkSystemLibrary2("qrcodegen", .{ .preferred_link_mode = .Static });

    notcurses.addIncludePath(.{ .path = notcurses_source_path ++ "/include" });
    notcurses.addIncludePath(.{ .path = notcurses_source_path ++ "/build/include" });
    notcurses.addIncludePath(.{ .path = notcurses_source_path ++ "/src" });
    notcurses.addCSourceFiles(&[_][]const u8{
        notcurses_source_path ++ "/src/compat/compat.c",
        notcurses_source_path ++ "/src/media/shim.c",
        notcurses_source_path ++ "/src/media/none.c",

        notcurses_source_path ++ "/src/lib/automaton.c",
        notcurses_source_path ++ "/src/lib/banner.c",
        notcurses_source_path ++ "/src/lib/blit.c",
        notcurses_source_path ++ "/src/lib/debug.c",
        notcurses_source_path ++ "/src/lib/direct.c",
        notcurses_source_path ++ "/src/lib/fade.c",
        notcurses_source_path ++ "/src/lib/fd.c",
        notcurses_source_path ++ "/src/lib/fill.c",
        notcurses_source_path ++ "/src/lib/gpm.c",
        notcurses_source_path ++ "/src/lib/in.c",
        notcurses_source_path ++ "/src/lib/kitty.c",
        notcurses_source_path ++ "/src/lib/layout.c",
        notcurses_source_path ++ "/src/lib/linux.c",
        notcurses_source_path ++ "/src/lib/menu.c",
        notcurses_source_path ++ "/src/lib/metric.c",
        notcurses_source_path ++ "/src/lib/mice.c",
        notcurses_source_path ++ "/src/lib/notcurses.c",
        notcurses_source_path ++ "/src/lib/plot.c",
        notcurses_source_path ++ "/src/lib/progbar.c",
        notcurses_source_path ++ "/src/lib/reader.c",
        notcurses_source_path ++ "/src/lib/reel.c",
        notcurses_source_path ++ "/src/lib/render.c",
        notcurses_source_path ++ "/src/lib/selector.c",
        notcurses_source_path ++ "/src/lib/sixel.c",
        notcurses_source_path ++ "/src/lib/sprite.c",
        notcurses_source_path ++ "/src/lib/stats.c",
        notcurses_source_path ++ "/src/lib/tabbed.c",
        notcurses_source_path ++ "/src/lib/termdesc.c",
        notcurses_source_path ++ "/src/lib/tree.c",
        notcurses_source_path ++ "/src/lib/unixsig.c",
        notcurses_source_path ++ "/src/lib/util.c",
        notcurses_source_path ++ "/src/lib/visual.c",
        notcurses_source_path ++ "/src/lib/windows.c",
    }, &[_][]const u8{
        "-std=gnu11",
        "-D_GNU_SOURCE", // to make memory management work, see sys/mman.h
        "-DUSE_MULTIMEDIA=none",
        "-DUSE_QRCODEGEN=off",
        "-DPOLLRDHUP=0x2000",
    });

    const jni = b.addSharedLibrary(.{
        .name = "notcurses-jni",
        .version = .{ .major = 0, .minor = 1, .patch = 0 },
        .target = target,
        .optimize = optimize,
    });
    jni.linkLibC();
    b.installArtifact(jni);
    // jni.setOutputDir("target/native");

    jni.addCSourceFiles(&[_][]const u8{"src/swig/notcurses_wrap.c"}, &[_][]const u8{
        "-Wno-deprecated",
    });

    const JAVA_HOME = try process.getEnvVarOwned(allocator, "JAVA_HOME");
    defer allocator.free(JAVA_HOME);

    const java_include = try path.join(allocator, &.{ JAVA_HOME, "include" });
    defer allocator.free(java_include);
    jni.addIncludePath(.{ .path = java_include });

    const java_include_linux = try path.join(allocator, &.{ JAVA_HOME, "include", "linux" });
    defer allocator.free(java_include_linux);
    jni.addIncludePath(.{ .path = java_include_linux });

    jni.addIncludePath(.{ .path = notcurses_source_path ++ "/include" });
    jni.linkLibrary(notcurses);

    const jni_step = b.step("notcurses-jni", "Build the notcurses JNI lib");
    jni_step.dependOn(&jni.step);
}
