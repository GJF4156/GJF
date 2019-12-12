package com.showly.commodityclassifydemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class CommonUtils {


    /**
     * 隐藏软键盘
     *
     * @param context
     */
    public static void hideSoftkey(Activity context, IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 从alipay支付信息中截取信息
     *
     * @param s
     * @return
     */
    public static Bundle decodeUrl(String s) {
        s.replaceAll("\"", "");
        Bundle params = new Bundle();
        if (s != null) {
            String array[] = s.split("&");
            for (String parameter : array) {
                String v[] = parameter.split("=");
                if (v.length == 2) {
                    params.putString(URLDecoder.decode(v[0]), URLDecoder.decode(v[1]));
                }
            }
        }
        return params;
    }

    /**
     * MD5加密
     *
     * @param s
     * @return
     */
    public static String md5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * SHA1加密
     *
     * @param s
     * @return
     */
    public static String SHA1(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String toHexString(byte[] keyData) {
        if (keyData == null) {
            return null;
        }
        int expectedStringLen = keyData.length * 2;
        StringBuilder sb = new StringBuilder(expectedStringLen);
        for (int i = 0; i < keyData.length; i++) {
            String hexStr = Integer.toString(keyData[i] & 0x00FF, 16);
            if (hexStr.length() == 1) {
                hexStr = "0" + hexStr;
            }
            sb.append(hexStr);
        }
        return sb.toString();
    }

    /**
     * 获取sd卡路径 返回路径带"／"
     *
     * @param context
     * @return
     */
    public static String getSDPath(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File dirFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
            try {
                if (!(dirFile.exists() && !(dirFile.isDirectory()))) {
                    dirFile.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dirFile.getAbsolutePath();
        }
        return null;
    }

    public static Bundle parseUrl(String url) {
        try {
            URL u = new URL(url);
            Bundle b = decodeUrl(u.getQuery());
            b.putAll(decodeUrl(u.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    /**
     * 检查包名对应的apk是否有安装
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean checkPackInstall(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean networkWroking(Activity activity) {
        return networkWroking(activity.getApplicationContext());
    }

    public static boolean networkWroking(Context context) {
        try {
            // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            } else {
                // 获取NetworkInfo对象
                @SuppressLint("MissingPermission") NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
                if (networkInfo != null && networkInfo.length > 0) {
                    for (int i = 0; i < networkInfo.length; i++) {
                        // 判断当前网络状态是否为连接状态
                        if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 吐司
     *
     * @param mContext
     * @param msg
     */
    public static void showToast(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context mContext, String msg, int time) {
        Toast.makeText(mContext, msg, time).show();
    }

    /**
     * 根据appkey，sdkVersion，token得到签名
     *
     * @param appKey
     * @param SDKVersion
     * @param token
     * @return
     */
    public static String getSign(String appKey, String SDKVersion, String token) {
        if (TextUtils.isEmpty(token) || token.equals("")) {
            token = null;
        }
        return md5(appKey + "_" + SDKVersion + "_" + token);
    }


    /**
     * MD5生成签名字符串
     *
     * @param map 需签名参数
     * @return
     */
    public static String MD5sign(Map<String, Object> map) {
        String genSign = "";
        try {
            String[] signFields = new String[6];
            signFields[0] = "appId";
            signFields[1] = "openId";
            signFields[2] = "token";
            signFields[3] = "channelkey";
            signFields[4] = "uid";
            signFields[5] = "appKey";
            JSONObject param = new JSONObject(map);
            // 生成签名原文
            String signSrc = orgSignSrc(signFields, param);
            //Log.i("aaa", "signSrc==" + signSrc);
            // MD5的方式签名
            genSign = md5(signSrc);
            //Log.i("aaa", "genSign==" + genSign);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return genSign;
    }

    /**
     * 构建签名原文
     *
     * @param param 参数与值的jsonbject
     * @return
     */
    private static String orgSignSrc(String[] signFields, JSONObject param) throws JSONException {
        if (signFields != null) {
            Arrays.sort(signFields); // 对key按照 字典顺序排序
        }
        StringBuffer signSrc = new StringBuffer("");
        int i = 0;
        for (String field : signFields) {
            if (TextUtils.isEmpty(param.getString(field))) {
                return null;
            }
            signSrc.append(field);
            signSrc.append("=");
            signSrc.append(param.getString(field));
            i++;
        }
        return signSrc.toString();
    }


    /**
     * dp转换成px
     *
     * @param mContext
     * @param dp
     * @return
     */
    public static int dpToPx(Context mContext, int dp) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取屏幕的宽
     *
     * @param mContext
     * @return
     */
    public static int getScreenWidth(Context mContext) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获取屏幕的高
     *
     * @param mContext
     * @return
     */
    public static int getScreenHeight(Context mContext) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获取屏幕的截图
     *
     * @param activity
     * @return
     */
    public static Bitmap getScreenBitmap(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;
    }

    public static String getApplicationName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        String applicationName = "";
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationName;
    }

    /**
     * 根据资源名字来反射出资源id author:chuan
     *
     * @param name        资源的名字
     * @param type        资源的类型
     * @param packageName 项目的报名
     * @param context
     * @return 资源的id
     */
    public static int getIdByName(String name, String type, String packageName, Context context) {
        int id = context.getResources().getIdentifier(name, type, packageName);
        return id;
    }

    /**
     * 判断微信是否安装
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void hideInput(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    //沉浸式
    public static void setStatusBar(Activity activity) {
        //要考虑虚拟按钮的事
        if (Build.VERSION.SDK_INT >= 21) {//沉浸式，要版本在21以上才有效
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {

        }
    }

    //转换时间戳  05-04
    public static String getMonthTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeString = sdf.format(new Date(time));
        String[] timeList = timeString.split("-");
        return timeList[1] + "-" + timeList[2];
    }

    //转换时间戳  年份
    public static String getYearTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeString = sdf.format(new Date(time));
        String[] timeList = timeString.split("-");
        return timeList[0];
    }

    //转换时间戳  13:18:28
    public static String getHoustTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeString = sdf.format(new Date(time));
        String[] timeList = timeString.split("-");
        return timeList[3] + ":" + timeList[4] + ":" + timeList[5];
    }

    //转换时间戳  5月17日
    public static String getDayTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeString = sdf.format(new Date(time));
        String[] timeList = timeString.split("-");
        return timeList[1] + "月" + timeList[2] + "日";
    }

    //转换时间戳  2018.5.19 16:00:00
    public static String getSecondTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeString = sdf.format(new Date(time));
        String[] timeList = timeString.split("-");
        return timeList[0] + "." + timeList[1] + "." + timeList[2] + " " +
                "" + timeList[3] + ":" + timeList[4] + ":" + timeList[5];
    }

    //转换时间戳  2018.5.19 16:00:00
    public static String getEndTime(String endDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(endDate);
        String timeString = df.format(d1);
        String[] timeList = timeString.split(" ");
        String[] split = timeList[0].split("-");
        String[] strings = timeList[1].split(":");

        return split[1] + "月" + split[2] + "日" + " " + strings[0] + ":" + strings[1];
    }

    //转换时间戳
    public static String getMonthTime(String endDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(endDate);
        String timeString = df.format(d1);
        String[] timeList = timeString.split(" ");
        String[] split = timeList[0].split("-");
        String month = "";
        switch (split[1]) {
            case "01":
                month = "一";
                break;
            case "02":
                month = "二";
                break;
            case "03":
                month = "三";
                break;
            case "04":
                month = "四";
                break;
            case "05":
                month = "五";
                break;
            case "06":
                month = "六";
                break;
            case "07":
                month = "七";
                break;
            case "08":
                month = "八";
                break;
            case "09":
                month = "九";
                break;
            case "10":
                month = "十";
                break;
            case "11":
                month = "十一";
                break;
            case "12":
                month = "十二";
                break;
        }

        return month;
    }

    //转换时间戳
    public static String getDay(String endDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(endDate);
        String timeString = df.format(d1);
        String[] timeList = timeString.split(" ");
        String[] split = timeList[0].split("-");

        return split[2];
    }

    //获取当前时间戳，秒
    public static Long getTimeNow() {
        long time = new Date().getTime();
        String sTime = time + "";
        String substring = sTime.substring(0, sTime.length() - 2);
        Log.d("aaa", "---------------当前时间戳-" + time + "-截取-" + substring + "_长度_" + sTime.length());
        return Long.parseLong(substring);
    }


    //获取两个2019-03-31 10:00:00时间格式，时间差
    public static String residueTime(String endDate, String newDate) throws ParseException {
        String result = "";

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(endDate);
        Date d2 = df.parse(newDate);
        long diff = d1.getTime() - d2.getTime();
        long day = diff / nd;//天
        long hour = (diff / nh) % 24;//时
        long minute = (diff / nm) % 60;//分
        if (day == 0) {
            if (hour == 0) {
                result = minute + "分";
            } else {
                result = hour + "时" + minute + "分";
            }
        } else {
            result = (day + 1) + "天";
        }

        return result;
    }

    //将毫秒转化为 时：分：秒 格式 ，例如  00:05:23
    public static long residueTimeout(String endDate, String newDate) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(endDate);
        Date d2 = df.parse(newDate);
        long diff = d1.getTime() - d2.getTime();

        return diff;
    }

    //将毫秒转化为 时：分：秒 格式 ，例如  00:05:23
    public static String calculatTime(long milliSecondTime) {

        long hour = milliSecondTime / (60 * 60 * 1000);
        long minute = (milliSecondTime - hour * 60 * 60 * 1000) / (60 * 1000);
        long seconds = (milliSecondTime - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;

        if (seconds >= 60) {
            seconds = seconds % 60;
            minute += seconds / 60;
        }
        if (minute >= 60) {
            minute = minute % 60;
            hour += minute / 60;
        }

        String sh = "";
        String sm = "";
        String ss = "";
        if (hour < 10) {
            sh = "0" + String.valueOf(hour);
        } else {
            sh = String.valueOf(hour);
        }
        if (minute < 10) {
            sm = "0" + String.valueOf(minute);
        } else {
            sm = String.valueOf(minute);
        }
        if (seconds < 10) {
            ss = "0" + String.valueOf(seconds);
        } else {
            ss = String.valueOf(seconds);
        }

        return sh + ":" + sm + ":" + ss;
    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //long lt = new Long(s);
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }


    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

}
