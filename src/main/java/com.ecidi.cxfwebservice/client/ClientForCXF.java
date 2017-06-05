package com.ecidi.cxfwebservice.client;

import com.ecidi.cxfwebservice.server.MyWebService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * 该类为java发布的webservice（服务端客户端在一起，该客户端并非由wsdl2java生成）通过main方法访问
 *
 */
public class ClientForCXF {
    public static MyWebService getInterFace(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(MyWebService.class);
        factoryBean.setAddress("http://localhost:8083/server/web-publish?wsdl");
        return (MyWebService) factoryBean.create();
    }

    public static void main(String[] args) {
        MyWebService myWebService = getInterFace();
        System.out.println("client: "+myWebService.add(1,3));
    }
}
