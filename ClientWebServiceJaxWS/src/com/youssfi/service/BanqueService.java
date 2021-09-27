
package com.youssfi.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BanqueService", targetNamespace = "http://service.youssfi.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueService {


    /**
     * 
     * @param montant
     * @return
     *     returns double
     */
    @WebMethod(operationName = "ConversionEuroToDh")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ConversionEuroToDh", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.ConversionEuroToDh")
    @ResponseWrapper(localName = "ConversionEuroToDhResponse", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.ConversionEuroToDhResponse")
    @Action(input = "http://service.youssfi.com/BanqueService/ConversionEuroToDhRequest", output = "http://service.youssfi.com/BanqueService/ConversionEuroToDhResponse")
    public double conversionEuroToDh(
        @WebParam(name = "montant", targetNamespace = "")
        double montant);

    /**
     * 
     * @param code
     * @return
     *     returns com.youssfi.service.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompte", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.GetCompte")
    @ResponseWrapper(localName = "getCompteResponse", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.GetCompteResponse")
    @Action(input = "http://service.youssfi.com/BanqueService/getCompteRequest", output = "http://service.youssfi.com/BanqueService/getCompteResponse")
    public Compte getCompte(
        @WebParam(name = "code", targetNamespace = "")
        Long code);

    /**
     * 
     * @return
     *     returns java.util.List<com.youssfi.service.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getComptes", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.GetComptes")
    @ResponseWrapper(localName = "getComptesResponse", targetNamespace = "http://service.youssfi.com/", className = "com.youssfi.service.GetComptesResponse")
    @Action(input = "http://service.youssfi.com/BanqueService/getComptesRequest", output = "http://service.youssfi.com/BanqueService/getComptesResponse")
    public List<Compte> getComptes();

}
