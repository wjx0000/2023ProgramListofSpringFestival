package com.wjx.homework.NeedDelete;

import com.wjx.homework.NeedDelete.Result2;
import com.wjx.homework.Service.InfoEnum;
import org.springframework.stereotype.Repository;

@Repository
public class ResultHandler2 {

    Result2 result2=new Result2();

    //对剩下行为返回结果的封装
    public Result2 statusHandler(Integer statusCode){
        switch (statusCode){
            //添加成功
            case 1:
                 this.result2.code= InfoEnum.ADDSUCCESS.getCode();
                 this.result2.message=InfoEnum.ADDSUCCESS.getMsg();
                 break;
            //删除成功
            case 2:
                this.result2.code=InfoEnum.DELETESUCCESS.getCode();
                this.result2.message=InfoEnum.DELETESUCCESS.getMsg();
                break;
            //更新成功
            case 3:
                this.result2.code=InfoEnum.UPDATESUCESS.getCode();
                this.result2.message=InfoEnum.UPDATESUCESS.getMsg();
                break;
            //删除失败
            case 4:
                this.result2.code=InfoEnum.DELETEFIAL.getCode();
                this.result2.message=InfoEnum.DELETEFIAL.getMsg();
                break;
            //更新失败
            case 5:
                this.result2.code=InfoEnum.UPDATEFIAL.getCode();
                this.result2.message=InfoEnum.UPDATEFIAL.getMsg();
                break;
            //添加失败
            case 6:
                this.result2.code=InfoEnum.ADDFAIL.getCode();
                this.result2.message=InfoEnum.ADDFAIL.getMsg();
                break;
        }
        return this.result2;
    }
}
