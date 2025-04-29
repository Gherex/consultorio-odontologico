<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <h1>Alta Pacientes</h1>
    <p class="mb-3">Este es el apartado para dar de alta los diferentes pacientes del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="/admin/pacientes/crear" method="POST">
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
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="tieneObraSocial" name="tieneObraSocial"
                        placeholder="Tiene Obra Social">
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre"
                        placeholder="Tipo de Sangre">
                </div>
            </div>
            <div class="form-group">
                <input type="email" class="form-control form-control-user" id="responsable" name="responsable"
                    placeholder="Responsable">
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Crear Paciente
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>