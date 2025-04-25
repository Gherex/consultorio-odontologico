<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <h1>Alta Odontólogos</h1>
    <p class="mb-3">Este es el apartado para dar de alta los diferentes odontólogos del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user">
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido"
                        placeholder="Apellido">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni"
                        placeholder="DNI">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono"
                        placeholder="Teléfono">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion"
                        placeholder="Dirección">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="fechaNac"
                        placeholder="Fecha de nacimiento">
                </div>
            </div>
            <div class="form-group">
                <input type="email" class="form-control form-control-user" id="especialidad"
                    placeholder="Especialidad">
            </div>

            <a href="" class="btn btn-primary btn-user btn-block">
                Crear Odontólogo
            </a>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>
