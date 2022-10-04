var email = '';
var email = new URL(location.href).searchParams.get("email");
var user;
const tbody = document.querySelector('.tbody')
$(document).ready(function(){
    getProductos(false, "ASC");   
    getUsuario().then(function () {
        
        
        
        $("#user-nav").html(user.nombre);
        $("#pills-home-tab").addClass("d-none");
        
        

        
    });
});

let carrito = []




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
function getProductos() {
   
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoListar",
        
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarProductos(parsedResult);
            } else {
                console.log("Error recuperando los datos de las productos");
            }
        }
    });
}
function mostrarProductos(productos) {

    let contenido = "";

    $.each(productos, function (index, producto) {

        producto = JSON.parse(producto);
        

        if (producto.stock > 0) {
            
            
            contenido += '<div class="col d-flex justify-content-center mb-4">' +
                    '<div class="card shadow mb-1 bg-dark rounded" style="width: 20rem;">' +
                    '<h5 class="card-title pt-2 text-center text-light">'+ producto.producto +'</h5>' +
                    '<img src="'+producto.imagenPath +'" class="card-img-top" alt="...">' +
                    '<div class="card-body">' +
                    '<ul class="text-light">' +
                    '<li>'+producto.descripcion+'</li>'+
                    '<li>'+producto.stock+' Unidades Disponibles</li>'+
                    '</ul>'+
                    '<h5 class="text-warning">Precio: <span class="precio">$ '+ producto.precio +'</span></h5>' +
                    '<div class="d-grid gap-2">' +
                    '<button onclick="addToCarritoItem('+producto.id_producto+',String(`'+producto.producto+'`),'+producto.precio+','+producto.stock+',String(`'+producto.imagenPath+'`));"  class="btn btn-warning button" ">Agregar al carrito</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
            

        }
    });
    $("#productos-div").html(contenido);
}

function comprar() {
    let ids = [];
    let cantidades = [];
    if(email===''){
        document.location.href = "login.html";
    }
    for(let i =0; i < carrito.length ; i++){
        ids.push(carrito[i]);
        cantidades.push(carrito[i]);
    }
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletProductoComprar",
        data: $.param({
            email: carrito,
            ids:ids,
            cantidades:cantidades
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error en la reserva de la película");
            }
        }
    });
}

function addToCarritoItem(id_producto, producto, precio, stock, imagen){
  
  
  const idProducto = id_producto;
  const itemTitle = producto;
  const itemPrice = precio;
  const itemImg = imagen;
  const itemStock = stock;
  const newItem = {
    idProducto : id_producto,  
    title: itemTitle,
    precio: itemPrice,
    stock: stock,
    img: itemImg,
    cantidad: 1
  };

  addItemCarrito(newItem);
}


function addItemCarrito(newItem){

  const alert = document.querySelector('.alert')

  setTimeout( function(){
    alert.classList.add('hide')
  }, 1500)
    alert.classList.remove('hide')

  const InputElemnto = tbody.getElementsByClassName('input__elemento')
  for(let i =0; i < carrito.length ; i++){
    if(carrito[i].title.trim() === newItem.title.trim()){
      if(carrito[i].cantidad >= carrito[i].stock){
          (carrito[i].cantidad = carrito[i].stock); 
      } else{
          carrito[i].cantidad ++;
      }
      const inputValue = InputElemnto[i];
      inputValue.value++;
      CarritoTotal();
      return null;
    }
  }
  
  carrito.push(newItem)
  
  renderCarrito()
} 


function renderCarrito(){
  tbody.innerHTML = ''
  carrito.map(item => {
    const tr = document.createElement('tr')
    tr.classList.add('ItemCarrito')
    const Content = `
    
    <th scope="row">${item.idProducto}</th>
            <td class="table__productos">
              <img src=${item.img}  alt="">
              <h6 class="title">${item.title}</h6>
            </td>
            <td class="table__price"><p>${item.precio}</p></td>
            <td class="table__cantidad">
              <input type="number" min="1" max="${item.stock}" value=${item.cantidad} class="input__elemento">
              <button class="delete btn btn-danger">x</button>
            </td>
    
    `
    tr.innerHTML = Content;
    tbody.append(tr)

    tr.querySelector(".delete").addEventListener('click', removeItemCarrito)
    tr.querySelector(".input__elemento").addEventListener('change', sumaCantidad)
  })
  CarritoTotal()
}

function CarritoTotal(){
  let Total = 0;
  const itemCartTotal = document.querySelector('.itemCartTotal')
  carrito.forEach((item) => {
    Total = Total + item.precio*item.cantidad
  })

  itemCartTotal.innerHTML = `Total $${Total}`
  addLocalStorage()
}

function removeItemCarrito(e){
  const buttonDelete = e.target
  const tr = buttonDelete.closest(".ItemCarrito")
  const title = tr.querySelector('.title').textContent;
  for(let i=0; i<carrito.length ; i++){

    if(carrito[i].title.trim() === title.trim()){
      carrito.splice(i, 1)
    }
  }

  const alert = document.querySelector('.remove')

  setTimeout( function(){
    alert.classList.add('remove')
  }, 2000)
    alert.classList.remove('remove')

  tr.remove()
  CarritoTotal()
}

function sumaCantidad(e){
  const sumaInput  = e.target
  const tr = sumaInput.closest(".ItemCarrito")
  const title = tr.querySelector('.title').textContent;
  carrito.forEach(item => {
    if(item.title.trim() === title){
      sumaInput.value < 1 ?  (sumaInput.value = 1) : sumaInput.value;
      item.cantidad = sumaInput.value;
      CarritoTotal()
    }
  })
}

function addLocalStorage(){
  localStorage.setItem('carrito', JSON.stringify(carrito))
}

window.onload = function(){
  const storage = JSON.parse(localStorage.getItem('carrito'));
  if(storage){
    carrito = storage;
    renderCarrito()
  }
}

