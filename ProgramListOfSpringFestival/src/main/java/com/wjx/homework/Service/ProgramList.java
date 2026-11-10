package com.wjx.homework.Service;


import com.wjx.homework.NeedDelete.Program;
import org.springframework.stereotype.Controller;
;import java.util.ArrayList;

@Controller
public class ProgramList {

    public ArrayList<Program> arrayList=new ArrayList<>();

    public ProgramList(){
    }

    //获取所有节目
    public ArrayList<Program> getAllPrograms(){
          return arrayList;
    }

    //按条件检索节目
    public ArrayList<Program> serachProgram(String programType, Integer actorsNum, String programName){

        ArrayList<Program> searchResult=new ArrayList<>();

        if (programName != null){
            for (Program program : this.arrayList) {
                if (program.name.equals(programName)){
                    searchResult.add(program);
                }
            }
            return searchResult;

        }else{
            if(programType == null && actorsNum == null){
                return searchResult;
            }

            if (programType != null && actorsNum ==null){
                for (Program program : this.arrayList) {
                    if (program.typeName.equals(programType)){
                        searchResult.add(program);
                    }
                }
                return searchResult;
            }

            if(programType == null){
                for (Program program : this.arrayList) {
                    if (program.actorList.split(",").length == actorsNum){
                        searchResult.add(program);
                    }
                }
                return searchResult;
            }

                for (Program program : this.arrayList) {
                    if (program.typeName.equals(programType)){
                        searchResult.add(program);
                    }
                }
                    if (!searchResult.isEmpty()){
                        searchResult.removeIf(program -> program.actorList.split(",").length != actorsNum);
                    }else{
                        for (Program program : this.arrayList) {
                            if (program.actorList.split(",").length == actorsNum){
                                searchResult.add(program);
                            }
                        }
                    }
            return searchResult;
        }
    }

    //添加节目
    public Integer addProgram(Program program){
        int flage=0;
        for (Program program1 : this.arrayList) {
            if(program1.name.equals(program.name)){
                flage=1;
            }
        }

        if(flage==1){
            return 6;
        }else{
            program.id=arrayList.size()+1;
            arrayList.add(program);
            return 1;
        }
    }

    //删除节目
    public Integer deleteProgram(Integer Id){
        if(this.arrayList.size() >=Id){
            this.arrayList.removeIf(program -> program.id.equals(Id));
            this.arrayList.forEach(program ->{
                if(program.id>Id){
                    program.id-=1;
                }
            });
            return 2;
        }else{
            return 4;
        }
    }

    //更新节目
    public Integer updatePrograms(Program updateProgramContext){
        if(this.arrayList.size() >=updateProgramContext.id){
            this.arrayList.get(updateProgramContext.id-1).typeName=updateProgramContext.typeName;
            this.arrayList.get(updateProgramContext.id-1).name=updateProgramContext.name;
            this.arrayList.get(updateProgramContext.id-1).view=updateProgramContext.view;
            this.arrayList.get(updateProgramContext.id-1).actorList=updateProgramContext.actorList;
            return 3;
        }else{
            return 5;
        }
    }

}
