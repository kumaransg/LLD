# jira-fk


# Design a system like Jira. (Flipkart II) (Machine Round)

It should have the following functionalities : 
1) User should be able to create Task of type Story, Feature, Bugs. 
2) Each can have their own status.Stories can further have subtracts.
3) Should be able to change the status of any task. 
4) User should be able to create any sprint.
5) Should be able to add any task to sprint and remove from it. 
6) User should be able to print 
    6.1)  Delayed task 
    6.2)  Sprint details Tasks 
    6.3)  assigned to the user
7) based on Task Status Will see all Task
8) get all disableTask of sprint

# SOLUTION PROVIDED

# TaskService.Class
Sol.1-2)    Task createTask(TaskDto task);
Sol 3) 	    Task updateTask(TaskDto task);
Sol 5)	    Boolean disableTask(TaskDto task);
sol 6.1) 	List<Task> getDelayTask(Long sprintId);
sol 6.2)    TaskDetailDto getTaskDetail(Long taskId);
sol 6.3) 	List<Task> getAssignTask(Long userId);
Sol 7)      Map<TaskStatus, List<Task>> getDashboard(Long sprintId);
sol 8)	    List<Task> getDisableTask(Long sprintId);
    
# SprintService.Class	
sol 4) createSprint(SprintDto sprint);


	

	
