package app.morphe.patches.primevideo.speed

import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.primevideo.shared.Constants
import app.morphe.util.returnEarly

@Suppress("unused")
val playbackSpeedPatch = bytecodePatch(
    name = "Enable speed control",
    description = "Enables experimental speed control to the video player.",
) {
    compatibleWith(Constants.COMPATIBILITY)

    execute {
        IsPlaybackSettingsV2EnabledFingerprint.method.returnEarly(true)
        IsPlaybackSpeedFeatureEnabledFingerprint.method.returnEarly(true)
    }
}