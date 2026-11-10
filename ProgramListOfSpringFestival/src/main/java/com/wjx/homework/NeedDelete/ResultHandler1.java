package com.wjx.homework.NeedDelete;

import com.wjx.homework.Service.InfoEnum;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class ResultHandler1 {
    //对获取所有节目和获取一定条件节目返回结果的封装
    public Result1 DataHandler(ArrayList<Program> data, Integer status){
        Result1 result1=new Result1();
        if(status == 1){
            if (data.isEmpty()){
                result1.code= InfoEnum.GETFAIL.getCode();
                result1.message=InfoEnum.GETFAIL.getMsg();
            }else{
                result1.code=InfoEnum.REQUIRESUCCESS.getCode();
                result1.message=InfoEnum.REQUIRESUCCESS.getMsg();
                result1.data.addAll(data);
            }

        }else{
            if (data.isEmpty()){
                result1.code=InfoEnum.EQUALFAIL.getCode();
                result1.message=InfoEnum.EQUALFAIL.getMsg();
            }else{
                result1.code=InfoEnum.REQUIRESUCCESS.getCode();
                result1.message=InfoEnum.REQUIRESUCCESS.getMsg();
                result1.data.addAll(data);
            }

        }
        return result1;
    }


}
