package demo.mine.base_core;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

/**
 * @author alexwu package_name com.tools.idcardandtemperature.common.utils Created at 5/27/21 5:40
 * PM Describe: 请求Body的构建
 */
public class RequestJsonObject {

    public static class Builder {

        private final JsonObject jsonObject = new JsonObject();

        public Builder setName(String name) {
            jsonObject.addProperty("name", name);
            return this;
        }

        public Builder buildWorkNo(String workNo) {
            jsonObject.addProperty("workNo", workNo);
            return this;
        }

        public Builder setPassword(String password) {
            jsonObject.addProperty("password", password);
            return this;
        }

        public Builder setDeviceId(String deviceId) {
            jsonObject.addProperty("deviceId", deviceId);
            return this;
        }

//        public Builder buildDeviceId() {
//            jsonObject.addProperty("deviceId", StringUtil.getDeviceId());
//            return this;
//        }
//
//        public Builder buildOperatorId() {
//            jsonObject.addProperty("operatorId",
//                    LocalData.getInstance().getUserInfo().getOperator().getId());
//            return this;
//        }

//        public Builder buildOutOperatorId() {
//            jsonObject.addProperty("outOperatorId",
//                    LocalData.getInstance().getUserInfo().getOperator().getId());
//            return this;
//        }
//
//        /*任何接口都需要加上*/
//        public Builder buildCompanyId() {
//            if (LocalData.getInstance().getUserInfo() != null
//                    && LocalData.getInstance().getUserInfo().getOperator() != null) {
//                jsonObject.addProperty("companyId",
//                        LocalData.getInstance().getUserInfo().getOperator().getCompanyId());
//            }
//            return this;
//        }


        public Builder setDeviceNo(String value) {
            jsonObject.addProperty("deviceNo", value);
            return this;
        }

//        public Builder setDeviceNo() {
//            jsonObject.addProperty("deviceNo", StringUtil.getDeviceId());
//            return this;
//        }

        public Builder setSignType(int value) {
            jsonObject.addProperty("signType", value);
            return this;
        }

        public Builder setPage(int page) {
            jsonObject.addProperty("page", page);
            return this;
        }

        public Builder setPageSize(int pageSize) {
            jsonObject.addProperty("pageSize", pageSize);
            return this;
        }

        public Builder setStartDate(String startDate) {
            jsonObject.addProperty("startDate", startDate);
            return this;
        }

        public Builder setEndDate(String endDate) {
            jsonObject.addProperty("endDate", endDate);
            return this;
        }

        public Builder buildZoneIds() {

//            List<EntityLoginResult.ZonesBean> zonesBeans = LocalData.getInstance().getUserInfo()
//                    .getZones();
//            if (zonesBeans == null || zonesBeans.size() == 0) {
//                LogUtils.i("参数错误 buildZoneIds ");
//                return this;
//            }
//            /*获取list,快速，jdk*/
//            List<String> zoneIds = zonesBeans.stream().map(o -> o.getId())
//                    .collect(Collectors.toList());
//
//            JsonArray array = new JsonArray();
//            for (int i = 0; i < zoneIds.size(); i++) {
//                array.add(zoneIds.get(i));
//            }
//
//            jsonObject.add("zoneIds", array);
            return this;
        }

        public Builder buildAreaId() {
//            jsonObject.addProperty("areaId",
//                    LocalData.getInstance().getUserInfo().getOperator().getAreaId());
            return this;
        }

        public JsonObject build() {
            return jsonObject;
        }

        public Builder buildGroupName(String carType) {
            jsonObject.addProperty("groupName", carType);
            return this;
        }

        public Builder buildPlaceId(String placeId) {
            jsonObject.addProperty("placeId", placeId);
            return this;
        }

        public Builder buildPlaceName(String placeName) {
            jsonObject.addProperty("placeName", placeName);
            return this;
        }

        public Builder buildCarNo(String carNo) {
            jsonObject.addProperty("carNo", carNo);
            return this;
        }

        public Builder buildCarNoPhoto(String carNoPhoto) {
            jsonObject.addProperty("carNoPhoto", carNoPhoto);
            return this;
        }

        public Builder buildEntranceDate(String entranceDate) {
            jsonObject.addProperty("entranceDate", entranceDate);
            return this;
        }

