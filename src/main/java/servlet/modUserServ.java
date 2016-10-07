package servlet;

import biz.UserBiz;
import biz.UserBizImp;
import entity.Sex;
import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/30/16
 * TIME:9:42 AM
 */

/**
 * 修改用户Servlet
 */
public class modUserServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 更新用户资料
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        String fieldName = "";
        User user = new User();

        String birthyear = "";
        String birthmonth = "";
        String birthday = "";

        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
        String uploadFilePath = req.getSession().getServletContext()
                .getRealPath("upload/headimage/");
        String uploadFileName = "";

        if (isMultipart) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> items = upload.parseRequest(req);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) { //依次处理每个文件
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) { //普通表单字段
                        fieldName = item.getFieldName(); //表单字段的name属性值
                        if (fieldName.equals("userName")) {
                            user.setEu_user_name(item.getString("UTF-8"));
                        } else if (fieldName.equals("passWord")) {
                            user.setEu_password(item.getString("UTF-8"));
                        } else if (fieldName.equals("sex")) {
                            user.setEu_sex(item.getString().equals("0") ? Sex.MALE.getSex() : Sex.FEMALE.getSex());
                        } else if (fieldName.equals("birthyear")) {
                            birthyear = item.getString();
                        } else if (fieldName.equals("birthmonth")) {
                            birthmonth = item.getString();
                        } else if (fieldName.equals("birthday")) {
                            birthday = item.getString();
                        } else if (fieldName.equals("identitycode")) {
                            user.setEu_identity_code(item.getString());
                        } else if (fieldName.equals("mobile")) {
                            user.setEu_mobile(item.getString());
                        } else if (fieldName.equals("address")) {
                            user.setEu_address(item.getString("UTF-8"));
                        } else if (fieldName.equals("userid")) {
                            user.setEu_user_id(Integer.valueOf(item.getString()));
                        }
                    } else { //文件表单字段
                        String fileName = item.getName();
                        if (fileName != null && !fileName.equals("")) {
                            File fullFile = new File(item.getName());
                            File saveFile = new File(uploadFilePath,
                                    fullFile.getName());
                            item.write(saveFile);
                            uploadFileName = fullFile.getName();
                        }
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            user.setEu_birthday(birthyear + "-" + birthmonth + "-" + birthday);
            user.setEu_headimage(uploadFilePath + uploadFileName);
            System.out.println(user);

            //加入数据库
            UserBiz userBiz = new UserBizImp();
            if (userBiz.modUser(user)) {
                System.out.println("修改成功");
                req.getRequestDispatcher("manage-result.html").forward(req, resp);
            } else {
                System.out.println("修改失败");
                req.getRequestDispatcher("manage-result-fail.html").forward(req, resp);
            }

        }
    }
}

