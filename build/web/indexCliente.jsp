<%-- 
    Document   : indexCliente
    Created on : 27/06/2024, 3:26:03 p. m.
    Author     : MIKI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAGINA CITAS</title>
        <%@include file="referencias.jsp" %>
        <link rel="stylesheet" href="estilos/indexCliente.css">
        <link rel="stylesheet" href="estilos/indexCliente.js">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .navbar {
                background-color: #333;
                color: white;
                padding: 10px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .navbar h1 {
                margin: 0;
            }
            .navbar button {
                background-color: #28a745;
                color: white;
                border: none;
                padding: 10px 15px;
                border-radius: 4px;
                cursor: pointer;
            }
            .navbar button:hover {
                background-color: #218838;
            }
            .hero {
                background: url('https://via.placeholder.com/1200x600') no-repeat center center/cover;
                height: 80vh;
                display: flex;
                justify-content: center;
                align-items: center;
                color: white;
                text-align: center;
            }
            .hero h2 {
                font-size: 3em;
                margin: 0;
            }
            .content {
                padding: 20px;
            }
            .content h3 {
                margin-top: 0;
            }
            .content p {
                line-height: 1.6;
            }
            #contact {
                position: relative;
                color: white;
                padding: 50px 20px;
                text-align: center;
                margin-top: auto;
                overflow: hidden; /* Para asegurar que los elementos no se desborden */
            }

            .contact-overlay {
                position: relative;
                z-index: 1; /* Coloca este contenido encima de la imagen de fondo */
            }

            .background-image {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                object-fit: cover;
                z-index: -1;
            }

            .contact-methods {
                display: flex;
                justify-content: center;
                gap: 20px;
                margin-top: 20px;
            }

            .contact-methods a {
                display: inline-block;
            }

            .contact-methods img {
                height: 50px;
            }

        </style>
    </head>   
    <body>
        <header>
            <nav>
                <div class="logo">
                    <img src="imagenes/logo.png" alt="Mr. Moon">
                </div>
                <ul class="nav justify-content-center">
                    <ul class="navn">

                        <li class="nav-item">
                            <a href="#contact" class="nav-link">Contáctenos</a>
                        </li>
                    </ul>
                    <li class="nav-item">
                        <a class="btn inicio-sesion-btn" href="login.jsp">Inicia Sesion</a>
                    </li>
                </ul>
            </nav>
        </header>
        <section class="main-image">
        <img src="imagenes/Baner.jpg" alt="Banner" width="100%">
    </section>

    <section class="hero" >
        <div class="services" style="background-color: #33B3FF;">
            <div class="service">
                <img src="imagenes/LavadoExterior.png" alt="Limpieza Exterior">
                <p style="color: black;">Lavado Exterior</p>
            </div>
            <div class="service">
                <img src="imagenes/LimpiezaExterna.png" alt="Limpieza Extensa">
                <p style="color: black;">Limpieza Extensa</p>
            </div>
            <div class="service">
                <img src="imagenes/EquipoModerno.png" alt="Equipo Moderno">
                <p style="color: black;">Equipo Moderno</p>
            </div>
            <div class="service">
                <img src="imagenes/Materiales.png" alt="Materiales de Calidad">
                <p style="color: black;">Materiales de Calidad</p>
            </div>
        </div>
    </section> 
    </body>

    <img src="imagenes/linea_separacion.png" width="100%">

    <body>
        <h1>Precios Asequibles</h1>
        <div class="vehicle-options">
            <div class="vehicle-option" onclick="changePrices('sedan')">
                <img src="imagenes/sedan.png" alt="Sedan/Hatch" class="vehicle-image">
                <p>Sedan/Hatch</p>
            </div>
            <div class="vehicle-option" onclick="changePrices('suv-small')">
                <img src="imagenes/SUV_Pequeña.png" alt="SUV Pequeño" class="vehicle-image">
                <p>SUV Pequeño</p>
            </div>
            <div class="vehicle-option" onclick="changePrices('suv-medium')">
                <img src="imagenes/SUV_Mediana.png" alt="SUV Mediana 2 filas" class="vehicle-image">
                <p>SUV Mediana 2 filas</p>
            </div>
            <div class="vehicle-option" onclick="changePrices('suv-large')">
                <img src="imagenes/SUV_Grande.png" alt="SUV Grande 3 filas" class="vehicle-image">
                <p>SUV Grande 3 filas</p>
            </div>
            <!--<div class="vehicle-option" onclick="changePrices('moto')">
                <img src="imagenes/motocicleta.png" alt="Moto" class="vehicle-image">
                <p>Moto</p>
            </div>-->
        </div>
        <div class="pricing-container">
            <div class="card">
                <h3>BASICO</h3>
                <p>S/ <span id="price-standard">30.00</span></p>
                <ul>
                    <li><img src="imagenes/check.png" width="5%"> Sedan/Hatchback</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv Pequeña</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 2 Filas</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 3 filas</li>
                </ul>
                <!--<a href="#">Reservar</a>-->
            </div>
            <div class="card">
                <h3>PREMIUM</h3>
                <p>S/ <span id="price-basic">40.00</span></p>
                <ul>
                    <li><img src="imagenes/check.png" width="5%"> Sedan/Hatchback</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv Pequeña</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 2 Filas</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 3 filas</li>
                </ul>
                <!-- <a href="#">Reservar</a> -->
            </div>
            <div class="card">
                <h3>DELUXE</h3>
                <p>S/ <span id="price-management">50.00</span></p>
                <ul>
                    <li><img src="imagenes/check.png" width="5%"> Sedan/Hatchback</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv Pequeña</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 2 Filas</li>
                    <li><img src="imagenes/check.png" width="5%"> Suv 3 filas</li>
                </ul>
                <!--<a href="#">Reservar</a>-->
            </div>
            <div class="card">
                <h3>SALÓN</h3>
                <p>S/ <span id="price-salon">250.00</span></p>
                <ul>
                    <li><img src="imagenes/check.png" width=2%"> Sedan/Hatchback</li>
                    <li><img src="imagenes/check.png" width="2%"> Suv Pequeña</li>
                    <li><img src="imagenes/check.png" width="2%"> Suv 2 Filas</li>
                    <li><img src="imagenes/check.png" width="2%"> Suv 3 filas</li>
                </ul>
                <!--<a href="#">Reservar</a>-->
            </div>
        </div>
    </body>

    <script>
        function changePrices(vehicle) {
            let prices = {
                sedan: {standard: 20, basic: 30, management: 40, salon: 250},
                'suv-small': {standard: 25, basic: 35, management: 45, salon: 270},
                'suv-medium': {standard: 30, basic: 40, management: 50, salon: 290},
                'suv-large': {standard: 35, basic: 45, management: 55, salon: 310},
                moto: {standard: 15, basic: 25, management: 35, salon: 150},
            };

            document.getElementById('price-standard').textContent = prices[vehicle].standard.toFixed(2);
            document.getElementById('price-basic').textContent = prices[vehicle].basic.toFixed(2);
            document.getElementById('price-management').textContent = prices[vehicle].management.toFixed(2);
            document.getElementById('price-salon').textContent = prices[vehicle].salon.toFixed(2);
        }
    </script>
