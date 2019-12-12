package com.flj.latte.fragments;

import android.Manifest;
import android.support.annotation.NonNull;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by 傅令杰 on 2017/4/2
 */

@RuntimePermissions
public abstract class LatteFragment extends BaseFragment {

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void requestFilePermission() {
    }

    public void requestFilePermissionWithCheck() {
        LatteFragmentPermissionsDispatcher.requestFilePermissionWithPermissionCheck(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LatteFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
