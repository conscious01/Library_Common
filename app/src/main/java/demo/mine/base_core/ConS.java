package demo.mine.base_core;


/**
 * 本地Constants
 */
public class ConS {

    public static final boolean IF_DEBUG_CODE_MODE = false;// 是否测试代码
    public static final String HTTP_DOMAIN = "HTTP_DOMAIN";
    public static final String SERVER_URL = "http://iot.unioncore.vip";
    public static final String IF_NEED_BLUE_T_PR = "IF_NEED_BLUE_T_PR";// 用于设置是用蓝牙打印机打印的标志，是否一体机

    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;// 禁止HOME按键的码值

    public static final String IF_NEED_REM_PASS = "IF_NEED_REM_PASS";// 设置是否需要记住密码
    public static final String OPERATOR_ID = "OPERATOR_ID";// 用户的ID。
    public static final String OPERATOR_PASSWORD = "OPERATOR_PASSWORD";// 登录密码
    public static final String IF_NEED_WATER_MARK = "IF_NEED_WATER_MARK";// 是否需要水印背景
    public static final String IF_NEED_UPLOAD_EVIDENCE = "IF_NEED_UPLOAD_EVIDENCE";// 是否需要上传取证照片
    public static final String ADMIN_PASSWORD = "ADMIN_PASSWORD";
    public static final String USER_INFO = "USER_INFO";
    public static final String LOGIN_TIME_STAMP = "LOGIN_TIME_STAMP";
    public static final String IF_LOGGED = "IF_LOGGED";
    public static final String IF_PRINT_QR_CODE = "IF_PRINT_QR_CODE";// 是否打印出场二维码
    public static final String PRINT_GRAY = "PRINT_GRAY"; // 打印浓度
    public static final String IF_NEED_CAR_NUM_INPUT = "IF_NEED_CAR_NUM_INPUT";// 用于获取是否用车牌输入法
    public static final String IF_AUTO_RECOG = "IF_AUTO_RECOG";// 获取是否自动识别
    public static final String EXT_PLACE_NAME = "EXT_PLACE_NAME";// 车位名的KEY
    public static final String IF_ENABLE_VOICE = "IF_ENABLE_VOICE";// 否用语音播报
    public static final int RESPOND_OK = 200;
    public static final int CHECK_TYPE_START = 1;// 上班
    public static final int CHECK_TYPE_END = 2;// 下班
    public static final String EXT_SERIALZABLE = "EXT_SERIALZABLE";
    public static final String PLATE_NUMBER = "PLATE_NUMBER"; // 车牌号
    public static final int PAY_WAY_WECHAT = 2;
    public static final String REFRESH_PARK_PLACE = "REFRESH_PARK_PLACE";// 刷新车位信息
    public static final String ADAPTER_NOTIFY_DATA_CHANGED = "ADAPTER_NOTIFY_DATA_CHANGED";// 单纯调用adapter的notify方法

    public static final String METHOD_PAY_PLEDGE = "METHOD_PAY_PLEDGE";
    public static final String METHOD_CHECK_PLEDGE_RESULT = "METHOD_CHECK_PLEDGE_RESULT";
    public static final int PAY_STATE_SUCCESS = 1;
    public static final String CLOSE_PAGE = "CLOSE_PAGE";
    public static final String IF_OTHER_UI = "IF_OTHER_UI";

    public static final String SERVICE_MSG_CAR_IN = "placeCarIn";// 车辆入场，红色
    public static final String SERVICE_MSG_CAR_OUT = "placeCarOut";// 车辆离场，橙色
    public static final String SERVICE_MSG_CAR_EMPTY = "placeCarEmpty";// 车辆空场，绿色
    public static final String SERVICE_MSG_CAR_ERROR = "placeError";// 设备异常
    public static final String SERVICE_MSG_DIS_CONNECT = "disconnectActive";// 服务器关闭连接
    public static final String SERVICE_MSG_JUMP_2_DETAIL = "msgNotify";// 通知的，点击进入消息列表，根据消息的objectId请求列表，然后过滤出对应的消息

    public static final String SERVICE_MSG_CAR_IN_SUCCESS = "placeCarInSuc"; // 入场成功 地磁入场消息
    public static final String SERVICE_MSG_CAR_OUT_SUCCESS = "placeCarOutSuc"; // 出场成功

