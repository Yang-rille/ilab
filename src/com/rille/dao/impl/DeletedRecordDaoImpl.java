package com.rille.dao.impl;

import com.rille.common.pojo.DeletedRecord;
import com.rille.dao.DeletedRecordDao;
import com.rille.dao.MySqlSessionDaoSupport;
import java.util.List;

import org.springframework.stereotype.Service;

@Service(value="deletedRecordDaoImpl")
public class DeletedRecordDaoImpl extends MySqlSessionDaoSupport implements DeletedRecordDao {

    @Override
    public int insertDeletedRecordByRecord(DeletedRecord record) {

        return getSqlSession().getMapper(DeletedRecordDao.class).insertDeletedRecordByRecord(record);
    }

    @Override
    public int getDeletedRecordCount(String keyword, int requestUserId) {

        return getSqlSession().getMapper(DeletedRecordDao.class).getDeletedRecordCount(keyword, requestUserId);
    }

    @Override
    public List<DeletedRecord> getDeletedRecordPagination(String keyword, int start, int offset, String orderBy, int requestUserId) {

        return getSqlSession().getMapper(DeletedRecordDao.class).getDeletedRecordPagination(keyword, start, offset, orderBy, requestUserId);
    }
}
