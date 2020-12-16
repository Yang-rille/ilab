package com.rille.services;

import com.rille.common.exception.EquipmentException;
import com.rille.common.pojo.Pagination;
import java.util.Map;

import com.rille.common.pojo.Equipment;
import com.rille.common.pojo.User;

public interface EquipmentService {

    /**
     * 申请购置设备
     * @param equipments
     * @param user
     * @throws EquipmentException
     */
    public void requestBuyEquipment(Map<String, Object> equipments, User user) throws EquipmentException;

    /**
     * 根据当前页，以及搜索内容还有排序顺序进行显示设备列表
     * @param searchKeyWord
     * @param page
     * @param orderBy
     * @param labId
     * @param user
     * @return 分好页的设备列表
     * @throws EquipmentException
     */
    public Pagination<Equipment> listEquipmentsByPagination(String searchKeyWord, String page, String orderBy, String labId, User user) throws EquipmentException;

    public int insertEquipmentByEquipment(Equipment equipment, User user) throws EquipmentException;

    /**
     * @param user
     * @param deletedIds
     * @return
     * @throws EquipmentException
     */
    int deleteEquipmentByIdArray(User user, String[] deletedIds) throws EquipmentException;
}
