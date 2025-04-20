<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Custom.css">
</head>
<body>
<div class="login-container">
    <div class="avatar">
        <img src="${pageContext.request.contextPath}/imagenes/iconogrande.png" alt="Avatar">
    </div>
    <div class="separator"></div>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <!-- CAMPO USUARIO -->
        <div class="input-group ${not empty userError ? 'has-error' : ''}">
            <label for="username">
                <img src="${pageContext.request.contextPath}/imagenes/user.jpg" class="icon">
            </label>
            <input
                    type="text" id="username" name="username"
                    placeholder="Nombre"
                    value="${fn:escapeXml(param.username)}"
                    class="${not empty userError ? 'input-error' : ''}"
            />
            <c:if test="${not empty userError}">
                <div class="error-message">${userError}</div>
            </c:if>
        </div>

        <!-- CAMPO CONTRASEÑA -->
        <div class="input-group ${not empty passError ? 'has-error' : ''}">
            <label for="password">
                <img src="${pageContext.request.contextPath}/imagenes/candado.jpg" class="icon">
            </label>
            <input
                    type="password" id="password" name="password"
                    placeholder="Contraseña"
                    class="${not empty passError ? 'input-error' : ''}"
            />
            <c:if test="${not empty passError}">
                <div class="error-message">${passError}</div>
            </c:if>
        </div>

        <div class="remember">
            <input type="checkbox" id="remember">
            <label for="remember">Recordar contraseña</label>
        </div>

        <button type="submit">Iniciar Sesión</button>

        <div class="captcha">
            <input type="checkbox" id="captcha">
            <label for="captcha">I'm not a robot</label>
        </div>

        <a href="#" class="forgot-password">Olvidaste tu contraseña</a>
    </form>
</div>
</body>
</html>