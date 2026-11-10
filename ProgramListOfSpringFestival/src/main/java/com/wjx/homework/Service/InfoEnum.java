package com.wjx.homework.Service;
//枚举状态
public enum InfoEnum {
    REQUIRESUCCESS("00000","请求正常"),
    ADDSUCCESS("00000","添加成功"),
    DELETESUCCESS("00000","删除成功"),
    UPDATESUCESS("00000","更新成功"),

    ADDFAIL("11111","添加失败,已有该节目"),
    EQUALFAIL("22222","没有满足匹配条件的节目"),
    GETFAIL("33333","当前节目单为空"),
    DELETEFIAL("44444","删除失败,没有找到id对应的节目"),
    UPDATEFIAL("55555","更新失败,没有找到id对应的节目");

    //状态码
    private final String code;
    //状态信息
    private final String msg;


    InfoEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }


    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}


