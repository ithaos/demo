package haos.demo.pattern_design.bridge_pattern.operator.abs;

import haos.demo.pattern_design.bridge_pattern.issue_type.JiraIssue;

/**
 * 抽象Issue操作者
 */
public abstract class IssueOperator {

    protected JiraIssue jiraIssue;

    public abstract void handle();

    public IssueOperator(JiraIssue jiraIssue) {
        this.jiraIssue = jiraIssue;
    }
}
