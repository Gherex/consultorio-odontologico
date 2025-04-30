<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a draggable="false" class="sidebar-brand d-flex align-items-center justify-content-center" href="/inicio">
        <div class="sidebar-brand-icon rotate-n-15">
            <i draggable="false" class="fas fa-solid fa-teeth-open"></i>
        </div>
        <div draggable="false" class="sidebar-brand-text mx-3">Consultorio Odontológico</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a draggable="false" class="nav-link" href="/inicio">
            <i class="fas fa-solid fa-bars"></i>
            <span>Menú</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Gestión
    </div>

    <!-- Nav Item - Odontólogos Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOdo"
            aria-expanded="true" aria-controls="collapseOdo">
            <i class="fas fa-solid fa-user-tie"></i>
            <span>Odontólogos</span>
        </a>
        <div id="collapseOdo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Acciones:</h6>
                <a class="collapse-item" href="/odontologos">Ver Odontólogos</a>
                <a class="collapse-item" href="/admin/odontologos/crear">Alta Odontólogos</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Secretarios Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSec"
            aria-expanded="true" aria-controls="collapseSec">
            <i class="fas fa-regular fa-address-book"></i>
            <span>Secretarios</span>
        </a>
        <div id="collapseSec" class="collapse" aria-labelledby="headingUtilities"
            data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Acciones:</h6>
                <a class="collapse-item" href="/secretarios">Ver Secretarios</a>
                <a class="collapse-item" href="/admin/secretarios/crear">Alta Secretarios</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Pacientes Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePac"
            aria-expanded="true" aria-controls="collapsePac">
            <i class="fas fa-solid fa-hospital-user"></i>
            <span>Pacientes</span>
        </a>
        <div id="collapsePac" class="collapse" aria-labelledby="headingUtilities"
            data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Acciones:</h6>
                <a class="collapse-item" href="/pacientes">Ver Pacientes</a>
                <a class="collapse-item" href="/admin/pacientes/crear">Alta Pacientes</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Usuarios Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsu"
            aria-expanded="true" aria-controls="collapseUsu">
            <i class="fas fa-solid fa-user-plus"></i>
            <span>Usuarios</span>
        </a>
        <div id="collapseUsu" class="collapse" aria-labelledby="headingUtilities"
            data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Acciones:</h6>
                <a class="collapse-item" href="/usuarios">Ver Usuarios</a>
                <a class="collapse-item" href="/admin/usuarios/crear">Alta Usuarios</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

    <!-- Sidebar Message -->
    <div class="sidebar-card d-none d-lg-flex">
        <img draggable="false" class="sidebar-card-illustration mb-2" src="${pageContext.request.contextPath}/img/male-programmer-svgrepo-com.svg" alt="Imagen SVG de un desarrollador">
        <p class="text-center mb-2">Desarrollado por<br><strong>Germán Lagger.</strong></p>
        <a draggable="false" class="btn btn-success btn-sm" href="https://germanlagger.dev.ar">Portfolio</a>
    </div>

</ul>
<!-- End of Sidebar -->