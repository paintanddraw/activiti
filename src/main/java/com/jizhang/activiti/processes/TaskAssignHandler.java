package com.jizhang.activiti.processes;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Custom Assignment via task listeners
 * 
 * @author Administrator
 *
 */
public class TaskAssignHandler implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		delegateTask.setAssignee("kermit");
		delegateTask.addCandidateUser("fozzie");
		delegateTask.addCandidateGroup("management");
	}

}
