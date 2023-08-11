function validarCredenciales(username, password) {
    return username === "admin" && password === "1234";
}

function mostrarMensaje(mensaje) {
    alert(mensaje);
}

function ingresarCredenciales() {
    const username = prompt("Ingrese el usuario:");
    const password = prompt("Ingrese la contraseña:");

    if (validarCredenciales(username, password)) {
        mostrarMensaje("Datos ingresados correctamente");
    } else {
        mostrarMensaje("Datos incorrectos. Por favor, inténtalo nuevamente.");
    }
}

ingresarCredenciales();
