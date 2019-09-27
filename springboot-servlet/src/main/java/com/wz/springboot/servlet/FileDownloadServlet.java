package com.wz.springboot.servlet;

import cn.hutool.core.io.IoUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "fileDownloadServlet", urlPatterns = {"/download/file"})
public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获得下载的文件名
        String fileName = req.getParameter("fileName");
        // 设置要下载的文件类型
        resp.setContentType(this.getServletContext().getMimeType(fileName));
        // 下载的路径
        String absolutProgramPath = ClassLoader.getSystemClassLoader().getResource(".").getPath();
        // 获得输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 获得该文件的输入流
        InputStream in = new FileInputStream(absolutProgramPath+fileName);
        // 流的拷贝
        IoUtil.copy(in, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
