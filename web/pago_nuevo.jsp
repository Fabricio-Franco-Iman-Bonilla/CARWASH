<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Cobro de Servicio</title>
    <%@include file="referencias.jsp" %>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .background-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: -1;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: relative;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label {
            margin: 10px 0 0;            
            padding-left: 100px;
            width: 100%;
            text-align: left;
        }
        input, select {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 30%;
        }
        .btn {
            padding: 10px;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }
        .btn-success {
            background-color: #4CAF50;
        }
        .btn-success:hover {
            background-color: #45a049;
        }
        .btn-danger {
            background-color: #f44336;
            text-decoration: none;
            text-align: center;
            padding: 10px;
        }
        .btn-danger:hover {
            background-color: #e53935;
        }
    </style>
    <script>
        function actualizarPrecio() {
            var tipoLavado = document.getElementById("tipoLavado").value;
            var tamaño = document.getElementById("tamano").value;

            var precios = {
                "Basico": { "Sedan": 20, "SuvP": 30, "SuvM": 35, "SuvG": 40 },
                "Premium": { "Sedan": 30, "SuvP": 40, "SuvM": 45, "SuvG": 50 },
                "Deluxe": { "Sedan": 40, "SuvP": 50, "SuvM": 55, "SuvG": 60 },
                "Salon": { "Sedan": 250, "SuvP": 300, "SuvM": 350, "SuvG": 400 },
            };

            var precio = precios[tipoLavado][tamaño];
            document.getElementById("precio").value = precio ? precio : 0;
        }
    </script>
</head>
<body>
    <div class="background-overlay"></div>
    <div class="container">
        <h2>Formulario de Cobro de Servicio</h2><br>
        <form action="ctrlPago" method="post">
            <label for="dni">DNI:</label>
            <input type="text" id="dni" maxlength="8" class="form-control" name="dni" style="width: 30%;" required>

            <label for="nombre">Nombre Completo:</label>
            <input type="text" id="nombre" class="form-control" name="nombre" style="width: 30%" required>

            <label for="placa">Placa:</label>
            <input type="text" id="placa" class="form-control" name="placa" style="width: 30%" required>

            <label for="tipoLavado">Tipo Lavado:</label>
            <select id="tipoLavado" class="form-control" name="tipoLavado" style="width: 30%;" onchange="actualizarPrecio()" required>
                <option value="Basico">Básico</option>
                <option value="Premium">Premium</option>
                <option value="Deluxe">Deluxe</option>
                <option value="Salon">Salón</option>
            </select>

            <label for="tamano">Tamaño de Auto:</label>
            <select id="tamano" class="form-control" name="tamano" style="width: 30%;" onchange="actualizarPrecio()" required>
                <option value="Sedan">Sedan / hatch</option>
                <option value="SuvP">SUV PEQUEÑO</option>
                <option value="SuvM">SUV 2 FILAS</option>
                <option value="SuvG">SUV 3 FILAS</option>
            </select>

            <label for="precio">Precio:</label>
            <input type="text" id="precio" class="form-control" name="precio" style="width: 30%" required readonly>
            <br>
            <input type="hidden" name="pagina" value="pago_nuevo">
            <input type="submit" class="btn btn-info" value="Aceptar">
            <input type="hidden" name="csrfToken" value="<%= session.getAttribute("csrfToken") %>">
            <a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-danger" style="width: 270px">Cancelar</a>
        </form>
    </div>
</body>
</html>
