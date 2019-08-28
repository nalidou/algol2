package com;

import atranslate.common.util.Language;
import insight.common.util.StringUtils;
import toolbox.collections.Pair;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 语言工具类
 *
 * @author liqiang
 * @MOD zhaoyh
 * @MOD wuzhy
 * @DATE 2019-07-08
 */
public class LanguageUtils extends insight.common.util.LanguageUtils {

    public static final int LANG_JP = 3;

    static final int[] CHN_DELIMITER = {'，', '。', '？', '：', '（', '）', '【', '】', '￥', '、', '·'};

    private static Set<Integer> chnDelimiters = new HashSet<Integer>();

    private static Set<String> smallLangSet = new HashSet<String>();
    private static Set<String> foreignLangSet = new HashSet<String>();
    private static Map<String, String> languageMap = new HashMap<String, String>();

    static {
        for (int e : CHN_DELIMITER) {
            chnDelimiters.add(e);
        }

        // 在这里增加语言方向
        smallLangSet.add(Language.AR.getLang());
        languageMap.put(Language.AR.getLang(), "阿");

        smallLangSet.add(Language.DE.getLang());
        languageMap.put(Language.DE.getLang(), "德");

        smallLangSet.add(Language.ES.getLang());
        languageMap.put(Language.ES.getLang(), "西");

        smallLangSet.add(Language.ES_ES.getLang());
        languageMap.put(Language.ES_ES.getLang(), "西");

        smallLangSet.add(Language.ES_LA.getLang());
        languageMap.put(Language.ES_LA.getLang(), "拉美西");

        smallLangSet.add(Language.FR.getLang());
        languageMap.put(Language.FR.getLang(), "法");

        smallLangSet.add(Language.IT.getLang());
        languageMap.put(Language.IT.getLang(), "意");

        smallLangSet.add(Language.JP.getLang());
        languageMap.put(Language.JP.getLang(), "日");

        smallLangSet.add(Language.KR.getLang());
        languageMap.put(Language.KR.getLang(), "韩");

        smallLangSet.add(Language.PT.getLang());
        languageMap.put(Language.PT.getLang(), "葡");

        smallLangSet.add(Language.PT_BR.getLang());
        languageMap.put(Language.PT_BR.getLang(), "巴葡");

        smallLangSet.add(Language.PT_PT.getLang());
        languageMap.put(Language.PT_PT.getLang(), "葡");

        smallLangSet.add(Language.RU.getLang());
        languageMap.put(Language.RU.getLang(), "俄");

        smallLangSet.add(Language.TH.getLang());
        languageMap.put(Language.TH.getLang(), "泰");

        smallLangSet.add(Language.VN.getLang());
        languageMap.put(Language.VN.getLang(), "越");

        smallLangSet.add(Language.IN.getLang());
        languageMap.put(Language.IN.getLang(), "印地");

        smallLangSet.add(Language.ID.getLang());
        languageMap.put(Language.ID.getLang(), "印尼");

        smallLangSet.add(Language.NL.getLang());
        languageMap.put(Language.NL.getLang(), "荷");

        smallLangSet.add(Language.TR.getLang());
        languageMap.put(Language.TR.getLang(), "土");

        smallLangSet.add(Language.EL.getLang());
        languageMap.put(Language.EL.getLang(), "希腊");

        smallLangSet.add(Language.BS.getLang());
        languageMap.put(Language.BS.getLang(), "波斯");

        smallLangSet.add(Language.MS.getLang());
        languageMap.put(Language.MS.getLang(), "马来");

        smallLangSet.add(Language.LAO.getLang());
        languageMap.put(Language.LAO.getLang(), "老挝");

        smallLangSet.add(Language.PL.getLang());
        languageMap.put(Language.PL.getLang(), "波兰");

        smallLangSet.add(Language.CS.getLang());
        languageMap.put(Language.CS.getLang(), "捷克");

        // 下面不用改
        foreignLangSet.addAll(smallLangSet);
        foreignLangSet.add(Language.EN.getLang());

        languageMap.put(Language.EN.getLang(), "英");
        languageMap.put(Language.ZH.getLang(), "中");
    }

