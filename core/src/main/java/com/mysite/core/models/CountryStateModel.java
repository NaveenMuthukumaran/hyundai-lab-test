package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CountryStateModel {
    @Inject
    private List<CountryState> multifieldTab;

    public List<CountryState> getMultifieldTab() {
        return multifieldTab;
    }

    public void setMultifieldTab(List<CountryState> multifieldTab) {
        this.multifieldTab = multifieldTab;
    }
}
