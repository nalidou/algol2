package com;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        String text = "生活の文化を笑颜であるし、何もない滞纳私たちは、常にする必要があるので苦い。感谢の気持ちでいっぱいの人生への対処、少なくとも、それは私たちの生活を与えている、生き残るために私たちを与えた。笑颜の金持ちと贫しい人々 の生活态度、状况が必ずしも位置ではありません。金持ちは常に心配でした、しかし贫しいを缓和することがあります: 障害楽観の穷状容易になります;、スムーズな难色を示す场合があります、人々 が笑颜... 人の感情的な环境、これはかなり普通ですが、苦い、1 组の kudachoushen 状况に直面し、変更がない、する生活の向上と、笑颜、他のメンバーに、话に前向き场合は逆に、机会の详细になります。Sun の现実を感じるように太阳の光の心臓部のみ] は、しばしば颜、苦しんでいる场合その生活より良いですか？ 人生は我々 のイメージによると、ミラーは泣く、泣く、私たちの生活と笑颜、笑颜で生活。笑颜、心が、どちらも弱いバカも强力にお世辞のであります。あなたの笑颜、お世辞で虚伪スマイル マスクが长く、ないだろうと、机会があるあれば、彼らを明らかに、以下のサイトを対象になります。目的の笑颜、それ、上司はガードのかどうかは、笑颜とは、笑颜他の点である、尊重の生活。笑颜を「复帰」は、関系は物理学力のバランス、何を言うよう他人ためには、他多く笑颜を扱います、他お客様の笑颜详细になります。他のユーザーによって歪められての怒りを选択することができます、笑颜を选択することもできます、笑颜は小さく、感じる开放的な方法で丑いは明らかに、他の心の冲撃されますので通常は笑颜の力をさらに大きなになります。清経、暗い云からであります。时々 あまり说明不要です。故意 vilify 人を知っていたは、人は彼は笑颜を与えたそれの残りの部分がそれを证明する时间だった。その时、どこでも、アインシュタインの理论が间违っていると 100 の科学者を目撃することだったのだ、アインシュタインと言うこのことは、ちょうど、笑颜のヒントを知って、多くに 100 人、私は本当にですか？ だけ间违って男前方に来た。アインシュタインの论者ビートに笑颜を明らかにしなかったが、时间のテストが行われました。笑颜の心、伪装することはできません。人生は良くなると、「笑颜」考え方をしてください。生活の中で挫折失败した误解に暮らすしたい场合は、まずすべての障害物の明确べきこと、全く正常です。笑颜は爱情、爱の本质であり、平凡なことがある必要があります。笑颜は最高のビジネス カードの生活と人は楽観的な人间の友达に话をしたくはないですか？ 笑颜を自信を持って、自分を与えることができますが、また他の人に向上につながる、自信を持って、动机付け潜在的な。笑颜はお友达との间の最高の言语、自発的な笑颜、冲撃は、最初のかどうか互いを知っている、长い时间、お互いの间の距离に笑颜他暖かい感じ。笑颜は达成であり、大きな成果、诚心诚意、笑颜の本质である奨励、暖かいです。本当に、常に简単な他より多くの成功を达成するためには、常に简単に笑颜を知っています。";
        System.out.println(LanguageUtils.countWordSmallLanguage(text));
        //int language = LanguageUtils.guessTextLanguage(text);
        //System.out.println(language);
        System.out.println("原文长度：" + text.length());
        getJpPair(text);

    }

    private static void getJpPair(String text) {
        text = text.replaceAll("[\\pP\\pS\\pZ]", "");
        text = text.replaceAll("\\d+", "");
        String patternJp = "[\\u3040-\\u309F\\u30A0-\\u30FF]";
        String patternCh = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]";
        String jpStr = "";
        String chStr = "";
        String unStr = "";
        char[] textArray = text.toCharArray();
        int jpLen = 0;
        int chLen = 0;
        int unknownLen = 0;
        int realLen = text.length();
        char[] arr$ = textArray;
        int len$ = textArray.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char c = arr$[i$];
            if (Pattern.matches(patternJp, String.valueOf(c))) {
                ++jpLen;
                jpStr += String.valueOf(c);
            } else if (Pattern.matches(patternCh, String.valueOf(c))) {
                ++chLen;
                chStr += String.valueOf(c);
            } else {
                ++unknownLen;
                unStr += String.valueOf(c);
            }
        }

        float un = (float)unknownLen / (float)realLen;
        float jp = (float)jpLen / (float)(jpLen + chLen);
        System.out.println("日文长度：" + jpLen);
        System.out.println("中文长度：" + chLen);
        System.out.println("未识别字符长度：" + unknownLen);
        System.out.println("实际长度：" + realLen);
        System.out.println("日文：" + jpStr);
        System.out.println("中文：" + chStr);
        System.out.println("未识别：" + unStr);


    }

}
