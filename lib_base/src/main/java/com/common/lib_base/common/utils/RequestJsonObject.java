package com.common.lib_base.common.utils;

import com.common.lib_base.common.ConS;
import com.google.gson.JsonObject;


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


        public JsonObject build() {
            return jsonObject;
        }


        public Builder buildEtpId() {
            jsonObject.addProperty("etp_id", ConS.ETP_ID);
            return this;
        }

        public Builder buildSecretKey() {
            jsonObject.addProperty("secret_key", ConS.SERCRET_KEY);
            return this;

        }

        public Builder buildSN(String sn) {
            jsonObject.addProperty("sn", sn);
            return this;
        }

        public Builder buildCompanyId() {

            jsonObject.addProperty("companyId", "66bc4852-40c0-4c7a-b2f9-0722846c2d21");
            return this;

        }


    }

}
