package k15hkii.se114.bookstore.ui.address;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.api.user.UserAddressCRUDRequest;
import k15hkii.se114.bookstore.data.model.location.*;
import k15hkii.se114.bookstore.data.remote.LocationRepository;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.SpinnerWrapper;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class BaseAddressUpdateViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<List<SpinnerWrapper<City>>> cities = new ObservableField<>();
    public final ObservableField<List<SpinnerWrapper<District>>> districts =new ObservableField<>();
    public final ObservableField<List<SpinnerWrapper<Ward>>> wards =new ObservableField<>();
    public final ObservableField<List<SpinnerWrapper<Project>>> projects =new ObservableField<>();
    public final ObservableField<List<SpinnerWrapper<Street>>> streets =new ObservableField<>();

    public final ObservableInt cityIndex = new ObservableInt(0);
    public final ObservableInt districtIndex = new ObservableInt(0);
    public final ObservableInt wardIndex = new ObservableInt(0);
    public final ObservableInt projectIndex = new ObservableInt(0);
    public final ObservableInt streetIndex = new ObservableInt(0);

    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableBoolean isPrimary = new ObservableBoolean(false);

    public UserAddressCRUDRequest toRequest() {
        UserAddressCRUDRequest requset = new UserAddressCRUDRequest();

        requset.setAddress(address.get());
        requset.setCity(cities.get().get(cityIndex.get()).getDisplay());
        requset.setDistrict(districts.get().get(districtIndex.get()).getDisplay());
        requset.setWard(wards.get().get(wardIndex.get()).getDisplay());
        requset.setProject(projects.get().get(projectIndex.get()).getDisplay());
        requset.setStreet(streets.get().get(streetIndex.get()).getDisplay());
        requset.setPrimary(isPrimary.get());

        return requset;
    }

    public BaseAddressUpdateViewModel(SchedulerProvider schedulerProvider, LocationRepository locationRepository) {
        super(schedulerProvider);

        cities.set(AddressHelper.toWrapper(locationRepository.getCities()));
        AddressHelper.filter(cities, districts, wards, projects, streets, cityIndex, districtIndex, wardIndex, projectIndex, streetIndex);

        Observable.OnPropertyChangedCallback cityCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                AddressHelper.filter(cities, districts, wards, projects, streets, cityIndex, districtIndex, wardIndex, projectIndex, streetIndex);
            }
        };
        Observable.OnPropertyChangedCallback districtCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                AddressHelper.filter(districts, wards, projects, streets, districtIndex, wardIndex, projectIndex, streetIndex);
            }
        };
        cityIndex.addOnPropertyChangedCallback(cityCallback);
        districtIndex.addOnPropertyChangedCallback(districtCallback);
    }

}
