/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var proveedores;
var proveedorActual;


function getAllProveedores() {
    $.ajax(
            {
                type: 'GET',
                async: true,
                url: 'api/proveedor/getAll'
            }
    ).done(function(data)
            {

                    proveedores = data;
                    var str = '';
                    for (var i = 0; i < proveedores.length; i++) {
                        str += '<tr>' +
                                
                                '<td>' + proveedores[i].nombreContacto + '</td>' +
                                '<td>' + proveedores[i].nombreEmpresa + '</td>' +
                                '<td>' + proveedores[i].telefonoContacto + '</td>' +
                                '<td>' + proveedores[i].direccion + '</td>' +
                                '<td>' + proveedores[i].correoElectronico + '</td>' +
                                '<td>' + proveedores[i].paginaWeb + '</td>' +

                                '<td><button onclick="selectProveedor(' + i + ');"'+
                                ' class="btn btn-info btn-rounded" data-toggle="modal" data-target="#modalRegisterForm"><i class="fas fa-info-circle"></i></button>'+'</td>' +
                                
                                '</tr>';    
                    }
                    $('#tblProveedor').html(str);
                    buildTableData();
            });
}

function insertProveedores() {
    
        var nomContacto = $('#txtContacto').val();
        var nomEmpresa = $('#txtEmpresa').val();
        var telContacto = $('#txtTelefono').val();
        var direccion = $('#txtDireccion').val();
        var email = $('#txtEmail').val();
        var web = $('#txtWeb').val();
        
        var  datos = {
            nomContacto : nomContacto,
            nomEmpresa : nomEmpresa,
            telContacto : telContacto,
            direccion : direccion,
            email : email,
            paginaWeb : web
            
          };
          
        $.ajax(
                {
                    type: 'POST',
                    async: true,
                    url: 'api/proveedor/insert',
                    data : datos
                }
        ).done(function(data)
                {
                   if (data.result === 'error') {

                            Swal.fire({
                                type: 'error',
                                title: 'No puedes acceder',
                                text:  'Tienes el acceso restringido, inicia sesión de nuevo',
                                showConfirmButton: true
                            });


                     }else{

                          Swal.fire({
                                    type: 'success',
                                    title: 'Movimiento realizado',
                                    text:  'Proveedor guardado con éxito',
                                    showConfirmButton: false,
                                    timer : 1500
                                });

                          getAllProveedores();
                     }

                });
}

function updateProveedor(){
    
        var nomContacto = $('#txtContacto').val();
        var nomEmpresa = $('#txtEmpresa').val();
        var telContacto = $('#txtTelefono').val();
        var direccion = $('#txtDireccion').val();
        var email = $('#txtEmail').val();
        var web = $('#txtWeb').val();
        var id = $('#idProveedor').val();
        
        var  datos = {
            nomContacto : nomContacto,
            nomEmpresa : nomEmpresa,
            telContacto : telContacto,
            direccion : direccion,
            email : email,
            paginaWeb : web,
            idProveedor : id
            
          };
          
        $.ajax(
                {
                    type: 'POST',
                    async: true,
                    url: 'api/proveedor/update',
                    data : datos
                }
        ).done(function(data)
                {
                   if (data.result === 'error') {

                            Swal.fire({
                                type: 'error',
                                title: 'No puedes acceder',
                                text:  'Tienes el acceso restringido, inicia sesión de nuevo',
                                showConfirmButton: true
                            });


                     }else{

                          Swal.fire({
                                    type: 'success',
                                    title: 'Movimiento realizado',
                                    text:  'Proveedor actualizadó con éxito',
                                    showConfirmButton: false,
                                    timer : 1500
                                });

                          getAllProveedores();
                     }

                });
}

function deleteProveedor(){
    
        var id = $('#idProveedor').val();
        
        var  datos = {
           
            id : id
          };
          
        $.ajax(
                {
                    type: 'POST',
                    async: true,
                    url: 'api/proveedor/delete',
                    data : datos
                }
        ).done(function(data)
                {
                   if (data.result === 'error') {

                            Swal.fire({
                                type: 'error',
                                title: 'No puedes acceder',
                                text:  'Tienes el acceso restringido, inicia sesión de nuevo',
                                showConfirmButton: true
                            });


                     }else{

                          Swal.fire({
                                    type: 'success',
                                    title: 'Movimiento realizado',
                                    text:  'Proveedor eliminado con éxito',
                                    showConfirmButton: false,
                                    timer : 1500
                                });

                          getAllProveedores();
                     }

                });
}

