package com.base.bean;

public class Region {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_region.ID
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_region.NAME
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_region.IFDELETE
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    private Integer ifdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_region.ID
     *
     * @return the value of base_region.ID
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_region.ID
     *
     * @param id the value for base_region.ID
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_region.NAME
     *
     * @return the value of base_region.NAME
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_region.NAME
     *
     * @param name the value for base_region.NAME
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_region.IFDELETE
     *
     * @return the value of base_region.IFDELETE
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public Integer getIfdelete() {
        return ifdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_region.IFDELETE
     *
     * @param ifdelete the value for base_region.IFDELETE
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }
}