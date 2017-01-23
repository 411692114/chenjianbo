package com.sinsz.test.aio.client;

/**
 * Created by chenjianbo on 2017/1/23.
 */
public interface Tests {

    int caseNum();

    default int sumNum(){
        return 100+caseNum();
    }

}
