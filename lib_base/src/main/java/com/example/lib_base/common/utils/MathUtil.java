package com.example.lib_base.common.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;


public class MathUtil {
    // 这个类不能实例化
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 格式化double类型，保留小数点后俩位。
     *
     * @param number
     * @return
     */
    public static String format(double number) {
        return String.format(Locale.CHINA, "%.02f", number);
    }

    /**
     * 格式化double类型，强制转换int。
     *
     * @param number
     * @return
     */
    public static String format1(double number) {
        return String.valueOf(new Double(number).intValue());
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 计算俩个string类型的数字之和
     *
     * @param v1
     * @param v2
     * @return 返回一个相加后保留后俩位小数点的字符串
     */
    public static String add(String v1, String v2) {

        double v1D;
        if (StringUtils.isEmpty(v1)) {
            v1D = 0.00;
        } else {
            v1D = Double.valueOf(v1);
        }
        double v2D;
        if (StringUtils.isEmpty(v2)) {
            v2D = 0.00;
        } else {
            v2D = Double.valueOf(v2);
        }

        return round(add(v1D, v2D), 2) + "";
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {

        BigDecimal bigDecimal = new BigDecimal(v1).divide(new BigDecimal(v2), scale, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    /**
     * 字符串类型转换double，然后由除法运算。当发生除不尽的情况时，保留小数点后俩位
     *
     * @param v1 字符串被除数
     * @param v2 字符串除数
     * @return 两个参数的商
     */
    public static String div(String v1, String v2) {
        if (v1 == null || v2 == null || v1.isEmpty() || v2.isEmpty()) {
            return "0.00";
        }
        return div(Double.valueOf(v1), Double.valueOf(v2), 2) + "";

    }

    /**
     * 字符串类型转换double，然后由除法运算。当发生除不尽的情况时，由scale参数指定精度，四舍五入
     *
     * @param v1    字符串被除数
     * @param v2    字符串除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double divide(String v1, String v2, int scale) {
        try {
            BigDecimal bd1 = new BigDecimal(v1);
            BigDecimal bd2 = new BigDecimal(v2);
            return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 字符串转换双精度，然后在进行相乘运算
     *
     * @param v1 字符串乘数
     * @param v2 字符串被乘数
     * @return 两个参数的积
     */
    public static double multiply(String v1, String v2) {
        try {
            BigDecimal bd1 = new BigDecimal(v1);
            BigDecimal bd2 = new BigDecimal(v2);
            return bd1.multiply(bd2).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 保留小数点后x位，不四舍五入，截取
     */
    public static String formatNumberFloor(double v, int pointCount) {
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(pointCount);
        formater.setGroupingSize(0);
        formater.setRoundingMode(RoundingMode.FLOOR);
        return formater.format(v);
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (v == 0.0 || v == 0) {
            return 0.00;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    /**
     * 生成一个 startNum到 endNum之间的（int）随机数
     *
     * @param startNum
     * @param endNum
     * @return
     */
    public static int getRandom(int startNum, int endNum) {
        if (endNum > startNum) {
            Random random = new Random();
            return random.nextInt(endNum - startNum) + startNum;
        }
        return 0;
    }


    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param doubleValue Double 类型参数
     * @param pointCounts 保留小数点位数
     * @return
     */
    public static String KeepDecimalPoint(Double doubleValue, int pointCounts) {
        if (doubleValue == null) {
            doubleValue = 0.0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.").append(pointCounts).append("f");
        return String.format(stringBuilder.toString(), doubleValue);
    }

    /**
     * 为int类型提供精确的小数位四舍五入处理。
     *
     * @param intValue    int 类型参数
     * @param pointCounts 保留小数点位数
     * @return
     */
    public static String KeepDecimalPoint(Integer intValue, int pointCounts) {
        if (intValue == null) {
            intValue = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.").append(pointCounts).append("f");
        return String.format(stringBuilder.toString(), Double.valueOf(String.valueOf(intValue)));
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param floatValue  float 类型参数
     * @param pointCounts 保留小数点位数
     * @return
     */
    public static String KeepDecimalPoint(Float floatValue, int pointCounts) {
        if (floatValue == null) {
            floatValue = Float.valueOf(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.").append(pointCounts).append("f");
        return String.format(stringBuilder.toString(), Double.valueOf(String.valueOf(floatValue)));
    }

    /**
     * 为Long类型提供精确的小数位四舍五入处理。
     *
     * @param longValue   long 类型参数
     * @param pointCounts 保留小数点位数
     * @return
     */
    public static String KeepDecimalPoint(Long longValue, int pointCounts) {
        if (longValue == null) {
            longValue = Long.valueOf(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.").append(pointCounts).append("f");
        return String.format(stringBuilder.toString(), Double.valueOf(String.valueOf(longValue)));
    }

    /**
     * 为String类型提供精确的小数位四舍五入处理。
     *
     * @param stringValue String 类型参数
     * @param pointCounts 保留小数点位数
     * @return
     */
    public static String KeepDecimalPoint(String stringValue, int pointCounts) {
        if (TextUtils.isEmpty(stringValue)) {
            stringValue = "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.").append(pointCounts).append("f");
        return String.format(stringBuilder.toString(), Double.valueOf(stringValue));
    }


    /**
     * @param doubleDiscount
     * @return 获取提问的折扣数字，9.0的话已经去掉 .0
     */
    public static String getDiscount(Double doubleDiscount) {
        double d1 = doubleDiscount * 10;
        String s1 = String.valueOf(d1);
        if (s1.endsWith(".0")) {
            return s1.substring(0, s1.length() - 2);
        }
        return s1;
    }


}
