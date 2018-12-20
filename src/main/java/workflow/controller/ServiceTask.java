package workflow.controller;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import workflow.SpringUtil.BeanUtil;
import workflow.taskcore.TaskCore;

@RestController
@RequestMapping("/api")
public class ServiceTask {
    @RequestMapping(value = "/step", method = RequestMethod.POST)
    @ResponseBody
    public String step(){
        System.out.print(TaskCore.processEngine);
        return "helloworld";
    }

}
