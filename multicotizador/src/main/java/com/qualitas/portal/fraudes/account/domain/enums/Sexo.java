package com.qualitas.portal.fraudes.account.domain.enums;

public enum Sexo {
    MASCULINO("Masculino", "M", "HOMBRE", "H"),
    FEMENINO("Femenino", "F", "MUJER", "M"),
    OTRO("Otro", "O", "OTRO", "X");

    private final String[] variantes;

    Sexo(String... variantes) {
        this.variantes = variantes;
    }

    public static Sexo fromString(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }

        String textoLimpio = text.trim().toUpperCase();

        for (Sexo sexo : Sexo.values()) {
            for (String variante : sexo.variantes) {
                if (variante.toUpperCase().equals(textoLimpio)) {
                    return sexo;
                }
            }
        }

        // Si no encuentra coincidencia exacta, intenta coincidencia parcial
        for (Sexo sexo : Sexo.values()) {
            if (sexo.name().startsWith(textoLimpio) ||
                    textoLimpio.startsWith(sexo.name().substring(0, 1))) {
                return sexo;
            }
        }

        throw new IllegalArgumentException("Valor de sexo no reconocido: '" + text + "'. Valores aceptados: " + getValoresAceptados());
    }

    private static String getValoresAceptados() {
        StringBuilder sb = new StringBuilder();
        for (Sexo sexo : Sexo.values()) {
            sb.append("\n- ").append(sexo.name()).append(" (acepta: ");
            for (String v : sexo.variantes) {
                sb.append(v).append(", ");
            }
            sb.delete(sb.length()-2, sb.length()).append(")");
        }
        return sb.toString();
    }
}