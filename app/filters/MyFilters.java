package filters;

import play.mvc.EssentialFilter;
import play.filters.cors.CORSFilter;
import play.http.DefaultHttpFilters;

import javax.inject.Inject;

public class MyFilters extends DefaultHttpFilters {
    @Inject public MyFilters(CORSFilter corsFilter) {
        super(corsFilter);
    }
}