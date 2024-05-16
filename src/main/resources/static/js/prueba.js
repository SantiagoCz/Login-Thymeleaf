// Define la función para alternar el estado del botoncito
function alternarEstado() {
    var labelDisciplina = document.getElementById("labelDisciplina");
    var labelGrado = document.getElementById("labelGrado");
    var boton = document.getElementById("botonArtista");

    if (labelDisciplina.style.display === "none") {
        labelDisciplina.style.display = "block";
        labelGrado.style.display = "block";
        boton.textContent = "No soy artista marcial";

        // Cargar todas las disciplinas al presionar el botón "Soy artista marcial"
        var contextPathDisciplinas = "/disciplinas";
        $.getJSON(contextPathDisciplinas, { ajax: 'true' })
            .done(function(data) {
                var html = '<option value="">--Seleccione una disciplina--</option>';
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].nombre + '</option>';
                }
                $('#disciplina').html(html);
            })
            .fail(function(jqXHR, textStatus, errorThrown) {
                console.error("Error al cargar las disciplinas:", textStatus, errorThrown);
            });

        // Agregar la opción "--Seleccione un Grado--" al select de grados
        $('#grado').html('<option value="">--Seleccione un Grado--</option>');
    } else {
        labelDisciplina.style.display = "none";
        labelGrado.style.display = "none";
        boton.textContent = "Soy artista marcial";
    }
}


// cargamo los grados segun la disciplina seleccionada
$('#disciplina').change(function() {
    // Verificar si se seleccionó una disciplina válida
    var disciplinaSeleccionada = $(this).val();
    if (!disciplinaSeleccionada || disciplinaSeleccionada === "0") {
        console.log("No se ha seleccionado una disciplina válida.");
        return; // No se ejecuta el bloque de carga de grados
    }

    // Si se selecciono una disciplina, continua con la carga de grados
    var contextPathGrados = "/grados"; // <-- ruta para cargar los grados
    $.getJSON(contextPathGrados, {
        idDisciplina: disciplinaSeleccionada,
        ajax: 'true'
    })
    .done(function(data) {
        var html = '<option value="">--Seleccione un Grado--</option>';
        var len = data.length;
        for (var i = 0; i < len; i++) {
            html += '<option value="' + data[i].id + '">' + data[i].grado + '</option>';
        }
        $('#grado').html(html);
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        console.error("Error al cargar los grados:", textStatus, errorThrown);
    });
});


// Restablecer el select de grado cuando se selecciona "--Seleccione una disciplina--"
$('#disciplina').change(function() {
    if ($(this).val() === "") {
        $('#grado').html('<option value="">--Seleccione un Grado--</option>');
    }
});
