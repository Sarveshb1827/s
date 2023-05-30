
package com.newwebservice;

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
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NewWebService", targetNamespace = "http://newwebservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NewWebService {


    /**
     * 
     * @param number
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculate", targetNamespace = "http://newwebservice.com/", className = "com.newwebservice.Calculate")
    @ResponseWrapper(localName = "calculateResponse", targetNamespace = "http://newwebservice.com/", className = "com.newwebservice.CalculateResponse")
    @Action(input = "http://newwebservice.com/NewWebService/calculateRequest", output = "http://newwebservice.com/NewWebService/calculateResponse")
    public String calculate(
        @WebParam(name = "number", targetNamespace = "")
        int number);

}