    public static final String SERVICE_MSG_REPORT_OPERATOR = "reportOperator";// 上报收费员信息
    public static final String SERVICE_MSG_HEAR_BEATER = "heartBeat";// 心跳
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MSG_STATUS_READ = 1;
    public static final int SEND_HEAT_BEAT_INTERVAL = 60;// 发送心跳间隔
    public static final String NOTIFY_DATE = "NOTIFY_DATE";// 通知时间
    public static final String LAST_PRINT_INFO = "LAST_PRINT_INFO";
    public static final String PLATE_COLOR_DESC = "PLATE_COLOR_DESC";
    public static final String THROWABLE_MESSAGE = "THROWABLE_MESSAGE";
    public static final String THROWABLE_STACK_TRACE = "THROWABLE_STACK_TRACE";
    public static final int DEFAULT_TERMINAL_TYPE = 1;
    public static final String METHOD_GET_MEMEBER_TYPE_PAID_AMOUNT =
            "METHOD_GET_MEMEBER_TYPE_PAID_AMOUNT";
    public static final String METHOD_GET_ORDER_FEE = "METHOD_GET_ORDER_FEE";
    public static final String METHOD_CHECK_ETC_PERMISSION = "METHOD_CHECK_ETC_PERMISSION";
    public static final String METHOD_REPORT_ETC_PAY_INFO = "METHOD_REPORT_ETC_PAY_INFO";

    public static final String CHOOSE_TYPE_NOTIFY_TIME = "CHOOSE_TYPE_NOTIFY_TIME";
    public static final String CHOOSE_TYPE_DEVICE_TIME = "CHOOSE_TYPE_DEVICE_TIME";
    public static final String METHOD_GET_PATROL = "METHOD_GET_PATROL";
    public static final String KEY_OBJECT_ID = "KEY_OBJECT_ID";
    public static final String DEVICE_TYPE = "DEVICE_TYPE";
    public static final String DEFAULT_DEVICE_TYPE = "A900"; // 默认设备型号
    public static final String DEVICE_950 = "A950";
    public static final String DEVICE_930 = "A930";// 商米
    public static final String DEVICE_980 = "A980";
    public static final String DEVICE_M700 = "M700"; // 金溢M700

    public static final String PRINT_TYPE_PARK_IN = "PRINT_TYPE_PARK_IN";
    public static final String PRINT_TYPE_PAYMENT_VOUCHER = "PRINT_TYPE_PAYMENT_VOUCHER";
    public static final String NOW_ZONE_POSITION = "NOW_ZONE_POSITION";
    public static final String PAY_TYPE_WECHAT = "微信";
    public static final String PAY_TYPE_ALI = "支付宝";
    public static final String IF_SUNMI_ETC = "IF_SUNMI_ETC";
    public static final String LAST_BLUE_TOOTH_DEVICE = "LAST_BLUE_TOOTH_DEVICE";
    public static final String CHECK_TYPE = "CHECK_TYPE";
    public static final int REQUEST_LOCATION_INTERVAL = 1800000;// 一个小时定位一次 3600000
    public static final String CLEAR_NOTI_INTERVAL_15_MINUTES = "15分钟";
    public static final String CLEAR_NOTI_INTERVAL_30_MINUTES = "30分钟";
    public static final String CLEAR_NOTI_INTERVAL_46_MINUTES = "46分钟";
    public static final String CLEAR_NOTI_INTERVAL_60_MINUTES = "60分钟";
    public static final String CLEAR_NOTI_INTERVAL_120_MINUTES = "120分钟";
    public static final String CLEAR_NOTI_INTERVAL = "CLEAR_NOTI_INTERVAL";
    public static final long NOTIFY_EXPIRED_MILLS = 1800000;// 默认30分钟 1800000 测试的时候使用10秒 10000
    public static final String IF_NEED_PLATE = "IF_NEED_PLATE";// 入场的页面是否需要识别车牌
    public static final int HEADER = 1;
    public static final int BODY = 2;
    public static final int FOOTER = 3;
    public static final int WARM_TIPS = 4;
    public static final int FEE_DESC = 5;
    public static final String REFRESH_INTERNET_TIME = "REFRESH_INTERNET_TIME";
    public static final String SERIAL_NO = "SERIAL_NO";
    public static final String IF_FROM_MAIN = "IF_FROM_MAIN";
    public static final String KEY_QUERY_TYPE = "KEY_QUERY_TYPE";
    public static final int LIST_ID_CARD = 1;
    public static final int LIST_TEMP = 2;


    public static int PHOTO_MAX_WIDTH = 400;

    public static int PHOTO_MAX_HEIGHT = 800;

    // 用于拍照保存的字节数组
    public static byte[] btPhotoBytes = null;


    public static final int RESULTCODE_OPEN_BLE = 0x20;
    public static final int RESULTCODE_CLOSE_BLE = 0x21;
    public static final int REQUESTCODE_OPEN_BLE = 0x22;

}
