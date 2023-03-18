package com.fj.generate.utils;

/**
 * <p>
 * 工具类使用说明
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 16:03
 */

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static final SimpleDateFormat SDF_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final SimpleDateFormat SDFNH_ = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat SDFNH = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat SDFSTAMP = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static final String ORACLETIMEWITH24_ = "'yyyy-mm-dd HH24:mi:ss'";
    public static final String ORACLETIMEWITH24 = "'yyyy/mm/dd HH24:mi:ss'";

    public DateUtil() {
    }

    public static String toString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return date == null ? "" : dateFormat.format(date);
    }

    public static Date getDate(String dateStr, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();

        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public static String getAgeByBirthday(Date birthday, Date nowDate) {
        String result = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        if (cal.getTime().compareTo(birthday) < 0) {
            result = "";
        } else {
            int yearNow = cal.get(1);
            int monthNow = cal.get(2) + 1;
            int dayOfMonthNow = cal.get(5);
            cal.setTime(birthday);
            int yearBirth = cal.get(1);
            int monthBirth = cal.get(2) + 1;
            int dayOfMonthBirth = cal.get(5);
            int yearInterval = Math.abs(yearNow - yearBirth);
            if (monthBirth > monthNow || monthBirth == monthNow && dayOfMonthBirth > dayOfMonthNow) {
                --yearInterval;
            }

            int monthInterval = Math.abs(monthNow - monthBirth);
            if (dayOfMonthBirth > dayOfMonthNow) {
                --monthInterval;
            }

            int dayInterval = Math.abs(dayOfMonthNow - dayOfMonthBirth);
            if (dayOfMonthBirth > dayOfMonthNow) {
                --dayInterval;
            }

            monthInterval %= 12;
            if (yearInterval >= 3) {
                result = yearInterval + " 岁";
            } else if (yearInterval >= 1) {
                if (monthInterval == 0) {
                    result = yearInterval + " 岁";
                } else {
                    result = yearInterval + " 岁 " + monthInterval + " 月 ";
                }
            } else if (monthInterval < 12 && monthInterval >= 1) {
                if (dayInterval == 0) {
                    result = monthInterval + " 月";
                } else {
                    result = monthInterval + " 月 " + dayInterval + " 天 ";
                }
            } else if (dayInterval <= 28 && dayInterval >= 3) {
                result = dayInterval + " 天 ";
            } else {
                result = dayInterval * 24 + " 小时 ";
            }
        }

        return result;
    }

    public static String getAgeByBirthdayOnlyNumber(Date birthday, Date nowDate) {
        Integer age = 1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int yearNow = cal.get(1);
        int monthNow = cal.get(2);
        int dayOfMonthNow = cal.get(5);
        cal.setTime(birthday);
        int yearBirth = cal.get(1);
        int monthBirth = cal.get(2);
        int dayOfMonthBirth = cal.get(5);
        age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age = age - 1;
                }
            } else {
                age = age - 1;
            }
        }

        if (age == 0) {
            age = age + 1;
        }

        return age.toString();
    }

    public static void main(String[] args) {
        String str = "2020/12/26 12:34:46";
        Date now = new Date();

        try {
            Date date1 = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse(str);
            System.out.println(getAgeByBirthdayOnlyNumber(date1, now));
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

    }

    public static String getAgeByBirthday(String birthdayStr, String nowDateStr) throws ParseException {
        birthdayStr = birthdayStr.replaceAll("-", "/");
        nowDateStr = nowDateStr.replaceAll("-", "/");
        Date birthday = SDFNH.parse(birthdayStr);
        Date nowDate = SDFNH.parse(nowDateStr);
        return getAgeByBirthday(birthday, nowDate);
    }

    public static String getCurrentTime(String format) {
        SimpleDateFormat sd = null;
        if (StringUtils.isEmpty(format)) {
            sd = SDF_;
        } else {
            sd = new SimpleDateFormat(format);
        }

        Date date = new Date();

        try {
            return sd.format(date);
        } catch (Exception var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public static Date getDayOfEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(10, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static Date getDayOfBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getMidnightDate(Date date) {
        return new Date(date.getTime() + 86400000L - 1L);
    }

    public static List<String> getBetweenDate(String beginDate, String endDate) {
        List<String> dateList = new ArrayList();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date begin = sdf.parse(beginDate);
            Date end = sdf.parse(endDate);
            if (begin.after(end)) {
                System.out.println(beginDate + "不能大于" + endDate);
                return dateList;
            }

            Calendar beginCalendar = GregorianCalendar.getInstance();
            beginCalendar.setTime(begin);
            Calendar endCalendar = GregorianCalendar.getInstance();
            endCalendar.setTime(end);
            int beginYear = beginCalendar.get(1);
            int beginMonth = beginCalendar.get(2) + 1;
            int beginDay = beginCalendar.get(5);
            int endYear = endCalendar.get(1);
            int endMonth = endCalendar.get(2) + 1;
            int endDay = endCalendar.get(5);

            for(int i = beginYear; i <= endYear; ++i) {
                int tempEndMonth = 12;
                int tempBeginMonth = 1;
                if (i == endYear) {
                    tempEndMonth = endMonth;
                }

                if (i == beginYear) {
                    tempBeginMonth = beginMonth;
                }

                for(int j = tempBeginMonth; j <= tempEndMonth; ++j) {
                    int tempDays = getDays(i, j);
                    int tempBeginDays = 1;
                    if (i == endYear && j == tempEndMonth) {
                        tempDays = endDay;
                    }

                    if (i == beginYear && j == tempBeginMonth) {
                        tempBeginDays = beginDay;
                    }

                    for(int k = tempBeginDays; k <= tempDays; ++k) {
                        dateList.add(i + "-" + (j < 10 ? "0" + j : j) + "-" + (k < 10 ? "0" + k : k));
                    }
                }
            }
        } catch (Exception var21) {
            dateList.clear();
            var21.printStackTrace();
        }

        return dateList;
    }

    public static boolean isRunNian(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int getDays(int year, int month) {
        if (month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12) {
            if (month == 2) {
                return isRunNian(year) ? 29 : 28;
            } else {
                return 30;
            }
        } else {
            return 31;
        }
    }

    public static boolean isWeekend(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;

        try {
            time = df.parse(date);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int day = cal.get(7);
        return day == 7 || day == 1;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(1);
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(2) + 1;
    }

    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(5);
    }

    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(11);
    }

    public static String addDay(String strDate, int days) {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(SDF.parse(strDate));
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        cal.add(5, days);
        return SDF.format(cal.getTime());
    }

    public static String addHour(String strDate, int hours) {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(SDF.parse(strDate));
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        cal.add(11, hours);
        return SDF.format(cal.getTime());
    }

    public static Date addMillisecond(Date date, int millisecond) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(14, millisecond);
        return cal.getTime();
    }

    public static long getDateDiff(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / 86400000L;
    }

    public static String getDateOfWeekMondy() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(7, 2);
        return SDFNH.format(calendar.getTime());
    }

    public static Map<String, List<String>> getAllWeekdays(Date indate, Date outdate) {
        Map<String, List<String>> resultMap = new HashMap();
        if (indate == null) {
            return resultMap;
        } else {
            if (outdate == null) {
                outdate = new Date();
            }

            List<String> dateList = getBetweenDate(SDF.format(indate), SDF.format(outdate));
            int index = 0;
            List<String> list = new ArrayList();
            Iterator var6 = dateList.iterator();

            while(true) {
                do {
                    do {
                        if (!var6.hasNext()) {
                            return resultMap;
                        }

                        String strdate = (String)var6.next();
                        ++index;
                        list.add(strdate);
                    } while(index <= 0);
                } while(index % 7 != 0 && index != dateList.size());

                if (list.size() != 7) {
                    String lastdate = (String)list.get(list.size() - 1);
                    int count = 0;
                    int size = list.size();

                    for(int i = size; i < 7; ++i) {
                        ++count;
                        list.add(addDay(lastdate, count));
                    }
                }

                resultMap.put((index % 7 == 0 ? index / 7 : index / 7 + 1) + "", list);
                list = new ArrayList();
            }
        }
    }

    public static Object[] getOneWeekDays(Date indate, Date outdate, Date date) {
        Object[] obj = new Object[2];
        List<String> tempList = new ArrayList();
        String week = "";
        Map<String, List<String>> resultMap = getAllWeekdays(indate, outdate);
        Iterator<Map.Entry<String, List<String>>> it = resultMap.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String, List<String>> entry = (Map.Entry)it.next();
            boolean flag = false;
            Iterator var10 = ((List)entry.getValue()).iterator();

            while(var10.hasNext()) {
                String strdate = (String)var10.next();
                if (strdate.equals(SDF.format(date))) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                week = (String)entry.getKey();
                tempList = (List)entry.getValue();
                break;
            }
        }

        obj[0] = week;
        obj[1] = tempList;
        return obj;
    }

    public static List<String> getOneWeekDaysForTwd(List<String> dateList) throws Exception {
        if (dateList != null && dateList.size() != 0) {
            List<String> resultList = new ArrayList();
            resultList.add(dateList.get(0));
            int size = dateList.size();

            for(int i = 0; i < size - 1; ++i) {
                compareDate((String)dateList.get(i), (String)dateList.get(i + 1), resultList);
            }

            return resultList;
        } else {
            return new ArrayList();
        }
    }

    private static void compareDate(String strdate1, String strdate2, List<String> dateList) throws Exception {
        Date date1 = SDF.parse(strdate1);
        Date date2 = SDF.parse(strdate2);
        int year1 = getYear(date1);
        int month1 = getMonth(date1);
        int year2 = getYear(date2);
        int month2 = getMonth(date2);
        if (year1 != year2) {
            dateList.add(SDF.format(date2));
        } else if (year1 == year2 && month1 != month2) {
            dateList.add((new SimpleDateFormat("MM-dd")).format(date2));
        } else if (year1 == year2 && month1 == month2) {
            dateList.add((new SimpleDateFormat("dd")).format(date2));
        }

    }

    public static Integer compareDate(String strDate1, String strDate2) {
        SimpleDateFormat sdf = SDF_;

        try {
            Date date1 = sdf.parse(strDate1);
            Date date2 = sdf.parse(strDate2);
            if (date1.getTime() == date2.getTime()) {
                return 0;
            } else {
                return date1.getTime() > date2.getTime() ? 1 : -1;
            }
        } catch (ParseException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static Integer compareDate(Date date1, Date date2) {
        SimpleDateFormat sdf = SDF_;

        try {
            if (date1.getTime() == date2.getTime()) {
                return 0;
            } else {
                return date1.getTime() > date2.getTime() ? 1 : -1;
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar nowGregorianCalendar = new GregorianCalendar();
            nowGregorianCalendar.setTime(date);

            try {
                XMLGregorianCalendar GregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowGregorianCalendar);
                return GregorianCalendar;
            } catch (DatatypeConfigurationException var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    public static Date toDate(XMLGregorianCalendar obj, String format) throws Exception {
        if (obj == null) {
            return null;
        } else {
            String str = obj.toString();
            String subStr = str.substring(0, 19);
            String dStr = subStr.replace("T", " ");
            Date date;
            if (StringUtils.isEmpty(format)) {
                date = SDF.parse(dStr);
            } else {
                date = (new SimpleDateFormat(format)).parse(dStr);
            }

            return date;
        }
    }
}