function buildTableData(){
    
    $(document).ready(function () {
            $('#dtBasicExample-1').DataTable();
            $('.dataTables_length').addClass('bs-select');
         });
         
}

function selectProveedor(posicion){
    
    if (posicion >= 0 && proveedores !== null && proveedores[posicion] !== null) {
        
        $('#tituloModal').html('Modicar Proveedor');
        var src = '<div class="md-form mb-5">'+
                    '<i class="fas fa-user prefix grey-text"></i>'+
                    '<input type="text" id="txtContacto" class="form-control validate">'+
                    
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-truck-moving prefix grey-text"></i>'+
                    '<input type="text" id="txtEmpresa" class="form-control validate">'+
                    
                  '</div>'+

                  '<div class="md-form mb-4">'+
                    '<i class="fas fa-phone-volume prefix grey-text"></i>'+
                    '<input type="number" id="txtTelefono" class="form-control validate">'+
                    
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-map-marker-alt prefix grey-text"></i>'+
                    '<input type="text" id="txtDireccion" class="form-control validate">'+
                    
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-envelope-open-text prefix grey-text"></i>'+
                    '<input type="email" id="txtEmail" class="form-control validate">'+
                    
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-server prefix grey-text"></i>'+
                    '<input type="hidden" id="idProveedor">'+
                    '<input type="text" id="txtWeb" class="form-control validate">'+
                    
                  '</div>';
        $('#modalModificacion').html(src);
        
        var btns = '<button class="btn btn-success btn-rounded" onclick="updateProveedor()"'+
                        'class="close" data-dismiss="modal" aria-label="Close">'+
                    '<i class="fas fa-edit"></i> '+
                    'Modificar'+
                '</button>'+
                 '<button class="btn btn-danger btn-rounded" onclick="deleteProveedor()"'+
                        'class="close" data-dismiss="modal" aria-label="Close">'+
                    '<i class="fas fa-trash-alt"></i> '+
                    'Eliminar'+
                '</button>';
        
        
        $('#btnAccion').html(btns);
        
        
        
        
        proveedorActual = proveedores[posicion];
        $('#txtContacto').val(proveedorActual.nombreContacto);
        $('#txtEmpresa').val(proveedorActual.nombreEmpresa);
        $('#txtTelefono').val(proveedorActual.telefonoContacto);
        $('#txtDireccion').val(proveedorActual.direccion);
        $('#txtEmail').val(proveedorActual.correoElectronico);
        $('#txtWeb').val(proveedorActual.paginaWeb);
        $('#idProveedor').val(proveedorActual.idProveedor);
        
    }
}

function clearFields(){
        $('#tituloModal').html('Agregar Proveedor');
        var src = '<div class="md-form mb-5">'+
                    '<i class="fas fa-user prefix grey-text"></i>'+
                    '<input type="text" id="txtContacto" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Contacto:</label>'+
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-truck-moving prefix grey-text"></i>'+
                    '<input type="text" id="txtEmpresa" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Empresa:</label>'+
                  '</div>'+

                  '<div class="md-form mb-4">'+
                    '<i class="fas fa-phone-volume prefix grey-text"></i>'+
                    '<input type="number" id="txtTelefono" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Telefono:</label>'+
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-map-marker-alt prefix grey-text"></i>'+
                    '<input type="text" id="txtDireccion" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Dirección:</label>'+
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-envelope-open-text prefix grey-text"></i>'+
                    '<input type="email" id="txtEmail" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Correo electrónico:</label>'+
                  '</div>'+

                  '<div class="md-form mb-5">'+
                    '<i class="fas fa-server prefix grey-text"></i>'+
                    '<input type="hidden" id="idProveedor">'+
                    '<input type="text" id="txtWeb" class="form-control validate">'+
                    '<label data-error="Datos incorrectos" data-success="Correcto" for="orangeForm-name">Paginá Web:</label>'+
                  '</div>';
        $('#modalModificacion').html(src);
        
        var btns = '<button class="btn btn-info btn-rounded" onclick="insertProveedores()"'+
                        'class="close" data-dismiss="modal" aria-label="Close">'+
                    '<i class="fas fa-save"></i> '+
                    'Guardar'+
                '</button>';
        
        
        $('#btnAccion').html(btns);
        
        
        
}

