package com.rille.services;

import com.rille.common.exception.RecordException;
import com.rille.common.pojo.DeletedRecord;
import com.rille.common.pojo.Pagination;
import com.rille.common.pojo.User;

public interface DeletedRecordService {

    /**
     * @param user
     * @param keyword
     * @param currentPage
     * @param orderBy
     * @return
     * @throws RecordException
     */
    Pagination<DeletedRecord> getPaginationDeletedRecord(User user, String keyword, String currentPage, String orderBy) throws RecordException;

}
