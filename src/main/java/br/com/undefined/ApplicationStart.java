package br.com.undefined;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class ApplicationStart {	
	public static void main(String[] args) {
		CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
		cdiContainer.boot();
		
		ContextControl contextControl = cdiContainer.getContextControl();
		contextControl.startContext(ApplicationScoped.class);
		
		Routes routes = BeanProvider.getContextualReference(Routes.class, false);
		routes.start();
		
		cdiContainer.shutdown();
	}
}
