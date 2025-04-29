<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="components/header.jsp"%>
    <%@include file="components/wrapper-top-content.jsp"%>
    <h1>Alta Usuarios</h1>
    <p class="mb-3">Este es el apartado para dar de alta los diferentes usuarios del sistema.</p>

    <div class="container pt-4 w-50">
        <form class="user" action="admin/usuarios/crear" method="POST">
            <div class="form-group">

                <div class="col-sm-12 mb-3">
                    <input type="text" class="form-control form-control-user" id="usuario" name="usuario"
                        placeholder="Usuario">
                </div>

                <div class="col-sm-12 mb-3">
                    <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                        placeholder="Contraseña">
                </div>

                <div class="col-sm-12 mb-3">
                    <input type="text" class="form-control form-control-user" id="rol" name="rol"
                        placeholder="Rol">
                </div>
            </div>

            <button class="btn btn-primary btn-user btn-block mt-4" type="submit">
                Crear Usuario
            </button>

        </form>
    </div>
    <%@include file="components/wrapper-bottom-content.jsp"%>
</html>
