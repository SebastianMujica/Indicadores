package SwingBernate.ayudantes;

public class validity {
    /***
     *
     * @param cadena Cadena de caracteres a validar.
     * @param excepto Caracter o grupo de caracteres que seran omitidos en la validación de la cadena.
     * @return Retorna una cadena sin caracteres alfabéticos, a menos que se encuentren en el parametro excepto.
     */

    public static String letras(String cadena,String excepto)
    {
     if(cadena.length()>0)
       {
        if(!excepto.equals(""))
        {
            String regex="[A-Za-z&&["+"^"+excepto+"]]";
                    if(cadena.substring(cadena.length()-1).matches(regex))
           {
         cadena=cadena.substring(0,cadena.length()-1);
         return cadena;
           }
        }
        else
        {
         if(cadena.substring(cadena.length()-1).matches("[A-Za-z]"))
           {
            cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
        }

        }
     return cadena;
    }

    /**
     *
     * @param cadena Cadena de caracteres a validar.
     * @return Retorna la cadena pasada como parametro sin caracteres alfabeticos.
     */
    public static String letras(String cadena)
    {
     if(cadena.length()>0)
       {
         if(cadena.substring(cadena.length()-1).matches("[A-Za-z]"))
           {
            cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
        }
     return cadena;
    }

    /***
     *
     * @param cadena Cadena de caracteres a validar.
     * @param excepto Caracter o grupo de caracteres que seran omitidos en la validación de la cadena.
     * @return Retorna una cadena sin caracteres numéricos, a menos que se encuetren en el parametro excepto.
     */
    public static String numeros(String cadena, String excepto)
    {
     if(cadena.length()>0)
       {
         if(!excepto.equals(""))
         {
       String regex="[0-9&&["+'^'+excepto+"]]";
       if(cadena.substring(cadena.length()-1).matches(regex))
           {
         cadena=cadena.substring(0,cadena.length()-1);
         return cadena;
           }
           }
        else
         {
          if(cadena.substring(cadena.length()-1).matches("[0-9]"))
           {
             cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
        }
        }
     return cadena;
    }

    /**
     *
     * @param cadena Cadena de caracteres a validar.
     * @return Retorna la cadena pasada como parametro sin caracteres numéricos.
     */
    public static String numeros(String cadena)
    {
     if(cadena.length()>0)
       {
          if(cadena.substring(cadena.length()-1).matches("[0-9]"))
           {
             cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
        }
     return cadena;
    }

    /***
     *
     * @param cadena Cadena de caracteres a validar.
     * @param excepto Caracter o grupo de caracteres que seran omitidos en la validación de la cadena.
     * @return Retorna una cadena sin caracteres numéricos, a menos que se encuetren en el parametro excepto.
     */
    public static String caracteres(String cadena,String excepto)
    {
        //[a-z&&[^bc]]
     if(cadena.length()>0)
       {
         if(!excepto.equals(""))
         {
         String regex="[A-Za-z0-9["+excepto+"]]";
         if(!cadena.substring(cadena.length()-1).matches(regex))
           {
            cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
          }
          else
          {
           if(!cadena.substring(cadena.length()-1).matches("[A-Za-z0-9]"))
           {
            cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
          }
        }
     return cadena;
    }

    /**
     *
     * @param cadena Cadena de caracteres a validar.
     * @return Retorna la cadena pasada como parametro sin caracteres especiales.
     */
    public static String caracteres(String cadena)
    {
     if(cadena.length()>0)
       {
           if(!cadena.substring(cadena.length()-1).matches("[A-Za-z0-9]"))
           {
            cadena=cadena.substring(0,cadena.length()-1);
            return cadena;
           }
          }
     return cadena;
    }

    /**
     *
     * @param cadena Cadena de caracteeres a validar.
     * @param excl Caracter. Use "l" para evitar letras, "n" para evitar números, "c" para evitar caracteres especiales ó use una combinación de 2 tipos separados con "|" ejem. "l|n".
     * @return Retorna la cadena pasada como parámetro validada.
     */
    public static String validar(String cadena, String excl)
    {
        if(excl.length()<2)
        {
        switch(excl.charAt(0))
        {
            case 'l':
                return letras(cadena);
            case 'n':
                return numeros(cadena);
            case 'c':
                return caracteres(cadena);
        }
        }
        else
        {
          return excluir(cadena,excl);
        }
        return "Error de validación";
    }
/**
 *
 * @param cadena Cadena de caracteeres a validar.
 * @param excl Caracter. Use "l" para evitar letras, "n" para evitar números, "c" para evitar caracteres especiales ó use una combinación de 2 tipos separados con "|" ejem. "l|n".
 * @param excepto Cadena que contiene el caractér o grupo de caracteres que se omitirán en la validación.
 * @return Retorna la cadena pasada como parámetro validada.
 */
    public static String validar(String cadena, String excl, String excepto)
    {
        if(excl.length()<2)
        {
        switch(excl.charAt(0))
        {
            case 'l':
                return letras(cadena,excepto);
            case 'n':
                return numeros(cadena,excepto);
            case 'c':
                return caracteres(cadena,excepto);
        }
        }
        else
        {
          return excluir(cadena,excl,excepto);
        }
        return "Error de validación";
    }

    /**
     *
     * @param cadena Cadena de caracteeres a validar.
     * @param excl  Caracter. Use "l|n" para evitar letras y números, "n|c" para evitar números y caracteres especiales ó "c|l" para evitar caracteres especiales y letras.
     * @param excepto Cadena que contiene el caractér o grupo de caracteres que se omitirán en la validación.
     * @return Retorna la cadena pasada como parámetro validada.
     */
public static String excluir(String cadena, String excl,String excepto)
    {
    String cadena1=cadena;
        if((excl.equals("l|n"))||(excl.matches("n|l")))
        {
            cadena1=letras(cadena1,excepto);
            cadena1=numeros(cadena1,excepto);
            return cadena1;
        }

    if((excl.equals("n|c"))||(excl.equals("c|n")))
        {
            cadena1=numeros(cadena1,excepto);
            cadena1=caracteres(cadena1,excepto);
            return cadena1;
        }
    if((excl.equals("l|c"))||(excl.equals("c|l")))
        {
            cadena1=letras(cadena1,excepto);
            cadena1=caracteres(cadena1,excepto);
            return cadena1;
        }
        return "Error de logitud de cadena";
    }

/**
 *
 *@param cadena Cadena de caracteeres a validar.
 *@param excl  Caracter. Use "l|n" para evitar letras y números, "n|c" para evitar números y caracteres especiales ó "c|l" para evitar caracteres especiales y letras.
 * @return
 */
public static String excluir(String cadena, String excl)
    {
    String cadena1=cadena;
        if((excl.equals("l|n"))||(excl.equals("n|l")))
        {
            cadena1=letras(cadena1);
            cadena1=caracteres(cadena1);
            return cadena1;
        }

    if((excl.equals("n|c"))||(excl.equals("c|n")))
        {
            cadena1=numeros(cadena1);
            cadena1=caracteres(cadena1);
            return cadena1;
        }
    if((excl.equals("l|c"))||(excl.equals("c|l")))
        {
            cadena1=letras(cadena1);
            cadena1=caracteres(cadena1);
            return cadena1;
        }
        return "Error de logitud de cadena";
    }

}