    /**
     * 显示语言方向
     * @return
     */
    public static String getLangInChinese(String lang) {
        if (languageMap.containsKey(lang)) {
            return languageMap.get(lang);
        }
        return "";
    }

    /**
     * 是否是小语种
     * @param lang
     * @returnx
     */
    public static boolean isSmallLanguage(String lang) {
        return smallLangSet.contains(lang);
    }

    /**
     * 是否是外语
     * 小语种+英语
     * @param lang
     * @return
     */
    public static boolean isForeignLanguage(String lang) {
        return foreignLangSet.contains(lang);
    }

    /**
     * 中外互译
     * @param srcLang
     * @param desLang
     * @return
     */
    public static boolean isZhAndForeignLanguage(String srcLang, String desLang) {
        if (srcLang.equals(desLang)) {
            return false;
        }
        String zh = Language.ZH.getLang();
        if ((srcLang.equals(zh) && isForeignLanguage(desLang)) || (desLang.equals(zh) && isForeignLanguage(srcLang))) {
            return true;
        }
        return false;
    }

    /**
     * 中／小语种互译订单
     * @return
     */
    public static boolean isZhAndSmallLanguageOrder(String srcLang, String desLang) {
        if (srcLang.equals(desLang)) {
            return false;
        }
        String zh = Language.ZH.getLang();
        if ((srcLang.equals(zh) && isSmallLanguage(desLang)) || (desLang.equals(zh) && isSmallLanguage(srcLang))) {
            return true;
        }
        return false;
    }

    /**
     * 中英订单
     * @param srcLang
     * @param desLang
     * @return
     */
    public static boolean isZhAndEnLanguageOrder(String srcLang, String desLang) {
        if (srcLang.equals(desLang)) {
            return false;
        }
        String zh = Language.ZH.getLang();
        String en = Language.EN.getLang();
        if ((srcLang.equals(zh) && desLang.equals(en)) || (srcLang.equals(en) && desLang.equals(zh))) {
            return true;
        }
        return false;
    }

    /**
     * 英／小语种互译
     * @param srcLang
     * @param desLang
     * @return
     */
    public static boolean isEnAndSmallLanguageOrder(String srcLang, String desLang) {
        if (srcLang.equals(desLang)) {
            return false;
        }
        String en = Language.EN.getLang();
        if ((srcLang.equals(en) && isSmallLanguage(desLang)) || (desLang.equals(en) && isSmallLanguage(srcLang))) {
            return true;
        }
        return false;
    }

    private static boolean isCJKChar(char c) {
        // 除去全角空格,属于CJK_SYMBOLS_AND_PUNCTUATION, 但算字数不应统计进去
        if (isFullWidthSpace(c)) {
            return false;
        }
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub.equals(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
                || ub.equals(Character.UnicodeBlock.CJK_COMPATIBILITY)
                || ub.equals(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT)
                || ub.equals(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS)
                || ub.equals(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS)
                || ub.equals(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT)
                || ub.equals(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION)
                || ub.equals(Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS)
                || ub.equals(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A)
                //|| ub.equals(Character.UnicodeBlock.GENERAL_PUNCTUATION)
                || ub.equals(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)
                || ub.equals(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B)
                // japanese
                || ub.equals(Character.UnicodeBlock.HIRAGANA)
                || ub.equals(Character.UnicodeBlock.KATAKANA) || ub.equals(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS)
                || (c >= 0xFF65 && c <= 0xFF9F)
                // korean
                || ub.equals(Character.UnicodeBlock.HANGUL_SYLLABLES)
                || ub.equals(Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO)
                || ub.equals(Character.UnicodeBlock.HANGUL_JAMO)
                || (c >= 0xFFA0 && c <= 0xFFDC)) {
            return true;
        }
        return false;
    }

    /**
     * 全角空格
     * @param c
     * @return
     */
    private static boolean isFullWidthSpace(char c) {
        return c == 0x3000;
    }

    public static boolean isChnDelimiter(char c) {
        return chnDelimiters.contains(Integer.valueOf(c));
    }

