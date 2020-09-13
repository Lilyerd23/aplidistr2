<%-- 
    Document   : Principal
    Created on : 12 set. 2020, 20:44:59
    Author     : alexandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="img/logo.png">
        <title>CIDECOM</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">
                    <img src="img/SLOGAN.PNG" height="40px">
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Inicio</a>
                        </li>
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Registrar
                            </a>
                            <div class="dropdown-menu bg-dark text-white" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item bg-dark text-white"  href='#'>Productos</a>
                                <a class="dropdown-item bg-dark text-white" href='PostEmpleado'>Empleados</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item bg-dark text-white" href="#">Clientes</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Listar
                            </a>
                            <div class="dropdown-menu bg-dark text-white" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item bg-dark text-white"  href='#'>Productos</a>
                                <a class="dropdown-item bg-dark text-white" href='ListEmpleados'>Empleados</a>
                                <a class="dropdown-item bg-dark text-white" href="#">Clientes</a>
                            </div>
                        </li>
                    </ul>
                    <span class="navbar-text mr-sm-2 rext-white">
                        APLICACIONES DISTRIBUIDAS II
                    </span>
                </div>
            </nav>
        </header>

        <main>
            <div class="bd-example d-none d-md-block">
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active" style="height: 100vh">
                            <img src="img/PR1.jpg" class="d-block" alt="">
                            <div class="carousel-caption text-right text-white-space">
                                <h5 color="red">DE VUELTA AL COLE CON SIDECOM</h5>
                                <p>Ven y encuentra los mejores utiles escolares de calidad y a buen precio</p>
                                <button class="btn btn-primary btn-lg btn-propio">Leer Más</button>
                                <hr>
                            </div>

                        </div>
                        <div class="carousel-item" style="height: 100vh">
                            <img src="img/f2.png" class="d-block" alt="">
                            <div class="carousel-caption text-right">
                            </div>
                        </div>
                        <div class="carousel-item" style="height: 100vh">
                            <img src="img/F3.png" class="d-block" alt="">
                            <div class="carousel-caption text-center">
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>


            <section class="cursos">
                <div class="container">
                    <h1 class="text-center">SIDECOM</h1>
                    <hr>
                    <p class="text-center">La librería SIDECOM tiene un promedio de 18 años funcionando, los productos que venden son muy variados, en la línea de papelería; las hojas bond, espirales y todo lo que se necesitan los locales de servicio de fotocopiado y espiralado, ellos son los abastecedores de esos productos a sus clientes.</p>
                    <div class="row">
                        <div class="col-md-4 col-sm-6">
                            <div class="card" style="width: 100%; background-color: #B2F0D6;">
                                <img src="img/1.png" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">¿Quines Somos?</h5>
                                    <p class="card-text">La empresa SIDECOM IMPORT E.I.R.L se dedica a la venta de útiles escolares para todo tipo de nivel académico, primaria, segundaria, universidad entre otros.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="card" style="width: 100%; background-color:#7a5270;">
                                <img src="img/2.jpeg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Mision</h5>
                                    <p class="card-text">La misión de la empresa es proveer a sus clientes productos académicos de calidad y economicos además de dar un excelente servicio para lograr la aceptación de sus clientes.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <div class="card" style="width: 100%;  background-color:#cc0066;">
                                <img src="img/2.jpg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Vision</h5>
                                    <p class="card-text">Llegar a ser una empresa distribuidora de materiales educativos, además de ser reconocida por la calidad del servicio de atención a sus clientes quedando estos satisfechos.</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>
        </main>
        <hr>
        <footer class="container">
            <img class="float-right" src="img/uns.png"  height="40px">
            <p>&copy; 2020 Libreria SIDECOM
        </footer>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
