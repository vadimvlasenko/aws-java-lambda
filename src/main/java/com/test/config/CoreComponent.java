package com.test.config;

import com.test.handlers.FindSponsorHandler;
import com.test.handlers.GetSponsorsHandler;
import com.test.handlers.DeleteSponsorHandler;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {CoreModule.class})
public interface CoreComponent {

    void inject(GetSponsorsHandler requestHandler);

    void inject(FindSponsorHandler requestHandler);

    void inject(DeleteSponsorHandler deleteSponsorHandler);
}