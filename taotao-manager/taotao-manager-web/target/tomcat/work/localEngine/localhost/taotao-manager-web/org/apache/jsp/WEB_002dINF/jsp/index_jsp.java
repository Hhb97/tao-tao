package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("    x                  c x 344,...................`\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>富农网城后台管理系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"js/jquery-easyui-1.4.1/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"js/jquery-easyui-1.4.1/themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/taotao.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/kindeditor-4.1.10/kindeditor.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.content {\r\n");
      out.write("\t\tpadding: 10px 10px 10px 10px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("    <div data-options=\"region:'west',title:'菜单',split:true\" style=\"width:180px;\">\r\n");
      out.write("    \t<ul id=\"menu\" class=\"easyui-tree\" style=\"margin-top: 10px;margin-left: 5px;\">\r\n");
      out.write("         \t<li>\r\n");
      out.write("         \t\t<span>商品管理</span>\r\n");
      out.write("         \t\t<ul>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-add'}\">新增商品</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-list'}\">查询商品</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-param-list'}\">规格参数</li>\r\n");
      out.write("\t         \t</ul>\r\n");
      out.write("         \t</li>\r\n");
      out.write("         \t<li>\r\n");
      out.write("         \t\t<span>网站内容管理</span>\r\n");
      out.write("         \t\t<ul>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'content-category'}\">内容分类管理</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'content'}\">内容管理</li>\r\n");
      out.write("\t         \t</ul>\r\n");
      out.write("         \t</li>\r\n");
      out.write("         </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div data-options=\"region:'center',title:''\">\r\n");
      out.write("    \t<div id=\"tabs\" class=\"easyui-tabs\">\r\n");
      out.write("\t\t    <div title=\"首页\" style=\"padding:20px;\">\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#menu').tree({\r\n");
      out.write("\t\tonClick: function(node){\r\n");
      out.write("\t\t\tif($('#menu').tree(\"isLeaf\",node.target)){\r\n");
      out.write("\t\t\t\tvar tabs = $(\"#tabs\");\r\n");
      out.write("\t\t\t\tvar tab = tabs.tabs(\"getTab\",node.text);\r\n");
      out.write("\t\t\t\tif(tab){\r\n");
      out.write("\t\t\t\t\ttabs.tabs(\"select\",node.text);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\ttabs.tabs('add',{\r\n");
      out.write("\t\t\t\t\t    title:node.text,\r\n");
      out.write("\t\t\t\t\t    href: node.attributes.url,\r\n");
      out.write("\t\t\t\t\t    closable:true,\r\n");
      out.write("\t\t\t\t\t    bodyCls:\"content\"\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
