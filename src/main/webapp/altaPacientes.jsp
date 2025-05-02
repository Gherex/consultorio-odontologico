<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                        placeholder="Nombre" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                        placeholder="Apellido" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                        placeholder="DNI" required>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                        placeholder="Teléfono" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                        placeholder="Dirección" required>
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control form-control-user" id="fechaNac" name="fechaNac"
                        placeholder="Fecha de nacimiento" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                    <label for="tieneObraSocial" class="form-label" style="margin-left:10px;">¿Tiene Obra Social?</label>
                    <select class="form-control form-control-user" id="tieneObraSocial" name="tieneObraSocial" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <option value="true">Sí</option>
                        <option value="false">No</option>
                    </select>
                </div>
                <div class="col-sm-6">
                    <label for="tipoSangre" class="form-label" style="margin-left:10px;">Tipo de Sangre: </label>
                    <select type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre" required>
                        <option value="" disabled selected>-- Seleccionar --</option>
                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                    </select>
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Crear Paciente
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>