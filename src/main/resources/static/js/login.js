        var currentUrl = window.location.href;
        if (currentUrl.includes("?error")) {
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "Usuario o contraseña incorrectos",
            });
        }
