package haos.demo.pattern_design.bridge_pattern.operator;

import haos.demo.pattern_design.bridge_pattern.issue_type.JiraIssue;
import haos.demo.pattern_design.bridge_pattern.operator.abs.IssueOperator;

public class DelIssueOperator extends IssueOperator {
    @Override
    public void handle() {
        System.out.println("删除了一个" + this.jiraIssue.buildIssue());
    }

    public DelIssueOperator(JiraIssue jiraIssue) {
        super(jiraIssue);
    }
}
