package com.base.bean;

public class DeviceType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.NAME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.IFDELETE
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private Integer ifdelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.SORT
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.USER_ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_devicetype.CREATETIME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    private String createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.ID
     *
     * @return the value of base_devicetype.ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.ID
     *
     * @param id the value for base_devicetype.ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.NAME
     *
     * @return the value of base_devicetype.NAME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.NAME
     *
     * @param name the value for base_devicetype.NAME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.IFDELETE
     *
     * @return the value of base_devicetype.IFDELETE
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public Integer getIfdelete() {
        return ifdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.IFDELETE
     *
     * @param ifdelete the value for base_devicetype.IFDELETE
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.SORT
     *
     * @return the value of base_devicetype.SORT
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.SORT
     *
     * @param sort the value for base_devicetype.SORT
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.USER_ID
     *
     * @return the value of base_devicetype.USER_ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.USER_ID
     *
     * @param userId the value for base_devicetype.USER_ID
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_devicetype.CREATETIME
     *
     * @return the value of base_devicetype.CREATETIME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_devicetype.CREATETIME
     *
     * @param createtime the value for base_devicetype.CREATETIME
     *
     * @mbg.generated Tue Oct 16 14:11:01 CST 2018
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
    
    
    private User createUser;

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
    
}