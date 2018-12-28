/**
 * Created by xuw-e on 2018/11/13.
 */
public class Role {
    private String id;
    private String tenantId;
    private String name;
    private String productCode;
    private Boolean deleted;
    private Boolean enabled;
    private String defined;
    private String authorities;
    private String orgTypes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDefined() {
        return defined;
    }

    public void setDefined(String defined) {
        this.defined = defined;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(String orgTypes) {
        this.orgTypes = orgTypes;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", deleted=" + deleted +
                ", enabled=" + enabled +
                ", defined='" + defined + '\'' +
                ", authorities='" + authorities + '\'' +
                ", orgTypes='" + orgTypes + '\'' +
                '}';
    }
}
