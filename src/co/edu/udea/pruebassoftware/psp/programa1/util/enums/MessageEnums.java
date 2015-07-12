package co.edu.udea.pruebassoftware.psp.programa1.util.enums;

public enum MessageEnums {

    EXTENSION_NOT_VALID("Extensión No Válida", "La extensión del archivo que ha"
            + " sido seleccionado no es: .txt\n\nSeleccione un archivo con dicha"
            + " extensión e intente de nuevo."),
    FILE_NOT_SELECTED("Archivo No Seleccionado", "No se ha seleccionado ningún"
            + " archivo.\n\nNo hay datos para reconocer."),
    INTERNAL_ERROR("Error Interno",
            "Ha sucedido un error inesperado. Por favor inténtelo de nuevo."),
    ERROR_READING_NUMBERS("Error leyendo números",
            "Se ha producido un error porque uno de los valores no es un número."
            + "\nPor favor verificiar y volver a intentar.");

    private String message;

    private String title;

    private MessageEnums(String title, String message) {
        this.setMessage(message);
        this.setTitle(title);
    }

    public String getMessage() {

        return (this.message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {

        return (this.title);
    }

    private void setTitle(String title) {
        this.title = title;
    }
}
