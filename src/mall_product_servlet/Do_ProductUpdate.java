package mall_product_servlet;

import mall_bean.Mall_Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Do_ProductUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String cpage="";
        int count=-1;
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
                            case "cpage":
                                if (str!=null){
                                    cpage=str;

                                }
                                break;
                            case "product_id":
                                if (str!=null){
                                    int id=Integer.parseInt(str);
                                    p.setProduct_id(id);

                                }
                                break;

                        }
                    }else {
                        String filename = fileItem.getName();
                        String[] fns = filename.split("\\\\");
                        String fn=fns[fns.length-1];
                        p.setProduct_filename(fn);
                        File file = new File("img/product/" + fn);
                        if (file.exists()){
                            fileItem.write(new File("img/product/" + fn+System.currentTimeMillis()));
                        }else {
                            fileItem.write(file);
                        }



                    }
                }


                count = Product_Dao.updateByProduct(p);

                PrintWriter out = response.getWriter();

                if (count>0){
                    request.setAttribute("cp", cpage);
                    String url="/08_shop/manage/productselect?cp="+cpage;
                    System.out.println(url);
                    response.sendRedirect(url);
                }else {

                    out.write("<script>");
                    out.write("<alert('修改失败')>;");
                    out.write("location.href='/08_shop/manage/productselect?cp="+cpage+"'");
                    out.write("</script>");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }


}
