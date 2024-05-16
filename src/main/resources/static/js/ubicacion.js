var contextPathUbicacionProvincias = "/ubicacion/provincias"; // Ruta de donde se obtienen los datos...
var contextPathUbicacionLocalidades = "/ubicacion/localidades"; // Ruta de donde se obtienen los datos...

/* ------- BUSCAR PROVINCIAS SEGUN PAIS SELECCIONADO -------- */
$('#pais').change(function() {
    // Restablece el selector de provincia al seleccionar un país nuevo
    $('#provincia').html('<option value="">--Seleccione una Provincia/Estado--</option>');
    $('#localidad').html('<option value="">--Seleccione una Ciudad/Localidad--</option>');

    $.getJSON(contextPathUbicacionProvincias, {
        idPais: $(this).val(), // Buscamos el id del país dentro de provincias
        ajax: 'true'
    }, function(data) {
        var html = '<option value="">--Seleccione una Provincia/Estado--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            html += '<option value="' + data[i].id + '">' + data[i].nombre + '</option>';
        } // Asignamos los campos
        html += '</option>';
        $('#provincia').html(html);
    });
});

/* --------- BUSCAR LOCALIDADES SEGUN LA PROVINCIA SELECCIONADA --------- */
$('#provincia').change(function() {
    // Restablece el selector de localidad al seleccionar una provincia nueva
    $('#localidad').html('<option value="">--Seleccione una Ciudad/Localidad--</option>');

    $.getJSON(contextPathUbicacionLocalidades, {
        idProvincia: $(this).val(), // Buscamos el id de la provincia dentro de localidades
        ajax: 'true'
    }, function(data) {
        var html = '<option value="">--Seleccione una Ciudad/Localidad--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            html += '<option value="' + data[i].id + '">' + data[i].nombre + '</option>';
        } // Asignamos los campos
        html += '</option>';
        $('#localidad').html(html);
    });
});
