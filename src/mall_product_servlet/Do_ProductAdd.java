package mall_product_servlet;


import mall_bean.Mall_Product;
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
import java.util.List;

public class Do_ProductAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        if (ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                Mall_Product p=new Mall_Product();
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()){
                        String fieldName = fileItem.getFieldName();
                        String str = fileItem.getString("UTF-8");
                        switch(fieldName){
                            case "product_name":
                                if (str!=null){
                                    p.setProduct_name(str);
                                }
                                break;
                            case "id":
                                String fid = str.split("-")[0];
                                String cid = str.split("-")[1];
                                p.setProduct_fid(Integer.parseInt(fid));
                                p.setProduct_cid(Integer.parseInt(cid));
                                break;
                            case "product_descrption":
                                p.setProduct_descrption(str);
                                break;
                            case "product_price":
                                if (str!=null){
                                    double price=Double.parseDouble(str);
                                    p.setProduct_price(price);
                                }
                                break;
                            case "product_stock":
                                if (str!=null){
                                    int stock=Integer.parseInt(str);
                                    p.setProduct_stock(stock);
                                }
                                break;

                        }
                    }else {
                        String filename = fileItem.getName();
                        String[] fns = filename.split("\\\\");
                        String fn=fns[fns.length-1];
                        p.setProduct_filename(fn);
                        try {
                            fileItem.write(new File("img/product/"+fn));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

                int count = Product_Dao.addProduct(p);
                if (count>0){
                    response.sendRedirect("productselect");
                }else {
                    response.sendRedirect("to_productadd");
                }


            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }

    }
}
