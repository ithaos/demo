package haos.demo.pattern_design.bridge_pattern.issue_type.impl;

import haos.demo.pattern_design.bridge_pattern.issue_type.JiraIssue;

public class JiraDemand implements JiraIssue {
    @Override
    public String buildIssue() {
        return "技术需求";
    }
}
