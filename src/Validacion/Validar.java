package Validacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *Esta clase valida los campos de las interfaces, limitando la cantidad de caracteres y/o numeros, y validonde el ingreso de datos correspondientes
 * @author rodrigo
 * @version 10/06/2020A
 */
public class Validar {
 
   
    /**
     * Este metodo que valida el ingreso de numeros en el campo RUT y numeros o letra 'k' en el campo Digito Verificador 
     * envia un mensaje al JLabel asociado en caso que este el Rut no sea valido.
     * Se emplea en estas formas:
     * Cuando se presiona una tecla(keyTyped) en el campo JtextFieldRut y JTextFieldDV.
     * 
     * @param JTextFieldRut Define Campo a validar(RUT)
     * @param JTextFieldDV Define Campo a validar (DV)
     * @param JLRut Define el elemento donde se enviara el mensaje 
     */
    public static void validarRut(JTextField JTextFieldRut, JTextField JTextFieldDV, JLabel JLRut) {

        
         String rut = JTextFieldRut.getText();
                String dv = JTextFieldDV.getText();
                boolean estado = VerificaRut.verificacionRut(rut, dv);//se llama al metodo verificrRut que devuelve un boolean
                if (estado) {
                    JLRut.setText("");
                    JLRut.setEnabled(false);
                } else {
                    JLRut.setEnabled(true);
                    JLRut.setText("rut no valido");

                }
        
        JTextFieldRut.addKeyListener(new KeyAdapter() {
            //metodo abstracto del Objeto Key Adapter, se llama cada vez que se presiona una tecla
            public void keyTyped(KeyEvent e) {

                int tam = JTextFieldRut.getText().length();
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || tam >= 8) {
                    e.consume();
                }
            }

        }
        );

        JTextFieldDV.addKeyListener(new KeyAdapter() {
            
            //metodo abstracto del Objeto Key Adapter, se llama cada vez que se presiona una tecla
            public void keyTyped(KeyEvent e) {

                int tam = JTextFieldDV.getText().length();
                char c = e.getKeyChar();
                char dvK = 'k';

                if ((c != dvK) && (!Character.isDigit(c)) || tam > 0) {
                    e.consume();
                }
                
            }

        }
        );

    }//Cierre del metodo

    /**
     * Metodo que valida que el correo sea valido envia un mensaje al JLabel en caso que el correo no sea valido
     * @param jtfCorreo El parametro jtfCorreo Define el campo a validar
     * @param jlCorreo El parametro jlCorreo define el campo donde se enviara un menaje
     * @return Retorna un boolean con el estado del correo
     */
    public static boolean validarCorreo(JTextField jtfCorreo, JLabel jlCorreo) {

        String correo = jtfCorreo.getText();
        Pattern pat = null;
        Matcher mat = null;
        boolean estado;
       
        //patron de caracteres que se almacenan em el objeto pat
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);//revisa si el Strig(correo) que se envia cumpe con el patron almacenado en pat        
        estado = mat.find();
        if (true==estado) {
            jlCorreo.setText("");
            jlCorreo.setEnabled(true);
            return true;
        } 
            jlCorreo.setText("Correo no Valido");        
            jlCorreo.setEnabled(true);
            return false;
    }//cierre del metodo

    /**
     * Metodo que valida el ingreso solamente de caractres y Espacio, y la cantidad maxima de caracteres permitida
     * @param textField El parametro jtfField Define el campo a validar
     * @param cantidad  El parametro define la cantidad maxima de caracteres 
     */
    public static void validarCaracter(JTextField textField, int cantidad) {
        //se agrega el Evento Key Listener al JTextField y se el parametro Key Adapter
        textField.addKeyListener(new KeyAdapter() {//
            //metodo abstracto del Objeto Key Adapter, se llama cada vez que se presiona una tecla 
            public void keyTyped(KeyEvent e) {
                
                int tam = textField.getText().length();//se obtiene el tamaño del JTextField
                char c = e.getKeyChar();//Se obtiene el ultimo caracter ingresado 
                if (!Character.isLetter(c)&&!Character.isSpaceChar(c)) {
                    e.consume();//si es diferente de un caracter el Evento no permitira el ingreso de este 
                }
                if (tam >= cantidad) {
                    e.consume();//si la cantidad de cacarteres se sobrepasa a la especificada no permitira mas caracteres

                }
            }

        }
        );

    }//cierre del metodo

    /**
     * Metodo que valida el ingreso solamente de numeros y la cantidad maxima de caracteres permitida
     * @param textField El parametro jtfField Define el campo a validar
     * @param cantidad  El parametro define la cantidad maxima de numeros
     */
    public static void validarNumero(JTextField textField, int cantidad) {
        //se agrega el Evento Key Listener al JTextField y se el parametro Key Adapter
        textField.addKeyListener(new KeyAdapter() {
            //metodo abstracto del Objeto Key Adapter, se llama cada vez que se presiona una tecla 
            public void keyTyped(KeyEvent e) {
                int tam = textField.getText().length();//se obtiene el tamaño del JTextField
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();//si es diferente de un numero el Evento no permitira el ingreso de este 
                }
                if (tam >= cantidad) {
                    e.consume();//si la cantidad de cacarteres se sobrepasa a la especificada no permitira mas caracteres
                }
            }
        }
        );

    }//cierre del metodo

}//cierre de la clase
   
