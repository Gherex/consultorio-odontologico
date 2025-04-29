<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>

    <h1>Alta Odontólogos</h1>
    <p class="mb-3">Este es el apartado para dar de alta los diferentes odontólogos del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="admin/odontologos/crear" method="POST">
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                        placeholder="Nombre">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                        placeholder="Apellido">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                        placeholder="DNI">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                        placeholder="Teléfono">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                        placeholder="Dirección">
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac"
                        placeholder="Fecha de nacimiento">
                </div>
            </div>
            <div class="form-group">
                <input type="email" class="form-control form-control-user" id="especialidad" name="especialidad"
                    placeholder="Especialidad">
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="usuario" name="usuario"
                        placeholder="Usuario">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="horario" name="horario"
                        placeholder="Horario">
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Crear Odontólogo
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
