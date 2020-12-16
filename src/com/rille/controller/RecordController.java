package com.rille.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rille.common.Constants;
import com.rille.common.exception.RecordException;
import com.rille.common.pojo.Pagination;
import com.rille.common.pojo.RequestBuyRecord;
import com.rille.common.pojo.User;
import com.rille.services.RecordService;
import com.rille.services.UserService;

@Controller
@RequestMapping(value = "/record")
public class RecordController {

    @Qualifier(value="recordServiceImpl")
    @Autowired
    RecordService recordService;

    @Qualifier(value="userServiceImpl")
    @Autowired
    UserService userService;

    @RequestMapping("/buy-record")
    public String toBuyRecord(String searchKeyWord, String page, String orderBy, HttpSession session, HttpServletRequest request) {

        try {
            Pagination<RequestBuyRecord> pagination = recordService.getPaginationRequestBuyRecord(
                (User)session.getAttribute(Constants.User.SESSION_USER_KEY), searchKeyWord, page, orderBy
            );

            request.setAttribute(Constants.RecordController.REQUEST_ATTRIBUTE_KEY_REQUEST_BUY_RECORD, pagination);
        } catch (RecordException recordException) {

            if (recordException.getErrorCode().equals(Constants.ErrorCode.ERROR_USER_NOT_EXIST)) {

                return "redirect:/user/toLogin";
            }
        }

        return "record/request_buy_record";
    }

    @RequestMapping("/test")
    public @ResponseBody Object test(HttpSession session) throws RecordException {

//        Pagination<RequestBuyRecord> pagination = recordService.getPaginationRequestBuyRecord((User)session.getAttribute(Constants.User.SESSION_USER_KEY), "", "1", "1");

//        return pagination;
        Pagination<RequestBuyRecord> notReplyRequestBuyRecord = recordService.getNotReplyRequestBuyRecord((User)session.getAttribute(Constants.User.SESSION_USER_KEY), "", "1", "1");
        User user = (User) session.getAttribute(Constants.User.SESSION_USER_KEY);
        return notReplyRequestBuyRecord;
    }
}
