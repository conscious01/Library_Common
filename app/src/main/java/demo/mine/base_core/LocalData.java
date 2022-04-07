package demo.mine.base_core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.qbw.spm.P;
import java.util.TimeZone;

/**
 * @author alexwu
 * @package_name com.bt.RoadParking
 * @date 5/19/21 @time 6:24 PM 本地数据保存
 */
public class LocalData {

//    private EntityLoginResult mUserInfo;
//
//    public void deleteLocalUserData() {
//        LocalData.getInstance().setUserInfo(null);
//
//        /*删除本地SharedPreferences*/
//        SharedPreferences sSharedPreferences = demo.mine.base_core.MyApplication.mInstantce.getSharedPreferences(
//                "P_qbw", Context.MODE_PRIVATE);
//        sSharedPreferences.edit().clear().commit();
//    }


    private static class Holder {

        private static LocalData INSTANCE = new LocalData();
    }

    private LocalData() {
    }

    public static LocalData getInstance() {
        return Holder.INSTANCE;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            value = P.getBoolean(key, defaultValue);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public void putBoolean(String key, boolean value) {
        P.putBoolean(key, value);
    }

    public void putString(String key, String value) {
        P.putString(key, value);
    }

    public String getString(String key) {
        String value = "";
        try {
            value = P.getString(key, "");
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public String getString(String key, String defaultValue) {
        String value = "";
        try {
            value = P.getString(key, defaultValue);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }


    public Long getLong(String key) {
        long value = 0;
        try {
            value = P.getLong(key, 0);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }


    public int getInt(String key, int v) {
        int value = 0;
        try {
            value = P.getInt(key, v);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public void putInt(String key, int v) {
        P.putInt(key, v);

    }

    public void putLong(String key, long v) {
        P.putLong(key, v);

    }

    public String getWebServiceDomain() {

//        if (ConS.IF_DEBUG_CODE_MODE) {
//            return ConS.SERVER_URL;
//        }

        // 获取URL.
        String strUrl = SPUtilNoDelete.getInstance().getString(ConS.HTTP_DOMAIN, "");

        // 去除两端空格.
        strUrl = strUrl.trim();

        // 如果URL为空,则提示错误.
        if (strUrl.length() == 0) {
            return "";
        }

        // 如果没有http://不可以设置.
        if (strUrl.toLowerCase().indexOf("http://") != 0) {
            return "";
        }

        // 如果地址不完整.
        if (strUrl.length() <= "http://".length()) {
            return "";
        }

        return strUrl;
    }

    public String getHttpsUrl() {
        String url = getWebServiceDomain().toLowerCase();
        if (!TextUtils.isEmpty(url)) {
            if (!url.contains("https")) {
                url = url.replace("http", "https");
            }
        }

        return url;
    }

    /**
     * 功能:<br/> &nbsp;&nbsp;&nbsp;用于获取服务器的URL。
     *
     * @return 返回服务器的URL。
     */
    public String getWebServiceUrl() {
        String strRet = "";
        if (getWebServiceDomain().trim().length() <= 0) {
            return "";
        }
        strRet = getWebServiceDomain() + "/interface/Default.aspx";

        return strRet;
    }

    /**
     * 用于获取admin的密码的MD5值。
     *
     * @return admin的MD5值。
     */
    public String getAdminPassword() {
        String strRet = SPUtilNoDelete.getInstance()
                .getString(ConS.ADMIN_PASSWORD, "21232f297a57a5a743894a0e4a801fc3".toUpperCase());

        return strRet;
    }





    public void saveLoginTimeStamp() {
        P.putLong(ConS.LOGIN_TIME_STAMP, TimeUtils.getNowMills());
        setLogged();

    }

    private void setLogged() {
        P.putBoolean(ConS.IF_LOGGED, true);
    }

    private Long getLastLoginTimeStamp() {
        return P.getLong(ConS.LOGIN_TIME_STAMP, 0);
    }




    /*----zoneId---------------------------可以切换线路，选择zoneid*/
    public int getNowZonePosition() {

//        int nowPosition = getInt(ConS.NOW_ZONE_POSITION, 0);
//        if (CollectionUtils.isNotEmpty(getUserInfo().getZones())) {
//            /*防止出现指针越界*/
//            try {
//                getUserInfo().getZones().get(nowPosition);
//            } catch (Exception e) {
//                nowPosition = 0;
//            }
//        }
        return 0;
    }


    public void setNowZonePosition(int zonePosition) {
        putInt(ConS.NOW_ZONE_POSITION, zonePosition);
    }


    public void updateZonePositionViaZoneId(String zoneId) {
        LogUtils.i("查看zoneid ", zoneId);
        setNowZonePosition(getZonePositionViaZoneId(zoneId));
    }


    public String getNowZoneId() {
        return "";
//        try {
//            return LocalData.getInstance().getUserInfo().getZones().get(getNowZonePosition())
//                    .getId();
//        } catch (Exception e) {
//            return "";
//        }
    }


    public String getNowZoneName() {

//        if (LocalData.getInstance().getUserInfo().getZones() != null
//                && LocalData.getInstance().getUserInfo().getZones().size() > 0) {
//            String nowZoneName = "";
//
//            try {
//                nowZoneName = LocalData.getInstance().getUserInfo().getZones()
//                        .get(LocalData.getInstance().getNowZonePosition())
//                        .getName();
//            } catch (Exception e) {
//                LogUtils.i(nowZoneName);
//            }
//            return nowZoneName;
//
//        } else {
//            return "";
//        }
        return "";

    }


    public int getZonePositionViaZoneId(String zoneId) {

//        if (LocalData.getInstance().getUserInfo().getZones() != null
//                && LocalData.getInstance().getUserInfo().getZones().size() > 0) {
//
//            List<EntityLoginResult.ZonesBean> zonesBeanList = LocalData.getInstance().getUserInfo()
//                    .getZones();
//            for (int i = 0; i < zonesBeanList.size(); i++) {
//                if (zonesBeanList.get(i).getId().equals(zoneId)) {
//                    return i;
//                }
//            }
//        } else {
//            return 0;
//        }
        return 0;

    }


    /*----zoneId---------------------------------------------------*/

}
