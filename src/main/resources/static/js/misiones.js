    var contextPath = "/ubicacion/misiones"; // Ruta de donde se obtienen los datos...

    /* --------- BUSCAR LOCALIDADES DE MISIONES --------- */
    $('#provincia').change(function() {
        $.getJSON(contextPath, {
            idProvincia: $(this).val(),
            misiones: true,
            ajax: 'true'
        }, function(data) {
            var html = '<option value="">--Seleccione una Ciudad/Localidad--</option>';
            var len = data.length;
            for (var i = 0; i < len; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].nombre + '</option>';
            }
            $('#localidad').html(html);
        });
    });