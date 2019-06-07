<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-hover" >
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Raça</th>
                </tr>
            </thead>
            
            <tbody id="tabelaCachorros">
                    
                  
              <c:forEach var="cachorros" items="${listaDogs}">
                <tr> 	
                    <th scope="row"> ${cachorros['id']} </th>
                    <td>${cachorros['nome']}</td>
                    <td>${cachorros['raca']}</td>
                    <td><a href="editarProduto?idProduto=${cachorros['id']}"><button type="button" class="btn btn-outline-dark">Editar</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</body>
</html>