        public Builder buildDeviceNotifyInDate(String deviceNotifyInDate) {
            jsonObject.addProperty("deviceNotifyInDate", deviceNotifyInDate);
            return this;

        }

        public Builder buildCarType(String carType) {
            if (!TextUtils.isEmpty(carType)) {
                jsonObject.addProperty("carType", carType);
            }
            return this;
        }

//        public Builder buildOperatorName() {
//            jsonObject.addProperty("operatorName",
//                    LocalData.getInstance().getUserInfo().getOperator().getName());
//            return this;
//        }

        public Builder buildParkOrderId(String parkOrderId) {
            jsonObject.addProperty("parkOrderId", parkOrderId);
            return this;
        }

        public Builder buildReturnWay(int returnWay) {
            jsonObject.addProperty("returnWay", returnWay);
            return this;
        }

        public Builder buildPledgeAmount(float pledgeAmount) {
            jsonObject.addProperty("pledgeAmount", pledgeAmount);
            return this;
        }

        public Builder buildPayWay(int payWay) {
            jsonObject.addProperty("payWay", payWay);
            return this;
        }

        public Builder buildParkPledgeOrderId(String parkPledgeOrderId) {
            jsonObject.addProperty("parkPledgeOrderId", parkPledgeOrderId);
            return this;
        }

        public Builder buildOauthCode(String authCode) {
            jsonObject.addProperty("authCode", authCode);
            return this;
        }

        public Builder buildOrderIds(List<String> orderIds) {

            JsonArray array = new JsonArray();
            for (int i = 0; i < orderIds.size(); i++) {
                array.add(orderIds.get(i));
            }
            jsonObject.add("orderIds", array);
            return this;
        }

        public Builder buildPayState(int payState) {
            jsonObject.addProperty("payState", payState);
            return this;
        }

//        public Builder buildTerminalNo() {
//            jsonObject.addProperty("terminalNo", StringUtil.getSN());
//            return this;
//        }

//        public Builder buildAppVersion() {
//            jsonObject.addProperty("appVersion", AppUtils.getAppVersionName());
//            return this;
//        }

        public Builder buildZoneId() {
            String zoneId = "";
//            if (CollectionUtils.isNotEmpty(LocalData.getInstance().getUserInfo().getZones())) {
//                int nowZonePosition = LocalData.getInstance().getNowZonePosition();
//                try {
//                    zoneId = LocalData.getInstance().getUserInfo().getZones().get(nowZonePosition)
//                            .getId();
//                } catch (Exception e) {
//                    zoneId = LocalData.getInstance().getUserInfo().getZones().get(0).getId();
//                }
//            }
//            jsonObject.addProperty("zoneId", zoneId);
            return this;
        }

//        public Builder buildRetrieverId() {
//            jsonObject.addProperty("retrieverId",
//                    LocalData.getInstance().getUserInfo().getOperator().getId());
//            return this;
//
//        }

        public Builder buildEvidencePhoto1(String evidencePhoto) {
            jsonObject.addProperty("evidencePhoto1", evidencePhoto);
            return this;
        }

        public Builder buildEvidencePhoto2(String evidencePhoto) {
            jsonObject.addProperty("evidencePhoto2", evidencePhoto);
            return this;
        }

        public Builder buildEvidencePhoto3(String evidencePhoto) {
            jsonObject.addProperty("evidencePhoto3", evidencePhoto);
            return this;
        }

        public Builder buildEvidencePhoto4(String evidencePhoto) {
            jsonObject.addProperty("evidencePhoto4", evidencePhoto);
            return this;
        }

        public Builder setMsgIds(List<String> msgIdList) {
            JsonArray array = new JsonArray();
            for (int i = 0; i < msgIdList.size(); i++) {
                array.add(msgIdList.get(i));
            }
            jsonObject.add("msgIds", array);
            return this;
        }

        public Builder setStatus(int msgStatusRead) {
            jsonObject.addProperty("status", msgStatusRead);
            return this;
        }

        public Builder buildPlateColor(String plateColorDesc) {
            jsonObject.addProperty("plateColor", plateColorDesc);
            return this;
        }

        public Builder buildNewPassword(String newPassword) {
            jsonObject.addProperty("newPassword", newPassword);
            return this;
        }

