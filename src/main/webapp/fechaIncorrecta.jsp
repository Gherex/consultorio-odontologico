<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gherex.logic.Turno" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Fecha incorrecta.</h1>
    <p class="mb-3">Este es el apartado para dar de alta los turnos del sistema.</p>

    <div class="container pt-4 w-50" style="min-height: 500px;">
        <div class="form-group row">
            <div class="col-sm-6">
               <p><span style="color: darkred; font-weight: bold;">Error!</span> Seleccione una fecha válida.</p>
               <button class="btn btn-primary btn-user btn-block mt-4" href="/admin/turnos/crear"> Volver </button>
            </div>
        </div>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>