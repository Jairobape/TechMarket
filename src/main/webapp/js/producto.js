var email = new URL(location.href).searchParams.get("email");
var idProducto = new URL(location.href).searchParams.get("id");
var user;

$(document).ready(function () {


    fillProducto()

    $("#regresar-btn").attr("href", `admin.html?username=${email}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarProducto();
    });
    
    $("#form-agregar").on("submit", function (event) {

        event.preventDefault();
        agregarProducto();
    });
    
    $("#aceptar-eliminar-producto-btn").click(function () {

        eliminarProducto().then(function () {
            document.location.href = "admin.html?email=" + email;
        })
    })

});

async function fillProducto() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoPedir",
        data: $.param({
            idProducto: idProducto,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-producto").val(parsedResult.producto);
                $("#input-categoria").val(parsedResult.categoria);
                $("#input-precio").val(parsedResult.precio.toFixed(2));
                $("#input-stock").val(parsedResult.stock);
                $("#input-descripcion").val(parsedResult.descripcion);
                $("#input-imagen").val(parsedResult.imagenPath);

            } else {
                console.log("Error recuperando los datos del producto");
            }
        }
    });
}

function modificarProducto() {

    let producto = $("#input-producto").val();
    let categoria = $("#input-categoria").val();
    let precio = $("#input-precio").val();
    let stock = $("#input-stock").val();
    let descripcion = $("#input-descripcion").val();
    let imagen = $("#input-imagen").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoModificar",
        data: $.param({
            id:idProducto,
            producto: producto,
            categoria: categoria,
            precio: precio,
            stock: stock,
            descripcion: descripcion,
            imagen: imagen
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}
function agregarProducto() {

    let producto = $("#input-producto").val();
    let categoria = $("#input-categoria").val();
    let precio = $("#input-precio").val();
    let stock = $("#input-stock").val();
    let descripcion = $("#input-descripcion").val();
    let imagen = $("#input-imagen").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoAgregarProducto",
        data: $.param({
            id:idProducto,
            producto: producto,
            categoria: categoria,
            precio: precio,
            stock: stock,
            descripcion: descripcion,
            imagen: imagen
        }),
        success: function (result) {
            if (result != false) {
                $("#agregar-error").addClass("d-none");
                $("#agregar-exito").removeClass("d-none");
            } else {
                $("#agregar-error").removeClass("d-none");
                $("#agregar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);
            

        }
    });

}
async function eliminarProducto() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoEliminar",
        data: $.param({
            id: idProducto
        }),
        success: function (result) {

            if (result != false) {

                console.log("Producto eliminado")

            } else {
                console.log("Error eliminando el producto");
            }
        }
    });
}