package com.rille.dao.impl;

import com.rille.common.pojo.Lab;
import com.rille.dao.MySqlSessionDaoSupport;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rille.common.pojo.LabEquipmentCount;
import com.rille.dao.LabDao;

@Repository(value = "labDaoImpl")
public class LabDaoImpl extends MySqlSessionDaoSupport implements LabDao{

    @Override
    public List<Lab> getLab() {
        return getSqlSession().getMapper(LabDao.class).getLab();
    }

    @Override
    public List<LabEquipmentCount> getStatisticsInfo(int labId) {

        return getSqlSession().getMapper(LabDao.class).getStatisticsInfo(labId);
    }

    @Override
    public int getLabEquipmentTotalCount(int labId) {

        return getSqlSession().getMapper(LabDao.class).getLabEquipmentTotalCount(labId);
    }

    @Override
    public Lab getLabInfoById(int labId) {

        return getSqlSession().getMapper(LabDao.class).getLabInfoById(labId);
    }
}
