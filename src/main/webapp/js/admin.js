var email = new URL(location.href).searchParams.get("email");
var user;

$(document).ready(function () {
    
     $("#agregar-btn").attr("href", `agregar.html?email=${email}`);
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
        
    });
    getUsuario().then(function () {
        getProductos(false, "ASC");

        $("#ordenar-categoria").click(ordenarProductos);
    });
      
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            email: email
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}

function getProductos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoListarAdmin",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarProductos(parsedResult);
            } else {
                console.log("Error recuperando los datos de las peliculas");
            }
        }
    });
}
function mostrarProductos(productos) {
    
    let contenido = '';

    $.each(productos, function (index, producto) {

        producto = JSON.parse(producto);


        contenido += '<tr><th scope="row">' + producto.id_producto + '</th>' +
                '<td>' + producto.producto+ '</td>' +
                '<td>' + producto.categoria + '</td>' +
                '<td>' + producto.precio + '</td>' +
                '<td>' + producto.stock + '</td>' +
                '<td>' + producto.descripcion + '</td>' +
                '<td>' + producto.imagenPath + '</td>' +
                '<td><button onclick="opcionesProducto(' + producto.id_producto +  ');" class="btn btn-success">Editar</button></td></tr>'     
    });
    $("#productos-tbody").html(contenido);

}
function opcionesProducto(id_producto){
    let id = id_producto;
    document.location.href = "producto.html?id=" + id +"&email="+email;
}

function ordenarProductos() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getProductos(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getProductos(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getProductos(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}