    /**
     * 只由可读文字组成, 不包含标点空格等
     * @param text
     * @return
     */
    public static boolean isReadableCharOnly(String text) {
        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);
            if (isSpace(c) || isDelimiter(c)) {
                return false;
            } else if (isEnglishAlphabet(c)) {
                // do nothing
            } else if (isArabicDigits(c)) {
                // do nothing
            } else if (isChineseChar(c)) {
                // do nothing
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * count words like Office Word
     * 统计小语种的字数
     * @param text
     * @return
     */
    public static int countWordSmallLanguage(String text) {
        if (StringUtils.isBlank(text)){
            return 0;
        }
        String[] cells = text.trim().split("\\s+");
        if (cells.length == 0) {
            return 0;
        }
        int wordCount = 0;
        for (String cell : cells) {
            boolean isLatinWord = false;
            for (int i = 0; i < cell.length(); i++) {
                char c = cell.charAt(i);
                if (isCJKChar(c)) {
                    if (isLatinWord) {
                        // 一个拉丁词的结束
                        wordCount++;
                        isLatinWord = false;
                    }
                    wordCount++;
                } else {
                    isLatinWord = true;
                    if (i == cell.length() - 1) {
                        wordCount++;
                    }
                }

            }
        }
        return wordCount;
    }

    /**
     * zh-en 时候统计的是字符
     * @param text
     * @return
     */
    public static int countChar(String text) {
        int ch = 0;
        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);
            if (isSpace(c)) {
            } else {
                ch++;
            }
        }
        return ch;
    }

    /**
     * 文档订单字数统计，去掉了长词判断，增加了标点统计。标点统计规则：
     * 1. 中文标点在任何情况下都统计
     * 2. 英文标点与英文或者数字相邻不统计，如e-mail, 32.1, 23@qq.com 都属于1个字数
     * 3. 连续出现一串的英文标点算一个字数，如-----------， ********
     * @param text
     * @return
     */
    public static int countFileOrderWord(String text) {
        List<String> englishList = new ArrayList<String>();
        List<String> numberList = new ArrayList<String>();

        int chineseChar = 0;
        int unknown = 0;
        int delimiter = 0;
        int start = 0;

        // 找到英文单词的开头
        boolean startEn = false;
        // 找到数字的开头
        boolean startNum = false;
        // 记录上一个字符是否是space
        boolean before = true;
        // 记录是否由于-12， -help 这种情况多统计了字符数
        boolean startEnDeli = false;
        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);
            // 找到英文单词的结尾
            boolean endOfEn = false;
            // 找到数字的结尾
            boolean endOfNum = false;
            if (isSpace(c)) {
                endOfEn = endOfNum = true;
                before = true;
                startEnDeli = false;
            } else if (isDelimiter(c)) {
                if (isChnDelimiter(c)) {
                    delimiter++;
                    before = true;
                    startEnDeli = false;
                } else if (!startEn && !startNum && before) {
                    delimiter++;
                    startEnDeli = true;
                    before = false;
                }
            } else if (isEnglishAlphabet(c)) {
                if (!startEn && !startNum) {
                    startEn = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isArabicDigits(c)) {
                if (!startNum && !startEn) {
                    startNum = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isChineseChar(c)) {
                endOfEn = endOfNum = true;
                chineseChar++;
                before = true;
                startEnDeli = false;
            } else {
                endOfEn = endOfNum = true;
                unknown++;
                before = true;
                startEnDeli = false;
            }
            // 找到结尾
            if ((startEn && (endOfEn || i == l - 1))
                    || (startNum && (endOfNum || i == l - 1))) {

                int end = i;
                if (end == l - 1) {
                    end = i + 1;
                }
                String word = text.substring(start, end);

                if (startEn) {
                    englishList.add(word);
                } else if (startNum) {
                    numberList.add(word);
                }

                // 如果这个结尾是英文/数字
                if (startEn || startNum) {
                    start = i;
                }
                startEn = false;
                startNum = false;
            }
            // 如果这个结尾不是英文/数字
            if (endOfEn && endOfNum) {
                start = i + 1;

                startEn = false;
                startNum = false;
            }
        }
        int number = numberList.size();
        int englishWord = englishList.size();
        int realLength = englishWord + chineseChar;
        int knownLength = realLength + number;

        // 特殊情况, 中文英文都没有
        if (realLength == 0) {
            knownLength = number;
        }
        int costLength = knownLength + unknown;
        return costLength + delimiter;
    }

    /**
     * 判断文档订单的语言和字数
     * @param text
     * @return
     */
    public static Pair<Integer, Integer> guessFileOrderLanguage(String text) {
        List<String> englishList = new ArrayList<String>();
        List<String> numberList = new ArrayList<String>();
        int chineseChar = 0;
        int unknown = 0;
        int delimiter = 0;
        int start = 0;

        // 找到英文单词的开头
        boolean startEn = false;

        // 找到数字的开头
        boolean startNum = false;

        // 记录上一个字符是否是space
        boolean before = true;

        // 记录是否由于-12， -help 这种情况多统计了字符数
        boolean startEnDeli = false;

        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);

            // 找到英文单词的结尾
            boolean endOfEn = false;

            // 找到数字的结尾
            boolean endOfNum = false;
            if (isSpace(c)) {
                endOfEn = endOfNum = true;
                before = true;
                startEnDeli = false;

            } else if (isDelimiter(c)) {
                //endOfEn = endOfNum = true;
                if (isChnDelimiter(c)) {
                    delimiter++;
                    before = true;
                    startEnDeli = false;
                } else if (!startEn && !startNum && before) {
                    delimiter++;
                    startEnDeli = true;
                    before = false;
                }
            } else if (isEnglishAlphabet(c)) {
                if (!startEn && !startNum) {
                    startEn = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isArabicDigits(c)) {
                if (!startNum && !startEn) {
                    startNum = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isChineseChar(c)) {
                endOfEn = endOfNum = true;
                chineseChar++;
                before = true;
                startEnDeli = false;
            } else {
                endOfEn = endOfNum = true;
                unknown++;
                before = true;
                startEnDeli = false;
            }
            // 找到结尾
            if ((startEn && (endOfEn || i == l - 1))
                    || (startNum && (endOfNum || i == l - 1))) {

                int end = i;
                if (end == l - 1) {
                    end = i + 1;
                }
                String word = text.substring(start, end);

                if (startEn) {
                    englishList.add(word);
                } else if (startNum) {
                    numberList.add(word);
                }
                // 如果这个结尾是英文/数字
                if (startEn || startNum) {
                    start = i;
                }
                startEn = false;
                startNum = false;
            }
            // 如果这个结尾不是英文/数字
            if (endOfEn && endOfNum) {
                start = i + 1;
                startEn = false;
                startNum = false;
            }
        }
        int number = numberList.size();
        int englishWord = englishList.size();
        int realLength = englishWord + chineseChar;
        int knownLength = realLength + number;

        // 特殊情况, 中文英文都没有
        if (realLength == 0) {
            englishWord = number;
            realLength = number;
            knownLength = number;
        }
        int costLength = knownLength + unknown;
        float un = (float) unknown / costLength;
        if (un >= 0.4F) {
            return new Pair<Integer, Integer>(LANG_UNKNOWN, 0);
        }
        float en = (float) englishWord / realLength;
        if (en >= 0.7F) {
            return new Pair<Integer, Integer>(LANG_EN, costLength + delimiter);
        }
        float cn = (float) chineseChar / realLength;
        if (cn >= 0.7F) {
            return new Pair<Integer, Integer>(LANG_CN, costLength + delimiter);
        }
        return new Pair<Integer, Integer>(LANG_UNKNOWN, 0);
    }

    /**
     * 判断快速订单的语言和字数
     * @param text
     * @return
     */
    public static Pair<Integer, Integer> guessFastOrderLanguage(String text) {
        Pair<Integer, Integer> jpPair = getJpPair(text);
        if (jpPair != null) {
            return jpPair;
        } else {
            int guessLang = guessTextLanguage(text);
            return guessFastOrderLanguageAndWord(text, guessLang);
        }
    }

    /**
     * 判断快速订单的语言和字数
     * @param text
     * @param guessLang
     * @return
     */
    private static Pair<Integer, Integer> guessFastOrderLanguageAndWord(String text, int guessLang) {
        // 英文
        if (guessLang == 1) {
            // 所有的标点符号 替换为空格
            text = text.replaceAll("[\\pP\\pS\\pZ]", " ");

            // 所有数字 替换为空格
            text = text.replaceAll("\\d+", " ");
        }

        // 中文
        if (guessLang == 2) {
            // 去掉所有的标点符号
            text = text.replaceAll("[\\pP\\pS\\pZ]", "");

            // 去掉所有数字
            text = text.replaceAll("\\d+", "");
        }

        return guessFastOrderLanguageAndWord(text);
    }

    /**
     * 判断字符串的语言和字数
     * @param text
     * @return
     */
    private static Pair<Integer, Integer> guessFastOrderLanguageAndWord(String text) {
        List<String> englishList = new ArrayList<String>();
        List<String> numberList = new ArrayList<String>();

        int chineseChar = 0;
        int unknown = 0;
        int delimiter = 0;
        int start = 0;

        // 找到英文单词的开头
        boolean startEn = false;

        // 找到数字的开头
        boolean startNum = false;

        // 记录上一个字符是否是space
        boolean before = true;

        // 记录是否由于-12， -help 这种情况多统计了字符数
        boolean startEnDeli = false;

        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);

            // 找到英文单词的结尾
            boolean endOfEn = false;

            // 找到数字的结尾
            boolean endOfNum = false;

            if (isSpace(c)) {
                // 是否是空格
                endOfEn = endOfNum = true;
                before = true;
                startEnDeli = false;
            } else if (isDelimiter(c)) {
                // 是否是分隔符
                if (isChnDelimiter(c)) {
                    // 中文分隔符
                    delimiter++;
                    before = true;
                    startEnDeli = false;
                } else if (!startEn && !startNum && before) {
                    delimiter++;
                    startEnDeli = true;
                    before = false;
                }
            } else if (isEnglishAlphabet(c)) {
                // 英文字母
                if (!startEn && !startNum) {
                    startEn = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isArabicDigits(c)) {
                // 阿拉伯数字
                if (!startNum && !startEn) {
                    startNum = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                    delimiter--;
                }
            } else if (isChineseChar(c)) {
                endOfEn = endOfNum = true;
                chineseChar++;
                before = true;
                startEnDeli = false;
            } else {
                endOfEn = endOfNum = true;
                unknown++;
                before = true;
                startEnDeli = false;
            }
            // 找到结尾
            if ((startEn && (endOfEn || i == l - 1))
                    || (startNum && (endOfNum || i == l - 1))) {

                int end = i;
                if (end == l - 1) {
                    end = i + 1;
                }

                String word = text.substring(start, end);

                if (startEn) {
                    englishList.add(word);
                } else if (startNum) {
                    numberList.add(word);
                }
                // 如果这个结尾是英文/数字
                if (startEn || startNum) {
                    start = i;
                }
                startEn = false;
                startNum = false;
            }
            // 如果这个结尾不是英文/数字
            if (endOfEn && endOfNum) {
                start = i + 1;
                startEn = false;
                startNum = false;
            }
        }

        int number = numberList.size();
        int englishWord = englishList.size();
        int realLength = englishWord + chineseChar;
        int knownLength = realLength + number;

        // 特殊情况, 中文英文都没有
        if (realLength == 0) {
            englishWord = number;
            realLength = number;
            knownLength = number;
        }
        int costLength = knownLength + unknown;
        float un = (float) unknown / costLength;
        if (un >= 0.4F) {
            return new Pair<Integer, Integer>(LANG_UNKNOWN, 0);
        }
        float en = (float) englishWord / realLength;
        if (en >= 0.7F) {
            return new Pair<Integer, Integer>(LANG_EN, costLength + delimiter);
        }
        float cn = (float) chineseChar / realLength;
        if (cn >= 0.7F) {
            return new Pair<Integer, Integer>(LANG_CN, costLength + delimiter);
        }
        return new Pair<Integer, Integer>(LANG_UNKNOWN, 0);
    }

    /**
     * 判断字符串的语言
     * 0: unknown
     * 1: en
     * 2: zh
     * @param text
     * @return
     */
    public static int guessTextLanguage(String text) {
        List<String> englishList = new ArrayList<String>();
        List<String> numberList = new ArrayList<String>();

        int chineseChar = 0;
        int unknown = 0;
        int start = 0;

        // 找到英文单词的开头
        boolean startEn = false;

        // 找到数字的开头
        boolean startNum = false;

        // 记录上一个字符是否是space
        boolean before = true;

        // 记录是否由于-12， -help 这种情况多统计了字符数
        boolean startEnDeli = false;

        for (int i = 0, l = text.length(); i < l; i++) {
            char c = text.charAt(i);

            // 找到英文单词的结尾
            boolean endOfEn = false;

            // 找到数字的结尾
            boolean endOfNum = false;

            if (isSpace(c)) {
                // 是否是空格
                endOfEn = endOfNum = true;
                before = true;
                startEnDeli = false;
            } else if (isDelimiter(c)) {
                // 是否是分隔符
                if (isChnDelimiter(c)) {
                    // 中文分隔符
                    before = true;
                    startEnDeli = false;
                } else if (!startEn && !startNum && before) {
                    startEnDeli = true;
                    before = false;
                }
            } else if (isEnglishAlphabet(c)) {
                // 英文字母
                if (!startEn && !startNum) {
                    startEn = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                }
            } else if (isArabicDigits(c)) {
                // 阿拉伯数字
                if (!startNum && !startEn) {
                    startNum = true;
                }
                before = false;
                if (startEnDeli) {
                    startEnDeli = false;
                }
            } else if (isChineseChar(c)) {
                endOfEn = endOfNum = true;
                chineseChar++;
                before = true;
                startEnDeli = false;
            } else {
                endOfEn = endOfNum = true;
                unknown++;
                before = true;
                startEnDeli = false;
            }
            // 找到结尾
            if ((startEn && (endOfEn || i == l - 1))
                    || (startNum && (endOfNum || i == l - 1))) {

                int end = i;
                if (end == l - 1) {
                    end = i + 1;
                }

                String word = text.substring(start, end);

                if (startEn) {
                    englishList.add(word);
                } else if (startNum) {
                    numberList.add(word);
                }
                // 如果这个结尾是英文/数字
                if (startEn || startNum) {
                    start = i;
                }
                startEn = false;
                startNum = false;
            }
            // 如果这个结尾不是英文/数字
            if (endOfEn && endOfNum) {
                start = i + 1;
                startEn = false;
                startNum = false;
            }
        }

        int number = numberList.size();
        int englishWord = englishList.size();
        int realLength = englishWord + chineseChar;
        int knownLength = realLength + number;

        // 特殊情况, 中文英文都没有
        if (realLength == 0) {
            englishWord = number;
            realLength = number;
            knownLength = number;
        }

        int costLength = knownLength + unknown;

        float un = (float) unknown / costLength;

        if (un >= 0.4F) {
            return LANG_UNKNOWN;
        }

        float en = (float) englishWord / realLength;
        if (en >= 0.7F) {
            return LANG_EN;
        }

        float cn = (float) chineseChar / realLength;
        if (cn >= 0.7F) {
            return LANG_CN;
        }

        return LANG_UNKNOWN;
    }

    /**
     * 判定文本是否是日文，是的话返回字数，否则返回null
     * 3：jp
     * @param text
     * @return
     */
    private static Pair<Integer, Integer> getJpPair(String text) {
        text = text.replaceAll("[\\pP\\pS\\pZ]", "");
        text = text.replaceAll("\\d+", "");

        String patternJp = "[\\u3040-\\u309F\\u30A0-\\u30FF]";
        String patternCh = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]";

        char [] textArray = text.toCharArray();
        int jpLen = 0;
        int chLen = 0;
        int unknownLen = 0;
        int realLen = textArray.length;

        for (char c : textArray) {
            if (Pattern.matches(patternJp, String.valueOf(c))) {
                jpLen++;
            } else if (Pattern.matches(patternCh, String.valueOf(c))) {
                chLen++;
            } else {
                unknownLen++;
            }
        }

        float un = (float)unknownLen / realLen;
        float jp = (float)jpLen / (jpLen + chLen);
        if (textArray.length <= 10) {
            return new Pair<Integer, Integer>(3, textArray.length);
        }
        else if (jp >= 0.3F) {
            return new Pair<Integer, Integer>(3, realLen);
        }
        return null;
    }

}
