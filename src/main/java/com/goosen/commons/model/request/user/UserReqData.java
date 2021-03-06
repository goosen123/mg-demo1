package com.goosen.commons.model.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.annotations.EnumValue;
import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="用户")
public class UserReqData extends BaseReq{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "用户id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "头像",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
	private String avatar;
	@ApiModelProperty(value = "账号",required=true,example="15088132168")
	@NotEmpty
    private String account;
	@ApiModelProperty(value = "登录密码",required=true,example="123456")
    private String password;
    @ApiModelProperty(value = "用户名称",required=true,example="郭靖")
	@NotEmpty
    private String userName;
    @ApiModelProperty(value = "性别（1：男 2：女 3：未知）",example="1")
    @EnumValue(enumClass = UserSex.class, enumMethod = "isValidCode")
    private Integer userSex;
    @ApiModelProperty(value = "邮箱",example="2630344884@qq.com")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不对")
    private String userEmail;
    @ApiModelProperty(value = "手机号",example="15088132168")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不对")
    private String userPhone;
    @EnumValue(enumClass = UserTypeEnum.class, enumMethod = "isValidCode")
    @ApiModelProperty(value = "用户类型(1：管理员  2：普通用户）",example="1")
    private Integer userType;
    @ApiModelProperty(value = "状态(1：启用  2：冻结  3：删除）",example="1")
    @EnumValue(enumClass = StatusEnum.class, enumMethod = "isValidCode")
    private Integer status;
    
    /**
     * 用户性别枚举
     */
    public enum UserSex {
        MAN(1, "男"),
        WOMAN(2, "女"),
        UNKNOWN(3, "未知");
        private Integer code;
        private String desc;
        UserSex(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (UserSex status : UserSex.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 用户类型枚举
     */
    public enum UserTypeEnum {
        ADMIN(1, "管理员"),
        COMUSER(2, "普通用户");
        private Integer code;
        private String desc;
        UserTypeEnum(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (UserTypeEnum status : UserTypeEnum.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 账号状态枚举
     */
    public enum StatusEnum {
        NORMAL(1, "启用"),
        SUSPENDED(2, "冻结"),
        DELETED(3, "已删除");
        private Integer code;
        private String desc;
        StatusEnum(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (StatusEnum status : StatusEnum.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
