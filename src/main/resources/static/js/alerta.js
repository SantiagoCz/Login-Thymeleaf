document.addEventListener("DOMContentLoaded", function() {
    var errorMessage = /*[[${error}]]*/ "";
    var successMessage = /*[[${success}]]*/ "";
    if (errorMessage) {
        Swal.fire({
            icon: "error",
            title: "Error",
            text: errorMessage,
        });
    } else if (successMessage) {
        Swal.fire({
            icon: "success",
            title: "Éxito",
            text: successMessage,
        });
    }
});
