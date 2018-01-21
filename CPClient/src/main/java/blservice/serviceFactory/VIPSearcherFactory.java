package blservice.serviceFactory;

import bl.VIPbl.VIPFuzzySearchImpl;
import blservice.VIPblservice.VIPFuzzySearch;

public class VIPSearcherFactory {
	public static VIPFuzzySearch getVIPFuzzySearchService(){
		return new VIPFuzzySearchImpl();
	}
}
