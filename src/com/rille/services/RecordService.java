package com.rille.services;

import com.rille.common.exception.EquipmentException;
import com.rille.common.exception.RecordException;
import com.rille.common.pojo.Pagination;
import com.rille.common.pojo.RequestBuyRecord;
import com.rille.common.pojo.User;

public interface RecordService {
    public Pagination<RequestBuyRecord> getPaginationRequestBuyRecord(
        User user,
        String keyword,
        String currentPage,
        String orderBy
    ) throws RecordException;

    public Pagination<RequestBuyRecord> getNotReplyRequestBuyRecord(
        User user,
        String keyword,
        String currentPage,
        String orderBy
    ) throws RecordException;

    public RequestBuyRecord findRequestBuyRecordById(String id) throws RecordException;

    public RequestBuyRecord findRepliedBuyRecordById(String id) throws RecordException;

    /**
     * @param id
     * @param operation
     * @param user
     * @return
     * @throws RecordException
     * @throws EquipmentException
     */
    int approveRequestBuyRecord(String id, String operation, User user) throws RecordException, EquipmentException;

    /**
     * 获取已经答复了的购置记录
     * @param user
     * @param keyword
     * @param currentPage
     * @param orderBy
     * @return
     * @throws RecordException
     */
    Pagination<RequestBuyRecord> getRepliedRequestBuyRecord(User user, String keyword, String currentPage, String orderBy) throws RecordException;
}
