package com.rille.services.impl;

import com.rille.common.exception.RecordException;
import com.rille.common.pojo.DeletedRecord;
import com.rille.common.pojo.Pagination;
import com.rille.common.utils.PaginationUtil;
import com.rille.common.utils.PropertyUtil;
import com.rille.services.DeletedRecordService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rille.common.Constants;
import com.rille.common.pojo.User;
import com.rille.dao.DeletedRecordDao;

@Service(value="deletedRecordServiceImpl")
public class DeletedRecordServiceImpl implements DeletedRecordService {

    @Qualifier(value="deletedRecordDaoImpl")
    @Autowired
    DeletedRecordDao deletedRecordDao;

    @Override
    public Pagination<DeletedRecord> getPaginationDeletedRecord(User user, String keyword, String currentPage, String orderBy) throws RecordException {

        if (user == null) {
            throw new RecordException(Constants.ErrorCode.ERROR_USER_NOT_EXIST, "对不起, 请先登录.");
        }

        int page = 1;
        int order = 1;
        int count = 6;

        if (keyword == null) {
            keyword = new String();
        }

        try {
            page = Integer.parseInt(currentPage);

            if (page <= 0) {
                page = 1;
            }

        } catch (NumberFormatException numberFormatException) {
        }

        try {
            order = Integer.parseInt(orderBy);
            order = order == 0 ? order : 1;
        } catch (NumberFormatException e) {
        }

        try {
            count = Integer.parseInt(PropertyUtil.getRequestBuyRecordPerPageCount());
        } catch (NumberFormatException e) {
        }


        Pagination<DeletedRecord> pagination = new Pagination<DeletedRecord>();
        pagination.setSearchKeyWord(keyword);
        orderBy = order == 0 ? "ASC" : "DESC";

        keyword = "%" + keyword + "%";
        int totalCount = deletedRecordDao.getDeletedRecordCount(keyword, user.getId());
        int start = (page - 1) * count;
        int offset = count;
        int maxPage = (int) Math.ceil(totalCount * 1.0 / count);

        if (page > maxPage) {
            page = 1;
        }
        List<Integer> pageIndexList = PaginationUtil.makePageIndexList(page, count, maxPage);

        pagination.setCurrentPage(page);
        pagination.setResults(deletedRecordDao.getDeletedRecordPagination(keyword, start, offset, orderBy, user.getId()));
        pagination.setTotalCount(count);
        pagination.setTotalPage(maxPage);
        pagination.setPagesList(pageIndexList);
        pagination.setOrderBy(order);

        return pagination;
    }
}
