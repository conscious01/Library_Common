package com.common.myapplication.core;

import com.google.gson.JsonObject;


public class BaseJsonObject {

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



        public Builder buildSN(String sn) {
            jsonObject.addProperty("sn", sn);
            return this;
        }




    }

}
