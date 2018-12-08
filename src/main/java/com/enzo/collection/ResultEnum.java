package com.enzo.collection;

/**
 * @author c_fu
 * @date 2017/9/25
 * @time 13:50
 */
public enum ResultEnum {

    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    EXCEPTION(2,"异常");

    private final int value;
    private final String name;
    ResultEnum(int value,String name) {
        this.name=name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ResultEnum findByValue(int value) {
        switch (value) {
            case 0:
                return SUCCESS;
            case 1:
                return ERROR;
            case 2:
                return EXCEPTION;
            default:
                return null;
        }
    }
    public static ResultEnum getResultEnum(Integer value){
        ResultEnum response=null;
        for (ResultEnum status : ResultEnum.values()){
            if (status.getValue()==value){
                response=status;
                break;
            }
        }
        return response;
    }
}
