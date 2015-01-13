/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.codigospostales;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Modelo para codigos postales
 *
 * @author bustedvillain
 */
public class CodigosPostalesModel
{

    private GenericDao<Colonia> daoColonia;
    private GenericDao<CodigosPostales> daoCodigosPostales;
    private GenericDao<EstadosSia> daoEstadosSia;
    private GenericDao<MunicipiosSia> daoMunicipiosSia;
    private GenericDao<Ciudades> daoCiudades;
    private GenericDao<TipoLocalidad> daoTipoLocalidad;

    @Autowired
    public void setDaoColonia(GenericDao<Colonia> daoColonia)
    {
        this.daoColonia = daoColonia;
        daoColonia.setClass(Colonia.class);
    }

    @Autowired
    public void setDaoCodigosPostales(GenericDao<CodigosPostales> daoCodigosPostales)
    {
        this.daoCodigosPostales = daoCodigosPostales;
        daoCodigosPostales.setClass(CodigosPostales.class);
    }

    @Autowired
    public void setDaoEstadosSia(GenericDao<EstadosSia> daoEstadosSia)
    {
        this.daoEstadosSia = daoEstadosSia;
        daoEstadosSia.setClass(EstadosSia.class);
    }

    @Autowired
    public void setDaoCiudades(GenericDao<Ciudades> daoCiudades)
    {
        this.daoCiudades = daoCiudades;
        daoCiudades.setClass(Ciudades.class);
    }

    @Autowired
    public void setDaoTipoLocalidad(GenericDao<TipoLocalidad> daoTipoLocalidad)
    {
        this.daoTipoLocalidad = daoTipoLocalidad;
        daoTipoLocalidad.setClass(TipoLocalidad.class);
    }

    @Autowired
    public void setDaoMunicipiosSia(GenericDao<MunicipiosSia> daoMunicipiosSia)
    {
        this.daoMunicipiosSia = daoMunicipiosSia;
        daoMunicipiosSia.setClass(MunicipiosSia.class);
    }

    public ColoniaFacade coloniaFacade;
    public CodigosPostalesFacade codigosPostalesFacade;
    public EstadosSiaFacade estadosFacade;
    public MunicipiosSiaFacade municipiosFacade;
    public CiudadesFacade ciudadesFacade;
    public TipoLocalidadFacade tipoLocalidadFacade;
    public MetodosValidacion limpiar = new MetodosValidacion();

    public CodigosPostalesModel(GenericDao<Colonia> daoColonia, GenericDao<CodigosPostales> daoCodigosPostales, GenericDao<EstadosSia> daoEstadosSia,
            GenericDao<MunicipiosSia> daoMunicipiosSia, GenericDao<Ciudades> daoCiudades, GenericDao<TipoLocalidad> tipoLocalidad)
    {
        this.daoColonia = daoColonia;
        this.daoCodigosPostales = daoCodigosPostales;
        this.daoEstadosSia = daoEstadosSia;
        this.daoMunicipiosSia = daoMunicipiosSia;
        this.daoCiudades = daoCiudades;
        this.daoTipoLocalidad = tipoLocalidad;
    }

    /**
     * Metodo que agrega una nueva colonia a un codigo postale en especifico y al final retorna la nueva colonia
     *
     * @param codigo_postal al que se le agregara la colonia
     * @param otra_colonia nombre de la colonia
     * @return el objeto de la colonia nuevo
     */
    public Colonia agregaColonia(String codigo_postal, String otra_colonia)
    {
        try
        {
            System.out.println("AgregarColonia");
            System.out.println("codigo postal:" + codigo_postal.toString());
            List<CodigosPostales> codigosPostales = daoCodigosPostales.findBySpecificField("cp", codigo_postal, "equal", null, null);
            CodigosPostales codigoPostal = codigosPostales.get(0);
            Colonia nvaColonia = new Colonia();
            otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
            nvaColonia.setNombre(otra_colonia);
            nvaColonia.setIdCp(codigoPostal);
            nvaColonia.setStatus(BigInteger.ONE);
            daoColonia.create(nvaColonia);

            //Obtenemos la ultima colonia
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idColonia", "desc");
            Colonia colonia = (Colonia) daoColonia.findAll(ordenamiento).get(0);
            return colonia;

        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    /**
     * Agrega un nuevo codigo postal + colonia
     *
     * @param codigo_postal codigo postal nuevo
     * @param otra_colonia nombre de la colonia
     * @param idEstado id del estado
     * @param idMunicipio id del municipio
     * @param idCiudad id de la ciudad
     * @return el objeto de la nueva colonia
     */
    public Colonia agregarCodigoPostal(String codigo_postal, String otra_colonia, String idEstado, String idMunicipio, String idCiudad)
    {

        try
        {
            EstadosSia estado = (EstadosSia) daoEstadosSia.find(BigDecimal.valueOf(Double.parseDouble(idEstado)));
            MunicipiosSia municipio = (MunicipiosSia) daoMunicipiosSia.find(BigDecimal.valueOf(Double.parseDouble(idMunicipio)));
            TipoLocalidad localidad = (TipoLocalidad) daoTipoLocalidad.find(BigDecimal.ONE);
            Ciudades ciudad = null;
            try
            {
                ciudad = (Ciudades) daoCiudades.find(BigDecimal.valueOf(Double.parseDouble(idCiudad)));
            } catch (Exception e)
            {
                System.out.println("No tiene ciudad");
            }

            CodigosPostales codigoPostal = new CodigosPostales();
            codigoPostal.setCp(Integer.parseInt(codigo_postal));
            codigoPostal.setIdMunicipio(municipio);
            codigoPostal.setIdEstado(estado);
            codigoPostal.setIdTipoLocalidad(localidad);
            if (ciudad != null)
            {
                codigoPostal.setIdCiudad(ciudad);
            }
            daoCodigosPostales.create(codigoPostal);

            //Obtenemos el Ultimo codigo postal
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idCp", "desc");
            CodigosPostales codigoPostalNew = (CodigosPostales) daoCodigosPostales.findAll(ordenamiento).get(0);

            Colonia colonia = new Colonia();
            colonia.setIdCp(codigoPostal);
            otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
            colonia.setNombre(otra_colonia);
            colonia.setStatus(BigInteger.ONE);

            daoColonia.create(colonia);

            //Obtenemos la ultima colonia
            ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idColonia", "desc");
            Colonia coloniaNew = coloniaFacade.findAll(ordenamiento).get(0);
            return coloniaNew;

        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }

    }
}
