package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import br.icarwash.model.Cliente;
import java.util.ArrayList;
import br.icarwash.dao.ClienteDAO;

public final class listar_005fcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("                                <a class=\"navbar-brand\" href=\"./\">");
      out.print(user);
      out.write(", ICarWash</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"collapse navbar-collapse\">\n");
      out.write("                                <ul class=\"nav navbar-nav\">\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros Gerais <b class=\"caret\"></b></a>\n");
      out.write("                                        <ul class=\"dropdown-menu\">\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=cliente\">Clientes</a></li>\n");
      out.write("                                            <li><a href=\"Controle?action=Listar&listar=funcionario\">Funcionarios</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                        <!--                                    <li class=\"dropdown\">\n");
      out.write("                                                                                <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros Gerais <b class=\"caret\"></b></a>\n");
      out.write("                                                                                <ul class=\"dropdown-menu\">\n");
      out.write("                                                                                    <li><a href=\"#\">Fazer Pedido</a></li>\n");
      out.write("                                                                                </ul>\n");
      out.write("                                                                            </li>-->\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-9 col-lg-10 exibelista\">\n");
      out.write("                    ");
      out.write('\n');
      out.write("\n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("    <h2>Controle de Clientes</h2>\n");
      out.write("</div>\n");
      out.write("<table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Nome</th>\n");
      out.write("            <th>Telefone</th>\n");
      out.write("            <th>Data Nascimento</th>\n");
      out.write("            <th>CPF</th>\n");
      out.write("            <th>CEP</th>\n");
      out.write("            <th>Estado</th>\n");
      out.write("            <th>Cidade</th>\n");
      out.write("            <th>Bairro</th>\n");
      out.write("            <th>Endereco</th>\n");
      out.write("            <th colspan=2>Action</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");
//recupera a lista do request
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("lista");
            for (Cliente cliente : listaCliente) {
      out.write("  \n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( cliente.getNome());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getTelefone());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( f.format(cliente.getDataNascimento().getTime()));
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getCPF());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getEndereco().getCEP());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getEndereco().getEstado());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getEndereco().getCidade());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getEndereco().getBairro());
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cliente.getEndereco().getEndereco() + " " + cliente.getEndereco().getNumero());
      out.write("</td>\n");
      out.write("            <td><a type=\"button\" class=\"glyphicon glyphicon-search text-info\" href=\"Controle?action=LocalizarPorId&q=cli&id=");
      out.print(cliente.getId());
      out.write("\"></a></td>\n");
      out.write("            <td><a type=\"button\" class=\"glyphicon glyphicon-remove text-danger\"  href=\"Controle?action=Excluir&q=cli&id=");
      out.print(cliente.getId());
      out.write("\"></a></td>\n");
      out.write("        </tr>\n");
      out.write("        ");
}
      out.write(" \n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<button type=\"button\" class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#myModal\">Add Cliente</button>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("</div>\n");
      out.write("<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <!-- Modal content-->\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <h4 class=\"modal-title\">Cadastrar Cliente</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form action=\"Controle\" method=\"post\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"hidden\" name=\"quem\" value=\"cliente\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-8\"><label>Email:</label> <input class=\"form-control\" type=\"text\" name=\"txtEmail\" id=\"txtEmail\"><br></div>\n");
      out.write("                        </div>    \n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\"><label>Login:</label> <input class=\"form-control\" type=\"text\" name=\"login\"><br></div>\n");
      out.write("                            <div class=\"col-md-6\"><label>Senha:</label> <input class=\"form-control\" type=\"password\" name=\"senha\"><br></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\"><label>Nome:</label> <input class=\"form-control\" type=\"text\" name=\"nome\"><br></div>\n");
      out.write("                            <div class=\"col-md-6\"><label>Telefone:</label> <input class=\"form-control\" type=\"text\" name=\"telefone\" id=\"telefone\"><br></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\"><label>Data de Nascimento:</label> <input class=\"form-control\" type=\"text\" name=\"nascimento\" id=\"nascimento\"><br></div>\n");
      out.write("                            <div class=\"col-md-6\"><label>CPF:</label> <input class=\"form-control\" type=\"text\" name=\"cpf\" id=\"cpf\"><br></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\"><label>CEP:</label> <input class=\"form-control\" type=\"text\" name=\"cep\" id=\"cep\"><br></div>\n");
      out.write("                            <div class=\"col-md-6\"><label>Estado:</label> <input class=\"form-control\" type=\"text\" name=\"estado\" id=\"estado\"><br></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6\"><label>Cidade:</label> <input class=\"form-control\" type=\"text\" name=\"cidade\" id=\"cidade\"><br></div>\n");
      out.write("                            <div class=\"col-md-6\"><label>Bairro:</label> <input class=\"form-control\" type=\"text\" name=\"bairro\" id=\"bairro\"><br></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-8\"><label>Endereço:</label> <input class=\"form-control\" type=\"text\" name=\"endereco\" id=\"endereco\"><br></div>\n");
      out.write("                            <div class=\"col-md-4\"><label>Numero:</label> <input class=\"form-control\" type=\"text\" name=\"numero\" id=\"numero\"><br></div>\n");
      out.write("                        </div>   \n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input class=\"form-control btn btn-primary\" type=\"submit\" name=\"action\" value=\"Cadastrar\"><br>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Fechar</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