</body>

</html>

<div class="why-us">
    <div class="content-wrapper">
        <div class="image-section">
            <img src="imagenes/foto_2.png" class="feature-image">
        </div>
        <div class="text-section">
            <h2>¿POR QUÉ ELEGIRNOS?</h2>
            <h3>¿Por qué somos los mejores para lavar su automóvil?</h3>
            <div class="features">
                <div class="feature">
                    <div class="icon">
                        <div class="circle"></div>
                    </div>
                    <div class="feature-text">
                        <h4>Equipo moderno</h4>
                        <p>Utilizamos los equipos más modernos para garantizar la mejor limpieza.</p>
                    </div>
                </div>
                <div class="feature">
                    <div class="icon">
                        <div class="circle"></div>
                    </div>
                    <div class="feature-text">
                        <h4>Servicio Garantizado</h4>
                        <p>Ofrecemos garantía de satisfacción en todos nuestros servicios.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<img src="imagenes/linea_separacion.png" width="100%">

<div class="feature-section">
    <div class="feature-image">
        <img src="imagenes/foto_1.png" style="max-width: 100%; height: auto;">
    </div>
    <div class="feature-content">
        <h3>Equipo Moderno Usado</h3>
        <h1>Lavado Profesional y Limpieza de tu Coche</h1>
        <p>Descripción sobre el lavado profesional y la limpieza de coches. Aseguramos la mejor calidad y
            satisfacción del cliente.</p>
        <div class="feature-icons">
            <div class="icon-text">
                <div class="icon" style="margin-bottom: 10px;">
                    <img src="imagenes/Limpadores Naturales.png" alt="Limpiadores Naturales">
                </div>
                <p>Limpiadores Naturales</p>

                <div class="icon" style="margin-left: 50px;">
                    <img src="imagenes/Clientes_sadis.png" alt="Clientes Felices">
                </div>
                <p>Clientes Felices</p>
            </div>
            <ul class="feature-list">
                <li class="bullet1">Lavadores de coches profesionales</li>
                <li class="bullet2">Garantía de satisfacción de los clientes</li>
            </ul>
        </div>
    </div>
    <div class="feature-image">
        <img src="imagenes/carro.jpg" width="90%">
    </div>
</div>

<section id="contact" class="contact">
    <div class="contact-overlay">
        <h2>Contactanos</h2>
        <div class="contact-methods">
            <a href="#"><img src="imagenes/whatsapp.png" alt="WhatsApp"></a>
            <a href="#"><img src="imagenes/instagram.png" alt="Instagram"></a>
            <a href="#"><img src="imagenes/facebook.png" alt="Facebook"></a>
            <a href="#"><img src="imagenes/twitter.png" alt="Twitter"></a>
        </div>
        <p>&copy; 2024 Mr. Moon Car Wash. Todos los derechos reservados.</p>
    </div>
    <img src="imagenes/footer.jpg" width="2472" height="1247" alt="Banner1" class="background-image">
</section>

</body>
