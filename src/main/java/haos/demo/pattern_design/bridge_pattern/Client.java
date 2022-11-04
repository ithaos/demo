package haos.demo.pattern_design.bridge_pattern;

import haos.demo.pattern_design.bridge_pattern.issue_type.impl.JiraDemand;
import haos.demo.pattern_design.bridge_pattern.issue_type.impl.JiraTask;
import haos.demo.pattern_design.bridge_pattern.operator.AddIssueOperator;
import haos.demo.pattern_design.bridge_pattern.operator.DelIssueOperator;

/**
 * 模仿操作Jira-Issue进行桥接模式练习
 * 两个维度：1.Issue类型  2.操作(增 删 改)
 */
public class Client {
    public static void main(String[] args) {
        JiraTask jiraTask = new JiraTask();
        JiraDemand jiraDemand = new JiraDemand();
        DelIssueOperator delIssueOperator = new DelIssueOperator(jiraTask);
        AddIssueOperator addIssueOperator = new AddIssueOperator(jiraTask);
        addIssueOperator.handle();
        delIssueOperator.handle();

        AddIssueOperator addIssueOperator1 = new AddIssueOperator(jiraDemand);
        addIssueOperator1.handle();
    }
}
