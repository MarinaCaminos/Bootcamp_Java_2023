
function  puntoDeEquilibrio() {
    var costosFijos = window.prompt("Igrese los costos fijos");
    var precioDeVenta = window.prompt("Ingrese el precio de venta del producto ");
    var costosVariables = window.prompt("Ingrese los costos variables");

    var puntoDeEquilibrio = costosFijos / (precioDeVenta - costosVariables);
    alert('El punto de equilibrio es: ' + puntoDeEquilibrio);
}

puntoDeEquilibrio();