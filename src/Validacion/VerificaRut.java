package Validacion;

/**
 *Clase que  Verifica que un rut sea valido  
 * @author rodrigo
 */
public class VerificaRut {
    
    /**
     * Este metodo valida que el rut junto al digito verificador, sean validos 
     * @param rutVerificar El parametro rutVerificar Define el campo a validar
     * @param DV El parametro rutVerificar Define el campo a validar
     * @return retorna un boolean, con el estado de la verificacion 
     */
    public static boolean verificacionRut(String rutVerificar, String DV) {
        int i, aux, num, resto;
        int mul = 2;
        int acum = 0;
        int total = 0;
        int num_obtenido = 0;

        String rut = rutVerificar;
        String dV = DV;
        String pocision;

        aux = rut.length();//se obtiene la cantidad de caracteres del rut, 7 o 8 caracteres por lo general
        //este for se multiplicar cada digito del rut con el multiplo correspondiente empezando por el ultimo caracter de la cadena del rut
        //y sumando el resultado de estos
        for (i = rut.length() - 1; i >= 0; i--) {
            pocision = rut.substring(i, i + 1);//saca el ultimo caracter de la cadena
            num = Integer.parseInt(pocision);//convierte el String a int
            if (mul > 1 && mul < 8) {
                acum = num * mul;
                total = total + acum;
            } else {
                mul = 2;
                acum = num * mul;
                total = total + acum;
            }
            mul = mul + 1;
        }
        resto = total % 11;//saca el resto del modulo
        num_obtenido = 11 - resto;
        if (num_obtenido > 0 && num_obtenido < 10) {
            String auxNumObt = Integer.toString(num_obtenido);
            if (auxNumObt.equalsIgnoreCase(dV)) {//sie el nmero obtenido corresponde con el DV retornara true, de lo contrario False

                return true;
            } else {

                return false;
            }
        } else {
            if (num_obtenido == 11) {
                //sie el DV es igual a 0 retornara true, de lo contrario False
                if ("0".equalsIgnoreCase(dV)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                //sie el DV es igual a K retornara true, de lo contrario False
                if ("k".equalsIgnoreCase(dV)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

}
