package workflow.taskcore;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.spring.SpringProcessEngineConfiguration;
import workflow.SpringUtil.BeanUtil;

import java.util.Map;

public class TaskCore {
    public static ProcessEngine processEngine;
    private static TaskCore ourInstance = new TaskCore();

    public static TaskCore getInstance() {
        return ourInstance;
    }
    private TaskCore() {
        processEngine = ((SpringProcessEngineConfiguration)BeanUtil.getBeanByName("engineconfig")).buildProcessEngine();
    }

    public Task creatTask(String url){
        Deployment deploy = processEngine.getRepositoryService().createDeployment().addClasspathResource(url).deploy();
        ProcessDefinition processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
        return  processEngine.getTaskService().createTaskQuery().processInstanceId(processEngine.getRuntimeService().startProcessInstanceById(processDefinition.getId()).getId()).singleResult();
    }

    public void complete(Task task, Map<String,Object> variable){
        processEngine.getTaskService().complete(task.getId(),variable);
    }

}
