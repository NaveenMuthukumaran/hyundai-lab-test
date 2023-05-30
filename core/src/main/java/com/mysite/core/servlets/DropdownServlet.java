package com.mysite.core.servlets;


import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.osgi.service.component.annotations.Component;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Component(service = { Servlet.class },
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/test/countryjsonservlet",
        })
public class DropdownServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DropdownServlet.class);
    String[] countries=new String[]{"India","United States of America","France", "United Arab Emirates"};
    transient ValueMap valueMap;
    transient List<Resource> resourceList;
    public void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response){
        valueMap = new ValueMapDecorator(new HashMap<>());
        for(String country : countries){
            valueMap.put("value",country.toLowerCase());
            valueMap.put("text", country);
            resourceList.add(new ValueMapResource(request.getResourceResolver(), new ResourceMetadata(), "nt:unstructured", valueMap));
        }
        DataSource dataSource = new SimpleDataSource(resourceList.iterator());
        request.setAttribute(DataSource.class.getName(), dataSource);
    }
}
