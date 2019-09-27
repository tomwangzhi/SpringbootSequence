package com.wz.springboot.servlet;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "fileUploadServlet",urlPatterns = {"/upload/file"})
@Slf4j
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("reqUrl={},param={}",req.getRequestURI(),req.getParameter("file"));
        Part file = req.getPart("file");
        if(Objects.isNull(file)) {
            throw new IllegalArgumentException("file is not null");
        }
        String fileName = file.getSubmittedFileName();
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        //随机的生存一个32的字符串
        String filename = UUID.randomUUID()+"-"+DateUtil.format(DateUtil.date(), "yyyy-mm-dd hh-mm-ss")+suffix;
        // 得到class的目录,上传文件的路径
        String absolutProgramPath = ClassLoader.getSystemClassLoader().getResource(".").getPath();
        String fullFilePath = StrUtil.appendIfMissing(absolutProgramPath, "/")+filename;
        file.write(fullFilePath);
        log.info("save file path = {}",fullFilePath);
        resp.setStatus(HttpStatus.HTTP_OK);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("成功上传");
    }

}
