package com.rille.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rille.common.Constants;
import com.rille.common.exception.RecordException;
import com.rille.common.pojo.DeletedRecord;
import com.rille.common.pojo.Pagination;
import com.rille.common.pojo.User;
import com.rille.services.DeletedRecordService;
import com.rille.services.RecordService;
import com.rille.services.UserService;

@Controller
@RequestMapping(value = "/record")
public class DeletedRecordController {

    @Qualifier(value="recordServiceImpl")
    @Autowired
    RecordService recordService;

    @Qualifier(value="deletedRecordServiceImpl")
    @Autowired
    DeletedRecordService deletedRecordService;

    @Qualifier(value="userServiceImpl")
    @Autowired
    UserService userService;

    @RequestMapping("/delete-record")
    public String toDeletedRecord(String searchKeyWord, String page, String orderBy, HttpSession session, HttpServletRequest request) {

        try {
            Pagination<DeletedRecord> pagination = deletedRecordService.getPaginationDeletedRecord(
                (User)session.getAttribute(Constants.User.SESSION_USER_KEY), searchKeyWord, page, orderBy
            );

            request.setAttribute(Constants.RecordController.REQUEST_ATTRIBUTE_KEY_REQUEST_BUY_RECORD, pagination);
        } catch (RecordException recordException) {

            if (recordException.getErrorCode().equals(Constants.ErrorCode.ERROR_USER_NOT_EXIST)) {

                return "redirect:/user/toLogin";
            }
        }

        return "record/deleted_record";
    }

}
