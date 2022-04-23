package com.common.myapplication.bean;

/**
 * @author alexwu
 * package_name com.bt.RoadParking.model.entity
 * Created at 6/15/21  11:36 AM
 * Describe:
 */
public class EntityMsg {

    /**
     * id : 8e6c6d83-9faf-414b-90ff-fd57df360f96
     * personId : 93f88207-08d7-41ee-b56b-fa6133ed93dd
     * personName : 七仔
     * type : 2
     * title : 车辆离场
     * intro : 车牌:京A888888 车位:SK_002
     * content : 车主押金主动支付离场确认
     * objectId : PAK202106151114383097649
     * clickUrl : null
     * createDate : 1623726967215
     * status : 0
     * readDate : null
     * companyId : 07ba3508-e2d5-4659-be4a-758408f2250e
     * deleted : 0
     * msgPort : null
     * msgHost : null
     * operatorName : null
     * companyName : 联芯技术公司
     */

    private String id;
    private String personId;
    private String personName;
    private int type;
    private String title;
    private String intro;
    private String content;
    private String objectId;
    private Object clickUrl;
    private long createDate;
    private int status;
    private Object readDate;
    private String companyId;
    private int deleted;
    private Object msgPort;
    private Object msgHost;
    private Object operatorName;
    private String companyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Object getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(Object clickUrl) {
        this.clickUrl = clickUrl;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getReadDate() {
        return readDate;
    }

    public void setReadDate(Object readDate) {
        this.readDate = readDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Object getMsgPort() {
        return msgPort;
    }

    public void setMsgPort(Object msgPort) {
        this.msgPort = msgPort;
    }

    public Object getMsgHost() {
        return msgHost;
    }

    public void setMsgHost(Object msgHost) {
        this.msgHost = msgHost;
    }

    public Object getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(Object operatorName) {
        this.operatorName = operatorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
