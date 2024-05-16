document.addEventListener('DOMContentLoaded', function () {
    var botonMenu = document.getElementById('boton-menu');
    var menu = document.getElementById('menu');
    var scrollbar = document.documentElement.style;

    botonMenu.addEventListener('click', function () {
        // Cambiar el estilo de la barra de desplazamiento al abrir el menú
        scrollbar.overflowY = 'hidden'; // Oculta la barra de desplazamiento vertical
        if (menu.style.right === '0px') {
            document.documentElement.style.opacity = '0';
            setTimeout(() => { scrollbar.overflowY = ''; }, 300);
            menu.style.right = '-200px';
        } else {
            menu.style.right = '0px';
        }
    });

    document.addEventListener('click', function (event) {
        var target = event.target;
        if (!menu.contains(target) && target !== botonMenu) {
            document.documentElement.style.opacity = '1';
            setTimeout(() => { 
                document.documentElement.style.overflowY = 'auto'; // Restablece después de la animación
            }, 300);
            menu.style.right = '-200px';
        }
    });

    var enlaces = document.querySelectorAll('a[href^="#"]');

    for (var i = 0; i < enlaces.length; i++) {
        enlaces[i].addEventListener('click', function(e) {
            e.preventDefault();

            var destino = this.getAttribute('href');
            var seccion = document.querySelector(destino);

            if (seccion) {
                var posicion = seccion.offsetTop - (window.innerHeight / 4);

                window.scrollTo({
                    top: posicion,
                    behavior: 'smooth'
                });
                document.documentElement.style.opacity = '1';
                setTimeout(() => {
                    document.documentElement.style.overflowY = 'auto'; // Restablece después de la animación
                }, 300);
                menu.style.right = '-200px';
            }
        });
    }
});