package com.blogspot.diegopacheco.roll.rest.service.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.ext.atom.AtomElementWriter;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.AtomPojoProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.apache.cxf.jaxrs.provider.JSONProvider;

import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;
import com.blogspot.diegopacheco.roll.rest.service.engine.handlers.ArrayListProvider;
import com.blogspot.diegopacheco.roll.rest.service.engine.handlers.ListProvider;
import com.blogspot.diegopacheco.roll.rest.service.engine.handlers.ReceiptElementWriter;
import com.blogspot.diegopacheco.roll.rest.service.engine.handlers.URIProvider;

/**
 * 
 * @author Diego Pacheco
 * 
 * @since 28/11/2010
 * @version 1.0
 * 
 */
public class RESTExposureEngine {

	private TollService service;

	public void register(JAXRSServerFactoryBean svrFactoryRest) {
		svrFactoryRest.setResourceClasses(TollService.class);
		svrFactoryRest.setResourceProvider(TollService.class,
				new SingletonResourceProvider(service));
	}

	public void doExposure() {

		JAXRSServerFactoryBean svrFactoryRest = new JAXRSServerFactoryBean();

		register(svrFactoryRest);

		svrFactoryRest.setAddress("/rest");

		BindingFactoryManager manager = svrFactoryRest.getBus().getExtension(
				BindingFactoryManager.class);
		JAXRSBindingFactory factory = new JAXRSBindingFactory();
		factory.setBus(svrFactoryRest.getBus());
		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID,
				factory);

		Map<String, AtomElementWriter<?,?>> m = new HashMap<String, AtomElementWriter<?,?>>();
		m.put(ReceiptElementWriter.class.getName(), new ReceiptElementWriter());
		AtomPojoProvider app = new AtomPojoProvider();
		app.setAtomWriters(m);
		
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JSONProvider());
		providers.add(new JAXBElementProvider());
		providers.add(new ArrayListProvider());
		providers.add(new ListProvider());
		providers.add(new URIProvider());
		providers.add(app);
		// providers.add(new IntegerHandler());
		// providers.add(new IntegerProvider());
		// providers.add(new IntegerParameter());
		// providers.add(new LongProvider());

		svrFactoryRest.setProviders(providers);

		svrFactoryRest.create();
	}

	public void setService(TollService service) {
		this.service = service;
	}
}
