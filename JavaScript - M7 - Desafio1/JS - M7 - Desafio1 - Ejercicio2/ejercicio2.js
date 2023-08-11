
function presupestoPersonal() {
    var ingresoTotal = number(prompt('Introduzca el ingreso total'));

    var gastosNecesarios = ingresoTotal / 2;
    var gastosOpcionales = ingresoTotal * 0.3;
    var ahorroEInversion = ingresoTotal * 0.2;

    alert('El presupuesto es: ' + '\n' + 
        'Monto para gastos necesarios: ' + gastosNecesarios + '\n' +
        'Monto para gastos opcionales: ' + gastosOpcionales + '\n' + 
        'Monto para ahorro e inversion: ' + ahorroEInversion);
}


presupestoPersonal();