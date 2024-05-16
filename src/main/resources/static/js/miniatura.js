    $(document).ready(function() {
        // Solicitud AJAX para obtener todas las noticias
        $.ajax({
            url: '/noticia/todas', // Ruta de donde se obtienen los datos...
            method: 'GET',
            success: function(data) {
                // Itera sobre cada noticia y agrega una miniatura con el título
                data.forEach(function(noticia) {
                    var miniaturaHtml = '<div class="item">' +
                        '<a href="/' + noticia.id + '">' + // Enlace a la noticia completa va a homeControlador
                        '<img src="imagenes/noticias/' + noticia.foto + '" alt="' + noticia.titulo + '">' +
                        '<p>' + noticia.titulo + '</p>' +
                        '</a>' +
                        '</div>';

                    $('.noticias-miniatura .miniatura').append(miniaturaHtml);
                });
            }
        });
    });