$(document).ready(function () {

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });

   

});

function registrarUsuario() {

    let email = $("#input-email").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellido = $('#input-apellido').val();
    
    if(contrasena===contrasenaConfirmacion){
    
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                email: email,
                contrasena: contrasena,
                nombre: nombre,
                apellido: apellido
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let email = parsedResult['email'];
                    document.location.href = "home.html?email=" + email;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("error en el registro de usuario");
                }
            }
        });
    }else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}
