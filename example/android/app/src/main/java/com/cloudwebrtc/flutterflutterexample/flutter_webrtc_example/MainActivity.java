package com.cloudwebrtc.flutterflutterexample.flutter_webrtc_example;

import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.cloudwebrtc.webrtc.FlutterWebRTCPlugin;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends FlutterActivity {
  private VideoProcessorSample videoProcessorSample;

  @Override
  public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    super.configureFlutterEngine(flutterEngine);
    videoProcessorSample =
        new VideoProcessorSample(flutterEngine.getDartExecutor().getBinaryMessenger());
  }

  @Override
  public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    if (videoProcessorSample != null) {
      videoProcessorSample.dispose();
      videoProcessorSample = null;
    }
    super.cleanUpFlutterEngine(flutterEngine);
  }

  @Override
  public void onUserLeaveHint() {
    super.onUserLeaveHint();
    FlutterWebRTCPlugin.onUserLeaveHint();
  }

  @Override
  public void onPictureInPictureModeChanged(
      boolean isInPictureInPictureMode, @NonNull Configuration newConfig) {
    super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    FlutterWebRTCPlugin.onPictureInPictureModeChanged(isInPictureInPictureMode);
  }
}
