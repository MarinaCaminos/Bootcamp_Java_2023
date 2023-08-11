
function validarEdad(edad) {
    return edad >= 18; 
}

function mostrarMensaje(mensaje) {
    alert(mensaje);
}

function ingresarEdad() {
    const edad = prompt("Ingrese su edad:");

    if (isNaN(edad)) {
        mostrarMensaje("Por favor, ingrese un valor numérico.");
    } else {
        if (validarEdad(Number(edad))) {
            mostrarMensaje("Eres mayor de edad. Bienvenido.");
        } else {
            mostrarMensaje("Debes ser mayor de edad para ingresar.");
        }
    }
}

ingresarEdad();
