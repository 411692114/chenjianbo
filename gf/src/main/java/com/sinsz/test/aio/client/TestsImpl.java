package com.sinsz.test.aio.client;

/**
 * Created by chenjianbo on 2017/1/23.
 */
public class TestsImpl implements Tests {
    @Override
    public int caseNum() {
        return 1010;
    }

    public static void main(String[] args) {
        System.out.println(new TestsImpl().sumNum());

        Tests2<String,Integer> change = Integer::valueOf;


        System.out.println(change.change("1001") instanceof Integer);
    }





}
