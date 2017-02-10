package com.sinsz.netty.server;

import java.util.*;

/**
 * Created by chenjianbo on 2017/1/24.
 */
public class Test {

    public String GetInvitationCode()

    {

        //自定义进制，长度为34。  0和1与o和l容易混淆，不包含在进制中。

        char[] r = new char[]{'Q', 'w', 'E', '8', 'a', 'S', '2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3', 'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b', 'g', 'H'};

        char[] b = new char[]{'q', 'W', 'e', '5', 'A', 's', '3', 'D', 'z', 'X', '8', 'C', '2', 'P', 'o', '4', 'I', 'k', '9', 'M', 'J', 'u', 'F', 'R', '6', 'v', 'Y', 'T', 'n', '7', 'B', 'G', 'h'};

        char[] buf = new char[33];

        int s = 6;//生成六位的邀请码

        int binLen = r.length;

        int charPos = 33;

        //以当前的毫秒数作为标准

        int id = new Date().getMinutes();

        while (id / binLen > 0)

        {

            int k = (int) (id % binLen);

            buf[--charPos] = r[k];

            id /= binLen;

        }

        buf[--charPos] = r[(int) (id % binLen)];

        String str = new String(buf, charPos, (33 - charPos));

        //长度不够6位时自动随机补全

        if (str.length() < s)

        {

            StringBuilder sb = new StringBuilder();

            Random rd = new Random();

            for (int i = 1; i <= s - str.length(); i++)

            {

                sb.append(b[rd.nextInt(33)]);

            }

            str += sb.toString();

        }

        return str.toUpperCase();

    }

    public static void main(String[] args) {
        try {
            System.out.println("===============");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 100000; i++) {
                String str = new Test().GetInvitationCode();
                System.out.println(str);
                if(list.contains(str))
                    System.out.println(str + "已存在！");
                else
                    list.add(str);
            }
            System.out.println("===============");
        } catch (Exception e) {
            new Err(e);
        }



    }

}
class Err{
    private Throwable obje;

    public Err(Throwable obje) {
        this.obje = obje;
    }

    public Throwable getObje() {
        return obje;
    }

    public void setObje(Throwable obje) {
        this.obje = obje;
    }
}
