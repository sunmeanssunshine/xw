import java.util.List;

/**
 * Created by xuw-e on 2018/11/13.
 */

/**
 * 用户角色
 */
public class UserRole {
    private String orgId;
    private String userId;
    private String name;
    private String mobile;
    private String remark;
    private List<Role> roles;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "orgId='" + orgId + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", remark='" + remark + '\'' +
                ", roles=" + roles +
                '}';
    }
}
