package com.base.dao;

import com.base.bean.RoleMenu;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbg.generated Fri Dec 21 09:40:40 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbg.generated Fri Dec 21 09:40:40 CST 2018
     */
    int insert(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbg.generated Fri Dec 21 09:40:40 CST 2018
     */
    RoleMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbg.generated Fri Dec 21 09:40:40 CST 2018
     */
    List<RoleMenu> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbg.generated Fri Dec 21 09:40:40 CST 2018
     */
    int updateByPrimaryKey(RoleMenu record);
    
    
    Set<RoleMenu> selectByRoleId(@Param("roleId")int roleId);
}