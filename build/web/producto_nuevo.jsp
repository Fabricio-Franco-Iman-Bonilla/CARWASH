<form action="ctrlProducto" method="post" class="p-4 border rounded" style="max-width: 500px; margin: auto;" onsubmit="return validarFormulario()">
    <div class="mb-3">
        <label for="id" class="form-label">Código</label>
        <input type="text" class="form-control" id="id" name="id" required>
    </div>
    <div class="mb-3">
        <label for="idProveedor" class="form-label">Código de Proveedor</label>
        <input type="text" class="form-control" id="idProveedor" name="idProveedor" required>
    </div>
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" name="nombre" required pattern="^[A-Za-zÀ-ÿ\s]+$" title="Solo se permiten letras y espacios">
    </div>
    <div class="mb-3">
        <label for="descripcion" class="form-label">Descripción</label>
        <input type="text" class="form-control" id="descripcion" name="descripcion" required>
    </div>
    <div class="mb-3">
        <label for="cantidad" class="form-label">Cantidad</label>
        <input type="number" class="form-control" id="cantidad" name="cantidad" required min="1" title="La cantidad debe ser al menos 1">
    </div>
    <input type="hidden" name="pagina" value="producto_nuevo">
    <div class="d-flex justify-content-between">
        <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
        <button type="submit" class="btn btn-success">Aceptar</button>
    </div>
</form>
<script>
    function validarFormulario() {
        const nombre = document.getElementById("nombre").value;
        const cantidad = document.getElementById("cantidad").value;
        // Validar que el nombre solo contenga letras y espacios
        const nombreRegex = /^[A-Za-zÀ-ÿ\s]+$/;
        if (!nombreRegex.test(nombre)) {
            alert("El nombre solo debe contener letras y espacios.");
            return false;
        }
        // Validar que la cantidad sea al menos 1
        if (parseInt(cantidad) < 1) {
            alert("La cantidad debe ser al menos 1.");
            return false;
        }
        return true;
    }
</script>
