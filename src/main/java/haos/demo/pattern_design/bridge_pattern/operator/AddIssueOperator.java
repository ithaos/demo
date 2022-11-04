package haos.demo.pattern_design.bridge_pattern.operator;

import haos.demo.pattern_design.bridge_pattern.issue_type.JiraIssue;
import haos.demo.pattern_design.bridge_pattern.operator.abs.IssueOperator;

public class AddIssueOperator extends IssueOperator {

    @Override
    public void handle() {
        System.out.println("增加一个" + jiraIssue.buildIssue());
    }

    public AddIssueOperator(JiraIssue jiraIssue) {
        super(jiraIssue);
    }
}
