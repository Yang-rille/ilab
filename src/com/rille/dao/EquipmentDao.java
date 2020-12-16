package com.rille.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rille.common.pojo.Equipment;
import com.rille.common.pojo.RequestEquipment;

public interface EquipmentDao {
    public int insertRequestEquipment(RequestEquipment requestEquipment);

    public List<Equipment> getByPagination(
        @Param("keyword") String keyword,
        @Param("start") int start,
        @Param("offset") int offset,
        @Param("labId") int labId,
        @Param("orderBy") String orderBy
    );

    public int getCountBySearchWord(
        @Param("keyword") String keyword,
        @Param("labId") int labId
    );

    public int insertEquipment(Equipment equipment);

    public int deleteEquipmentByIdArray(@Param("idArray") int[] idArray,  @Param("deleteRecordId") int deleteRecordId);
}
