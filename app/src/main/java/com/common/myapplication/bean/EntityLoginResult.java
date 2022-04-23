package com.common.myapplication.bean;

public class EntityLoginResult {

    /**
     * shanDonghealthCodeCfg : {"testMode":"y","sn":"006020210141002973","type":"hygk","ifTurnOn":"y","version":"1.0.0"}
     * guangDongHealthCodeCfg : {"appId":"6dd47c02aefa432aab7569239c8cc2e3","testMode":"y","appSecret":"7ea02712370b40d2bb2afd69c631d5af","type":"wode","domainPort":"159.75.19.97:8010","expiredTime":518400,"token":"991d383800ed4ba5997beffa1d773f47"}
     * appName : 联芯科技
     * healthCodeCfgGK : {"authCode":"eD24O94mISX2mSNIba8ce1rMYJtNr31p9l2Ji+Y+LRn3Onf2JLoI8QUNwv/5MVn8D2y9W9V8OJatThjBtTCEDHcH4IIoxcRI347kEGM9pX2B2Ip4/EQJZuDyAD+2UmTtLIb8A+HDfrk83uqXOMyasUQhrKWZAVgugY0jcj8zlzN34/kIg1zu2QcC+7lAZQbWp8+12ujDKMq3tpPcC4RdUSiPN+jLaqLELKZ2rNbuIpCkDiHuuSiUZMiIcae20","testMode":"y","sn":"10800928","type":"gk","mac":"e811ca0c1631"}
     * shangHaihealthCodeCfg : {"authCode":"eD24O94mISX2mSNIba8ce1rMYJtNr31p9l2Ji+Y+LRn3Onf2JLoI8QUNwv/5MVn8D2y9W9V8OJatThjBtTCEDHcH4IIoxcRI347kEGM9pX2B2Ip4/EQJZuDyAD+2UmTtLIb8A+HDfrk83uqXOMyasUQhrKWZAVgugY0jcj8zlzN34/kIg1zu2QcC+7lAZQbWp8+12ujDKMq3tpPcC4RdUSiPN+jLaqLELKZ2rNbuIpCkDiHuuSiUZMiIcae20","testMode":"y","sn":"10800928","type":"gk","mac":"e811ca0c1631"}
     * operator : {"id":"1d9ae4fd-4bd4-4787-ae24-61b6ab9c0ddf","companyId":"66bc4852-40c0-4c7a-b2f9-0722846c2d21","name":"陈工","password":"670B14728AD9902AECBA32E22FA4F6BD","linkPhone":"","lastActionDate":1649594627207,"lastAction":"手持机登录","lastTerminal":"006020210141002973","createDate":1648431611718,"updateDate":1649559794831,"creatorId":"FDD7A3EE-4CF2-11EA-99D2-000C296F1ED7","ifEnable":1,"ifVirtual":0,"deleted":0,"updatorId":"FDD7A3EE-4CF2-11EA-99D2-000C296F1ED7","msgPort":null,"msgHost":"","msgWebPort":null,"workNo":"0755","defaultCkpName":"测试点","defaultCkpId":"e3d1f954-f123-4352-85c1-ebd76326b68f","regAbility":"guokangma,yuekangma_sheninin"}
     * guoKangHealthCodeCfg : {"appId":"6dd47c02aefa432aab7569239c8cc2e3","testMode":"y","appSecret":"7ea02712370b40d2bb2afd69c631d5af","type":"wode","domainPort":"159.75.19.97:8010","expiredTime":518400,"token":"991d383800ed4ba5997beffa1d773f47"}
     */

    private ShanDonghealthCodeCfgBean shanDonghealthCodeCfg;
    private GuangDongHealthCodeCfgBean guangDongHealthCodeCfg;
    private String appName;
    private HealthCodeCfgGKBean healthCodeCfgGK;
    private ShangHaihealthCodeCfgBean shangHaihealthCodeCfg;
    private OperatorBean operator;
    private GuoKangHealthCodeCfgBean guoKangHealthCodeCfg;
    private NfcCfgBean nfcCfg;
    private JiangSuHealthCodeCfgBean jiangSuhealthCodeCfg;
    private String ifTurnTravelCard;

