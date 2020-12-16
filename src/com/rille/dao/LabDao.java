package com.rille.dao;

import com.rille.common.pojo.Lab;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rille.common.pojo.LabEquipmentCount;

public interface LabDao {
    public List<Lab> getLab();

    public List<LabEquipmentCount> getStatisticsInfo(@Param("labId") int labId);

    public int getLabEquipmentTotalCount(@Param("labId") int labId);

    public Lab getLabInfoById(@Param("labId") int labId);
}
