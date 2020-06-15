package com.program.upviews.exceptions.custom;

import com.google.gson.Gson;
import com.program.upviews.exceptions.ExceptionModel;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorResponseFilter {

    public static void setErrorResponse(HttpServletResponse response, ExceptionModel exceptionModel) {
        try {
            response.setContentType("application/json");
            response.setStatus(exceptionModel.getHttpStatus().value());
            response.getWriter().write(new Gson().toJson(exceptionModel));
        } catch (IOException e) {
            log.error("Request from input stream not valid.");
        }
    }
}
