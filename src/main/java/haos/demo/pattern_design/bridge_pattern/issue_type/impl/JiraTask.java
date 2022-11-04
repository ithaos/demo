package haos.demo.pattern_design.bridge_pattern.issue_type.impl;

import haos.demo.pattern_design.bridge_pattern.issue_type.JiraIssue;

public class JiraTask implements JiraIssue {
    @Override
    public String buildIssue() {
        return "开发子任务";
    }
}
