/*
 * ESTA CLASE NO SE UTILIZA SE VA A ELIMINAR
 */
package edu.servicio.toluca.model.formatoUnico;

import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Héctor
 */
public class FormatoUnicoAdminModel
{

    private CatalogoObservacionesFacade observacionesCatalogoFacade;
    private FormatoUnicoFacade formatoUnicoFacade;
    private DocumentosFacade documentoFacade;
    private DatosPersonalesFacade datosPersonalesFacade;
    private RegObservacionesFacade regisObservacionesFacade;

    //Status de FormatoUnico FUI en  base al documento status_DOC_1.doc
    final int VALOR_NO_REVISADOS = 4;
    final int VALOR_ACEPTADOS = 1;
    final int VALOR_RECHAZADOS = 2;
    final int VALOR_CORRECCION = 3;

    //ID CatalogoDocumentos FormatoUnico
    final long DOC_CAT_FU = 1;

    //Pruebas Developer
    //**********************************************
    //Desactivar para Produccion, Activar para Desarrollo
    final boolean banderaPrueba = true;
    final String correoTest = "rehoscript@gmail.com";

    //**********************************************
    public FormatoUnicoAdminModel(CatalogoObservacionesFacade observacionesCatalogoFacade, FormatoUnicoFacade formatoUnicoFacade, DocumentosFacade documentoFacade, DatosPersonalesFacade datosPersonalesFacade, RegObservacionesFacade regisObservacionesFacade)
    {
        this.observacionesCatalogoFacade = observacionesCatalogoFacade;
        this.formatoUnicoFacade = formatoUnicoFacade;
        this.documentoFacade = documentoFacade;
        this.datosPersonalesFacade = datosPersonalesFacade;
        this.regisObservacionesFacade = regisObservacionesFacade;
    }

    public void rechazar()
    {

    }

    public void correccion()
    {

    }

    /**
     *
     * @param id
     * @return Cambia el estado de un FormatoUnico de estado NO_REVISADO a estado ACEPTADO
     */
    public boolean aceptar(String id)
    {
        //Obtener FormatoUnico en especifico 
        FormatoUnico fA = formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(id)));
        if (fA != null)
        {
            //Cambiar Estado de NO_ACEPTADO A ACEPTADO
            fA.setStatusFui(BigInteger.valueOf(VALOR_ACEPTADOS));
            formatoUnicoFacade.edit(fA);

            String nombre = fA.getDatosPersonalesId().getNombre() + " "
                    + fA.getDatosPersonalesId().getApellidoP() + " "
                    + fA.getDatosPersonalesId().getApellidoM();

            return true;
            //enviarCorreo(1,fA.getDatosPersonalesId().getCorreoElectronico(),nombre,null);
        } else
        {
            return false;
        }
    }

    /**
     * @param String idDatosPersonales
     */
    public void mostrarObservacion(String idDatosPersonales)
    {
        BigDecimal idDP = BigDecimal.valueOf(Long.parseLong(idDatosPersonales));

    }

    public void mostrarDocumentoFormatoUnico()
    {

    }

    private void obtenerFechaSubidaFormatoU()
    {

    }

    private void obtenerIDDocumentoFormatoU()
    {

    }

    private void listadoFormatosNoRevisados()
    {

    }

    private void listadoFormatosAceptados()
    {

    }

    private void listadoFormatosRechazados()
    {

    }

    private void listadoFormatosCorreccion()
    {

    }

    /**
     * @return the observacionesCatalogoFacade
     */
    public CatalogoObservacionesFacade getObservacionesCatalogoFacade()
    {
        return observacionesCatalogoFacade;
    }

    /**
     * @param observacionesCatalogoFacade the observacionesCatalogoFacade to set
     */
    public void setObservacionesCatalogoFacade(CatalogoObservacionesFacade observacionesCatalogoFacade)
    {
        this.observacionesCatalogoFacade = observacionesCatalogoFacade;
    }

    /**
     * @return the formatoUnicoFacade
     */
    public FormatoUnicoFacade getFormatoUnicoFacade()
    {
        return formatoUnicoFacade;
    }

    /**
     * @param formatoUnicoFacade the formatoUnicoFacade to set
     */
    public void setFormatoUnicoFacade(FormatoUnicoFacade formatoUnicoFacade)
    {
        this.formatoUnicoFacade = formatoUnicoFacade;
    }

    /**
     * @return the documentoFacade
     */
    public DocumentosFacade getDocumentoFacade()
    {
        return documentoFacade;
    }

    /**
     * @param documentoFacade the documentoFacade to set
     */
    public void setDocumentoFacade(DocumentosFacade documentoFacade)
    {
        this.documentoFacade = documentoFacade;
    }

    /**
     * @return the datosPersonalesFacade
     */
    public DatosPersonalesFacade getDatosPersonalesFacade()
    {
        return datosPersonalesFacade;
    }

    /**
     * @param datosPersonalesFacade the datosPersonalesFacade to set
     */
    public void setDatosPersonalesFacade(DatosPersonalesFacade datosPersonalesFacade)
    {
        this.datosPersonalesFacade = datosPersonalesFacade;
    }

    /**
     * @return the regisObservacionesFacade
     */
    public RegObservacionesFacade getRegisObservacionesFacade()
    {
        return regisObservacionesFacade;
    }

    /**
     * @param regisObservacionesFacade the regisObservacionesFacade to set
     */
    public void setRegisObservacionesFacade(RegObservacionesFacade regisObservacionesFacade)
    {
        this.regisObservacionesFacade = regisObservacionesFacade;
    }

}
