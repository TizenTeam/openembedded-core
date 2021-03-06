SUMMARY = "Assistive Technology Service Provider Interface (dbus core)"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e9f288ba982d60518f375b5898283886"

MAJ_VER = "${@oe.utils.trim_version("${PV}", 2)}"

SRC_URI = "${GNOME_MIRROR}/${BPN}/${MAJ_VER}/${BPN}-${PV}.tar.xz \
           file://0001-nls.m4-Take-it-from-gettext-0.15.patch \
          "

SRC_URI[md5sum] = "5f13ba8cfd97cf817261954ef49ebd48"
SRC_URI[sha256sum] = "57d555be4cc64905454687bf9bb7dc1e68531bee93befa77222d94ea083f01cf"

DEPENDS = "dbus glib-2.0 virtual/libx11 libxi libxtst intltool-native gettext-native"

inherit autotools gtk-doc pkgconfig distro_features_check upstream-version-is-even
# depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

EXTRA_OECONF = "--disable-introspection --disable-xevie --with-dbus-daemondir=${bindir}"

FILES_${PN} += "${datadir}/dbus-1/services/*.service \
                ${datadir}/dbus-1/accessibility-services/*.service"