        public Builder buildTerminalType(int terminalType) {
            jsonObject.addProperty("terminalType", terminalType);
            return this;
        }

//        public Builder buildAppName() {
//            jsonObject.addProperty("appName", AppUtils.getAppName());
//            return this;
//
//        }

        public Builder buildExceptionName(String exceptionName) {
            jsonObject.addProperty("exceptionName", exceptionName);
            return this;
        }

        public Builder buildStackTraceInfo(String stackTraceInfo) {
            jsonObject.addProperty("stackTraceInfo", stackTraceInfo);
            return this;
        }

        public Builder buildOrderId(String orderId) {
            jsonObject.addProperty("orderId", orderId);
            return this;
        }

        public Builder buildSettleDate(String patrolTimeString) {
            if (!TextUtils.isEmpty(patrolTimeString)) {
                jsonObject.addProperty("settleDate", patrolTimeString);
            }
            return this;
        }

        public Builder buildEvPhoto(String evPhoto) {
            if (!TextUtils.isEmpty(evPhoto)) {
                jsonObject.addProperty("evPhoto", evPhoto);
            }
            return this;
        }

        public Builder buildRemark(String remark) {

            if (!TextUtils.isEmpty(remark)) {
                jsonObject.addProperty("remark", remark);
            }
            return this;
        }

        public Builder buildMsgIds(String msgId) {
            if (!TextUtils.isEmpty(msgId)) {
                JsonArray array = new JsonArray();
                array.add(msgId);
                jsonObject.add("msgIds", array);
            }
            return this;
        }

        public Builder buildRefundState(int i) {
            jsonObject.addProperty("refundState", i);

            return this;
        }

        public Builder buildEtcTransOrderNo(String etcTransOrderNo) {
            jsonObject.addProperty("etcTransOrderNo", etcTransOrderNo);
            return this;

        }

        public Builder buildIfAggregatePay() {
            int ifAggregatePay = 0;
//            if (SystemUtils.ifAggregationOpen()) {
//                ifAggregatePay = 1;
//            }

            jsonObject.addProperty("ifAggregatePay", ifAggregatePay);
            return this;

        }


        public Builder setLocationDesc(String locationDescribe) {
            jsonObject.addProperty("locationDesc", locationDescribe);
            return this;
        }

        public Builder buildLat(double latitude) {
            jsonObject.addProperty("lat", latitude + "");
            return this;
        }

        public Builder buildLng(double lng) {
            jsonObject.addProperty("lng", lng + "");
            return this;
        }

        public Builder buildCheckType(int i) {
            jsonObject.addProperty("checkType", i);
            return this;

        }

//        public Builder buildImei1() {
//
//            jsonObject.addProperty("imei1", StringUtil.getImei1());
//            return this;
//        }
//
//        public Builder buildImei2() {
//
//            jsonObject.addProperty("imei2", StringUtil.getImei2());
//            return this;
//        }
//
//        public Builder buildMeid() {
//
//            jsonObject.addProperty("meid", StringUtil.getMeid());
//            return this;
//        }
//
//        public Builder buildAndroidId() {
//
//            jsonObject.addProperty("androidId", StringUtil.getAndroidId());
//            return this;
//        }

        public Builder setPhotoUrl(String photoUrl) {
            jsonObject.addProperty("photoUrl", photoUrl);
            return this;
        }

        public Builder setMsgIds(String msgIds) {
            // JsonArray array = new JsonArray();
            // for (int i = 0; i < msgIds.length; i++) {
            // array.add(msgIds[i]);
            // }
            jsonObject.addProperty("msgId", msgIds);
            return this;
        }

        public Builder buildPollingInMins(int lastMins) {
            jsonObject.addProperty("lastMins", lastMins);
            return this;
        }




        public Builder measureType(int measureType) {
            jsonObject.addProperty("measureType", measureType);
            return this;
        }

        public Builder setCardType(int cardType) {
            jsonObject.addProperty("cardType", cardType);
            return this;
        }

        public Builder setSerialNo(String serialNo) {
            if (!TextUtils.isEmpty(serialNo)) {
                jsonObject.addProperty("serialNo", serialNo);
            }
            return this;
        }
    }

    // todo 统一看使用build还是set

}
