/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.formatoUnico;

import edu.servicio.toluca.beans.MetodosValidacion;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoHorariosBean {
    private BigDecimal id;
    private String luI;
    private String luF;
    private String maI;
    private String maF;
    private String miI;
    private String miF;
    private String juI;
    private String juF;
    private String viI;
    private String viF;
    private ArrayList<String> listaErrores = new ArrayList<String>();
    MetodosValidacion mv = new MetodosValidacion();

    public void roy()
    {
        
    }
    public ArrayList<String> Valida() throws ParseException
    {
        boolean luih = true;
        boolean lufh = true;
        boolean maih = true;
        boolean mafh = true;
        boolean miih = true;
        boolean mifh = true;
        boolean juih = true;
        boolean jufh = true;
        boolean viih = true;
        boolean vifh = true;
        if(!luI.equals("") && !luI.equals(" ") && !mv.esHora(luI)){listaErrores.add("La hora de inicio del Lunes, no es una hora correcta, debe estar en el formato HH:MM"); luih = false;}
        if(!maI.equals("") && !maI.equals(" ") && !mv.esHora(maI)){listaErrores.add("La hora de inicio del Martes, no es una hora correcta, debe estar en el formato HH:MM"); maih = false;}
        if(!miI.equals("") && !miI.equals(" ") && !mv.esHora(miI)){listaErrores.add("La hora de inicio del Miercoles, no es una hora correcta, debe estar en el formato HH:MM"); miih = false;}
        if(!juI.equals("") && !juI.equals(" ") && !mv.esHora(juI)){listaErrores.add("La hora de inicio del Jueves, no es una hora correcta, debe estar en el formato HH:MM"); juih = false;}
        if(!viI.equals("") && !viI.equals(" ") && !mv.esHora(viI)){listaErrores.add("La hora de inicio del Viernes, no es una hora correcta, debe estar en el formato HH:MM"); viih = false;}
        
        if(!luF.equals("") && !luF.equals(" ") && !mv.esHora(luF)){listaErrores.add("La hora de fin del Lunes, no es una hora correcta, debe estar en el formato HH:MM"); lufh = false;}
        if(!maF.equals("") && !maF.equals(" ") && !mv.esHora(maF)){listaErrores.add("La hora de fin del Martes, no es una hora correcta, debe estar en el formato HH:MM"); mafh = false;}
        if(!miF.equals("") && !miF.equals(" ") && !mv.esHora(miF)){listaErrores.add("La hora de fin del Miercoles, no es una hora correcta, debe estar en el formato HH:MM"); mifh = false;}
        if(!juF.equals("") && !juF.equals(" ") && !mv.esHora(juF)){listaErrores.add("La hora de fin del Jueves, no es una hora correcta, debe estar en el formato HH:MM"); jufh = false;}
        if(!viF.equals("") && !viF.equals(" ") && !mv.esHora(viF)){listaErrores.add("La hora de fin del Viernes, no es una hora correcta, debe estar en el formato HH:MM"); vifh = false;}
        
        DateFormat formato = new SimpleDateFormat("HH:mm");
        if(!luI.equals(" ") && !luF.equals(" ") && !luI.equals("") && !luF.equals(""))
        {
            Date h1 = (Date)formato.parse(luI);
            Date h2 = (Date)formato.parse(luF);
            if(h1.after(h2)){listaErrores.add("La hora de fin del Lunes, es menor a la de inicio");}
        }
        if(!maI.equals(" ") && !maF.equals(" ") && !maI.equals("") && !maF.equals(""))
        {
            Date h1 = (Date)formato.parse(maI);
            Date h2 = (Date)formato.parse(maF);
            if(h1.after(h2)){listaErrores.add("La hora de fin del Martes, es menor a la de inicio");}
        }
        if(!miI.equals(" ") && !miF.equals(" "))
        {
            Date h1 = (Date)formato.parse(miI);
            Date h2 = (Date)formato.parse(miF);
            if(h1.after(h2)){listaErrores.add("La hora de fin del Miercoles, es menor a la de inicio");}
        }
        if(!juI.equals(" ") && !juF.equals(" "))
        {
            Date h1 = (Date)formato.parse(juI);
            Date h2 = (Date)formato.parse(juF);
            if(h1.after(h2)){listaErrores.add("La hora de fin del Jueves, es menor a la de inicio");}
        }
        if(!viI.equals(" ") && !viF.equals(" "))
        {
            Date h1 = (Date)formato.parse(viI);
            Date h2 = (Date)formato.parse(viF);
            if(h1.after(h2)){listaErrores.add("La hora de fin del Viernes, es menor a la de inicio");}
        }
        if((!luI.equals(" ") && !luI.equals("")) && (luF.equals(" ") || luF.equals(""))){listaErrores.add("El lunes no tiene hora de fin");}
        if((!luF.equals(" ") && !luF.equals("")) && (luI.equals(" ") || luI.equals(""))){listaErrores.add("El lunes no tiene hora de inicio");}
        if((!maI.equals(" ") && !maI.equals("")) && (maF.equals(" ") || maF.equals(""))){listaErrores.add("El martes no tiene hora de fin");}
        if((!maF.equals(" ") && !maF.equals("")) && (maI.equals(" ") || maI.equals(""))){listaErrores.add("El martes no tiene hora de inicio");}
        if((!miI.equals(" ") && !miI.equals("")) && (miF.equals(" ") || miF.equals(""))){listaErrores.add("El miercoles no tiene hora de fin");}
        if((!miF.equals(" ") && !miF.equals("")) && (miI.equals(" ") || miI.equals(""))){listaErrores.add("El miercoles tiene hora de inicio");}
        if((!juI.equals(" ") && !juI.equals("")) && (juF.equals(" ") || juF.equals(""))){listaErrores.add("El jueves tiene hora de fin");}
        if((!juF.equals(" ") && !juF.equals("")) && (juI.equals(" ") || juI.equals(""))){listaErrores.add("El jueves tiene hora de inicio");}
        if((!viI.equals(" ") && !viI.equals("")) && (viF.equals(" ") || viF.equals(""))){listaErrores.add("El viernes tiene hora de fin");}
        if((!viF.equals(" ") && !viF.equals("")) && (viI.equals(" ") || viI.equals(""))){listaErrores.add("El viernes no tiene hora de inicio");}
        
        if(!mv.maximoString(luI, 5) && !mv.minimoString(luI, 5)){listaErrores.add("La hora de inicio del Lunes, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(maI, 5) && !mv.minimoString(maI, 5)){listaErrores.add("La hora de inicio del Martes, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(miI, 5) && !mv.minimoString(miI, 5)){listaErrores.add("La hora de inicio del Miercoles, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(juI, 5) && !mv.minimoString(juI, 5)){listaErrores.add("La hora de inicio del Jueves, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(viI, 5) && !mv.minimoString(viI, 5)){listaErrores.add("La hora de inicio del Viernes, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(luF, 5) && !mv.minimoString(luF, 5)){listaErrores.add("La hora de fin del Lunes, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(maF, 5) && !mv.minimoString(maF, 5)){listaErrores.add("La hora de fin del Martes, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(miF, 5) && !mv.minimoString(miF, 5)){listaErrores.add("La hora de fin del Miercoles, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(juF, 5) && !mv.minimoString(juF, 5)){listaErrores.add("La hora de fin del Jueves, no es una hora correcta, debe estar en el formato HH:MM");}
        if(!mv.maximoString(viF, 5) && !mv.minimoString(viF, 5)){listaErrores.add("La hora de fin del Viernes, no es una hora correcta, debe estar en el formato HH:MM");}
        return listaErrores;
    }
    /**
     * @return the luI
     */
    public String getLuI() {
        return luI;
    }

    /**
     * @param luI the luI to set
     */
    public void setLuI(String luI) {
        this.luI = luI;
    }

    /**
     * @return the luF
     */
    public String getLuF() {
        return luF;
    }

    /**
     * @param luF the luF to set
     */
    public void setLuF(String luF) {
        this.luF = luF;
    }

    /**
     * @return the maI
     */
    public String getMaI() {
        return maI;
    }

    /**
     * @param maI the maI to set
     */
    public void setMaI(String maI) {
        this.maI = maI;
    }

    /**
     * @return the maF
     */
    public String getMaF() {
        return maF;
    }

    /**
     * @param maF the maF to set
     */
    public void setMaF(String maF) {
        this.maF = maF;
    }

    /**
     * @return the miI
     */
    public String getMiI() {
        return miI;
    }

    /**
     * @param miI the miI to set
     */
    public void setMiI(String miI) {
        this.miI = miI;
    }

    /**
     * @return the miF
     */
    public String getMiF() {
        return miF;
    }

    /**
     * @param miF the miF to set
     */
    public void setMiF(String miF) {
        this.miF = miF;
    }

    /**
     * @return the juI
     */
    public String getJuI() {
        return juI;
    }

    /**
     * @param juI the juI to set
     */
    public void setJuI(String juI) {
        this.juI = juI;
    }

    /**
     * @return the juF
     */
    public String getJuF() {
        return juF;
    }

    /**
     * @param juF the juF to set
     */
    public void setJuF(String juF) {
        this.juF = juF;
    }

    /**
     * @return the viI
     */
    public String getViI() {
        return viI;
    }

    /**
     * @param viI the viI to set
     */
    public void setViI(String viI) {
        this.viI = viI;
    }

    /**
     * @return the viF
     */
    public String getViF() {
        return viF;
    }

    /**
     * @param viF the viF to set
     */
    public void setViF(String viF) {
        this.viF = viF;
    }

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
}
