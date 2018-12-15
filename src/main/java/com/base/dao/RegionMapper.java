package com.base.dao;

import com.base.bean.Region;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_region
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_region
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    int insert(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_region
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    Region selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_region
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    List<Region> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_region
     *
     * @mbg.generated Sat Dec 15 14:14:57 CST 2018
     */
    int updateByPrimaryKey(Region record);

	public List<Region> selectByName(@Param("name")String name);
}