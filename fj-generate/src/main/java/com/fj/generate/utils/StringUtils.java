package com.fj.generate.utils;

import com.alibaba.fastjson.JSONObject;
import com.fj.common.utils.LoggerUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * annotation
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:53
 */
public class StringUtils {
    public StringUtils() {
    }

    public static <T> boolean isEmpty(T str) {
        return !notEmpty(str);
    }

    public static <T> boolean notEmpty(T str) {
        boolean result = false;
        if (null != str) {
            try {
                if (str instanceof List) {
                    List<Object> collection = new ArrayList();
                    collection.addAll((Collection)str);
                    if (null != collection && collection.size() > 0) {
                        result = true;
                    }
                } else if (str instanceof Set) {
                    Set<Object> collection = new HashSet();
                    collection.addAll((Collection)str);
                    if (null != collection && collection.size() > 0) {
                        result = true;
                    }
                } else if (str.getClass().isArray()) {
                    Integer length = Array.getLength(str);
                    if (length > 0) {
                        result = true;
                    }
                } else if (str instanceof Map) {
                    if (str instanceof JSONObject) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.putAll((JSONObject)str);
                        if (!jsonObject.isEmpty()) {
                            result = true;
                        }
                    } else {
                        Map<Object, Object> map = new HashMap();
                        map.putAll((HashMap)str);
                        if (!map.isEmpty()) {
                            result = true;
                        }
                    }
                } else if (null != str && str.toString().trim().length() > 0) {
                    result = true;
                }
            } catch (Exception var3) {
                LoggerUtil.printErr(var3.getMessage());
                var3.printStackTrace();
            }
        }

        return result;
    }

    public static String padLeft(String originStr, int length, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (notEmpty(originStr)) {
            stringBuilder.append(originStr);
        }

        stringBuilder = new StringBuilder(padRight(stringBuilder.reverse().toString(), length, str));
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "修恒";
        System.out.println(padLeft(str, 10, "0"));
        System.out.println(padRight(str, 10, "0"));
    }

    public static String padRight(String originStr, int length, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (notEmpty(originStr)) {
            stringBuilder.append(originStr);
        }

        while(stringBuilder.length() < length) {
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static List<String> strToList(String strArray, boolean noRepeat, String sort) {
        List<String> list = new ArrayList();
        if (null != strArray && !"".equals(strArray)) {
            ((List)list).addAll(Arrays.asList(strArray.split(",")));
            if (noRepeat) {
                list = (List)((List)list).stream().distinct().collect(Collectors.toList());
            }

            if (notEmpty(sort)) {
                switch (sort.toLowerCase()) {
                    case "asc":
                        Collections.sort((List)list);
                        break;
                    case "desc":
                        Collections.sort((List)list);
                        Collections.reverse((List)list);
                }
            }
        }

        return (List)list;
    }

    public static List<Integer> strToListWithInt(String strArray, boolean noRepeat, String sort) {
        List<Integer> list = new ArrayList();
        if (null != strArray && !"".equals(strArray)) {
            ((List)list).addAll((Collection)Arrays.asList(strArray.split(",")).stream().map((s) -> {
                return Integer.parseInt(s);
            }).collect(Collectors.toList()));
            if (noRepeat) {
                list = (List)((List)list).stream().distinct().collect(Collectors.toList());
            }

            if (notEmpty(sort)) {
                switch (sort.toLowerCase()) {
                    case "asc":
                        Collections.sort((List)list);
                        break;
                    case "desc":
                        Collections.sort((List)list);
                        Collections.reverse((List)list);
                }
            }
        }

        return (List)list;
    }

    public static String toHanYuPinYinWithTone(String word) {
        StringBuffer strBuffer = new StringBuffer();
        char[] cArray = word.toCharArray();
        char[] var3 = cArray;
        int var4 = cArray.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c);
            strBuffer.append(pinyin[0]);
        }

        return strBuffer.toString();
    }

    public static String toHanYuPinYin(String word) {
        return toHanYuPinYinWithTone(word).replaceAll("\\d", "");
    }

    public static String toHanYuPinYinWithInitial(String word) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = word.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination var6) {
                    var6.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }

        return pybf.toString().replaceAll("\\W", "").trim();
    }

    public static String toCamelName(String name, boolean isFirstUp) {
        if (name == null) {
            return null;
        } else {
            name = name.toLowerCase();
            if (!name.contains("_")) {
                return isFirstUp ? name.replace(String.valueOf(name.charAt(0)), String.valueOf(name.charAt(0)).toUpperCase()) : name;
            } else {
                StringBuilder sb = new StringBuilder(name.length());
                boolean upperCase = false;

                for(int i = 0; i < name.length(); ++i) {
                    char c = name.charAt(i);
                    if (c == '_') {
                        upperCase = true;
                    } else if (isFirstUp && i == 0) {
                        sb.append(Character.toUpperCase(c));
                        upperCase = false;
                    } else if (upperCase) {
                        sb.append(Character.toUpperCase(c));
                        upperCase = false;
                    } else {
                        sb.append(c);
                    }
                }

                return sb.toString();
            }
        }
    }
}
