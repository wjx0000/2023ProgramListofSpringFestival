package com.wjx.homework.Controller;

import com.wjx.homework.NeedDelete.*;
import com.wjx.homework.Service.ProgramList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ProgramList programList;
    @Autowired
    private ResultHandler2 resultHandler2;
    @Autowired
    private ResultHandler1 resultHandler1;

    //获取所有节目
    @GetMapping("/get/programList")
    public Object getPrograms(){
        return resultHandler1.DataHandler(programList.getAllPrograms(),1);
    }


    //按条件检索节目
    @GetMapping("/get/search")
    public Object searchProgram(@RequestParam(value = "type",required = false) String programType,@RequestParam(value="num",required=false) Integer actorsNum,@RequestParam(value="name",required = false) String programName){
        return resultHandler1.DataHandler(programList.serachProgram(programType,actorsNum,programName),2);
    }

    //新增一个节目
    @PostMapping("/add/program")
    public Object addProgram(@RequestBody Program program){
        Integer events=programList.addProgram(program);
        return resultHandler2.statusHandler(events);
    }

    //删除一个节目
    @PostMapping("/delete/program")
    public Object deleteProgram(@RequestBody DeleteID ID){
        Integer station=programList.deleteProgram(ID.id);
        return resultHandler2.statusHandler(station);
    }

    //更新一个节目
    @PostMapping("/update/program")
    public Object updatePrograms(@RequestBody Program updateProgramContext){
        Integer status=programList.updatePrograms(updateProgramContext);
        return resultHandler2.statusHandler(status);
    }


}
