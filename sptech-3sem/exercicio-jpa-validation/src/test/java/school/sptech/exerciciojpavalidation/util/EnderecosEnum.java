package school.sptech.exerciciojpavalidation.util;

public enum EnderecosEnum {

    BASE_URL("/eventos"),
    POR_ID("/eventos/{id}"),
    GRATUITOS("/eventos/gratuitos"),
    DATA("/eventos/data"),
    PERIODO("/eventos/periodo"),
    CANCELAR("/eventos/{id}/cancelamento");

    EnderecosEnum(String path) {
        this.PATH = path;
    }

    public final String PATH;
}
