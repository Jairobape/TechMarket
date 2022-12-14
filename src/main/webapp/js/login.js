$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

   

});

function autenticarUsuario() {

    let email = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            email: email,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let email = parsedResult['email'];
                let rol = parsedResult['rol'];
                
                if(rol==='admin'){
                    document.location.href = "admin.html?email=" + email;
                }else{
                    document.location.href = "index.html?email=" + email;
                }
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
 