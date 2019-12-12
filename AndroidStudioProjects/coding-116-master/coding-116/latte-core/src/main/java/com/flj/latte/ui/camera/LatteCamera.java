package com.flj.latte.ui.camera;

import android.net.Uri;

import com.flj.latte.fragments.LatteFragment;
import com.flj.latte.util.file.FileUtil;

/**
 * Created by 傅令杰
 * 照相机调用类
 */

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(LatteFragment fragment) {
        new CameraHandler(fragment).beginCameraDialog();
    }
}
