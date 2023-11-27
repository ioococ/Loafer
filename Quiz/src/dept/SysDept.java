package dept;

import java.util.List;

/**
 * @author Mr.Wang
 * @date 23-3-25
 */
public class SysDept implements Comparable<SysDept> {
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 新加属性   子部门
     */
    private List<SysDept> children;

    public SysDept() {
    }

    public SysDept(Long deptId, Long parentId, String deptName) {
        this.deptId = deptId;
        this.parentId = parentId;
        this.deptName = deptName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public List<SysDept> getChildren() {
        return children;
    }

    public void setChildren(List<SysDept> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return " SysDept " +
                "deptId=" + deptId + ", parentId=" + parentId +
                ", deptName='" + deptName + ", subDept=[" + children + "]} \n";
    }

    @Override
    public int compareTo(SysDept o) {
        return 0;
    }
}