    public String getIfTurnTravelCard() {
        return ifTurnTravelCard;
    }

    public void setIfTurnTravelCard(String ifTurnTravelCard) {
        this.ifTurnTravelCard = ifTurnTravelCard;
    }

    public JiangSuHealthCodeCfgBean getJiangSuhealthCodeCfg() {
        return jiangSuhealthCodeCfg;
    }

    public void setJiangSuhealthCodeCfg(JiangSuHealthCodeCfgBean jiangSuhealthCodeCfg) {
        this.jiangSuhealthCodeCfg = jiangSuhealthCodeCfg;
    }

    public ShanDonghealthCodeCfgBean getShanDonghealthCodeCfg() {
        return shanDonghealthCodeCfg;
    }

    public void setShanDonghealthCodeCfg(ShanDonghealthCodeCfgBean shanDonghealthCodeCfg) {
        this.shanDonghealthCodeCfg = shanDonghealthCodeCfg;
    }

    public GuangDongHealthCodeCfgBean getGuangDongHealthCodeCfg() {
        return guangDongHealthCodeCfg;
    }

    public void setGuangDongHealthCodeCfg(GuangDongHealthCodeCfgBean guangDongHealthCodeCfg) {
        this.guangDongHealthCodeCfg = guangDongHealthCodeCfg;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public HealthCodeCfgGKBean getHealthCodeCfgGK() {
        return healthCodeCfgGK;
    }

    public void setHealthCodeCfgGK(HealthCodeCfgGKBean healthCodeCfgGK) {
        this.healthCodeCfgGK = healthCodeCfgGK;
    }

    public ShangHaihealthCodeCfgBean getShangHaihealthCodeCfg() {
        return shangHaihealthCodeCfg;
    }

    public void setShangHaihealthCodeCfg(ShangHaihealthCodeCfgBean shangHaihealthCodeCfg) {
        this.shangHaihealthCodeCfg = shangHaihealthCodeCfg;
    }

    public OperatorBean getOperator() {
        return operator;
    }

    public void setOperator(OperatorBean operator) {
        this.operator = operator;
    }

    public GuoKangHealthCodeCfgBean getGuoKangHealthCodeCfg() {
        return guoKangHealthCodeCfg;
    }

    public void setGuoKangHealthCodeCfg(GuoKangHealthCodeCfgBean guoKangHealthCodeCfg) {
        this.guoKangHealthCodeCfg = guoKangHealthCodeCfg;
    }

    public static class ShanDonghealthCodeCfgBean {
        /**
         * testMode : y
         * sn : 006020210141002973
         * type : hygk
         * ifTurnOn : y
         * version : 1.0.0
         */

        private String testMode;
        private String sn;
        private String type;
        private String ifTurnOn;
        private String version;

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIfTurnOn() {
            return ifTurnOn;
        }

        public void setIfTurnOn(String ifTurnOn) {
            this.ifTurnOn = ifTurnOn;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class GuangDongHealthCodeCfgBean {
        /**
         * appId : 6dd47c02aefa432aab7569239c8cc2e3
         * testMode : y
         * appSecret : 7ea02712370b40d2bb2afd69c631d5af
         * type : wode
         * domainPort : 159.75.19.97:8010
         * expiredTime : 518400
         * token : 991d383800ed4ba5997beffa1d773f47
         */

        private String appId;
        private String testMode;
        private String appSecret;
        private String type;
        private String domainPort;
        private int expiredTime;
        private String token;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDomainPort() {
            return domainPort;
        }

        public void setDomainPort(String domainPort) {
            this.domainPort = domainPort;
        }

        public int getExpiredTime() {
            return expiredTime;
        }

        public void setExpiredTime(int expiredTime) {
            this.expiredTime = expiredTime;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class HealthCodeCfgGKBean {
        /**
         * authCode : eD24O94mISX2mSNIba8ce1rMYJtNr31p9l2Ji+Y+LRn3Onf2JLoI8QUNwv/5MVn8D2y9W9V8OJatThjBtTCEDHcH4IIoxcRI347kEGM9pX2B2Ip4/EQJZuDyAD+2UmTtLIb8A+HDfrk83uqXOMyasUQhrKWZAVgugY0jcj8zlzN34/kIg1zu2QcC+7lAZQbWp8+12ujDKMq3tpPcC4RdUSiPN+jLaqLELKZ2rNbuIpCkDiHuuSiUZMiIcae20
         * testMode : y
         * sn : 10800928
         * type : gk
         * mac : e811ca0c1631
         */

        private String authCode;
        private String testMode;
        private String sn;
        private String type;
        private String mac;

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }
    }

    public static class ShangHaihealthCodeCfgBean {
        /**
         * authCode : eD24O94mISX2mSNIba8ce1rMYJtNr31p9l2Ji+Y+LRn3Onf2JLoI8QUNwv/5MVn8D2y9W9V8OJatThjBtTCEDHcH4IIoxcRI347kEGM9pX2B2Ip4/EQJZuDyAD+2UmTtLIb8A+HDfrk83uqXOMyasUQhrKWZAVgugY0jcj8zlzN34/kIg1zu2QcC+7lAZQbWp8+12ujDKMq3tpPcC4RdUSiPN+jLaqLELKZ2rNbuIpCkDiHuuSiUZMiIcae20
         * testMode : y
         * sn : 10800928
         * type : gk
         * mac : e811ca0c1631
         */

        private String authCode;
        private String testMode;
        private String sn;
        private String type;
        private String mac;

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }
    }

    public static class OperatorBean {
        /**
         * id : 1d9ae4fd-4bd4-4787-ae24-61b6ab9c0ddf
         * companyId : 66bc4852-40c0-4c7a-b2f9-0722846c2d21
         * name : 陈工
         * password : 670B14728AD9902AECBA32E22FA4F6BD
         * linkPhone :
         * lastActionDate : 1649594627207
         * lastAction : 手持机登录
         * lastTerminal : 006020210141002973
         * createDate : 1648431611718
         * updateDate : 1649559794831
         * creatorId : FDD7A3EE-4CF2-11EA-99D2-000C296F1ED7
         * ifEnable : 1
         * ifVirtual : 0
         * deleted : 0
         * updatorId : FDD7A3EE-4CF2-11EA-99D2-000C296F1ED7
         * msgPort : null
         * msgHost :
         * msgWebPort : null
         * workNo : 0755
         * defaultCkpName : 测试点
         * defaultCkpId : e3d1f954-f123-4352-85c1-ebd76326b68f
         * regAbility : guokangma,yuekangma_sheninin
         */

        private String id;
        private String companyId;
        private String name;
        private String password;
        private String linkPhone;
        private long lastActionDate;
        private String lastAction;
        private String lastTerminal;
        private long createDate;
        private long updateDate;
        private String creatorId;
        private int ifEnable;
        private int ifVirtual;
        private int deleted;
        private String updatorId;
        private Object msgPort;
        private String msgHost;
        private Object msgWebPort;
        private String workNo;
        private String defaultCkpName;
        private String defaultCkpId;
        private String regAbility;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLinkPhone() {
            return linkPhone;
        }

        public void setLinkPhone(String linkPhone) {
            this.linkPhone = linkPhone;
        }

        public long getLastActionDate() {
            return lastActionDate;
        }

        public void setLastActionDate(long lastActionDate) {
            this.lastActionDate = lastActionDate;
        }

        public String getLastAction() {
            return lastAction;
        }

        public void setLastAction(String lastAction) {
            this.lastAction = lastAction;
        }

        public String getLastTerminal() {
            return lastTerminal;
        }

        public void setLastTerminal(String lastTerminal) {
            this.lastTerminal = lastTerminal;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public String getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(String creatorId) {
            this.creatorId = creatorId;
        }

        public int getIfEnable() {
            return ifEnable;
        }

        public void setIfEnable(int ifEnable) {
            this.ifEnable = ifEnable;
        }

        public int getIfVirtual() {
            return ifVirtual;
        }

        public void setIfVirtual(int ifVirtual) {
            this.ifVirtual = ifVirtual;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public String getUpdatorId() {
            return updatorId;
        }

        public void setUpdatorId(String updatorId) {
            this.updatorId = updatorId;
        }

        public Object getMsgPort() {
            return msgPort;
        }

        public void setMsgPort(Object msgPort) {
            this.msgPort = msgPort;
        }

        public String getMsgHost() {
            return msgHost;
        }

        public void setMsgHost(String msgHost) {
            this.msgHost = msgHost;
        }

        public Object getMsgWebPort() {
            return msgWebPort;
        }

        public void setMsgWebPort(Object msgWebPort) {
            this.msgWebPort = msgWebPort;
        }

        public String getWorkNo() {
            return workNo;
        }

        public void setWorkNo(String workNo) {
            this.workNo = workNo;
        }

        public String getDefaultCkpName() {
            return defaultCkpName;
        }

        public void setDefaultCkpName(String defaultCkpName) {
            this.defaultCkpName = defaultCkpName;
        }

        public String getDefaultCkpId() {
            return defaultCkpId;
        }

        public void setDefaultCkpId(String defaultCkpId) {
            this.defaultCkpId = defaultCkpId;
        }

        public String getRegAbility() {
            return regAbility;
        }

        public void setRegAbility(String regAbility) {
            this.regAbility = regAbility;
        }
    }

    public NfcCfgBean getNfcCfg() {
        return nfcCfg;
    }

    public void setNfcCfg(NfcCfgBean nfcCfg) {
        this.nfcCfg = nfcCfg;
    }

    public static class NfcCfgBean {

        /**
         * nfcAppKey : d5aed29a2189
         * nfcAppSecret : 5f5053efd0f3
         */

        private String nfcAppKey;
        private String nfcAppSecret;

        public String getNfcAppKey() {
            return nfcAppKey;
        }

        public void setNfcAppKey(String nfcAppKey) {
            this.nfcAppKey = nfcAppKey;
        }

        public String getNfcAppSecret() {
            return nfcAppSecret;
        }

        public void setNfcAppSecret(String nfcAppSecret) {
            this.nfcAppSecret = nfcAppSecret;
        }
    }

    public static class JiangSuHealthCodeCfgBean {

        /**
         * testMode : y
         * sn : 006020210141002973
         * type : wode
         * token : 570BB28EA33AAA225361C78F731CCB6F
         */

        private String testMode;
        private String sn;
        private String type;
        private String token;

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }


    public static class GuoKangHealthCodeCfgBean {
        /**
         * appId : 6dd47c02aefa432aab7569239c8cc2e3
         * testMode : y
         * appSecret : 7ea02712370b40d2bb2afd69c631d5af
         * type : wode
         * domainPort : 159.75.19.97:8010
         * expiredTime : 518400
         * token : 991d383800ed4ba5997beffa1d773f47
         */

        private String appId;
        private String testMode;
        private String appSecret;
        private String type;
        private String domainPort;
        private int expiredTime;
        private String token;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getTestMode() {
            return testMode;
        }

        public void setTestMode(String testMode) {
            this.testMode = testMode;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDomainPort() {
            return domainPort;
        }

        public void setDomainPort(String domainPort) {
            this.domainPort = domainPort;
        }

        public int getExpiredTime() {
            return expiredTime;
        }

        public void setExpiredTime(int expiredTime) {
            this.expiredTime = expiredTime;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
