package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sucesso_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/cabecalho.jsp");
    _jspx_dependants.add("/rodape.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link href=\"css/navbar-fixed-side.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-3.1.1.js\"></script>\n");
      out.write("        <script src=\"js/jquery.maskedinput.min.js\"></script>\n");
      out.write("        <title>ICarWash</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

//allow access only if session exists
            String user = (String) session.getAttribute("usuario");
            String nomeDeUsuario = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("usuario")) {
                        nomeDeUsuario = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--    <body>-->\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3 col-lg-2\">\n");
      out.write("                    <nav class=\"navbar navbar-default navbar-fixed-side\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"navbar-header\">\n");
      out.write("                                <button class=\"navbar-toggle\" data-target=\".navbar-collapse\" data-toggle=\"collapse\">\n");
      out.write("                                </button>\n");
      out.write("                                <a class=\"navbar-brand\" href=\"painel_admin.jsp\">");
      out.print(user);
      out.write(", ICarWash</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"collapse navbar-collapse\">\n");
      out.write("                                <ul class=\"nav navbar-nav\">\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros Pessoais<b class=\"caret\"></b></a>\n");
      out.write("                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=cliente\">Clientes</a></li>\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=lavador\">Lavadores</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros Gerais<b class=\"caret\"></b></a>\n");
      out.write("                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=produto\">Produtos</a></li>\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=servico\">Serviços</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Solicitações<b class=\"caret\"></b></a>\n");
      out.write("                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                            <li><a href=\"#\">Contratar Serviço</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-9 col-lg-10 exibelista\">\n");
      out.write("                    ");
      out.write('\n');
      out.write("\n");
      out.write("        <script>\n");
      out.write("            setTimeout(function () {\n");
      out.write("                document.location = \"index.jsp\";\n");
      out.write("            }, 1200); // <-- delay\n");
      out.write("        </script>\n");
      out.write("        <div class=\"bg-success center-block alert-success\">\n");
      out.write("            <h1>Cliente cadastrado com sucesso!</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <footer>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            jQuery(function ($) {\n");
      out.write("                $(\"#nascimento\").mask(\"99/99/9999\");\n");
      out.write("                $(\"#telefone\").mask(\"(99)99999-9999\");\n");
      out.write("                $(\"#cpf\").mask(\"999.999.999-99\");\n");
      out.write("                $(\"#cep\").change(function () {\n");
      out.write("                    var cep_code = $(this).val();\n");
      out.write("                    if (cep_code.length <= 0)\n");
      out.write("                        return;\n");
      out.write("                    $.get(\"http://apps.widenet.com.br/busca-cep/api/cep.json\", {code: cep_code},\n");
      out.write("                            function (result) {\n");
      out.write("                                if (result.status != 1) {\n");
      out.write("                                    alert(result.message || \"Houve um erro desconhecido\");\n");
      out.write("                                    return;\n");
      out.write("                                }\n");
      out.write("                                $(\"input#cep\").val(result.code);\n");
      out.write("                                $(\"input#estado\").val(result.state);\n");
      out.write("                                $(\"input#cidade\").val(result.city);\n");
      out.write("                                $(\"input#bairro\").val(result.district);\n");
      out.write("                                $(\"input#endereco\").val(result.address);\n");
      out.write("                                $(\"input#estado\").val(result.state);\n");
      out.write("                            });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("    </footer>\n");
      out.write("</html>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
