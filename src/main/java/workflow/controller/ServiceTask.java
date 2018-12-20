package workflow.controller;

import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import workflow.taskcore.TaskCore;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ServiceTask {
    private static Task task;
    @RequestMapping(value = "/step", method = RequestMethod.POST)
    @ResponseBody
    public String step(){
        TaskCore taskCore = TaskCore.getInstance();
        String taskname ;
        if(task == null){
           task = taskCore.creatTask("BPMN/service-app.bpmn20.xml");
           taskname =task.getName();
           taskCore.complete(task,new HashMap<String, Object>());
           task = TaskCore.processEngine.getTaskService().createTaskQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        }else{
           taskname = task.getName();
            taskCore.complete(task,new HashMap<String, Object>());
            task = TaskCore.processEngine.getTaskService().createTaskQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        }
        return taskname;
    }

}
