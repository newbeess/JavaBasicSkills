package com.enzo.collection;

/**
 * @author c_fu
 * @date 2017/12/25
 */
public enum PlatformEnum {
    H5(0),
    APP(1),
    ONLINE(2),
    WECHAT(3);

    private int value;

    PlatformEnum(int value){
        this.value=value;
    }

    public int toValue(){
        return this.value;
    }
}
